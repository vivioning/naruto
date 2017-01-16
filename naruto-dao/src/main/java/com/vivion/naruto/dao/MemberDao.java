package com.vivion.naruto.dao;

import com.vivion.naruto.bean.Member;
import com.vivion.naruto.dao.base.DaoBase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao extends DaoBase<Member, Long> {
    List<Member> getTop6(Member member);

    List<Member> get7_14(Member member);

    List<Member> get15_22(Member member);

    List<Member> get23_30(Member member);

    List<Member> getByLimit(Member member);
}
