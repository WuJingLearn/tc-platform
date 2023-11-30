package org.javaboy.platform.application.gamecenter.model.request;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class ExchangeRequest {

    private String activityName;

    private String awardCode;

    private Long uid;

    private Long amount;

    private String outId;

}
