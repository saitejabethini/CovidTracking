package com.saitejabethini.CovidTracking;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CovidTrackingApplicationTests {
		CovidData covidData = new CovidData();
		CovidModel covidModel = new CovidModel();

		@Autowired
		private CovidRest controller;

		@Test
		public void contexLoads() throws Exception {
			assertThat(controller).isNotNull();
		}




}
