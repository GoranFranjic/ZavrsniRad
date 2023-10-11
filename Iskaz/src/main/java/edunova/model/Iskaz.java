package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Iskaz {
     @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_iskaza;
	
	private String naziv;
        
        @ManyToOne
	private Djelatnik djelatnik;
        
        @ManyToOne
	private Artikal artikal;
        
	private Date datumPocetka;

    public Integer getId_iskaza() {
        return id_iskaza;
    }

    public void setId_iskaza(Integer id_iskaza) {
        this.id_iskaza = id_iskaza;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Djelatnik getDjelatnik() {
        return djelatnik;
    }

    public void setDjelatnik(Djelatnik djelatnik) {
        this.djelatnik = djelatnik;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }
        
}