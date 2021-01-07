package com.wms.api.deal;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 处理过程定义，对事务的一个补充，相当于子事务 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WarehouseDealsQueryParam对象", description = "处理过程定义，对事务的一个补充，相当于子事务查询参数")
public class WarehouseDealsQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
