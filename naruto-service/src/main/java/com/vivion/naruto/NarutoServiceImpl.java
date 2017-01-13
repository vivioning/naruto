package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.bean.Member;
import com.vivion.naruto.dao.MemberDao;
import com.vivion.naruto.enums.MemberView;
import com.vivion.naruto.enums.VerifyInfoView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by Mr.vivion on 2017/1/8.
 */
@Service
public class NarutoServiceImpl implements NarutoService {

    private static Logger logger = LoggerFactory.getLogger(NarutoServiceImpl.class);

    @Resource
    private MemberDao memberDao;
    @Override
    public List<Member> getUserList(MemberView memberView) {
        Member member = new Member();
        member.setIsValid(1);
        List<Member> members = memberDao.query(member);
        //logger.info(String.valueOf(memberDao.query(member)));
        return memberDao.query(member);
    }

    @Override
    public ResultEx addUser(MemberView memberView) {
        ResultEx resultEx = new ResultEx();
        Member member = new Member();
        BeanUtils.copyProperties(memberView,member);
        member.setIsValid(1);
        memberDao.add(member);
        return resultEx.makeSuccessResult();
    }

    @Override
    public ResultEx modifyUser(MemberView memberView) {
        ResultEx resultEx = new ResultEx();
        Member member = new Member();
        BeanUtils.copyProperties(memberView,member);
        member.setIsValid(1);
        memberDao.update(member);
        return resultEx.makeSuccessResult();
    }

    @Override
    public ResultEx deleteUser(MemberView memberView) {
        ResultEx resultEx = new ResultEx();
        Member member = new Member();
        member.setId(memberView.getId());
        member.setIsValid(0);
        memberDao.update(member);
        return resultEx.makeSuccessResult();
    }

    @Override
    public ResultEx verify(VerifyInfoView verifyInfoView) {
        ResultEx resultEx = new ResultEx();
        String secretKet = "2017";
        if (verifyInfoView.getSecretKey().equals(secretKet)){
            resultEx.makeSuccessResult();
        }else {
            resultEx.makeFailedResult();
        }
        return resultEx;
    }
}
