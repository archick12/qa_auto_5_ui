package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by macbook on 6/26/17.
 */
public class PropertyReader {

    public Map<String, String> readProperties(String propertyFile) {
        Properties propertyFileValues = new Properties();
        FileInputStream input = null;
        HashMap<String, String> result;

        try {

            try {
                input = new FileInputStream(propertyFile);
                try {
                    propertyFileValues.load(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            result = new HashMap();
            result.put("test_run_id", propertyFileValues.getProperty("test_run_id"));
            result.put("path_t", propertyFileValues.getProperty("path_t"));
            result.put("user_trail", propertyFileValues.getProperty("user_trail"));
            result.put("password_trail", propertyFileValues.getProperty("password_trail"));
            result.put("username", propertyFileValues.getProperty("username"));
            result.put("password", propertyFileValues.getProperty("password"));

            // TODO get configuration name if not empty

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return result;
    }


}
