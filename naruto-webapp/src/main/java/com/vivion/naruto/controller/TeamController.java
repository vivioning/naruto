package com.vivion.naruto.controller;

import com.vivion.naruto.NinjaService;
import com.vivion.naruto.bean.MemberNinja;
import com.vivion.naruto.enums.MemberNinjaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    private static Logger logger = LoggerFactory.getLogger(NinjaController.class);

    @Autowired
    private NinjaService ninjaService;

    @ResponseBody
    @RequestMapping(value = "/distribute")
    public List<MemberNinja> getNinjaList(MemberNinjaView memberNinjaView) {
        return ninjaService.getNinjaList(memberNinjaView);
    }
}
