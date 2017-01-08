package com.vivion.naruto.controller;

import com.vivion.naruto.NarutoService;
import com.vivion.naruto.bean.Member;
import com.vivion.naruto.enums.MemberParamter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
@Controller
@RequestMapping("/naruto")
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private NarutoService narutoService;

    @ResponseBody
    @RequestMapping(value = "/userList",method= RequestMethod.POST)
    public List<Member> getUserList(MemberParamter memberParamter) {
        return narutoService.getUserList(memberParamter);
    }


    @RequestMapping(value = "/test",method= RequestMethod.GET)
    public String test() {
        return "你数组";
    }
}
