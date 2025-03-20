package property_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Get_property {
@Test
public String get(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./propertyfile/data.properties");
	Properties p= new Properties();
	p.load(fis);
	String url = p.getProperty(key);
	return url;
}
}
