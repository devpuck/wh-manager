package com.wms.model.entity;

import java.math.BigDecimal;
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
 * 库位定义
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_WAREHOUSE_LOCATION")
public class WarehouseLocationEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 库位号
     */
    private String locationCode;

    /**
     * 库房编码
     */
    private String warehouseCode;

    /**
     * 库位类型
     */
    private String locationType;

    /**
     * 是否为空库位
     */
    private String isEmpty;

    /**
     * 状态
     */
    private String state;

    /**
     * 库位大小
     */
    private String locationSize;

    /**
     * 长，单位cm
     */
    private BigDecimal length;

    /**
     * 宽，单位cm
     */
    private BigDecimal width;

    /**
     * 高，单位cm
     */
    private BigDecimal heigh;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 版本号
     */
    private String version;

}
