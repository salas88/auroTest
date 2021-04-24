package com.example.test.controller;

import com.example.test.dao.SetEntityDao;
import com.example.test.entity.KPAC;
import com.example.test.entity.SetEntity;
import com.example.test.service.KPACService;
import com.example.test.service.SetEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class ForNewWindowController {

    @Autowired
    private SetEntityService setEntityService;
    @Autowired
    private KPACService kpacService;
    @Autowired
    private SetEntityDao setEntityDao;



    @GetMapping
    public String geMainPage(){
        return "redirect:/kpacs";
    }

    @GetMapping("/set{id}")
    public String open(Model theModel, @RequestParam("id") int id){

        SetEntity setEntity = setEntityService.findById(id).get();
        List<KPAC> kpacList = setEntity.getKpacs();

        theModel.addAttribute("set",setEntity );
        theModel.addAttribute("kpacs", kpacList);

        return "set-kpacs";
    }

    @GetMapping("/set/delete{id}")
    public String deleteKPacFromSet(@RequestParam("id") int id,
                                    HttpServletRequest request){
        String referer = request.getHeader("Referer");
        String [] parts = referer.split("=");
        int setId = Integer.parseInt(parts[1]);

        SetEntity setEntity = setEntityService.findById(setId).get();
        setEntity.deleteByid(id-1);
        setEntityService.save(setEntity);

        return "redirect:" + referer;
    }
}
