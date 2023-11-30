package org.javaboy.platform.domain.gamecenter.service.impl;

/**
 * @author:majin.wj
 */
public interface GamePointService {

    /**
     * 添加积分
     * @param userId
     * @param amount
     * @return
     */
    boolean addPoint(Long userId, Long amount);


    /**
     * 查询用户积分
     * @param userId
     * @return
     */
    Long queryPoint(Long userId);


    /**
     * 扣减积分
     * @param userId
     * @param amount
     * @return
     */
    boolean deductPoint(Long userId,Long amount);

}
