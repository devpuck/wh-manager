package com.wms.api.autoconfig;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 自动仓配置 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-17
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "AutoWarehouseConfigQueryParam对象", description = "自动仓配置查询参数")
public class AutoWarehouseConfigQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
