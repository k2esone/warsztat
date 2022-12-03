package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;

public class KomendaUsunPojazd implements Komenda {
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaUsunPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun pojazd";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego pojazdu:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Pojazd.class, id)) {
            System.out.println("Usunieto pojazd!");
        } else {
            System.err.println("Nie udalo sie usunac pojazd!");
        }
    }
}
