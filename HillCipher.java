package pkg; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
    


public class HillCipher { 
     static int[][] decrypt = new int[3][1]; 
     static int[][] a = new int[3][3]; 
     static int[][] b = new int[3][3]; 
     static int[][] mes = new int[3][1]; 
     static int[][] res = new int[3][1]; 
     static BufferedReader br = new BufferedReader(new InputStreamReader( 
               System.in)); 
     static Scanner sc = new Scanner(System.in); 

     public static void main(String[] args) throws IOException { 
          getKeys(); 
          for (int i = 0; i < 3; i++) 
               for (int j = 0; j < 1; j++) 
                    for (int k = 0; k < 3; k++) { 
                         res[i][j] = res[i][j] + a[i][k] * mes[k][j]; 
                    } 
          System.out.print("\nEncrypted string is : "); 
          for (int i = 0; i < 3; i++) { 
                System.out.print((char) (res[i][0] % 26 + 97)); 
               res[i][0] = res[i][0]; 
          } 
          getInverse(); 
          for (int i = 0; i < 3; i++) 
               for (int j = 0; j < 1; j++) 
                    for (int k = 0; k < 3; k++) { 
                         decrypt[i][j] = decrypt[i][j] + b[i][k] * res[k][j]; 
                    } 
          System.out.print("\nDecrypted string is : "); 
          for (int i = 0; i < 3; i++) { 
                System.out.print((char) (decrypt[i][0] % 26 + 97)); 
          } 
          System.out.print("\n"); 
     } 

     public static void getKeys() throws IOException { 
          System.out 
                    .println("Enter 3x3 matrix for key (It should be inversible): "); 
          for (int i = 0; i < 3; i++) 
               for (int j = 0; j < 3; j++) 
                    a[i][j] = sc.nextInt(); 
          System.out.print("\nEnter a 3 letter string: "); 
          String msg = br.readLine(); 
          for (int i = 0; i < 3; i++) 
               mes[i][0] = msg.charAt(i) - 97; 
     } 

   

     public static void getInverse() { 
          int p, q; 
          int[][] c = a; 
          for (int i = 0; i < 3; i++) 
               for (int j = 0; j < 3; j++) { 
                  
                    if (i == j) 
                         b[i][j] = 1; 
                    else 
                         b[i][j] = 0; 
               } 
          for (int k = 0; k < 3; k++) { 
               for (int i = 0; i < 3; i++) { 
                    p = c[i][k]; 
                    q = c[k][k]; 
                    for (int j = 0; j < 3; j++) { 
                         if (i != k) { 
                              c[i][j] = c[i][j] * q - p * c[k][j]; 
                              b[i][j] = b[i][j] * q - p * b[k][j]; 
                         } 
                    } 
               } 
          } 
          for (int i = 0; i < 3; i++) 
               for (int j = 0; j < 3; j++) { 
                    b[i][j] = b[i][j] / c[i][i]; 
               } 
          System.out.println(""); 
          System.out.println("\nInverse Matrix is : "); 
          for (int i = 0; i < 3; i++) { 
               for (int j = 0; j < 3; j++) 
                    System.out.print(b[i][j] + " "); 
               System.out.print("\n"); 
          } 
     } 
}

