package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import org.springframework.stereotype.Service;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
@Service
public interface TeamService {
    /**
     * 小队分配
     * @param teamTime
     * @return
     */
    public ResultEx distribute(String teamTime);

}
