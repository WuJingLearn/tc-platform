package org.javaboy.platform.domain.leaderboard.extension;

import org.javaboy.common.utils.exception.BizException;
import org.javaboy.common.utils.exception.BizExceptionEnums;
import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.LeaderBoardRequest;
import org.javaboy.platform.domain.leaderboard.model.entity.LeaderBoardConfig;
import org.javaboy.platform.domain.leaderboard.enums.Period;
import org.javaboy.platform.domain.leaderboard.repository.LeaderBoardConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:majin.wj
 */
public abstract class LeaderBoardExtension {

    @Autowired
    private LeaderBoardConfigRepository configRepository;

    public void preCheck(String scene) {
        LeaderBoardConfig config = configRepository.getLeaderBoardConfig(scene);
        if (config == null) {
            throw new BizException(BizExceptionEnums.CONFIG_NOT_EXIST.getCode());
        }
        if (Period.isCustom(config.getPeriod())) {
            Date start = config.getStart();
            Date end = config.getEnd();
            long nowTime = Calendar.getInstance().getTime().getTime();
            if (nowTime < start.getTime() || nowTime > end.getTime()) {
                throw new BizException(BizExceptionEnums.ACTIVITY_TIME_ILLEGAL.getCode());
            }
        }

    }

    /**
     * 更新并得到分数记录
     *
     * @param request
     * @return
     */
    public abstract Long refreshAndGetScoreRecord(EnterRequest request);

    /**
     * 获取对应的逻辑榜单
     *
     * @param request
     * @return
     */
    public abstract String getBid(LeaderBoardRequest request);

    protected abstract String getScene();

}
