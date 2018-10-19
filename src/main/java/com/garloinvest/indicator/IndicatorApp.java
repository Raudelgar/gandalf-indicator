package com.garloinvest.indicator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class IndicatorApp {
    private static final Logger LOG = LoggerFactory.getLogger(IndicatorApp.class);

    public static void main(String[] args) {
        LOG.info("*******   Starting GANDALF-INDICATOR APP  *******");
        SpringApplication.run(IndicatorApp.class,args);
    }
}
