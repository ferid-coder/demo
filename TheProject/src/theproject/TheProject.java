/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theproject;

import java.io.FileNotFoundException;

/**
 *
 * @author ferid
 */
public class TheProject extends FileNotFoundException {

    public int[] arr;
  
            

    public static void main(String[] args) throws InterruptedException, Exception {
        System.out.println( FileUtility.readObjectFile("Config.obj"));
       
    }
}
