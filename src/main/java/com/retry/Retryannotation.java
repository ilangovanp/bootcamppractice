package com.retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.annotations.ITestAnnotation;

public class Retryannotation  implements IAnnotationTransformer{
    public  void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    	
    	annotation.setRetryAnalyzer(Retry.class);
	    // not implemented
	  }
    

}