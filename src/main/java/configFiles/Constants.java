package configFiles;

public class Constants {
	/**constant config files**/
	
	public final static String CONFIG_PROPERTIES_DIRECTORY="src\\main\\java\\configFiles\\config.properties";
	
	public final static String GECKO_DRIVER_DIRECTORY=System.getProperty("user.dir") 
			+"\\src\\test\\resources\\Drivers\\geckodriver.exe";
	
	public final static String CHROME_DRIVER_DIRECTORY= System.getProperty("user.dir")
			+"\\src\\test\\resources\\Drivers\\chromedriver.exe";
	
	public final static String IE_DRIVER_DIRECTORY= System.getProperty("user.dir")
	+"\\src\\test\\resources\\Drivers\\IEDriverServer.exe";

	public final static int PAGE_LOAD_TIMEOUT= 60;
	public final static int IMPLICITLY_WAIT= 60;
	
}