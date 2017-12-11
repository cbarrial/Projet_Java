import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class api3 {
	String city;
	JSONArray tab;
	
	
	public JSONArray Tab_json3 (String city) throws Exception {
		JSONArray tab = new JSONArray();
		
		
		String 	urlString1="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+city+"%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
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
		JSONObject temp =info.getJSONObject("query");
		JSONObject temp2 =temp.getJSONObject("results");
	    JSONObject temp3 =temp2.getJSONObject("channel");
    	    JSONObject temp4 =temp3.getJSONObject("item");
		JSONArray t =temp4.getJSONArray("forecast");
	    for (int i=0;i<5;i++) {
	    		tab.put(t.getJSONObject(i));	
	    		
	    }
		  
		
		return tab;
	}
	
}