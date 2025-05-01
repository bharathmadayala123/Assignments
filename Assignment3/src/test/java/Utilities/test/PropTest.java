package Utilities.test;

import java.util.Properties;

import utility.PropUtil;
import utility.PropUtil1;

public class PropTest {

	public static void main(String[] args) {
		
		Properties pro = PropUtil.readData("Config.properties");
		
		System.out.println("Launch the url :"+pro.getProperty("url"));
		System.out.println("Enter emailaddress :"+pro.getProperty("emailaddress"));
		System.out.println("Enter password :"+pro.getProperty("password"));
	}

}
