package com.example.loginhomevalid.controllingsec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Validcontroller {
    
    @GetMapping("/login")
    public String login(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}

        return "redirect:/display";
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/display")
    public String display(Model model){
        List<Cardmanager> list=new ArrayList<>();
        list.add(new Cardmanager("LADAKH", "/images/LADAKH.jpg"));
        list.add(new Cardmanager("GOA", "/images/GOA.jpg"));
        list.add(new Cardmanager("COORG", "/images/COORG.jpg"));
        list.add(new Cardmanager("MANALI", "/images/MANALI.jpg"));
        list.add(new Cardmanager("ANDMAN-NICOBAR", "/images/ANDAMAN-NICOBAR-ISLANDS.jpg"));
        list.add(new Cardmanager("SRINAGAR", "/images/SRINAGAR.jpg"));
        list.add(new Cardmanager("MANALI", "/images/MANALI.jpg"));
        list.add(new Cardmanager("PONDICHERY", "/images/PONDICHERY.jpeg"));
        model.addAttribute("lst",list);
        return "display";
    }
    @GetMapping("/table")
    public String booking(Model model){
        List<Booking> book=new ArrayList<>();
        book.add(new Booking(1, "sandeep", "ladakh", 5000));
        book.add(new Booking(2, "kishore", "goa", 4500));
        book.add(new Booking(3, "jishnu", "coorg", 3500));
        model.addAttribute("book", book);
        return "table";
    }
}
