package org.javaboy.platform.application.gamecenter.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author:majin.wj
 * 查看兑换活动信息
 */
@Data
public class ExchangeActivityDTO {

    private String activityName;

    private Date startTime;

    private Date endTime;

    /**
     * 个人积分
     */
    private Long point;

    private List<ExchangeAwardDTO> awardDTOList;

}
