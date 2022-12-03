package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.model.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaDodajSerwisPojazdu implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;
    private DataAccessObject<Pojazd> dataAccessPojazd;
    private DataAccessObject<Mechanik> dataAccessMechanik;

    public KomendaDodajSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessPojazd = new DataAccessObject<>();
        this.dataAccessMechanik = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj pojazd";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id serwisowanego pojazdu:");
        String idString = Komenda.scanner.nextLine();
        Long idPojazd = Long.parseLong(idString);

        Optional<Pojazd> pojazdOptional = dataAccessPojazd.find(Pojazd.class, idPojazd);
        if (pojazdOptional.isEmpty()) {
            System.err.println("Pojazd nie istnieje, nie mozna dodac zlecenia serwisowego!");
            return;
        }

        System.out.println("Podaj id mechanika:");
        String idString2 = Komenda.scanner.nextLine();
        Long idMechanik = Long.parseLong(idString2);

        Optional<Mechanik> mechanikOptional = dataAccessMechanik.find(Mechanik.class, idMechanik);
        if (mechanikOptional.isEmpty()) {
            System.err.println("Mechanik nie istnieje, nie mozna dodac zlecenia serwisowego!");
            return;
        }

        System.out.println("Podaj opis serwisu (co jest do zrobienia?):");
        String opis = scanner.nextLine();

        SerwisPojazdu serwisPojazdu = SerwisPojazdu.builder()
                .mechanik(mechanikOptional.get())
                .pojazd(pojazdOptional.get())
                .opis(opis)
                .build();

        dataAccessObject.insert(serwisPojazdu);
        System.out.println("Dodano serwis!");

    }
}
