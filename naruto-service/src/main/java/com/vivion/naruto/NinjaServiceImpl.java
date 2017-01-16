package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.bean.MemberNinja;
import com.vivion.naruto.bean.MemberNinjaLog;
import com.vivion.naruto.dao.MemberNinjaDao;
import com.vivion.naruto.dao.MemberNinjaLogDao;
import com.vivion.naruto.enums.MemberNinjaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
@Service
public class NinjaServiceImpl implements NinjaService {

    private static Logger logger = LoggerFactory.getLogger(NarutoServiceImpl.class);

    @Resource
    private MemberNinjaDao memberNinjaDao;
    @Resource
    private MemberNinjaLogDao memberNinjaLogDao;

    @Override
    public List<MemberNinja> getNinjaList(MemberNinjaView memberNinjaView) {
        MemberNinja memberNinja = new MemberNinja();
        memberNinja.setUserId(memberNinjaView.getUserId());
        memberNinja.setNinja(memberNinjaView.getNinja());
        memberNinja.setIsValid(1);
        return memberNinjaDao.query(memberNinja);
    }

    @Override
    public ResultEx addNinja(MemberNinjaView memberNinjaView) {
        ResultEx resultEx = new ResultEx();
        MemberNinja memberNinja = new MemberNinja();
        BeanUtils.copyProperties(memberNinjaView, memberNinja);
        memberNinja.setCreateTime(new Date());
        memberNinja.setIsValid(1);
        memberNinjaDao.add(memberNinja);
        //添加日志
        MemberNinjaLog memberNinjaLog = new MemberNinjaLog();
        memberNinjaLog.setCreateTime(new Date());
        BeanUtils.copyProperties(memberNinjaView, memberNinjaLog);
        memberNinjaLog.setCreateTime(new Date());
        memberNinjaLogDao.add(memberNinjaLog);
        return resultEx.makeSuccessResult();
    }

    @Override
    public ResultEx modifyNinja(MemberNinjaView memberNinjaView) {
        ResultEx resultEx = new ResultEx();
        MemberNinja memberNinja = new MemberNinja();
        BeanUtils.copyProperties(memberNinjaView, memberNinja);
        memberNinja.setUpdateTime(new Date());
        memberNinjaDao.update(memberNinja);
        //添加日志
        MemberNinjaLog memberNinjaLog = new MemberNinjaLog();
        memberNinjaLog.setCreateTime(new Date());
        memberNinjaLog.setFightingForce(memberNinjaView.getFightingForce());
        memberNinjaLog.setMagicResistance(memberNinjaView.getMagicResistance());
        memberNinjaLog.setNinja(memberNinjaView.getNinja());
        memberNinjaLog.setUserId(memberNinjaView.getUserId());
        memberNinjaLogDao.add(memberNinjaLog);
        return resultEx.makeSuccessResult();
    }

    @Override
    public ResultEx deleteNinja(MemberNinjaView memberNinjaView) {
        ResultEx resultEx = new ResultEx();
        MemberNinja memberNinja = new MemberNinja();
        BeanUtils.copyProperties(memberNinjaView, memberNinja);
        memberNinja.setIsValid(0);
        memberNinjaDao.update(memberNinja);
        return resultEx.makeSuccessResult();
    }


}
