package Baigiamasis.controller;
import Baigiamasis.Model.entity.Filmai;
import Baigiamasis.Model.entity.FilmoKategorija;
import Baigiamasis.Model.repository.FilmaiRepository;
import Baigiamasis.Model.repository.FilmoKategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmaiController {

    @Autowired
    FilmaiRepository filmaiRepository;
    @Autowired
    FilmoKategorijaRepository kategorijaRepository;

    @GetMapping("/filmai/paieska")
    public String filmoPaieska(Model model, @RequestParam(required = false) String pavadinimas) {
        List<Filmai> visiFilmai;
        if (StringUtils.isEmpty(pavadinimas)) {
            visiFilmai = filmaiRepository.findAll();
        } else {
            visiFilmai = filmaiRepository.findByPavadinimasLike("%" + pavadinimas + "%");
        }
        model.addAttribute("visiFilmai", visiFilmai);
        return "filmai/paieska.html";
    }
    @GetMapping("/filmai/informacija/{id}")
    public String filmoInformacija(Model model, @PathVariable long id) {
        Filmai filmai = filmaiRepository.findById(id);
        model.addAttribute("filmai", filmai);
        return "filmai/informacija.html";
        }
    @PostMapping("/filmai/istrinti/{id}")
    public String istrintiFilma(Model model, @PathVariable long id) {
        filmaiRepository.deleteById(id);
        return "filmai/istrintas.html";
    }

    @GetMapping("/filmai/pridejimas")
    public String filmoPridejimas(Model model) {
        model.addAttribute("filmai", new Filmai());
        List<FilmoKategorija> kategorijos = kategorijaRepository.findAll();
        model.addAttribute("kategorijos", kategorijos);
        return "filmai/pridejimas.html";
    }

    @PostMapping("/filmai/pridetas")
    public String filmasPridetas(Model model, @ModelAttribute Filmai filmai) {
        filmaiRepository.save(filmai);
        return "filmai/pridetas.html";
    }

    @GetMapping("filmai/redagavimas/{id}")
    public String filmoRedagavimas(Model model, @PathVariable long id) {
        Filmai filmai = filmaiRepository.findById(id);
        model.addAttribute("filmai", filmai);
        List<FilmoKategorija> kategorijos = kategorijaRepository.findAll();
        model.addAttribute("kategorijos", kategorijos);
        return "filmai/redagavimas.html";
    }

}