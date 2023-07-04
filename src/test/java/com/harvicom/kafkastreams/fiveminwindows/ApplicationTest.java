package com.harvicom.kafkastreams.fiveminwindows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.harvicom.kafkastreams.straightthrough.processor.EventStreamProcessor;

@SpringBootTest
class ApplicationTest {

	@Autowired
    EventStreamProcessor fiveMinWindowEventStreamProcessor;

	@Test
	void contextLoads() {
	}

}