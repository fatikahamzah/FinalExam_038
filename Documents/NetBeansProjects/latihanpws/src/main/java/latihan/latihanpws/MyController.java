/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan.latihanpws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asus
 */
@RestController
@RequestMapping("/barang")

public class MyController {

    Barang brg = new Barang();
    BarangJpaController ctrl = new BarangJpaController();

    List<Barang> barangList = new ArrayList<Barang>();

    @GetMapping()
    public List<Barang> viewAll() {
        try {
            return ctrl.findBarangEntities();
        } catch (Exception e) {
            return List.of();
        }

    }
    
    @PostMapping()
    public String postBarang(@RequestBody Barang barang) // get data barang from
    {
        try {
            ctrl.create(barang);
            return "Data Saved";
        } catch (Exception e) {
            return "Failed to save data";
        }

    }
    
    @GetMapping("/{id}")
    public List<Barang> viewDatabyId(@PathVariable("id") int id) {
        try {
            brg = ctrl.findBarang(id);
            barangList.clear();
            barangList.add(brg);
            return barangList;
        } catch (Exception e) {
            return List.of();
        }
    }
    
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editData(@PathVariable("id") int id, @RequestBody Barang data) {
        String rslt = "Data has been updated";
        try {
            data.setId(id);
            ctrl.edit(data);
        } catch (Exception e) {
            rslt = e.toString() + " Update Failed";
        }
        
        return rslt;
    }    
    
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable("id") int id) {
        String rslt = "Data has been deleted";
        try {
            ctrl.destroy(id);
        } catch (Exception e) {
            rslt = "Delete Failed";
        }
        
        return rslt;
    }
}    
    



