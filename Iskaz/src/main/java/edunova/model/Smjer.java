package edunova.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Smjer extends Entitet {

    @Column(nullable = false)
    private String naziv;
    private BigDecimal cijena;
    private BigDecimal upisnina;
    private Integer trajanje;
    @Column(columnDefinition = "boolean")
    private Boolean verificiran;
    @OneToMany(mappedBy = "smjer")
    private List<Iskaz> grupe = new ArrayList<>();

    @Override
    public String toString() {
        return naziv;
    }
   
}
