package cc.mrbird.febs.statistic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BasicData
 * @Author yangli
 * @Date 2021/9/22 11:47
 * @Description:
 */
@Data
@TableName("t_basic_data")
@Excel("导出数据")
public class BasicData implements Serializable {

    public static final Long TOP_NODE = 0L;
    private static final long serialVersionUID = 5702271568363781328L;


    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 导入记录id
     */
    @TableField("IMPORT_ID")
    private Integer importId;


    /**
     * 部门人id
     */
    @TableField("USER_ID")
    private Integer userId;


    /**
     * 平台 0:抖音 1:快手 2:小红书
     */
    @TableField("PLATFORM")
    private Integer platform;

    /**
     * 平台名称
     */
    @TableField(exist = false)
    @ExcelField(value = "平台", required = false, maxLength = 20,
            comment = "提示：必填，长度不能超过20个字符")
    private String platformName;


    /**
     * 达人
     */
    @TableField("TALENT")
    @ExcelField(value = "达人", required = false, maxLength = 100,
            comment = "提示：必填，长度不能超过20个字符")
    private String talent;

    /**
     * 链接
     */
    @TableField("URL")
    @ExcelField(value = "链接", required = false, maxLength = 100,
            comment = "提示：必填，长度不能超过20个字符")
    private String url;



    /**
     * 点赞
     */
    @TableField("LIKES_ONE")
    @ExcelField(value = "点赞", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer likesOne;


    /**
     * 报价
     */
    @TableField("QUOTATION")
    @ExcelField(value = "报价", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer quotation;


    /**
     * 备注
     */
    @TableField("REMARK")
    @ExcelField(value = "备注", required = false, maxLength = 255,
            comment = "提示：必填，长度不能超过20个字符")
    private String remark;

    /**
     * 抖加
     */
    @TableField("TIKTOKE_ADD")
    @ExcelField(value = "抖加", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer tiktokeAdd;


    /**
     * 点赞
     */
    @TableField("LIKES_TWO")
    @ExcelField(value = "点赞", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer likesTwo;


    /**
     * 清晰度
     */
    @TableField("CLARITY")
    @ExcelField(value = "清晰度", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer clarity;


    /**
     * 文案
     */
    @TableField("COPY_WRITING")
    @ExcelField(value = "文案", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer copyWriting;


    /**
     * 睫毛款式
     */
    @TableField("SHAPE")
    @ExcelField(value = "睫毛款式", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer shape;

    /**
     * 作品热门得分
     */
    @TableField("POPULAR")
    @ExcelField(value = "作品热门得分", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer popular;


    /**
     * 作品维护
     */
    @TableField("MAINTAIN")
    @ExcelField(value = "作品维护", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer maintain;


    /**
     * 投放成本
     */
    @TableField("COST")
    @ExcelField(value = "投放成本", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer cost;


    /**
     * 总分
     */
    @TableField("TOTAL_SCORE")
    @ExcelField(value = "总分", required = false, maxLength = 11, regularExp = "[0-9]+",
            regularExpMessage = "必须是数字", comment = "提示: 必填，只能填写数字，并且长度不能超过11位")
    private Integer totalScore;


    /**
     * 导入时间
     */
    @TableField("IMPORT_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date importDate;

    /**
     * 用户名称
     */
    @TableField(exist = false)
    private String userName;




}
