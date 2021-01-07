package com.wms.api.location;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 库位物料绑定关系 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "LocationProductionVo对象", description = "库位物料绑定关系查询参数")
public class LocationProductionVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

private Long id;

    @ApiModelProperty(value = "库位号")
    private String warehouseLocationCode;

    @ApiModelProperty(value = "物料编码")
    private String productionCode;

    @ApiModelProperty(value = "库房编码")
    private String warehouseCode;

}
