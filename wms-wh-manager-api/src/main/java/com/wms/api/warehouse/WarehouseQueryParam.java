package com.wms.api.warehouse;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 库房定义表 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WarehouseQueryParam对象", description = "库房定义表查询参数")
public class WarehouseQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
