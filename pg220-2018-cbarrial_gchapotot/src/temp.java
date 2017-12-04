public class temp {
	
	String T;
	private int i;
	private int j;
	
	public temp() {
		this.T = null;
	}
	
	public int Temperature(String reponse) {
		
		for ( i=0; i<reponse.length(); i++) {
			j = reponse.indexOf("the_temp");
		}
		this.T = reponse.substring(j+10, j+13);
		
		
		if ( (Integer.parseInt(T.substring(2)))>=5) {
			return Integer.parseInt(T.substring(0,1))+1;
		}
		else
			return Integer.parseInt(T.substring(0,1));
	}
}