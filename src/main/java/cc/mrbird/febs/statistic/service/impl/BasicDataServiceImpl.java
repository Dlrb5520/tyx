package cc.mrbird.febs.statistic.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.properties.FebsProperties;
import cc.mrbird.febs.statistic.entity.BasicData;
import cc.mrbird.febs.statistic.mapper.BasicDataMapper;
import cc.mrbird.febs.statistic.service.IBasicDataService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName IBasicDataServiceImpl
 * @Author yangli
 * @Date 2021/9/22 10:58
 * @Description:
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BasicDataServiceImpl extends ServiceImpl<BasicDataMapper, BasicData> implements IBasicDataService {

    private final FebsProperties properties;

    @Override
    public void batchInsert(List<BasicData> basicDataList) {
        saveBatch(basicDataList, properties.getMaxBatchInsertNum());
    }

    @Override
    public IPage<BasicData> findBasicDataList(QueryRequest request, BasicData basicData) {
        Page<BasicData> page = new Page<>(request.getPageNum(), request.getPageSize());
        return page(page, null);
    }
}
