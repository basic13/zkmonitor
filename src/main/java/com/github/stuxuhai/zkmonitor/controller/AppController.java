package com.github.stuxuhai.zkmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 乔燃 on 15/12/1.
 */
@Controller
@RequestMapping("")
public class AppController {
    @RequestMapping("/")
    public String welcomeHtml() {
        return "redirect:/cluster/view";
    }
}
