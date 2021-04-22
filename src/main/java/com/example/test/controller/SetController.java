package com.example.test.controller;

import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;
import com.example.test.service.KPACService;
import com.example.test.service.SetEntityService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public String getAllSet(Model theModel){

        SetEntity setEntity = new SetEntity();
        theModel.addAttribute("set", setEntity);

        theModel.addAttribute("sets", setEntityService.findAll());

        theModel.addAttribute("kpacs", kpacService.findAll());
        return "set-page";
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
