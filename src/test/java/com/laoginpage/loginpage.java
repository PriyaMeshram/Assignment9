package com.laoginpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.config.config;
import com.launch.launch;

public class loginpage {

	@FindBy(how = How.LINK_TEXT, using = "MOBILE")
	WebElement mobile;

	public void click_on_mobile() throws Exception {
		mobile.click();
		Thread.sleep(2000);
	}

	@FindBy(how = How.XPATH, using = "//li[@class='item last'][2]/div/div[3]/button/span")
	WebElement addtocard;

	public void click_addtocard() throws Exception {
		addtocard.click();
		Thread.sleep(2000);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='coupon_code']")
	WebElement coupencode;

	public void enter_coupan_code() throws Exception {
		coupencode.sendKeys("GURU50");
		Thread.sleep(2000);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Apply']")
	WebElement apply;

	public void click_on_apply() throws Exception {
		apply.click();
		Thread.sleep(2000);
	}

	public void varify_discount_generated() throws Exception {
       Thread.sleep(2000);
		String actual = config.driver.findElement(By.xpath("//span[@class='price']")).getText();
		String expected = "$500.00";
		System.out.println(actual);
		System.out.println(expected);

		System.out.println("discount is verify succesfully");
	}

	public void page_load() {
		PageFactory.initElements(config.driver, this);
	}

	public static void main(String[] args) throws Exception {

		launch l = new launch();
		l.open_browser();
		l.enter_application_url();
		l.wat_till_pageoad();
		l.maximize_webpage();

		loginpage lp = new loginpage();
		lp.page_load();
		lp.click_on_mobile();
		lp.click_addtocard();
		lp.enter_coupan_code();
		lp.click_on_apply();
		lp.varify_discount_generated();

	}

}
