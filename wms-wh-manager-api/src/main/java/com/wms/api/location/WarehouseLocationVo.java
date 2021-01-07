package com.wms.api.location;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 库位定义 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WarehouseLocationVo对象", description = "库位定义查询参数")
public class WarehouseLocationVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

private Long id;

    @ApiModelProperty(value = "库位号")
    private String locationCode;

    @ApiModelProperty(value = "库房编码")
    private String warehouseCode;

    @ApiModelProperty(value = "库位类型")
    private String locationType;

    @ApiModelProperty(value = "是否为空库位")
    private String isEmpty;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "库位大小")
    private String locationSize;

    @ApiModelProperty(value = "长，单位cm")
    private BigDecimal length;

    @ApiModelProperty(value = "宽，单位cm")
    private BigDecimal width;

    @ApiModelProperty(value = "高，单位cm")
    private BigDecimal heigh;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "版本号")
    private String version;

}
