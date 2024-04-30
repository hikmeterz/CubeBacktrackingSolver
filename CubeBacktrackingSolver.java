public class CubeBacktrackingSolver{
	
	public static void main(String[] args) {
		int[][][] kup = new int[5][5][5];
		//Arrayin icini doldurma.
		kup[0][2][2]=4;
		kup[0][3][2]=1;
		kup[0][0][0]=1;
		kup[0][2][0]=3;
		kup[0][4][0]=4;
		kup[1][2][2]=3;
		kup[4][2][2]=2;
		
		
		
		kupu_doldur(kup);//Kupu dolduran metot.
		kupu_goster(kup);
		
		
		
	}
	
	//third integeri z ekseninin indexlerini tutuyor.
	public static boolean kupu_doldur(int[][][] kup) {
		
		for(int third=0;third<5;third++) {
			for(int row=0;row<5;row++){		    
				for(int col=0;col<5;col++){
						
					if(kup[third][row][col]==0) {//kup arrayindeki indexte 0 var mı yok mu onu kontrol ediyor.0 varsa doldurma islemini yapıcak.
						
						for(int x=1;x<=5;x++){//Kup arrayine doldurabilicek rakamlardan 1 den baslıyor.

							if(kontrol(x,third,row,col,kup)){//kontrol metoduna kupun third,row,column indexlerini ve doldurabilcek rakamları gonderiyor.
								//Eger rakam yani x kontrol edildiyse kupun icine yerlestiriliyor.								
								kup[third][row][col]=x;
								if(kupu_doldur(kup)){//Recursion olarak kupu_doldur metodunu cagırıyor.Metot tekrardan calısıyor..
									return true;
								}else {
									kup[third][row][col]=0;
								}		
							}
							
						}
						return false;
					}//Eger 0 yoksa baska rakam var demektir.Diger indexlere bakıyor.	
				}
		    	}
		}
		
		
	
		return true;
		
		
		
		
	}
		        		
		        		
    public static boolean kontrol(int x,int third ,int row,int col,int[][][] kup){
    	
    	//Satırda x i yani doldurabilcek rakamı arıyor.Satırda gezme islemi
    	for(int k=0;k<5;k++){
			if(x==kup[third][row][k])//Satırda gezme islemi icin third,row, sabit, columnu artırarak arama yapyor.Eger x varsa false donuyor.
				return false;
	}
    	//Sutunda gezme islemi..
    	for(int m=0;m<5;m++){
		if(x==kup[third][m][col])
				return false;
	}
    	//3.eksende gezme islemi row column sabit 3. ekseni artırarak x i kontrol ediyor
    	for(int l=0;l<5;l++) {
    		
    		if(x==kup[l][row][col])
    			return false;
    	}
    	
	//Eger rakam yani x aradıgımız indexlerde yoksa true donuyor..    	

    	return true;
    	
    	
    	
    	
    	
    }
    
    
    public static void kupu_goster(int[][][] cube) {
		
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				for(int z=0;z<5;z++) {
						System.out.print(cube[i][j][z] + " " );
						//System.out.println();
						
						
					
					
				}
				
				System.out.println();
					
				
				
			}
			
			System.out.println("---");
			
		}
		

		
	}
		        			

}

