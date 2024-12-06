package com.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	
	public boolean retry(ITestResult result) {
		 int counter =0;
		 int maxtry=3;
		if(counter<maxtry) {
			counter++;
			return true;
			
		}
		
		return false;
	}

}
