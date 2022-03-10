package uz.pdp.appwarehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Nurkulov Nodirbek 3/10/2022  12:06 PM
@RestController
public class HomeController {
    @GetMapping("/home")
    public String getHome(){
        return "/home is accessed";
    }
}
