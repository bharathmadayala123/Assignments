package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil1 {
	
	public static Properties readData(String fileName) {
	
	Properties pro= new Properties();
	
	try {
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\Config\\"+fileName);
		
		pro.load(fi);	
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return pro;
	
	}

}
