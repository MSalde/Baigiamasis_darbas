package Baigiamasis.controller;
import Baigiamasis.Model.entity.Komentarai;
import Baigiamasis.Model.entity.Filmai;
import Baigiamasis.Model.entity.Vartotojas;
import Baigiamasis.Model.repository.KomentarasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

@Controller
public class KomentaraiController {

    @Autowired
    KomentarasRepository komentarasRepository;

    @PostMapping("/komentaras/prideti/{id}")
    public String pridetiKomentara(Model model, @PathVariable long id, @RequestParam String pridedamasKomentaras) {
        Komentarai komentaras = new Komentarai();
        komentaras.setTekstas(pridedamasKomentaras);
        komentaras.setPridejimoData(new Date());
        Filmai filmai = new Filmai();
        filmai.setId(id);
        komentaras.setFilmai(filmai);
        Vartotojas vartotojas = new Vartotojas();
        vartotojas.setId(1);
        komentaras.setVartotojas(vartotojas);

        komentarasRepository.save(komentaras);
        return "komentaras/pridetas.html";
    }
}
