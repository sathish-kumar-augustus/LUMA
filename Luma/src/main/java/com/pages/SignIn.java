package com.pages;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class SignIn extends Base_Class {

	private static By SignInOption = By.xpath("(//ul//li[2]//a)[1]");
	private static By SigninEmail = By.xpath("//*[@id='email']");
	private static By SignInPassword = By.xpath("//*[@id='pass']");
	private static By SignInButton = By.xpath("(//*[@id='send2'])[1]");

	private static By Profile_dropdown = By.xpath("(//button[@class='action switch'])[1]");
	private static By SignOutButton = By.xpath("//div[1]//header//div//div//ul//li[2]//div//li[3]//a");

	public void MainMethod(String Value) throws Throwable {

		if (Value.equalsIgnoreCase("SignIn")) {

			TestCase3();
			TestCase4();
			TestCase5();

		}

	}

	// Existing User signin
	public static void TestCase3() throws Throwable {

		String password = configloader().getProperty("Password");
		String existing_user = configloader().getProperty("ExistingUserEmail");
		

		click(SignInOption);
		Thread.sleep(100);

		input(SigninEmail, existing_user);
		Thread.sleep(100);

		input(SignInPassword, password);
		Thread.sleep(100);

		click(SignInButton);
		Thread.sleep(100);

		SignOut();
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.PASS, " User Sign In Successful");
	}

	// Signin with invalid email and password
	public static void TestCase4() throws Throwable {

		String password = configloader().getProperty("Password");
		//String existing_user = configloader().getProperty("ExistingUserEmail");
		String email = configloader().getProperty("Email");

		click(SignInOption);
		Thread.sleep(100);

		input(SigninEmail, email);
		Thread.sleep(100);

		input(SignInPassword, password);
		Thread.sleep(100);

		click(SignInButton);
		Thread.sleep(100);

		ExtentTestManager.getTest().log(Status.PASS, " User Sign In Successful");
	}
	
	// Signin with valid email and incorrect password
	public static void TestCase5() throws Throwable {

		String password = configloader().getProperty("Password");
		String existing_user = configloader().getProperty("ExistingUserEmail");
	//	String email = configloader().getProperty("Email");
		String incorrectpwd = configloader().getProperty("IncorrectPwd");

		click(SignInOption);
		Thread.sleep(100);

		input(SigninEmail, existing_user);
		Thread.sleep(100);

		input(SignInPassword, incorrectpwd);
		Thread.sleep(100);

		click(SignInButton);
		Thread.sleep(100);

		ExtentTestManager.getTest().log(Status.PASS, " User Sign In Successful");
	}

	public static void SignOut() throws Throwable {
		click(Profile_dropdown);
		Thread.sleep(1000);
		click(SignOutButton);
		Thread.sleep(500);

	}

}
