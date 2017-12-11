import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class api1 {
	String city;
	JSONArray tab;
	
	
	public JSONArray Tab_json1 (String city) throws Exception {
		JSONArray tab = new JSONArray();
		
			String urlString="https://www.metaweather.com/api/location/search/?query="+city;
			URL url = new URL(urlString);
			  HttpURLConnection con = (HttpURLConnection) url.openConnection();
			  
			// Reading response from input Stream
			 BufferedReader in = new BufferedReader(
			       new InputStreamReader(con.getInputStream()));
			 
			 String output;
			 String response="";
			 
			 
			 while ((output = in.readLine()) != null) {
				   response += output;
				  }
				  in.close();
				  
			JSONArray nam =new JSONArray(response);
			JSONObject temp = nam.getJSONObject(0);
				  
			int woeid=temp.getInt("woeid");
			
		
		String 	urlString1="https://www.metaweather.com/api/location/"+Integer.toString(woeid);
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
	    JSONArray nam1 =info.getJSONArray("consolidated_weather");
	    for (int i=0;i<5;i++) {
	    		tab.put(nam1.getJSONObject(i));	
	    		
	    }
		  
		
		return tab;
	}
	
}