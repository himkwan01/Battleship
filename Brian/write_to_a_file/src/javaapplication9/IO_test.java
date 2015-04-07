/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 *
 * @author Himkw_000
 */
public class IO_test {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws UnsupportedEncodingException {
    // TODO code application logic here
    String str = "123";
    System.out.println((int)str.charAt(0));
    int[][] a = new int[5][5];
    int q=0;
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        a[i][j]=q;
        q++;
      }
    }
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("myFile.txt"), "utf-8"))) {
        for(int i=0;i<5;i++){
          for(int j=0;j<5;j++){
            writer.write(new Integer(a[i][j]).toString());
          }
          writer.write("\n");
        }
        //file closed
        writer.close();
    } catch (IOException ex) {
        // handle me
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("myFile.txt"), "utf-8"))) {
      String temp;
      while((temp=reader.readLine())!=null){
        System.out.println(temp);
        System.out.println(temp.length());
      }
      reader.close();
    } catch (IOException ex){
      
    }
  }
  
}
