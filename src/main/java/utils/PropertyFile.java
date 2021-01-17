package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFile {
    public static Map<String,String> envProp=new HashMap<String,String>();
    public static Properties propMain= new Properties();
   // public static Properties proPreSet= new Properties();

    public static  Map<String,String> envFile(){
        String environment=System.getProperty("env");
        try{
            if(environment.equalsIgnoreCase("nonprod")){
                FileInputStream nonProdFile=new FileInputStream("input/nonprod.properties");
                propMain.load(nonProdFile);
                envProp.put("ServerUrl",propMain.getProperty("ServerUrl"));
                envProp.put("InvalidAPIKey",propMain.getProperty("InvalidAPIKey"));
                envProp.put("APIKey",propMain.getProperty("apikey"));


         /*
          *  future use
          */
            } else if(environment.equalsIgnoreCase("pre-prod")){
                FileInputStream preProdFile=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/preprod.properties");
                propMain.load(preProdFile);
                envProp.put("baseURI",propMain.getProperty("baseURI"));
                envProp.put("InvalidAPIKey",propMain.getProperty("InvalidAPIKey"));
            }

        }catch(Exception e){

        }
        return envProp;
    }

    public static Map<String, String> getConfigReader(){
        if(envProp==null){
            envProp=envFile();
        }
        return envProp;
    }
}
