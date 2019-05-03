/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codility;

/**
    * 
    * A Binary Gap within a positive integer N is any maximal sequence
    * of consecutive zeros that is surrounded by ones at both ends in the
    * binary representation of N.
    *
*/
public class binaryGap {
    
    static void longestBinaryGap(int n) {
        // array to store binary number
        int[] binaryNum = new int[1000];
        
        // counter for binary  array
        int i = 0;
        while(n > 0)
        {
            // storing remainder in binary array
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
        
        // print binary array in reverse order
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 17; 
        longestBinaryGap(n);  
    }
}
