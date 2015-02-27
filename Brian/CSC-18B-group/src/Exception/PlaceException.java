/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

//Place ship exception
public class PlaceException extends Exception{
  private String temp;
  public PlaceException(String temp){
    this.temp=temp;
  }
}
