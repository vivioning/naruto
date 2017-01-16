package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.bean.Member;
import com.vivion.naruto.enums.MemberView;
import com.vivion.naruto.enums.UserView;
import com.vivion.naruto.enums.VerifyInfoView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
@Service
public interface NarutoService {
    /**
     * 获取成员信息
     * @param memberView
     * @return
     */
    public List<Member> getUserList(MemberView memberView);

    /**
     * 获取成员信息
     * @param
     * @return
     */
    public List<UserView> user();

    /**
     * 新增成员信息
     * @param memberView
     * @return
     */
    public ResultEx addUser(MemberView memberView);

    /**
     * 修改成员信息
     * @param memberView
     * @return
     */
    public ResultEx modifyUser(MemberView memberView);

    /**
     * 删除成员信息
     * @param memberView
     * @return
     */
    public ResultEx deleteUser(MemberView memberView);

    /**
     * 验证信息
     * @param verifyInfoView
     * @return
     */
    public ResultEx verify(VerifyInfoView verifyInfoView);
}
