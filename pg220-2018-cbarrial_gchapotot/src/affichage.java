public class affichage{
	String af;
	
public static byte[] Affichage(int tab_temp1[], int tab_hum1[], int tab_speed1[], int tab_temp2[], int tab_hum2, int tab_speed2, int tab_temp3[], int tab_hum3, int tab_speed3, String op1, String op2, String deg, int n) {
	
	//initialisation des variables
	String af="";
	String c="°";
	String per="%";
	String v="km/h";
	String blanc1[]= {" "," "," "," "," "," "};
	String blanc2[]= {" "," "," "," "," "," "};
	String blanc3[]= {" "," "," "," "," "," "};
	String blanc4[]= {" "," "," "," "," "," "};
	String blanc5[]= {" "," "," "," "," "," "};
	String blanc6=" ";
	String blanc7=" ";
	String blanc8=" ";
	String blanc9=" ";
	
	 String ligne="+-------------+" ;
	 String ligne2="---------+";
	 String saut="\n";
	 String ligne3="|             |";
	 String ligne_meta="| Metaweather |";
	 String ligne_pmeteo="| P-Meteo     |";
	 String ligne_yweather="| Y! Weather  |";
	 
	
	 if (deg=="-m F") {
		 for (int i=0;i<n+1;i++)
				tab_temp1[i]= (int) (tab_temp1[i]*1.8+32);
		 for (int i=0;i<n+1;i++)
				tab_temp2[i]=(int) (tab_temp2[i]*1.8+32);
		 c="F";
	 }
	 
	 else {
		 for (int i=0;i<n+1;i++)
				tab_temp3[i]= (int) ((tab_temp3[i]-32)/1.8);
		 
	 }
	 
	 for (int i=0;i<n+1;i++) {
		 if (tab_temp1[i]<10 && tab_temp1[i]>=0)
			 blanc1[i]="  ";
		 if (tab_temp2[i]<10 && tab_temp2[i]>=0)
			 blanc2[i]="  ";
		 if (tab_temp3[i]<10 && tab_temp3[i]>=0)
			 blanc3[i]="  ";
		 if (tab_temp1[i]<-9)
			 blanc1[i]="";
		 if (tab_temp2[i]<-9)
			 blanc2[i]="";
		 if (tab_temp3[i]<-9)
			 blanc3[i]="";
		 if (tab_hum1[i]<10 )
			 blanc4[i]="  ";
		 if (tab_speed1[i]<10 )
			 blanc5[i]="  ";
		 if (tab_hum2<10 )
			 blanc6="  ";
		 if (tab_speed2<10 )
			 blanc7="  ";
		 if (tab_hum3<10 )
			 blanc8="  ";
		 if (tab_speed3<10 )
			 blanc9="  ";
	 }
	 
	 
	 
	//1ere ligne pointillés
	af=af+ligne;
	for (int i=0;i<n+1;i++)
		af=af+ligne2;
	af=af+saut;
	
	//ligne des jours
	{	af=af+ligne3;
	
	for (int i=0;i<n+1;i++)
		af=af+"   J+"+i+"   |";
	af=af+saut;
	
	//ligne pointillés
	af=af+ligne;
	for (int i=0;i<n+1;i++)
		af=af+ligne2;
	af=af+saut;
	
	//Metaweather
	af=af+ligne_meta;
	
	for (int i=0;i<n+1;i++)
		af=af+"   "+String.valueOf(tab_temp1[i])+c+blanc1[i]+"  |";
	af=af+saut;
	
	if (op1=="-h") {
		af=af+ligne3;
		for (int i=0;i<n+1;i++)
			af=af+"   "+String.valueOf(tab_hum1[i])+per+blanc4[i]+"  |";
		af=af+saut;
	}
	
	if (op2=="-w") {
		af=af+ligne3;
		for (int i=0;i<n+1;i++)
			af=af+"  "+String.valueOf(tab_speed1[i])+v+blanc5[i]+"|";
		af=af+saut;
	}
	
	//ligne pointillés
	af=af+ligne;
	for (int i=0;i<n+1;i++)
		af=af+ligne2;
	af=af+saut;

	//P Meteo
	af=af+ligne_pmeteo;
		
	for (int i=0;i<n+1;i++)
		af=af+"   "+String.valueOf(tab_temp2[i])+c+blanc2[i]+"  |";
	af=af+saut;
	
	if (op1=="-h") {
		af=af+ligne3;
		af=af+"   "+String.valueOf(tab_hum2)+per+blanc6+"  |";
		for (int i=1;i<n+1;i++)
			af=af+"   "+"-"+per+"    |";
		af=af+saut;
	}
	
	if (op2=="-w") {
		af=af+ligne3;
		af=af+"  "+String.valueOf(tab_speed2)+v+blanc7+"|";
		for (int i=1;i<n+1;i++)
			af=af+"   "+"-"+v+" |";
		af=af+saut;
	}
	
	//ligne pointillés
	af=af+ligne;
	for (int i=0;i<n+1;i++)
		af=af+ligne2;
	af=af+saut;
	 
	 
	//Y Weather
	af=af+ligne_yweather;
			
	for (int i=0;i<n+1;i++)
		af=af+"   "+String.valueOf(tab_temp3[i])+c+blanc3[i]+"  |";
	af=af+saut;
		
	if (op1=="-h") {
		af=af+ligne3;
		af=af+"   "+String.valueOf(tab_hum3)+per+blanc8+"  |";
		for (int i=1;i<n+1;i++)
			af=af+"   "+"-"+per+"    |";
		af=af+saut;
	}
	
	if (op2=="-w") {
		af=af+ligne3;
		af=af+"  "+String.valueOf(tab_speed3)+v+blanc9+"|";
		for (int i=1;i<n+1;i++)
			af=af+"   "+"-"+v+" |";
		af=af+saut;
	}
	
			
	//ligne pointillés
	af=af+ligne;
	for (int i=0;i<n+1;i++)
		af=af+ligne2;
	af=af+saut;	
}
	byte[] tab;
	tab = af.getBytes();
	return tab;
}
	
 
 public static void main(String[] args) throws Exception {
	 
	 String op1="-h";
	 String op2="-w";
	 
	 int tab_temp1[] = {0, -1, -22, 3};
	 int tab_hum1[] = {0, 23, 2, 3};
	 int tab_speed1[] = {0, 31, 2, 3};
	 
	 int tab_temp2[] = {0, 21, -23, 3};
	 int tab_hum2 = 33;
	 int tab_speed2 = 4;
	 
	 int tab_temp3[] = {33, 34, 35, 36};
	 int tab_hum3 = 4;
	 int tab_speed3 = 3;
	 
	
	 
	 String deg="";
	 int n=3;
	 
	 
	 byte[] af=Affichage(tab_temp1, tab_hum1, tab_speed1, tab_temp2, tab_hum2, tab_speed2, tab_temp3, tab_hum3, tab_speed3, op1, op2, deg, n);
	 String str = new String(af);
	 System.out.println(str);
	 
 
 }
 
}
 
 