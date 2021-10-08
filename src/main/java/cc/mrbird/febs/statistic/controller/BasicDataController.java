package cc.mrbird.febs.statistic.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.others.entity.Eximport;
import cc.mrbird.febs.statistic.entity.BasicData;
import cc.mrbird.febs.statistic.entity.ImportRecord;
import cc.mrbird.febs.statistic.service.IBasicDataService;
import cc.mrbird.febs.statistic.service.IImportRecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.wuwenze.poi.ExcelKit;
import com.wuwenze.poi.handler.ExcelReadHandler;
import com.wuwenze.poi.pojo.ExcelErrorField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @ClassName BasicDataController
 * @Author yangli
 * @Date 2021/9/13 20:08
 * @Description:
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("basicData")
public class BasicDataController extends BaseController {

    private final IBasicDataService basicDataService;
    
    private final IImportRecordService iImportRecordService;

    /**
     * 基础数据导入
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("import")
    @RequiresPermissions("eximport:import")
    public FebsResponse importExcels(MultipartFile file ,String userId) throws IOException {
        if ("-1".equals(userId)) {
            return new FebsResponse().fail().message("请选择导入人员");
        }
        if (file.isEmpty()) {
            throw new FebsException("导入数据为空");
        }
        String filename = file.getOriginalFilename();
        if (!StringUtils.endsWith(filename, ".xlsx")) {
            throw new FebsException("只支持.xlsx类型文件导入");
        }
        // 开始导入操作
        Stopwatch stopwatch = Stopwatch.createStarted();
        final List<BasicData> data = Lists.newArrayList();
        final List<Map<String, Object>> error = Lists.newArrayList();
        ExcelKit.$Import(BasicData.class).readXlsx(file.getInputStream(), new ExcelReadHandler<BasicData>() {
            @Override
            public void onSuccess(int sheet, int row, BasicData basicData) {
                // 数据校验成功时，加入集合
                basicData.setImportDate(new Date());
                basicData.setUserId(Integer.parseInt(userId));
                data.add(basicData);
            }

            @Override
            public void onError(int sheet, int row, List<ExcelErrorField> errorFields) {
                // 数据校验失败时，记录到 error集合
                error.add(ImmutableMap.of("row", row, "errorFields", errorFields));
            }
        });

        // 插入记录表
        ImportRecord importRecord = new ImportRecord();
        importRecord.setImportName("导入记录");
        importRecord.setCreateDate(new Date());
        importRecord.setUserId(Integer.parseInt(userId));
        Long recordId = iImportRecordService.saveImportRecord(importRecord);

        if (CollectionUtils.isNotEmpty(data)) {
            // 将合法的记录批量入库
            basicDataService.batchInsert(data,recordId);
        }
        ImmutableMap<String, Object> result = ImmutableMap.of(
                "time", stopwatch.stop().toString(),
                "data", data,
                "error", error
        );
        return new FebsResponse().success().data(result);
    }



    /**
     * 生成 Excel导入模板
     */
    @GetMapping("template")
    @RequiresPermissions("eximport:template")
    public void generateImportTemplate(HttpServletResponse response) {
        // 构建数据
        List<BasicData> list = new ArrayList<>();
        BasicData basicData = new BasicData();
        basicData.setPlatformName("抖音");
        basicData.setTalent("墙墙很强强");
        basicData.setUrl("www.baidu.com");
        basicData.setLikesOne(10);
        basicData.setQuotation(50000);
        basicData.setRemark("来自抖音官方");
        basicData.setTiktokeAdd(15);
        basicData.setLikesTwo(20);
        basicData.setClarity(1);
        basicData.setCopyWriting(2);
        basicData.setShape(3);
        basicData.setPopular(5);
        basicData.setMaintain(6);
        basicData.setCost(600);
        basicData.setTotalScore(96);
        list.add(basicData);
        // 构建模板
        ExcelKit.$Export(BasicData.class, response).downXlsx(list, true);
    }


    /**
     * 导出excle
     * @param queryRequest
     * @param basicData
     * @param response
     */
    @GetMapping("excel")
    @RequiresPermissions("eximport:export")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, BasicData basicData, HttpServletResponse response) {
        IPage<BasicData> basicDataList = basicDataService.findBasicDataList(queryRequest, basicData);
        if (ObjectUtils.isNotEmpty(basicDataList.getRecords())) {
            basicDataList.getRecords().forEach(it->{
                if (it.getPlatform() == 0) {
                    it.setPlatformName("抖音");
                } else if (it.getPlatform() == 1) {
                    it.setPlatformName("快手");
                } else {
                    it.setPlatformName("小红书");
                }
            });
        }
        ExcelKit.$Export(BasicData.class, response)
                .downXlsx(basicDataList.getRecords(), false);
    }

    /**
     * 获取列表
     * @param request
     * @return
     */
    @GetMapping
    @RequiresPermissions("others:eximport:view")
    public FebsResponse findBasicData(QueryRequest request,BasicData basicData) {
        return new FebsResponse().success()
                .data(getDataTable(basicDataService.findBasicDataList(request, basicData)));
    }


}
