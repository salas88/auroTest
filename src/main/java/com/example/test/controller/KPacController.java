package com.example.test.controller;

import com.example.test.entity.KPAC;
import com.example.test.service.KPACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kpacs")
public class KPacController {
    @Autowired
    private KPACService kpacService;

    @GetMapping()
    public String getAllObject(Model theModel){

        theModel.addAttribute("kpac", new KPAC());
        theModel.addAttribute("kpacs", kpacService.findAll());
        return "main-page";
    }

    @GetMapping("/delete")
    public String deleteKPac(@RequestParam("id") int theId) {
        kpacService.delete(theId);
        return "redirect:/kpacs";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute KPAC kpac){
        kpacService.save(kpac);
        return "redirect:/kpacs";
    }

}
