package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

public class KomendaUsunMechanik implements Komenda {
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaUsunMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego mechanika:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Mechanik.class, id)){
            System.out.println("Usunieto mechanika!");
        } else{
            System.err.println("Nie udalo sie usunac mechanika!");
        }
    }
}
