package com.vivion.naruto;

import com.vivion.naruto.bean.Member;
import com.vivion.naruto.dao.MemberDao;
import com.vivion.naruto.enums.MemberParamter;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
public class NarutoServiceImpl implements NarutoService {
    @Resource
    private MemberDao memberDao;
    @Override
    public List<Member> getUserList(MemberParamter memberParamter) {
        Member member = new Member();
        member.setIsValid(1);
        return memberDao.query(member);
    }
}
