package com.vivion.naruto.dao;

import com.hkfs.fundamental.database.DaoBase;
import com.vivion.naruto.bean.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends DaoBase<Member, Long> {
}
