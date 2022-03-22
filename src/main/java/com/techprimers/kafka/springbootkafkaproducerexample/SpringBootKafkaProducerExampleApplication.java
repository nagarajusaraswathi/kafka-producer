package com.techprimers.kafka.springbootkafkaproducerexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootKafkaProducerExampleApplication implements ApplicationRunner {
  public static Logger logger = LoggerFactory.getLogger(SpringBootKafkaProducerExampleApplication.class);

  private String name;
	public static void main(String[] args) {
		/*logger.info("yes start...");
		for(String value : args){
			logger.info("yes start..."+value);
			System.out.println(value);

		}*/
		SpringApplication.run(SpringBootKafkaProducerExampleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//logger.info("file path " + name);
	}
}
