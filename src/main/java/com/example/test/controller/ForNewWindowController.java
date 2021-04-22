package com.example.test.controller;

import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;
import com.example.test.service.SetEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ForNewWindowController {

    @Autowired
    private SetEntityService setEntityService;

    @GetMapping("/set{id}")
    public String open(Model theModel, @RequestParam("id") int id){

        SetEntity setEntity = setEntityService.findById(id).get();
        List<KPAC> kpacList = setEntity.getKpacs();

        theModel.addAttribute("set",setEntity );
        theModel.addAttribute("kpacs", kpacList);

        return "set-kpacs";
    }
}
