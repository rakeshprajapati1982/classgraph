package com.readtorakesh.reflection.processor;

import java.util.Properties;

import com.readtorakesh.reflection.annotation.AppConfig;
import com.readtorakesh.reflection.annotation.BusinessProcessor;
import com.readtorakesh.reflection.annotation.Traditional;

@BusinessProcessor
@Traditional
public class TraditionalProcessor implements Processor {

	private Properties properties;
	
	@AppConfig
	public void setProperties() {
		// Manually load properties
	}
	
	@Override
	public void process() {
		System.out.println("This is modern processor");
	}

}
