package com.example.test.controller;

import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;
import com.example.test.service.KPACService;
import com.example.test.service.SetEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sets")
public class SetController {

    @Autowired
    private SetEntityService setEntityService;
    @Autowired
    private KPACService kpacService;

    @GetMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum,
                           @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir){


        Page<SetEntity> page = setEntityService.listAll(pageNum,sortField, sortDir);
        List<SetEntity> setEntityList = page.getContent();

        model.addAttribute("set", new SetEntity());
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("sets", setEntityList);
        model.addAttribute("kpacs", kpacService.findAll());
        return "set-page";
    }

    @GetMapping
    public String getAllSet(Model theModel){

        theModel.addAttribute("set", new SetEntity());

        return viewPage(theModel, 1,"id", "asc");
    }

    @GetMapping("/delete")
    public String deleteKPacSets(@RequestParam("id") int theId ) {
        setEntityService.delete(theId);
        return "redirect:/sets";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SetEntity setEntity,
                       @RequestParam(value = "isChecked", required=false) List<String> list){

        List<Integer> ids = new ArrayList<>();
        List<KPAC> kpacs = new ArrayList<>();

        if(list != null){
            for (String s: list)
                ids.add(Integer.parseInt(s));
        }

        for (Integer id:
             ids) {
            kpacs.add(kpacService.findById(id).get());
        }

        setEntity.setKpacs(kpacs);
        setEntityService.save(setEntity);
        return "redirect:/sets";
    }


}
