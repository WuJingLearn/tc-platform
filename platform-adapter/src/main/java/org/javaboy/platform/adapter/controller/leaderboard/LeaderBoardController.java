package org.javaboy.platform.adapter.controller.leaderboard;

import org.javaboy.common.utils.Result;
import org.javaboy.platform.application.leaderboard.service.LeaderBoardAppService;
import org.javaboy.platform.client.request.leaderboard.EnterRequest;
import org.javaboy.platform.client.request.leaderboard.QueryRequest;
import org.javaboy.platform.domain.leaderboard.model.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:majin.wj
 */
@RestController("/leaderboard")
public class LeaderBoardController {


    @Autowired
    private LeaderBoardAppService leaderBoardAppService;

    @PostMapping("/enter")
    public Result<Boolean> enterLeaderboard(@RequestBody EnterRequest request) {
        leaderBoardAppService.enterLeaderBoard(request);
        return Result.success(true);
    }

    @GetMapping("/get")
    public Result<List<Member>> queryLeaderBoard(@RequestParam(required = true) String scene, @RequestParam(required = false, defaultValue = "10") Integer topN,
                                                 @RequestParam(required = false) String ruleItem) {
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setScene(scene);
        queryRequest.setTopN(topN);
        queryRequest.setRuleItem(ruleItem);
        return Result.success(leaderBoardAppService.queryLeaderBoard(queryRequest));
    }

}
