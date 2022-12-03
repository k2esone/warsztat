package pl.sda.j133.hibernate.warsztat.komendy;


import pl.sda.j133.hibernate.warsztat.model.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaZnajdzSerwisPojazdu implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaZnajdzSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz serwis pojazdu";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id szukanego serwisu pojazdu:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        Optional<SerwisPojazdu> serwisPojazduOptional = dataAccessObject.find(SerwisPojazdu.class, id);
        if (serwisPojazduOptional.isPresent()) {
            System.out.println(serwisPojazduOptional.get());
        } else {
            System.err.println("Nie znaleziono serwisu pojazdu!");
        }

    }
}
