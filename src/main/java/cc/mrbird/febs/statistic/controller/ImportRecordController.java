package cc.mrbird.febs.statistic.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.statistic.entity.ImportRecord;
import cc.mrbird.febs.statistic.service.IBasicDataService;
import cc.mrbird.febs.statistic.service.IImportRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @ClassName ImportRecordController
 * @Author yangli
 * @Date 2021/9/30 11:29
 * @Description:
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("importRecord")
public class ImportRecordController extends BaseController {

    private final IImportRecordService iImportRecordService;

    private final IBasicDataService basicDataService;

    /**
     * 列表
     * @param queryRequest
     * @return
     */
    @GetMapping("list")
    public FebsResponse getImportRecordList (QueryRequest queryRequest, ImportRecord importRecord) {
        return new FebsResponse().success()
                .data(getDataTable(iImportRecordService.getImportRecordList(queryRequest, importRecord)));
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    public FebsResponse deleteImportRecord (@PathVariable("id") String id) {
        ImportRecord importRecord = new ImportRecord();
        importRecord.setId(Long.parseLong(id));
        // 删除主表数据
        iImportRecordService.deleteImportRecord(importRecord);
        // 删除导入的基础数据
        HashMap<String,String> params = new HashMap<>(1);
        params.put("id",id);
        basicDataService.deleteBasicData(params);
        return new FebsResponse().success();
    }
}
