package com.wms.api.autoconfig;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 自动仓配置 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-17
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "AutoWarehouseConfigVo对象", description = "自动仓配置查询参数")
public class AutoWarehouseConfigVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

private Long id;

    @ApiModelProperty(value = "库房编号")
    private String warehouseCode;

    @ApiModelProperty(value = "通讯地址")
    private String communicationPlace;

    @ApiModelProperty(value = "自动仓类型")
    private String autoType;

    @ApiModelProperty(value = "自动仓调用类型，WMS、WCS")
    private String strategy;

    @ApiModelProperty(value = "自动仓KEY")
    private String appKey;

    @ApiModelProperty(value = "自动仓密钥")
    private String appSecret;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "自动仓存储优化策略")
    private String optimizationType;

}
