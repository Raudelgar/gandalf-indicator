package com.garloinvest.indicator.oanda.service.impl;

import com.garloinvest.indicator.oanda.service.FXCandle;
import com.garloinvest.searcher.oanda.dto.candle.OandaInstrumentCandlestick;
import com.garloinvest.searcher.oanda.service.OandaRouter;

import java.time.LocalDateTime;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FXCandleImpl implements FXCandle {
	private static final Logger LOG = LoggerFactory.getLogger(FXCandleImpl.class);

	@Autowired
	private OandaRouter router;

	@Scheduled(fixedRate = 60000)
	public void init() {
		readCandlestickData("EUR_USD");
	}

	@Async("readCandlestickData")
	@Override
	public void readCandlestickData(String instrumentName) {
		Map<String, Map<LocalDateTime, OandaInstrumentCandlestick>> candlestickData = router
				.readOandaInstrumentCandlestickPerMinute(instrumentName);
		LOG.info("Testing Connection with Searcher Service and Thread");
		LOG.info("Time: {}\nCandleStickData: {}\n Thread: {}",LocalDateTime.now(),candlestickData.size(),Thread.currentThread().getName());
	}
}
