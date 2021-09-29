package cc.mrbird.febs.statistic.service.impl;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.statistic.entity.StatisticUser;
import cc.mrbird.febs.statistic.mapper.StatisticUserMapper;
import cc.mrbird.febs.statistic.service.IStatisticUserService;
import cc.mrbird.febs.system.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName StatisticUserServiceImpl
 * @Author yangli
 * @Date 2021/9/13 15:28
 * @Description:
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StatisticUserServiceImpl extends ServiceImpl<StatisticUserMapper, StatisticUser> implements IStatisticUserService {

    /**
     * 列表分页
     * @param user
     * @param request
     * @return
     */
    @Override
    public IPage<StatisticUser> findStatisticUserDetailList(StatisticUser user, QueryRequest request) {
        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.conutAllStatisticUser(user));
        SortUtil.handlePageSort(request, page, "CREATE_TIME", FebsConstant.ORDER_DESC, false);
        return baseMapper.findStatisticUserDetailPage(page, user);
    }


    /**
     * 新增
     * @param user
     */
    @Override
    public void addStatisticUser(StatisticUser user) {
        user.setCreateTime(new Date());
        this.baseMapper.insert(user);
    }

    /**
     * 编辑
     * @param user
     */
    @Override
    public void modifyStatisticUser(StatisticUser user) {
        this.baseMapper.updateById(user);
    }

    /**
     * 删除
     * @param userIds
     */
    @Override
    public void deleteStatisticUser(String[] userIds) {
        List<String> list = Arrays.asList(userIds);
        this.baseMapper.deleteBatchIds(list);
    }


    /**
     * select 不分页
     * @param user
     * @return
     */
    @Override
    public List<StatisticUser> selectStatisticUserList(StatisticUser user) {
        return this.baseMapper.selectStatisticUserList(user);
    }
}
