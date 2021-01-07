package com.wms.api.location;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 库位定义 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WarehouseLocationQueryParam对象", description = "库位定义查询参数")
public class WarehouseLocationQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
