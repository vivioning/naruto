package com.vivion.naruto.dao;

import com.vivion.naruto.bean.Member;
import com.vivion.naruto.dao.base.DaoBase;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends DaoBase<Member, Long> {
}
