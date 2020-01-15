/**
 * 
 */
package com.app.ecclesiamainframe;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;
//
//import com.app.ecclesiamainframe.controller.AppErrorController;

//import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 * @author Harry
 *
 */

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
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
