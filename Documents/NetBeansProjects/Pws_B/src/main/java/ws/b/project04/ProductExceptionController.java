/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.project04;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 *
 * @author asus
 */
//controller untuk exception 
@ControllerAdvice
public class ProductExceptionController {
   @ExceptionHandler(value = ProductNotFoundException.class)
   public ResponseEntity<Object> exception(ProductNotFoundException exception) {
      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
   }
}
