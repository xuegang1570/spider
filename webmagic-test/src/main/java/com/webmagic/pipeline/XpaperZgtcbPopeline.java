package com.webmagic.pipeline;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.webmagic.bean.Journal;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Service
public class XpaperZgtcbPopeline implements Pipeline{
	
	private static Logger logger = LoggerFactory.getLogger(XpaperZgtcbPopeline.class);

	@Override
	public void process(ResultItems resultItems, Task task) {
		for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().contains("journal")) {
                Journal journal = (Journal) entry.getValue();
                logger.info("XpaperZgtcbPopeline-journal:{}", journal.toString());
            }
            if (entry.getKey().contains("contentPage")) {
                String contentPage = (String) entry.getValue();
                logger.info("XpaperZgtcbPopeline-contentPage:{}", contentPage);
            }
            if (entry.getKey().contains("links")) {
                String links = (String) entry.getValue();
                logger.info("XpaperZgtcbPopeline-links:{}", links);
            }

        }
	}

}
