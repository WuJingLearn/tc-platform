package org.javaboy.platform.client.request.leaderboard;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @author:majin.wj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnterRequest extends LeaderBoardRequest{

    private Long score;
    private Map<String,String> extData;
}
