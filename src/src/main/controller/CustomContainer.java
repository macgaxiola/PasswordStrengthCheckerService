/**
 * 
 */
package src.main.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author Mac - mac.gaxiola@gmail.com
 */
@Component
public class CustomContainer implements EmbeddedServletContainerCustomizer {
	
	private static final String HOSTNAME = "127.0.0.1";
	
	public void customize(ConfigurableEmbeddedServletContainer container) {
		try {
			// Set to local Host
			InetAddress host=InetAddress.getByName(HOSTNAME);
			container.setAddress(host);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
