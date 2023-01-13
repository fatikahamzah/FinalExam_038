/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexam.finalexam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import finalexam.finalexam.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fatika Mirtananda 038
 */
@RestController
@CrossOrigin
@ResponseBody
public class MyController {
    Person data = new Person();
    PersonJpaController control = new PersonJpaController();
    
    @GetMapping(value="/GET", produces = APPLICATION_JSON_VALUE)
    public List<Person> getData(){
        List<Person> buffer = new ArrayList<>();
        buffer = control.findPersonEntities();
        return buffer;
    }    
    
    @PostMapping(value = "/POST", consumes = APPLICATION_JSON_VALUE)
    public String sendData(HttpEntity<String> datasend) throws JsonProcessingException{
        String feedback = "Do Nothing";
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(datasend.getBody(), Person.class);
        try {
            control.create(data);
            feedback = data.getNama() + "Tersimpan";
        } catch (Exception error) {
            feedback = "ERROR" + error.getMessage();
        }
            return feedback; 
    }
    
    @PutMapping(value = "/PUT", consumes = APPLICATION_JSON_VALUE)
    public String editData(HttpEntity<String> datasend) throws JsonProcessingException{
        String feedback = "Do Nothing";
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(datasend.getBody(), Person.class);
        try {
            control.edit(data);
            feedback = data.getNama() + "Edited";
        } catch (Exception error) {
            feedback ="ERROR" +  error.getMessage();
        }
            return feedback;  
    }
    
    @DeleteMapping(value = "/DELETE", consumes = APPLICATION_JSON_VALUE)
    public String deleteData(HttpEntity<String> datasend) throws JsonProcessingException, NonexistentEntityException{
        String feedback = "Do Nothing";
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(datasend.getBody(), Person.class);
        try {
            control.destroy(data.getId());
            feedback = data.getNama() + "Terhapus";
        } catch (NonexistentEntityException error) {
            feedback = error.getMessage();
        }
            return feedback;
        
    }
    
}
