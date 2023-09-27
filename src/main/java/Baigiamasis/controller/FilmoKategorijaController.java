package Baigiamasis.controller;
import Baigiamasis.Model.entity.FilmoKategorija;
import Baigiamasis.Model.repository.FilmoKategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FilmoKategorijaController {
    @Autowired
    FilmoKategorijaRepository filmoKategorijaRepository;
    @GetMapping ("/kategorijos/gauti-visas")
    public String gautiVisasKategorijas(Model model) {
        List<FilmoKategorija> visosKategorijos = filmoKategorijaRepository.findAll();
        model.addAttribute("visosKategorijos", visosKategorijos);
        return "Kategorijos/Visos_kategorijos.html";
    }
    @GetMapping("/kategorijos/visi-filmai/{id}")
    public String kategorijosFilmai(Model model, @PathVariable long id) {
        FilmoKategorija kategorija = filmoKategorijaRepository.findById(id);
        model.addAttribute("kategorija", kategorija);
        return "Kategorijos/visi_filmai.html";
    }

    @PostMapping("/kategorija/istrinti/{id}")
    public String kategorijaIstrinti(Model model, @PathVariable long id) {
        filmoKategorijaRepository.deleteById(id);
        return "Kategorijos/istrintas.html";
    }

    @GetMapping("/kategorija/pridejimas")
    public String kategorijaPrideti(Model model) {
        model.addAttribute("kategorija", new FilmoKategorija());
        return "Kategorijos/pridejimas.html";
    }

    @PostMapping("/kategorija/pridetas")
    public String kategorijaPrideta(Model model, @ModelAttribute FilmoKategorija filmoKategorija) {
        filmoKategorijaRepository.save(filmoKategorija);
        return "Kategorijos/pridetas.html";
    }

    @GetMapping("/kategorija/redagavimas/{id}")
    public String kategorijaRedaguoti(Model model, @PathVariable long id) {
        FilmoKategorija kategorija = filmoKategorijaRepository.findById(id);
        model.addAttribute("kategorija", kategorija);
        return "Kategorijos/redagavimas.html";
    }
}

