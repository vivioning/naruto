package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.dao.MemberNinjaDao;
import com.vivion.naruto.dao.MemberNinjaLogDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
@Service
public class TeamServiceImpl implements TeamService {

    private static Logger logger = LoggerFactory.getLogger(NarutoServiceImpl.class);

    @Resource
    private MemberNinjaDao memberNinjaDao;
    @Resource
    private MemberNinjaLogDao memberNinjaLogDao;


    @Override
    public ResultEx distribute(String teamTime) {
        ResultEx resultEx = new ResultEx();
        return resultEx.makeFailedResult();
    }
}
