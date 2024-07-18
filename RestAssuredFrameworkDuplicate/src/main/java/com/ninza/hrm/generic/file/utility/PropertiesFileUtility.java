package com.ninza.hrm.generic.file.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility {
	public String getDataFromProperties(String key) throws Throwable {

		FileInputStream fis = new FileInputStream("./config_env_data/configEnvData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;

	}

}
