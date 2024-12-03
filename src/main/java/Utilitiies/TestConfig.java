package Utilitiies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    public Properties Property() throws IOException, FileNotFoundException {
        Properties prop=new Properties();
//        FileReader filereader=new FileReader("src/test/Recourse/config.properties");
        FileInputStream fileInputStream=new FileInputStream("src/test/Recourse/config.properties");
        prop.load(fileInputStream);
        return prop;
    }

}
