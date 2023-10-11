/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Artikal;
import edunova.model.Djelatnik;
import edunova.model.Iskaz;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author goran
 */
public class PocetniInsert {
    
    private static final int BROJ_ARTIKALA = 12;
    private static final int BROJ_DJELATNIKA = 11256;
    //private static final int BROJ_ISKAZA = 7;
       
    private final Faker faker;
    private final Session session;
    private final List<Artikal> artikli;
    private final List<Djelatnik> djelatnici;
    //private List<Iskaz> iskazi;

    
    public PocetniInsert() {
        faker = new Faker();
        session = HibernateUtil.getSession();
        artikli = new ArrayList<>();
        djelatnici = new ArrayList<>();
        //iskazi = new ArrayList<>();
        session.getTransaction().begin();
        
        
        
        kreirajArtikle();
        kreirajDjelatnike();
        //kreirajIskaze();
        session.getTransaction().commit();
    }

    
    private void kreirajArtikle() {
        
        Artikal a;
       
        for (int i = 0; i < BROJ_ARTIKALA; i++) {
            a = new Artikal();
            a.setNaziv(faker.beer().name());
            a.setCijena(new BigDecimal(faker.number().numberBetween(910, 1560)));
            a.setId_artikla(faker.number().numberBetween(50, 120));
            session.persist(a);
            artikli.add(a);
        }
    }

    
    private void kreirajDjelatnike() {
        
        Djelatnik d;
        for (int i = 0; i < BROJ_DJELATNIKA; i++) {
            d = new Djelatnik();
          //  d.setIme(faker.name().firstName());
           // d.setPrezime(faker.name().lastName());
            
           
            
            session.persist(d);
            djelatnici.add(d);
            
        }
        
    }
    
        }
        
   
        
