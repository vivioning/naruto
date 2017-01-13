package com.vivion.naruto.controller;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    private static Logger logger = LoggerFactory.getLogger(NinjaController.class);

    @Autowired
    private TeamService teamService;

    @ResponseBody
    @RequestMapping(value = "/distribute")
    public ResultEx distribute(String teamTime) {
        return teamService.distribute(teamTime);
    }
}
