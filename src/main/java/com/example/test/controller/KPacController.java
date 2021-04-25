package com.example.test.controller;

import com.example.test.entity.KPAC;
import com.example.test.service.KPACService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kpacs")
public class KPacController {

    @Autowired
    private KPACService kpacService;

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum,
                           @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir){


        Page<KPAC> page = kpacService.listAll(pageNum,sortField, sortDir);
        List<KPAC> listKpacs = page.getContent();

        model.addAttribute("kpac", new KPAC());
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("kpacs", listKpacs);
        return "kpacs";
    }

    @GetMapping("")
    public String getAllObject(Model theModel){
        theModel.addAttribute("kpac", new KPAC());
        return viewPage(theModel, 1,"id", "asc");
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
