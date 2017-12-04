
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class api extends temp{
 
 public static void main(String[] args) throws Exception {
 
  api http = new api();
 
     // Sending get request
  http.sendingGetRequest();
 
 
 }
 
 
 
 
 
 // HTTP GET request
 private void sendingGetRequest() throws Exception {
 
  String urlString = "https://www.metaweather.com/api/location/44418";
  
  URL url = new URL(urlString);
  HttpURLConnection con = (HttpURLConnection) url.openConnection();
 
 
  // Reading response from input Stream
  BufferedReader in = new BufferedReader(
          new InputStreamReader(con.getInputStream()));
  String output;
  String response=null;
 
  while ((output = in.readLine()) != null) {
   response += output;
  }
  in.close();
  
  temp T= new temp();
  
  //printing result from response
  System.out.println(response.toString());
  System.out.println(T.Temperature(response));
 
 }
}