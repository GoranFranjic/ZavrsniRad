package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Iskaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_iskaza;

    private Integer djelatnikId; // ID Djelatnika
    private Integer artikalId;   // ID Artikla

    private Date datum;

    public Integer getId_iskaza() {
        return id_iskaza;
    }

    public void setId_iskaza(Integer id_iskaza) {
        this.id_iskaza = id_iskaza;
    }

    public Integer getDjelatnikId() {
        return djelatnikId;
    }

    public void setDjelatnikId(Integer djelatnikId) {
        this.djelatnikId = djelatnikId;
    }

    public Integer getArtikalId() {
        return artikalId;
    }

    public void setArtikalId(Integer artikalId) {
        this.artikalId = artikalId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Object getArtikal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getDjelatnik() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
  
   
}
