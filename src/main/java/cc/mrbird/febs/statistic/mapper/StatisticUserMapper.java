package cc.mrbird.febs.statistic.mapper;

import cc.mrbird.febs.statistic.entity.StatisticUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName StatisticUserMapper.xml
 * @Author yangli
 * @Date 2021/9/13 15:29
 * @Description:
 */
public interface StatisticUserMapper extends BaseMapper<StatisticUser> {

    <T> IPage<StatisticUser> findStatisticUserDetailPage(Page<T> page, @Param("statisticUser") StatisticUser statisticUser);

    int conutAllStatisticUser (@Param("statisticUser") StatisticUser statisticUser);

    List<StatisticUser>  selectStatisticUserList( @Param("statisticUser") StatisticUser statisticUser);
}
