package pkg;

import java.util.*;
class TranspositionCipher{
	
	public static String findTranspositionCipher(String plainText)
	{
		char letter[]=new char [25];
		Scanner in = new Scanner(System.in);
		String cipherText="",jpt="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int c=0,l=1,v=0,i=0,t=1,vc=0,r=0;
		char mat[][]=new char[50][50];

		int key[]={4,3,1,2,5,6,7};
		char z;
		
		for(i=0;i<c+1;i++){
			for(int j=0;j<key.length;j++){
				if(c<plainText.length()){
					char a=plainText.charAt(c);
					mat[i][j]=a;
					c++;
					v=i+1; //for row count 
				}
				if(c==plainText.length()&&j!=vc)//to last string X Y Z..
				{
					r=key.length-j;
					if(r<=jpt.length()){
						z=jpt.charAt(jpt.length()-r);
						mat[i][j+1]= z;
					}
				}
			}
			t=2;
			if(c==plainText.length()&&r==0)//to exit the loop
			{
				i=c+2;
			}
		}
		c=1;
		while(c<=key.length)//to count the no. of key used
		{
			for(i=0;i<key.length;i++){
				if(key[i]==c)//to match the sequence of key position
				{
					int k=0;
					for(l=0;l<v;l++){
						cipherText=cipherText+mat[k][i];
						k++;//to increase the row
					}
				}
		}
		c++;
	}
		cipherText=cipherText.toUpperCase();
		return cipherText;
	}
	public static String DecryptTranspositionCipher(String cipherText){
		Scanner in = new Scanner(System.in);
		String plainText="",jpt="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int c=0,l=1,v=0,i=0,j=0,k=0;
	char mat[][]=new char[50][50];
	char pmat[][]=new char[50][50];
	int key[]={4,3,1,2,5,6,7};
	char z;
	
	v=(cipherText.length()/key.length);
	while(c<key.length)
	{
		for(j=0;j<key.length;j++){
			if(key[j]==c+1){
				for(i=0;i<v;i++){
					mat[i][j]=cipherText.charAt(k);
					k++;
				}
			}
		}
		c++;
	}
	
	for(int p=0;p<4;p++){
		for(int q=0;q<key.length;q++){
			plainText=plainText+mat[p][q];
		}
	}	
      return plainText;
	}
}