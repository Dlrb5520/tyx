package cc.mrbird.febs.statistic.mapper;

import cc.mrbird.febs.statistic.entity.BasicData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @InterfaceName BasicDataMapper
 * @Author yangli
 * @Date 2021/9/22 14:14
 * @Description:
 */
public interface BasicDataMapper extends BaseMapper<BasicData> {

    <T> IPage<BasicData> findBasicDataDetailPage(Page<T> page, @Param("basicData") BasicData basicData);


    int conutAllBasicData(@Param("basicData") BasicData basicData);

}
