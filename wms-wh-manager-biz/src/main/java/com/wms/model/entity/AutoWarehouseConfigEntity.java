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
 * 自动仓配置
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_AUTO_WAREHOUSE_CONFIG")
public class AutoWarehouseConfigEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 库房编号
     */
    private String warehouseCode;

    /**
     * 通讯地址
     */
    private String communicationPlace;

    /**
     * 自动仓类型
     */
    private String autoType;

    /**
     * 自动仓调用类型，WMS、WCS
     */
    private String strategy;

    /**
     * 自动仓KEY
     */
    private String appKey;

    /**
     * 自动仓密钥
     */
    private String appSecret;

    /**
     * 版本号
     */
    private String version;

    /**
     * 自动仓存储优化策略
     */
    private String optimizationType;

}
