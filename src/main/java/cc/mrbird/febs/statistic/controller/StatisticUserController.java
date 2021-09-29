package cc.mrbird.febs.statistic.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.entity.Strings;
import cc.mrbird.febs.statistic.entity.StatisticUser;
import cc.mrbird.febs.statistic.service.IStatisticUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName StatisticUserController
 * @Author yangli
 * @Date 2021/9/13 15:24
 * @Description:
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("statistic")
public class StatisticUserController extends BaseController {

    private final IStatisticUserService statisticUserService;

    @GetMapping("list")
    public FebsResponse getStatisticUserList(StatisticUser user, QueryRequest request) {
        return new FebsResponse().success()
                .data(getDataTable(statisticUserService.findStatisticUserDetailList(user, request)));
    }

    @PostMapping("add/user")
    public FebsResponse addStatisticUser(StatisticUser user) {
        statisticUserService.addStatisticUser(user);
        return new FebsResponse().success();
    }

    @PostMapping("modify/user")
    public FebsResponse modifyStatisticUser(StatisticUser user) {
        statisticUserService.modifyStatisticUser(user);
        return new FebsResponse().success();
    }


    @GetMapping("delete/user/{userIds}")
    public FebsResponse modifyStatisticUser(@PathVariable String userIds) {
        statisticUserService.deleteStatisticUser(StringUtils.split(userIds, Strings.COMMA));
        return new FebsResponse().success();
    }

}
