package helpers;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfigHelper
{
    private String propFileName = "config.properties";
    private Properties prop = new Properties();
    public ReadConfigHelper()
    {
        initProps();
    }
    public String readEndPointUrl()
    {
        return prop.getProperty("service.url");
    }
    private void initProps()
    {
        try
        {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream == null)
            {
                throw new RuntimeException("property file: '"+ propFileName+"' not found in the classpath");
            }
            prop.load(inputStream);
        }catch (Exception ex)
        {
            throw new RuntimeException(ex.getStackTrace().toString());
        }
    }
}
