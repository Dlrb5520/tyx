package cc.mrbird.febs.statistic.service.impl;

import cc.mrbird.febs.statistic.entity.ImportRecord;
import cc.mrbird.febs.statistic.mapper.ImportRecordMapper;
import cc.mrbird.febs.statistic.service.IImportRecordService;
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
}
