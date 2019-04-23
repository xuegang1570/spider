package com.webmagic.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class JobClassListener implements ApplicationListener<ContextRefreshedEvent>{

	private Logger logger = LoggerFactory.getLogger(JobClassListener.class);


	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			// 获取上下文
			ApplicationContext context = event.getApplicationContext();
			System.out.println("-------------------onApplicationEvent-----------------");
			
		} catch (Exception e) {
			logger.error("JobAdvice is error", e);
		}
	}
}
