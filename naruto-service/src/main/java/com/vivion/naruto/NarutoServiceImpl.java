package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.bean.Member;
import com.vivion.naruto.dao.MemberDao;
import com.vivion.naruto.enums.MemberView;
import com.vivion.naruto.enums.UserView;
import com.vivion.naruto.enums.VerifyInfoView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        member.setId(memberView.getId());
        member.setIsValid(1);
        return memberDao.query(member);
    }

    @Override
    public List<UserView> user() {
        Member member = new Member();
        member.setIsValid(1);
        List<Member> members = memberDao.query(member);
        List<UserView> userViewList = new ArrayList<UserView>();
        for (int i = 0; i < members.size(); i++) {
            UserView userView = new UserView();
            userView.setId(members.get(i).getId());
            userView.setUserName(members.get(i).getNickName());
            userViewList.add(userView);
        }
        return userViewList;
    }

    @Override
    public ResultEx addUser(MemberView memberView) {
        ResultEx resultEx = new ResultEx();
        Member member = new Member();
        BeanUtils.copyProperties(memberView, member);
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
