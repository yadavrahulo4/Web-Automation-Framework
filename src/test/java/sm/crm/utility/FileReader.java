package sm.crm.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * To read .properties file 
 */
public class FileReader {
	
	private static Properties p;
	private static FileReader read;
	public static FileReader getObj() {
		return read;
	}
	static {
		read=new FileReader();
	}

	public FileReader(String path) {
		p = new Properties();
		InputStream s = null;
		try {
			s = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.load(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FileReader() {
		this("src\\test\\resources\\config.properties");
	}

	/**Method returns value for a given key from properties file
	 * @param key
	 * @return value 
	 */
	public static String get(String key) {
		return (String) p.get(key);
	}

}
