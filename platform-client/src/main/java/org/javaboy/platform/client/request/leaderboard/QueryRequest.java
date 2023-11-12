package org.javaboy.platform.client.request.leaderboard;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author:majin.wj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryRequest extends LeaderBoardRequest{

    private Integer topN;

}
