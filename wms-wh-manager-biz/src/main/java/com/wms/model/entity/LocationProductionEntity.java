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
 * 库位物料绑定关系
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_LOCATION_PRODUCTION")
public class LocationProductionEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 库位号
     */
    private String warehouseLocationCode;

    /**
     * 物料编码
     */
    private String productionCode;

    /**
     * 库房编码
     */
    private String warehouseCode;

}
