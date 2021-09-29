package cc.mrbird.febs.statistic.service;

import cc.mrbird.febs.statistic.entity.ImportRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @InterfaceName IImportRecordService
 * @Author yangli
 * @Date 2021/9/22 14:15
 * @Description:
 */
public interface IImportRecordService extends IService<ImportRecord> {

    /**
     * 新增
     * @param importRecord
     */
    Long saveImportRecord(ImportRecord importRecord);
}
