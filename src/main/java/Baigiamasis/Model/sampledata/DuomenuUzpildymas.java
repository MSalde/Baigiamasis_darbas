package Baigiamasis.Model.sampledata;
import Baigiamasis.Model.entity.Filmai;
import Baigiamasis.Model.entity.FilmoKategorija;
import Baigiamasis.Model.entity.Komentarai;
import Baigiamasis.Model.entity.Vartotojas;
import Baigiamasis.Model.repository.FilmaiRepository;
import Baigiamasis.Model.repository.FilmoKategorijaRepository;
import Baigiamasis.Model.repository.KomentarasRepository;
import Baigiamasis.Model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DuomenuUzpildymas implements ApplicationListener<ContextRefreshedEvent> {
    boolean arJauYra = true;
    @Autowired
    FilmoKategorijaRepository filmoKategorijaRepository;

    @Autowired
    FilmaiRepository filmaiRepository;
    @Autowired
    VartotojasRepository vartotojasRepository;

    @Autowired
    KomentarasRepository komentarasRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!arJauYra) {
            sukurtiKategorijas();
            idetiFilmus();
            sukurtiVartotojus();
            sukurtiKomentarus();
        }
    }
    public void sukurtiKategorijas () {
        FilmoKategorija kategorija1 = new FilmoKategorija();
        kategorija1.setPavadinimas("Siaubo");
        FilmoKategorija kategorija2 = new FilmoKategorija();
        kategorija2.setPavadinimas("Veiksmo");
        FilmoKategorija kategorija3 = new FilmoKategorija();
        kategorija3.setPavadinimas("Komedija");
        FilmoKategorija kategorija4 = new FilmoKategorija();
        kategorija4.setPavadinimas("Mistinis");

        filmoKategorijaRepository.save(kategorija1);
        filmoKategorijaRepository.save(kategorija2);
        filmoKategorijaRepository.save(kategorija3);
        filmoKategorijaRepository.save(kategorija4);
    }
    public void idetiFilmus(){
        Filmai filmas1 = new Filmai();
        filmas1.setPavadinimas("Vienas Namuose");
        filmas1.setAprasymas("Aštuonerių metų Kevinas netyčia paliekamas, kai jo šeima išvyksta į Prancūziją...");
        filmas1.setImdbReitingas(8.5);
        FilmoKategorija kategorija1 = new FilmoKategorija();
        kategorija1.setId(3);
        filmas1.setKategorija(kategorija1);

        Filmai filmas2 = new Filmai();
        filmas2.setPavadinimas("Gladiatorius");
        filmas2.setAprasymas("Gladiatoriai dažni veikėjai filmuose, kurių pagrindinė tematika Romos imperija ...");
        filmas2.setImdbReitingas(8.8);
        FilmoKategorija kategorija2 = new FilmoKategorija();
        kategorija2.setId(2);
        filmas2.setKategorija(kategorija2);

        filmaiRepository.save(filmas1);
        filmaiRepository.save(filmas2);
    }
    public void sukurtiVartotojus() {
        Vartotojas vartotojas1 = new Vartotojas();
        vartotojas1.setUsername("anonimas");
        vartotojas1.setPassword("labasrytas123");

        Vartotojas vartotojas2 = new Vartotojas();
        vartotojas2.setUsername("belekas");
        vartotojas2.setPassword("visogero321");

        vartotojasRepository.save(vartotojas1);
        vartotojasRepository.save(vartotojas2);
    }

    public void sukurtiKomentarus() {
        Komentarai komentaras1 = new Komentarai();
        komentaras1.setTekstas("Labai patiko.");
        komentaras1.setPridejimoData(new Date());
        Filmai filmas1 = new Filmai();
        filmas1.setId(1);
        komentaras1.setFilmai(filmas1);
        Vartotojas vartotojas1 = new Vartotojas();
        vartotojas1.setId(1);
        komentaras1.setVartotojas(vartotojas1);

        Komentarai komentaras2 = new Komentarai();
        komentaras2.setTekstas("Geras filmas.");
        komentaras2.setPridejimoData(new Date());
        Filmai filmas2 = new Filmai();
        filmas2.setId(2);
        komentaras2.setFilmai(filmas2);
        Vartotojas vartotojas2 = new Vartotojas();
        vartotojas2.setId(2);
        komentaras2.setVartotojas(vartotojas2);

        komentarasRepository.save(komentaras1);
        komentarasRepository.save(komentaras2);
    }
}
