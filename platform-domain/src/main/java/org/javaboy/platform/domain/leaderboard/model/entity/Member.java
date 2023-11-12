package org.javaboy.platform.domain.leaderboard.model.entity;

import lombok.Data;

/**
 * @author:majin.wj
 * 排行榜中元素
 */
@Data
public class Member {

    private int rank;
    private Long score;
    private String itemRule;
}
