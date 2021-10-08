package cc.mrbird.febs.statistic.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.statistic.entity.ImportRecord;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    /**
     * 列表查询
     * @param queryRequest
     * @param importRecord
     * @return
     */
    IPage<ImportRecord> getImportRecordList(QueryRequest queryRequest, ImportRecord importRecord);

    /**
     * 删除
     * @param importRecord
     */
    void deleteImportRecord(ImportRecord importRecord);
}
