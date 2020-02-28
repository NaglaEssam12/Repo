/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpeg;

import java.util.*;

/**
 *
 * @author Nagla Essam
 */
public class JPEG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> inputStream = new ArrayList<Integer>();
        
        ArrayList<String> compressedOutput = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        for (int i=0 ; i<25 ; i++){
            inputStream.add(in.nextInt());
        }
        Compression c = new Compression(inputStream);
        compressedOutput = c.compress();
        System.out.println("output : " + compressedOutput);
    }
    
}
