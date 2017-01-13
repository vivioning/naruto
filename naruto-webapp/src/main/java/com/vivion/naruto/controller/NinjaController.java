package com.vivion.naruto.controller;

import com.hkfs.fundamental.api.data.ResultEx;
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
@RequestMapping("/ninja")
public class NinjaController {

    private static Logger logger = LoggerFactory.getLogger(NinjaController.class);

    @Autowired
    private NinjaService ninjaService;

    @ResponseBody
    @RequestMapping(value = "/getNinjaList")
    public List<MemberNinja> getNinjaList(MemberNinjaView memberNinjaView) {
        return ninjaService.getNinjaList(memberNinjaView);
    }

    @ResponseBody
    @RequestMapping(value = "/addNinja")
    public ResultEx addNinja(MemberNinjaView memberNinjaView) {
        return ninjaService.addNinja(memberNinjaView);
    }

    @ResponseBody
    @RequestMapping(value = "/modifyNinja")
    public ResultEx modifyNinja(MemberNinjaView memberNinjaView) {
        return ninjaService.modifyNinja(memberNinjaView);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteNinja")
    public ResultEx deleteNinja(MemberNinjaView memberNinjaView) {
        return ninjaService.deleteNinja(memberNinjaView);
    }
}
