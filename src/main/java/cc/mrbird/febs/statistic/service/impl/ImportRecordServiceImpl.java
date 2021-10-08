package cc.mrbird.febs.statistic.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.statistic.entity.ImportRecord;
import cc.mrbird.febs.statistic.mapper.ImportRecordMapper;
import cc.mrbird.febs.statistic.service.IImportRecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ImportRecordServiceImpl
 * @Author yangli
 * @Date 2021/9/22 14:18
 * @Description:
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ImportRecordServiceImpl extends ServiceImpl<ImportRecordMapper, ImportRecord> implements IImportRecordService {

    /**
     * 新增
     * @param importRecord
     */
    @Override
    public Long saveImportRecord(ImportRecord importRecord) {
        this.baseMapper.insert(importRecord);
        return importRecord.getId();
    }

    /**
     * 列表查询
     * @param queryRequest
     * @param importRecord
     * @return
     */
    @Override
    public IPage<ImportRecord> getImportRecordList(QueryRequest queryRequest, ImportRecord importRecord) {
        Page<ImportRecord> page = new Page<>();
        page.setCurrent(queryRequest.getPageNum());
        page.setSize(queryRequest.getPageSize());
        page.setSearchCount(false);
        return baseMapper.getImportRecordList(page,importRecord);
    }

    /**
     * 删除
     * @param importRecord
     */
    @Override
    public void deleteImportRecord(ImportRecord importRecord) {
        removeById(importRecord.getId());
    }
}
