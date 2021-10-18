package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {

    private PersonService personService = new PersonService();

    @GetMapping("/")
    public String index(@RequestParam (required = false) String hey, Model model) {
        model.addAttribute("message", hey);
        return "hello";
    }


    @GetMapping("/find")
    public String find(Model model) {
        Person found = personService.findPerson();
        model.addAttribute("person", found);
        return "person";
    }

    @GetMapping("/items")
    public String passParametersWithModel(Model model) {
        List<Integer> items = Arrays.asList(100,200,300);
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/create")
    public String create() {
        return "createForm";
    }

    @PostMapping("/addPerson")
    public String addPerson(@RequestParam String name, @RequestParam int age, Model model) {
        personService.createPerson(name, age);
        Person ny = personService.findPerson();
        model.addAttribute("person", ny);
        return "person";
    }

    @GetMapping("/people")
    public String passParametersWithModel2(Model model) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Oliver", 22));
        people.add(new Person("Lise", 25));
        model.addAttribute("people", people);
        return "people";
    }

    @GetMapping("/calc")
    @ResponseBody
    public String passfromForm(@RequestParam int num1, @RequestParam int num2, Model model) {
         return num1 + num2 + "";
    }

}
