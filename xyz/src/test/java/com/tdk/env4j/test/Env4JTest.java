package com.atk.env4j.test;

import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.optum.atk.env4j.Env4JImpl;

public class Env4JTest {

	@Test
	public void test() throws InvalidFileFormatException, IOException {
		
		//Loading default file
		Env4JImpl atk_conf = new Env4JImpl();
		System.out.println("--------------------------------");
		try {
			System.out.println("DB User= " + atk_conf.getDbUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		try {
			System.out.println("DB Sid= " + atk_conf.getDbSid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		System.out.println("--------------------------------");	
		System.out.println("Section= " + atk_conf.getEnvName());
				
	}
				
}
