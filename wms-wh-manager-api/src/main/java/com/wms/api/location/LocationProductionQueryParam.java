package com.wms.api.location;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 库位物料绑定关系 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "LocationProductionQueryParam对象", description = "库位物料绑定关系查询参数")
public class LocationProductionQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
