/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author Himkw_000
 */
public class JavaApplication9 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    int[][] a = new int[5][5];
    int q=0;
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        a[i][j]=q;
        q++;
      }
    }
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("myFile.txt"), "utf-8"))) {
        writer.write("text to write\n");
        for(int i=0;i<5;i++){
          for(int j=0;j<5;j++){
            writer.write(new Integer(a[i][j]).toString());
            writer.write(" ");
          }
          writer.write("\n");
        }
    } catch (IOException ex) {
        // handle me
    }  
  }
  
}
