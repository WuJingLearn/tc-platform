package org.javaboy.platform.domain.leaderboard.extension;

import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.LeaderBoardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author:majin.wj 排行榜扩展点组件类
 */
@Component
public class LeaderBoardExtensionComponent extends LeaderBoardExtension {

    @Autowired
    private Map<String, LeaderBoardExtension> extensionMap = new HashMap<>();

    @Override
    public Long refreshAndGetScoreRecord(EnterRequest request) {
        return Optional.ofNullable(extensionMap.get(request.getScene())).map(e -> e.refreshAndGetScoreRecord(request)).orElse(0L);
    }

    @Override
    public String getBid(LeaderBoardRequest request) {
        return Optional.ofNullable(extensionMap.get(request.getScene())).map(e -> e.getBid(request)).orElse(null);
    }

}
