package cc.mrbird.febs.statistic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName ImportRecord
 * @Author yangli
 * @Date 2021/9/22 14:07
 * @Description:
 */
@Data
@Accessors(chain = true)
@TableName("t_import_record")
public class ImportRecord implements Serializable {


    public static final Long TOP_NODE = 0L;
    private static final long serialVersionUID = 5702271568363798755L;



    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;


    /**
     * 导入名称
     */
    @TableField("IMPORT_NAME")
    private String importName;



    /**
     * 部门人id
     */
    @TableField("USER_ID")
    private Integer userId;


    /**
     * 总分
     */
    @TableField("导入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;


    /**
     * 用户名称
     */
    @TableField(exist = false)
    private String UserName;



}
