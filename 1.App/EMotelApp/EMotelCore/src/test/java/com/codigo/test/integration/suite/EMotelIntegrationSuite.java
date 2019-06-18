package com.codigo.test.integration.suite;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.codigo.test.integration.test.HotelIntegrationTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//http://www.baeldung.com/mockito-void-methods

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources",
	glue = {"com.codigo.test.integration.test"},
	plugin = {
			"pretty",
			"html:target/cucumber",
			"json:target/cucumber.json",
			"junit:target/cucumber_junit_report.xml"
	}
)
public class EMotelIntegrationSuite {
	
	
	
}
