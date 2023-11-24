package org.javaboy.platform.adapter.controller.leaderboard;

import org.javaboy.common.utils.PlatformResult;
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
@RestController
@RequestMapping("/leaderboard")
public class LeaderBoardController {


    @Autowired
    private LeaderBoardAppService leaderBoardAppService;

    /**
     *
     * {
     *     scene:"",
     *     "ruleItem","java",
     *     "score":"1"
     * }
     *
     * @param request
     * @return
     */
    @PostMapping("/enterLeaderboard")
    public PlatformResult<Boolean> enterLeaderboard(@RequestBody EnterRequest request) {
        leaderBoardAppService.enterLeaderBoard(request);
        return PlatformResult.success(true);
    }

    /**
     * 在需要分不同逻辑榜单时，需要传ruleItem参数，需要通过ruleItem确定逻辑榜单;
     * @param scene
     * @param topN
     * @param ruleItem
     * @return
     */
    @GetMapping("/getLeaderboard")
    public PlatformResult<List<Member>> queryLeaderBoard(@RequestParam(required = true) String scene, @RequestParam(required = false, defaultValue = "10") Integer topN,
                                                         @RequestParam(required = false) String ruleItem) {
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setScene(scene);
        queryRequest.setTopN(topN);
        queryRequest.setRuleItem(ruleItem);
        return PlatformResult.success(leaderBoardAppService.queryLeaderBoard(queryRequest));
    }

}
