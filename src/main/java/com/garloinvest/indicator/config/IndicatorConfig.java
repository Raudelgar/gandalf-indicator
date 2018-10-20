package com.garloinvest.indicator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.garloinvest.searcher.oanda.connection.OandaConnectionFXPractice;
import com.garloinvest.searcher.oanda.service.OandaRouter;
import com.garloinvest.searcher.oanda.service.impl.OandaRouterImpl;

@Configuration
@PropertySource(value={"application.yml"},ignoreResourceNotFound = true)
@PropertySource(value={"file:application.yml"},ignoreResourceNotFound = true)
@PropertySource(value={"file:config/application.yml"},ignoreResourceNotFound = true)
public class IndicatorConfig {

    @Bean(name="readCandlestickData")
    public TaskExecutor candlePoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setThreadNamePrefix("CandlestickData-");
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }
    
    @Bean
    public OandaRouter getOandaRouter() {
    	return new OandaRouterImpl();
    }
    
    @Bean
    public OandaConnectionFXPractice getOndaConnection() {
    	return new OandaConnectionFXPractice();
    }
}
