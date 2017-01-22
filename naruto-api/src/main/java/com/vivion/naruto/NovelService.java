package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;

/**
 * Created by GuoXinJie on 2017-01-22.
 */
public interface NovelService {

    /**
     * 获取小说信息
     * @param date
     * @return
     */
    public ResultEx getNovel(String date);
}
