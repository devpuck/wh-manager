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
 * 库房定义表
 * </pre>
 *
 * @author puck
 * @since 2020-12-16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_WAREHOUSE")
public class WarehouseEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 库房ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 库房名称
     */
    private String name;

    /**
     * 库房编码
     */
    private String warehouseCode;

    /**
     * 库房类型
     */
    private String warehouseType;

    /**
     * 库房分类编码
     */
    private String warehouseClassify;

    /**
     * 是否为自动仓
     */
    private String isAuto;

    /**
     * 管理部门名称
     */
    private String departmentName;

    /**
     * 管理部门编号
     */
    private String departmentNo;

    /**
     * 管理人员电话
     */
    private String phone;

    /**
     * 库房状态
     */
    private String state;

    /**
     * 连接状态
     */
    private String connectState;

    /**
     * 盘点类型
     */
    private String inventoryType;

    /**
     * 是否是核销库
     */
    private String isVerification;

    /**
     * 是否参与资金核算
     */
    private String isAccounting;

    /**
     * 核销类型
     */
    private String verificationType;

    /**
     * 库房级别，大库、车间库
     */
    private String warehouseLevel;

    private String projectCode;

    /**
     * 库房位置
     */
    private String place;

    /**
     * 版本号
     */
    private String version;

    /**
     * 备注
     */
    private String details;

    private String keyid;

}
