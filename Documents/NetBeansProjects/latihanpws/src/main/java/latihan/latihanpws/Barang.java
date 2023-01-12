/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan.latihanpws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "barang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b"),
    @NamedQuery(name = "Barang.findById", query = "SELECT b FROM Barang b WHERE b.id = :id"),
    @NamedQuery(name = "Barang.findByNamabarang", query = "SELECT b FROM Barang b WHERE b.namabarang = :namabarang"),
    @NamedQuery(name = "Barang.findByJumlahbarang", query = "SELECT b FROM Barang b WHERE b.jumlahbarang = :jumlahbarang")})
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "namabarang")
    private String namabarang;
    @Basic(optional = false)
    @Column(name = "jumlahbarang")
    private int jumlahbarang;

    public Barang() {
    }

    public Barang(Integer id) {
        this.id = id;
    }

    public Barang(Integer id, String namabarang, int jumlahbarang) {
        this.id = id;
        this.namabarang = namabarang;
        this.jumlahbarang = jumlahbarang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public int getJumlahbarang() {
        return jumlahbarang;
    }

    public void setJumlahbarang(int jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "latihan.latihanpws.Barang[ id=" + id + " ]";
    }
    
}
