package com.readtorakesh.java.classgraph;

import com.readtorakesh.reflection.annotation.AppConfig;
import com.readtorakesh.reflection.annotation.BusinessProcessor;
import com.readtorakesh.reflection.annotation.Smart;
import com.readtorakesh.reflection.annotation.Traditional;
import com.readtorakesh.reflection.processor.Processor;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

public class MainApp {

	public static void main(String[] args) {
		ScanResult scanResult = new ClassGraph()
				.whitelistPackages("com.readtorakesh.reflection") 
				.verbose()
				.enableAllInfo() 
				.scan();
		
		ClassInfoList classInfoList = null;

		System.out.println("Classes which implements '" + Processor.class.getSimpleName() + "' interface");
		classInfoList = scanResult.getClassesImplementing(Processor.class.getName());
		for (ClassInfo classInfo : classInfoList) {
			System.out.println("\t" + classInfo.getName());
		}

		System.out.println("\nClasses annotated with '@" + BusinessProcessor.class.getSimpleName() + "' annotation");
		classInfoList = scanResult.getClassesWithAnnotation(BusinessProcessor.class.getName());
		for (ClassInfo classInfo : classInfoList) {
			System.out.println("\t" + classInfo.getName());
		}

		System.out.println("\nClasses annotated with '@" + Smart.class.getSimpleName() + "' annotation");
		classInfoList = scanResult.getClassesWithAnnotation(Smart.class.getName());
		for (ClassInfo classInfo : classInfoList) {
			System.out.println("\t" + classInfo.getName());
		}

		System.out.println("\nClasses annotated with '@" + Traditional.class.getSimpleName() + "' annotation");
		classInfoList = scanResult.getClassesWithAnnotation(Traditional.class.getName());
		for (ClassInfo classInfo : classInfoList) {
			System.out.println("\t" + classInfo.getName());
		}

		System.out
				.println("\nClasses having field annotated with '@" + AppConfig.class.getSimpleName() + "' annotation");
		classInfoList = scanResult.getClassesWithFieldAnnotation(AppConfig.class.getName());
		for (ClassInfo classInfo : classInfoList) {
			System.out.println("\t" + classInfo.getName());
		}

		System.out.println(
				"\nClasses having method annotated with '@" + AppConfig.class.getSimpleName() + "' annotation");
		classInfoList = scanResult.getClassesWithMethodAnnotation(AppConfig.class.getName());
		for (ClassInfo classInfo : classInfoList) {
			System.out.println("\t" + classInfo.getName());
		}

	}

}
