package org.javaboy.platform.domain.gamecenter.context;

import lombok.Data;
import org.javaboy.platform.domain.gamecenter.model.config.AwardConfig;
import org.javaboy.platform.domain.gamecenter.model.config.GameActivityConfig;

/**
 * @author:majin.wj
 */
@Data
public class GameExchangeContext {

    private Long uid;

    private GameActivityConfig gameActivityConfig;

    private AwardConfig awardConfig;

}
