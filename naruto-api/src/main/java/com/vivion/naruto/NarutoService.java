package com.vivion.naruto;

import com.vivion.naruto.bean.Member;
import com.vivion.naruto.enums.MemberParamter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
@Service
public interface NarutoService {

    public List<Member> getUserList(MemberParamter memberParamter);
}
