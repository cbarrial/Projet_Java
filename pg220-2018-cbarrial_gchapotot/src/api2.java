import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class api2 {
	String city;
	JSONArray tab;
	
	
	public JSONArray Tab_json2 (String city) throws Exception {
		JSONArray tab = new JSONArray();
		
		
		String 	urlString1="https://www.prevision-meteo.ch/services/json/"+city;
		URL url1 = new URL(urlString1);
		  HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
		  
		// Reading response from input Stream
		 BufferedReader in1 = new BufferedReader(
		       new InputStreamReader(con1.getInputStream()));
		 
		 String output1;
		 String response1="";
		 
		 
		 while ((output1 = in1.readLine()) != null) {
			   response1 += output1;
			  }
			  in1.close();
			  
	
		JSONObject info = new JSONObject(response1);
	    for (int i=0;i<5;i++) {
	    		JSONObject temp2 =info.getJSONObject("fcst_day_"+i);
	    		tab.put(temp2);	
	    		
	    }
		  
	    JSONObject other =info.getJSONObject("current_condition");
	    tab.put(other);	
	    
		return tab;
	}
	
}