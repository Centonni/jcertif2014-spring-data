package com.jcertif.abj2014.intro.spring.data;

import com.jcertif.abj2014.intro.spring.data.AbstractTest.TestConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Komi Serge Innocent <komi.innocent@gmail.com>
 */
@SpringApplicationConfiguration(classes = TestConfig.class)
@Transactional
public abstract class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Configuration
	@EnableAutoConfiguration
	@ComponentScan
	static class TestConfig {

	}

	@BeforeTransaction
	public void setupData() throws Exception {

		deleteFromTables("sessions", "speaker");
		executeSqlScript("classpath:data.sql", false);
	}
}
