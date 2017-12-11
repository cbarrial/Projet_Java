
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

public class api extends api3{
 
 public static void main(String[] args) throws Exception {
 
  api http = new api();
 
     // Sending get request
  http.sendingGetRequest();
 
 
 }
 
 
 
 
 
 // HTTP GET request
 private void sendingGetRequest() throws Exception {
 
  String urlString = "https://www.metaweather.com/api/location/580778";
  String urlString2 = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22bordeaux%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
  
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
  
  //System.out.println((temp.getInt("max_temp")+temp.getInt("min_temp"))/2); 
  
//second api
  //System.out.println(response2.toString());
  JSONObject info2 = new JSONObject(response2);
 
  
  JSONArray tab=Tab_json3 ("bordeaux");
  System.out.println(tab.toString());
  
  JSONObject temp3 = tab.getJSONObject(1);
  
  //System.out.println((temp3.getInt("max_temp")+temp3.getInt("min_temp"))/2); 
  
  
  
  
 
 }
}