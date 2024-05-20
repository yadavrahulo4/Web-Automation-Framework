package sm.crm.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileReader {
	Properties p;

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

	public String getProperty(String key) {
		return (String) p.get(key);
	}

}
