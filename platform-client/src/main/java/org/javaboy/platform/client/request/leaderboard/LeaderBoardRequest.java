package org.javaboy.platform.client.request.leaderboard;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class LeaderBoardRequest {

    /**
     * 排行榜场景
     */
    private String scene;
    /**
     * 规则项,按照什么唯独进入排行榜。
     * 1.亚运会时，ruleItem 是country国家
     * 2.编程语言，ruleItem 是程序语言
     * 3.也可以是userId等字段
     */
    private String ruleItem;

}
