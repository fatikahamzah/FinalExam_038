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
   private Integer price;
   private Integer number;
   private Integer total;
   
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
   public int getPrice() {
       return price;
   }
   public void setPrice(int price) {
       this.price = price;
   }
   public int getNumber() {
       return number;
   }
   public void setNumber(int number) {
       this.number = number;
   }
   public int  getTotal() {
       return total;
   }
   public void setTotal() {
       this.total = price * number;
   }
}