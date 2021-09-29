package cc.mrbird.febs.statistic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName StatisticUser
 * @Author yangli
 * @Date 2021/9/13 15:16
 * @Description:
 */
@Data
@TableName("t_statistics_user")
public class StatisticUser implements Serializable {

    public static final Long TOP_NODE = 0L;
    private static final long serialVersionUID = 5022231568363798328L;

    /**
     * ID
     */
        @TableId(value = "ID", type = IdType.AUTO)
    private Long id;


    /**
     * 部门员工名称
     */
    @TableField("NAME")
    private String name;


    /**
     * 性别 1:男 2:女 3:其他
     */
    @TableField("GENDER")
    private Integer gender;


    /**
     * 是否离职 1:离职 2:未离职
     */
    @TableField("IS_RESIGN")
    private Integer isResign;


    /**
     * 是否离职 1:离职 2:未离职
     */
    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date createTime;


}
