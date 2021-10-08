package cc.mrbird.febs.statistic.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.statistic.entity.StatisticUser;
import cc.mrbird.febs.statistic.mapper.StatisticUserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @ClassName viewController
 * @Author yangli
 * @Date 2021/9/13 14:29
 * @Description:
 */
@Controller("statisticView")
@RequiredArgsConstructor
public class ViewController extends BaseController {

    @Resource
    private StatisticUserMapper statisticUserMapper;

    /**
     * 统计人员
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX +"statistic/user")
    @RequiresPermissions("statistic:view")
    public String statisticUser() {
        return FebsUtil.view("statistic/user/statisticUser");
    }

    /**
     * 统计人员 新增
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX +"statistic/add/user")
    @RequiresPermissions("statistic:view")
    public String addStatisticUser() {
        return FebsUtil.view("statistic/user/addStatisticUser");
    }

    /**
     * 统计人员 编辑
     * @param id
     * @param model
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "statistic/modify/user/{id}")
    @RequiresPermissions("statistic:view")
    public String modifyStatisticUser(@PathVariable String id, Model model) {
        resolveStatisticUserModel(id, model, false);
        return FebsUtil.view("statistic/user/modifyStatisticUser");
    }

    /**
     * 基础数据
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX +"statistic/basic/data")
    @RequiresPermissions("statistic:view")
    public String basicData() {
        return FebsUtil.view("statistic/data/basicData");
    }

    /**
     * 导入记录
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX +"statistic/import/record")
    @RequiresPermissions("statistic:view")
    public String importRecord() {
        return FebsUtil.view("statistic/record/importRecord");
    }

    private void resolveStatisticUserModel(String id, Model model, Boolean transform) {
        StatisticUser user = statisticUserMapper.selectById(id);
        model.addAttribute("statisticUser", user);
    }
}
