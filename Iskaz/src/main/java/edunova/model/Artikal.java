package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Artikal{
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_artikla;
        private String naziv;
        private BigDecimal cijena;
        @ManyToOne
        private JedMjera JedMjera;

    public Integer getId_artikla() {
        return id_artikla;
    }

    public void setId_artikla(Integer id_artikla) {
        this.id_artikla = id_artikla;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public JedMjera getJedMjera() {
        return JedMjera;
    }

    public void setJedMjera(JedMjera JedMjera) {
        this.JedMjera = JedMjera;
    }

    

}