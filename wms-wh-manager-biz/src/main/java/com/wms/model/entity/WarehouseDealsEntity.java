package com.wms.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.xac.core.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 处理过程定义，对事务的一个补充，相当于子事务
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_WAREHOUSE_DEALS")
public class WarehouseDealsEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 事务名称
     */
    private String name;

    /**
     * 处理编号
     */
    private String dealCode;

    /**
     * 事务编号
     */
    private String transactionsCode;

    /**
     * 状态
     */
    private String status;

}
