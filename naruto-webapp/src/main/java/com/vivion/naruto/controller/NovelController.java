package com.vivion.naruto.controller;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.NovelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GuoXinJie on 2017-01-22.
 */
@Controller
@RequestMapping("/novel")
public class NovelController {
    private static Logger logger = LoggerFactory.getLogger(NovelController.class);

    @Autowired
    private NovelService novelService;

    @ResponseBody
    @RequestMapping(value = "/getNovel")
    public ResultEx getNovel(String date) {
        return novelService.getNovel(date);
    }
}
