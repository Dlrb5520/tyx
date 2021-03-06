package cc.mrbird.febs.statistic.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.statistic.entity.BasicData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName IBasicDataService
 * @Author yangli
 * @Date 2021/9/22 10:55
 * @Description:
 */
public interface IBasicDataService extends IService<BasicData> {

    /**
     * 批量插入
     * @param basicDataList
     */
    void batchInsert(List<BasicData> basicDataList,Long recordId);


    /**
     * 查询（分页）
     *
     * @param request  QueryRequest
     * @param basicData basicData
     * @return IPage<BasicData>
     */
    IPage<BasicData> findBasicDataList(QueryRequest request, BasicData basicData);


    /**
     * 删除
     * @param params
     */
    void deleteBasicData(Map<String,String> params);
}
