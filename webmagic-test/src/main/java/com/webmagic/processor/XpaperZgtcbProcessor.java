package com.webmagic.processor;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webmagic.bean.Journal;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class XpaperZgtcbProcessor implements PageProcessor {

	private static Logger logger = LoggerFactory.getLogger(XpaperZgtcbProcessor.class);

	public static final String BASE_URL = "http://i.xpaper.net/cnsports";

	private Site site = Site.me()
				.setDomain(BASE_URL)
				.setSleepTime(1000)
				.setRetryTimes(30)
				.setCharset("utf-8")
				.setTimeOut(30000)
				.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {

		String contentTitle = page.getHtml().xpath("//title/text()").toString();

		String[] contentTitles = contentTitle.trim().split("-");
		String issueStr = contentTitles[1].replaceAll("第", "").replaceAll("期", "").replaceAll(" ", "").trim()
				.replaceAll("\\s*", "");

		String issue = new String(issueStr);

		// 由于里面有空格，因此使用了多种方式去空格。
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(issue);
		issue = m.replaceAll("");
		issue = issue.replaceAll("\\u00A0", "");

		String issueDesc = contentTitles[0] + "-" + contentTitles[1];

		Journal journal = new Journal();
		journal.setTitle(issueDesc);
		journal.setTitleDesc(contentTitle);
		journal.setIssue(issue);
		journal.setDateStr(DateUtil.newIsoDateFormat().format((new Date())));

		logger.info("XpaperZgtcbProcessor-journal:{}", journal.toString());

		String contentPage = page.getHtml().xpath("//div[@id='m1']/a").toString();

		logger.info("XpaperZgtcbProcessor-contentPage:{}", contentPage);
		
		String links = page.getHtml().xpath("//div[@id='m1']/a").links().all().toString();
		logger.info("XpaperZgtcbProcessor-links:{}", links);

		page.putField("journal", journal);
		page.putField("contentPage", contentPage);
		page.putField("links", links);
		
	}

}
