package cc.mrbird.febs.statistic.mapper;

import cc.mrbird.febs.statistic.entity.ImportRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @InterfaceName ImportRecordMapper
 * @Author yangli
 * @Date 2021/9/22 14:15
 * @Description:
 */
public interface ImportRecordMapper extends BaseMapper<ImportRecord> {

    <T> IPage<ImportRecord> getImportRecordList(Page<T> page,@Param("importRecord") ImportRecord importRecord);

    int getImportRecordLCount(@Param("importRecord") ImportRecord importRecord);
}
