package com.vivion.naruto.controller;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.NarutoService;
import com.vivion.naruto.bean.Member;
import com.vivion.naruto.enums.MemberView;
import com.vivion.naruto.enums.VerifyInfoView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
@Controller
@RequestMapping("/naruto")
public class NatutoController {

    private static Logger logger = LoggerFactory.getLogger(NatutoController.class);

    @Autowired
    private NarutoService narutoService;
    //,method= RequestMethod.POST

    @ResponseBody
    @RequestMapping(value = "/getUserList")
    public List<Member> getUserList(MemberView memberParamter) {
        return narutoService.getUserList(memberParamter);
    }

    @ResponseBody
    @RequestMapping(value = "/addUser")
    public ResultEx addUser(MemberView memberParamter) {
        return narutoService.addUser(memberParamter);
    }

    @ResponseBody
    @RequestMapping(value = "/modifyUser")
    public ResultEx modifyUser(MemberView memberParamter) {
        return narutoService.modifyUser(memberParamter);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser")
    public ResultEx deleteUser(MemberView memberParamter) {
        return narutoService.deleteUser(memberParamter);
    }

    @ResponseBody
    @RequestMapping(value = "/verify")
    public ResultEx verify(VerifyInfoView verifyInfoView) {
        return narutoService.verify(verifyInfoView);
    }
}
