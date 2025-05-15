package uj.ieee.computer.geeks.geeksLeagueWebsite.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/test")
public class testRest {

    public testRest(){

    }

    @GetMapping("/greet/{userName}")
    public String greet(@PathVariable String userName) {
        return "hello %s.".formatted(userName);
    }
    
}
