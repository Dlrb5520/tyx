package cc.mrbird.febs.statistic.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.statistic.entity.StatisticUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * @InterfaceName StatisticUserService
 * @Author yangli
 * @Date 2021/9/13 15:25
 * @Description:
 */
public interface IStatisticUserService extends IService<StatisticUser> {

    /**
     * 分页
     * @param user
     * @param request
     * @return
     */
    IPage<StatisticUser> findStatisticUserDetailList(StatisticUser user, QueryRequest request);

    /**
     * 新增
     * @param user
     */
    void addStatisticUser(StatisticUser user);

    /**
     * 编辑
     * @param user
     */
    void modifyStatisticUser(StatisticUser user);

    /**
     * 删除
     * @param userIds
     */
    void deleteStatisticUser(String[] userIds);

    /**
     *
     * @param user
     * @return
     */
    List<StatisticUser>  selectStatisticUserList(StatisticUser user);

}
