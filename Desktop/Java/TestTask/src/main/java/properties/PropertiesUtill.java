package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtill {

    private Properties properties;

    public PropertiesUtill() throws IOException {
        try(FileInputStream in = new FileInputStream(new File("src//main//resources//test.properties"))) {
            properties = new Properties();
            properties.load(in);
        }
    }
    public String getQuickSearchKeyWord(){
        return properties.getProperty("quickSearchKeyWord");
    }

    public String getSearchWord(){
        return properties.getProperty("searchWord");
    }

}
