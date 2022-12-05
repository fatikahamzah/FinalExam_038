/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.project04;

/**
 *
 * @author asus
 */

//deklarasi kelas
public class Product {
    //variabel string id
   private String id;
   //variabel string name
   private String name;
   
   //method input id
   public String getId() {
      return id;
   }
   //method display id
   public void setId(String id) {
      this.id = id;
   }
   //method input name
   public String getName() {
      return name;
   }
   //method display name
   public void setName(String name) {
      this.name = name;
   }
}