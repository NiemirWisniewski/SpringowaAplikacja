package pl.nw.oceniarka.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @RequestMapping("/home")
    @GetMapping
    public String home(){
        return "Strona główna";
    }

}
