package com.readtorakesh.reflection.processor;

import java.util.Properties;

import com.readtorakesh.reflection.annotation.AppConfig;
import com.readtorakesh.reflection.annotation.BusinessProcessor;
import com.readtorakesh.reflection.annotation.Smart;

@BusinessProcessor
@Smart
public class SmartProcessor implements Processor {
	
	// Smart, auto injected properties
	@AppConfig
	private Properties properties;
	
	@Override
	public void process() {
		System.out.println("This is modern processor");
	}

}
