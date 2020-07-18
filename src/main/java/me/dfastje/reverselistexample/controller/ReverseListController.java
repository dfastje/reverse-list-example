package me.dfastje.reverselistexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReverseListController {

    @GetMapping("/sanity-check")
    public String sanityCheck(){
        String exampleEndpointString = "are you?";
        System.out.println(exampleEndpointString);
        return exampleEndpointString;
    }

    @PostMapping("/reverse-list")
    public List<String> reverseList(@RequestBody List<String> inputList){


        return null;
    }

}
