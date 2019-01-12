package com.jcy.jenkins.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    private static List<String> list = new ArrayList<>();

    @RequestMapping(value="/6")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/more")
    public String more(Model model) {
        long current = System.currentTimeMillis();
        for (int i=0; i<5; i++) {
            list.add(current + "-more-" + i);
        }

        model.addAttribute("msgs", list);
        return "index::msgTable";

    }

}
