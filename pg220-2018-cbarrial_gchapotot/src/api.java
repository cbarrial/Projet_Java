
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class api extends api1{
 
 public static void main(String[] args) throws Exception {
 
  api http = new api();
 
     // Sending get request
  http.sendingGetRequest();
 
 
 }
 
 
 
 
 
 // HTTP GET request
 private void sendingGetRequest() throws Exception {
 
  String urlString = "https://www.metaweather.com/api/location/580778";
  String urlString2 = "https://www.prevision-meteo.ch/services/json/bordeaux";
  
  URL url = new URL(urlString);
  HttpURLConnection con = (HttpURLConnection) url.openConnection();
  URL url2 = new URL(urlString2);
  HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
 
 
  // Reading response from input Stream
  BufferedReader in = new BufferedReader(
          new InputStreamReader(con.getInputStream()));
  BufferedReader in2 = new BufferedReader(
          new InputStreamReader(con2.getInputStream()));
  
  String output;
  String response="";
  String output2;
  String response2="";
  
 
  while ((output = in.readLine()) != null) {
   response += output;
  }
  in.close();
  while ((output2 = in2.readLine()) != null) {
	   response2 += output2;
	  }
	  in2.close();
	  
	

  
// first api
  //printing result from response
  System.out.println(response.toString());
  JSONObject info = new JSONObject(response);
  JSONArray nam =info.getJSONArray("consolidated_weather");
  JSONObject temp = nam.getJSONObject(0);
  
  System.out.println((temp.getInt("max_temp")+temp.getInt("min_temp"))/2); 
  
//second api
  System.out.println(response2.toString());
  JSONObject info2 = new JSONObject(response2);
  JSONObject temp2 =info2.getJSONObject("fcst_day_0");
  
  
  System.out.println((temp2.getInt("tmax")+temp2.getInt("tmin"))/2); 
 
  
  JSONArray tab=Temperature ("bordeaux");
  System.out.println(tab.toString());
  
  
  
 
 }
}