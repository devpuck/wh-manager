package com.wms.model.bo.autoconfig;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 自动仓配置 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-17
 */
@Data
@Accessors(chain = true)
public class AutoWarehouseConfigBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

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
