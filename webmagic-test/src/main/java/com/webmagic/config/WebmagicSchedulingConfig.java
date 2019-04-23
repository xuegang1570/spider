package com.webmagic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.webmagic.pipeline.XpaperZgtcbPopeline;
import com.webmagic.processor.XpaperZgtcbProcessor;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;

@Component
@EnableScheduling
public class WebmagicSchedulingConfig {
	
	private final Logger logger = LoggerFactory.getLogger(WebmagicSchedulingConfig.class);

	@Autowired
    private XpaperZgtcbPopeline xpaperZgtcbPopeline;
	
	public static final String BASE_URL = "http://i.xpaper.net/cnsports";

    @Scheduled(cron = "0 01 12 * * ?")
    public void createLotteryInfo(){
        long startTime, endTime;
        System.out.println("【爬虫开始】");
        startTime = System.currentTimeMillis();
        logger.info("爬取地址：" + BASE_URL);
        try {
            Spider spider = Spider.create(new XpaperZgtcbProcessor());
            Request request = new Request();
            request.setUrl(BASE_URL);
            request.putExtra("taskId", "00001");
            spider.addRequest(request);
            spider.addPipeline(xpaperZgtcbPopeline);
            spider.thread(5);
            spider.setExitWhenComplete(true);
            spider.start();
            spider.stop();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】");

        System.out.println("中内容抓取耗时约" + ((endTime - startTime) / 1000) + "秒，已保存");

    }

}
