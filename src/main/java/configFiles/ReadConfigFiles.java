package configFiles;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadConfigFiles {
	protected InputStream input=null;
	protected Properties prop=null;
	
	public ReadConfigFiles() {
		try {
			input = ReadConfigFiles.class.getClassLoader().getResourceAsStream(Constants.CONFIG_PROPERTIES_DIRECTORY);
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		if (prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
	}


	

}
