/**
 * 
 */
package com.app.ecclesiamainframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * @author Harry
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootApplications extends SpringBootServletInitializer {

	/**
	 * @param args
	 */	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(SpringBootApplications.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplications.class,args);
	}

}
