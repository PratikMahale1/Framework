package com.resonantiatechnologie.amazon.pom.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.resonantiatechnologie.amazon.keyword.Keyword;
import com.resonantiatechnologie.amazon.utility.Constant;
import com.resonantiatechnologie.amazon.utility.PropertyFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PomBase{
	PropertyFileReader propertyfilereader;
	static Logger log = Logger.getLogger(PomBase.class);
	// constructor to initilize proeperty file reader object
	public PomBase() {
		log.info("Initilizing propertyfile");
		propertyfilereader = new PropertyFileReader();
		propertyfilereader.propertyFileReaderMethod();
		log.info("Initilized propertyfile");
	} // end of constructor

	// method to open Browser
	public static void openBrowser() {
		Keyword.openBrowser(Constant.property.getProperty("BROWSERNAME"));
		Keyword.setupWebDriverEventListener();
		Keyword.openUrl(Constant.property.getProperty("URL"));
		Keyword.setImplicitlyWait("seconds", Constant.IMPLICIT_WAIT);
		Keyword.setPageLoadTimeOut("seconds", Constant.PAGE_LOAD_TIMEOUT);
		Keyword.maximizeWindow(); 
	} // end of method

	// method to close browser
	public void closeBrowser() {
		Keyword.closeBrowser();
	} // end of method
} // end of class
