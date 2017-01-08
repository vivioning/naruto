package com.vivion.naruto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mr.vivion on 2017/1/8.
 */

@Controller
@RequestMapping("/user")
public class NarutoController {
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "hello";
    }
}
