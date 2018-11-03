package com.smoothspark.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SmoothSpark in 10/31/2018
 */
@Controller
public class IndexController {

    @RequestMapping({"", "index", "/", "index.html"})
    public String index() {

        return "index";
    }
}
