/**
 * @author: LQHuy
 * @create_date: Mar 14, 2021
 * @TODO
 * @PageableConfig
 */
package com.vti.config.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

/**
 * @author Administrator
 *
 */
@Configuration
public class PageableConfig {
	
	@Bean
	public PageRequest pageRequest(){
		return PageRequest.of(1, 1);
		
	}

}
