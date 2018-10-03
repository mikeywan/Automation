import java.io.*;
import java.util.HashMap;

public class ConfigReader {
    private static ConfigReader configReader = null;
    public HashMap<String, String> configMap = new HashMap();
    private String configFile = System.getProperty("user.dir") + "/src/main/resources/Config.cfg";

    private ConfigReader() throws FileNotFoundException {
        readConfigFile();
    }

    public static synchronized ConfigReader getInstance() {
        try {
            if (configReader == null)
                configReader = new ConfigReader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return configReader;
    }

    private Boolean readConfigFile() throws FileNotFoundException {
        //Use InputStreamReader instead of FileReader
        BufferedReader bufferdReader = null;

        this.configMap = new HashMap();

        try {

            bufferdReader = new BufferedReader(new InputStreamReader(new FileInputStream(configFile), "UTF-8"));

            String str = null;
            while ((str = bufferdReader.readLine()) != null) {
                if (str.length() == 0)
                    continue;
                String[] strTemp = str.split("==");
                String value = null;
                if (strTemp.length > 1) {
                    if (!strTemp[1].trim().isEmpty())
                        value = strTemp[1].trim();
                }
                this.configMap.put(strTemp[0].trim(), value);
            }
            bufferdReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getBaseEndpoint() {
        return this.configMap.get("BASE_ENDPOINT");
    }
}