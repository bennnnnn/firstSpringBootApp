package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


        @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping("/index")

    public  String  index(Model model){
        model.addAttribute("message", "Hello");

        return  "hello";
    }

    @RequestMapping("/addProduct")

    public  String  addProduct(Model model){
       model.addAttribute("message", "Adding products");

        return  "Adding products";
    }


    @RequestMapping("/listProducts")
        public   String listProducts(){
            return "THis is a list of your products.";

        }

        @RequestMapping("/thankYou")
        public String thankYou(){
            return  "Thank you for shopping with us.";
        }



}



