package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@Entity
public class JedMjera {
	 @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_JedMjere;
	private String naziv;

    public Integer getId_JedMjere() {
        return id_JedMjere;
    }

    public void setId_JedMjere(Integer id_JedMjere) {
        this.id_JedMjere = id_JedMjere;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

   
        

}
