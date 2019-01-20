package com.launch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.config.config;

public class launch {
	
	Properties prop=new Properties();
	public void open_browser() throws IOException {
		System.out.println("open browser");
		FileInputStream fis=new FileInputStream("C:\\Users\\PARESHAN\\eclipse-workspace\\Assignment9\\src\\test\\resources\\config.properties");
		prop.load(fis);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_exe_path"));
			config.driver=new ChromeDriver();
		}}	
			
	public void enter_application_url() {
		System.out.println("enter application url");
		config.driver.get("http://live.guru99.com/");
		
	}	
	
	public void maximize_webpage() {
		System.out.println("maximize the webpage");
		config.driver.manage().window().maximize();
	}
		
	public void wat_till_pageoad() {
		System.out.println("please wait till page load");
		config.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) throws IOException {
		launch l=new launch();
		l.open_browser();
		l.enter_application_url();
		l.wat_till_pageoad();
		l.maximize_webpage();
		
	}
	
	
	
	
	

}
