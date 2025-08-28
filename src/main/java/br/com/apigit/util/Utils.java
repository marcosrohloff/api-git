package br.com.apigit.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Utils {

	public static String getBaseUrl() {
		return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
	}

}
