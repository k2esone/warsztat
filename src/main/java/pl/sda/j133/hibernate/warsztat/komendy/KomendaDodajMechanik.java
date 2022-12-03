package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;

public class KomendaDodajMechanik implements Komenda {
    @Override
    public String getKomenda() {
        return "dodaj mechanika";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie mechanika");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikacje mechanika");
        String kwalifikacje = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizacje mechanika");
        String specjalizacja = Komenda.scanner.nextLine();

        Mechanik mechanik = Mechanik.builder()
                .imie(imie)
                .kwalifikacje(kwalifikacje)
                .specjalizacja(specjalizacja)
                .build();

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(mechanik);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Blad: " + e);
        }

    }
}
