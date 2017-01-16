package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.bean.ForeignAidMember;
import com.vivion.naruto.bean.Member;
import com.vivion.naruto.bean.TeamDistribute;
import com.vivion.naruto.dao.ForeignAidMemberDao;
import com.vivion.naruto.dao.MemberDao;
import com.vivion.naruto.dao.MemberNinjaDao;
import com.vivion.naruto.dao.TeamDistributeDao;
import com.vivion.naruto.enums.TeamDistributeView;
import com.vivion.naruto.enums.TeamView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
@Service
public class TeamServiceImpl implements TeamService {

    private static Logger logger = LoggerFactory.getLogger(NarutoServiceImpl.class);

    @Resource
    private MemberNinjaDao memberNinjaDao;
    @Resource
    private MemberDao memberDao;
    @Resource
    private ForeignAidMemberDao foreignAidMemberDao;
    @Resource
    private TeamDistributeDao teamDistributeDao;


    @Override
    public ResultEx distribute(String teamTime) {
        ResultEx resultEx = new ResultEx();
        List<TeamDistribute> teamDistributeList = new ArrayList<TeamDistribute>();
        List<Member> memberList = memberDao.getTop6(new Member());
        List<ForeignAidMember> foreignAidMemberList = foreignAidMemberDao.query(new ForeignAidMember());
        for (int i = 0; i < foreignAidMemberList.size(); i++) {
            Member member = new Member();
            member.setNickName(foreignAidMemberList.get(i).getForeignAidName());
            member.setFighting(foreignAidMemberList.get(i).getFighting());
            member.setMagicResistance(foreignAidMemberList.get(i).getMagicResistance());
            memberList.add(member);
        }
        distributeByAsc(memberList, "队长");
        Member member = new Member();
        member.setRequestOffset(6);
        member.setRequestCount(8);
        distributeByDesc(memberDao.getByLimit(member), "成员");
        member.setRequestOffset(14);
        distributeByDesc(memberDao.getByLimit(member), "成员");
        member.setRequestOffset(22);
        distributeByAsc(memberDao.getByLimit(member), "成员");

        return resultEx.makeSuccessResult();
    }

    @Override
    public List<TeamDistributeView> getTeam() {
        List<TeamDistribute> distributeList = new ArrayList<TeamDistribute>();
        List<TeamDistributeView> teamDistributeViewList = new ArrayList<TeamDistributeView>();
        for (int i = 1; i <= 8; i++) {
            List<TeamView> teamViewList = new ArrayList<TeamView>();
            TeamDistribute teamDistribute = new TeamDistribute();
            teamDistribute.setTeamId(i);
            distributeList = teamDistributeDao.query(teamDistribute);
            TeamDistributeView teamDistributeView = new TeamDistributeView();
            for (int j = 0; j < distributeList.size(); j++) {
                TeamView teamView =new TeamView();
                BeanUtils.copyProperties(distributeList.get(j), teamView);
                teamViewList.add(teamView);
            }
            teamDistributeView.setTeamViewList(teamViewList);
            teamDistributeViewList.add(teamDistributeView);
        }
        return teamDistributeViewList;
    }

    /**
     * 正序分配
     *
     * @param memberList
     * @param position
     */
    public void distributeByAsc(List<Member> memberList, String position) {
        for (int i = 0; i < memberList.size(); i++) {
            TeamDistribute teamDistribute = new TeamDistribute();
            teamDistribute.setTeamId(i + 1);
            teamDistribute.setTeamName("第【 " + (i + 1) + " 】小队");
            teamDistribute.setNickName(memberList.get(i).getNickName());
            teamDistribute.setIsLeader(position);
            teamDistribute.setCreateTime(new Date());
            teamDistribute.setIsValid(1);
            teamDistributeDao.add(teamDistribute);
        }
    }

    /**
     * 倒叙分配
     *
     * @param memberList
     * @param position
     */
    public void distributeByDesc(List<Member> memberList, String position) {
        int desc = 1;
        for (int i = memberList.size() - 1; i >= 0; i--) {
            TeamDistribute teamDistribute = new TeamDistribute();
            teamDistribute.setTeamId(desc);
            teamDistribute.setTeamName("第【 " + desc + " 】小队");
            teamDistribute.setNickName(memberList.get(i).getNickName());
            teamDistribute.setIsLeader(position);
            teamDistribute.setCreateTime(new Date());
            teamDistribute.setIsValid(1);
            teamDistributeDao.add(teamDistribute);
            desc++;
        }
    }
}
