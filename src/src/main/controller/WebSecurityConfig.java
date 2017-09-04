package src.main.controller;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * 
 * This classs removes the csrf configuration from the Spring boot since it was causing connection problems.
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
    }
}

