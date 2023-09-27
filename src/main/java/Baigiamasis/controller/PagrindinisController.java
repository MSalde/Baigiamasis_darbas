package Baigiamasis.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagrindinisController { @GetMapping("/")
public String grazintiPagrindiniPuslapi() {
    return "index.html";

    }
}
