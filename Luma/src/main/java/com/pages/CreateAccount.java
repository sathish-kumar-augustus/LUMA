package com.pages;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class CreateAccount extends Base_Class {

	private static By CreateAccountOption = By.xpath("(//*[text()='Create an Account'])[1]");
	private static By FirstNameInput = By.xpath("//*[@id='firstname']");
	private static By LastNameInput = By.xpath("//*[@id='lastname']");
	private static By NewsLetterCheckBox = By.xpath("//*[@id='is_subscribed']");
	private static By Email = By.xpath("//*[@id='email_address']");
	private static By Password = By.xpath("//*[@id='password']");
	private static By ConfirmPassword = By.xpath("//*[@id='password-confirmation']");
	private static By CreateAccountButton = By.xpath("//*[@title='Create an Account']");

	public void MainMethod(String Value) throws Throwable {

		if (Value.equalsIgnoreCase("CreateAccount")) {
			
			TestCase1();
			TestCase2();
			

		}

	}
	
	//Existing User creating account
		public static void TestCase1() throws Throwable {
			
			//String email = configloader().getProperty("Email");
			String password = configloader().getProperty("Password");
			String firstname = configloader().getProperty("FirstName");
			String lastname = configloader().getProperty("LastName");
			String existing_user = configloader().getProperty("ExistingUserEmail");
			
			click(CreateAccountOption);
			Thread.sleep(100);

			input(FirstNameInput, firstname);
			Thread.sleep(100);

			input(LastNameInput, lastname);
			Thread.sleep(100);

			click(NewsLetterCheckBox);
			Thread.sleep(100);

			input(Email, existing_user);
			Thread.sleep(2000);

			input(Password, password);
			Thread.sleep(100);

			input(ConfirmPassword, password);
			Thread.sleep(100);

			click(CreateAccountButton);
			Thread.sleep(100);

			ExtentTestManager.getTest().log(Status.PASS, "Displays Error Message - user already exists");
		}
		

	//New User Creating Account
	public void TestCase2() throws AWTException, InterruptedException, Throwable {

		String email = configloader().getProperty("Email");
		String password = configloader().getProperty("Password");
		String firstname = configloader().getProperty("FirstName");
		String lastname = configloader().getProperty("LastName");
		String domain = configloader().getProperty("Domain");
		String n = configloader1().getProperty("N");
	//	String existing_user = configloader1().getProperty("ExistingUserEmail");

		email = email + n + domain;

		click(CreateAccountOption);
		Thread.sleep(100);

		input(FirstNameInput, firstname);
		Thread.sleep(100);

		input(LastNameInput, lastname);
		Thread.sleep(100);

		click(NewsLetterCheckBox);
		Thread.sleep(100);

		input(Email, email);
		Thread.sleep(2000);

		input(Password, password);
		Thread.sleep(100);

		input(ConfirmPassword, password);
		Thread.sleep(100);

		click(CreateAccountButton);
		Thread.sleep(100);
		UpdatingEmailId();

		ExtentTestManager.getTest().log(Status.PASS, "Account Created Successfully");
	}

	//Auto update of new email id for each test run. Used for New User account creation Test case
	public static void UpdatingEmailId() throws Throwable {
		String n = configloader1().getProperty("N");
		int a = Integer.parseInt(n);
		int b = a + 1;
		String c = Integer.toString(b);
		System.out.println(c);

	FileOutputStream File = new FileOutputStream(
				"C:\\Users\\sathishkumar.a\\Desktop\\sathish\\Projects\\Luma\\src\\test\\resources\\write.properties");
		Properties properties = new Properties();
		properties.setProperty("N", c);
		properties.store(File, "Properties");
		File.close();
		System.out.println("After saving properties: " + properties);
	}
		
		
		
		
		

	}


