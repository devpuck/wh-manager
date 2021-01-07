package com.wms.api.transaction;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 出入库事务 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "WarehouseTransactionsQueryParam对象", description = "出入库事务查询参数")
public class WarehouseTransactionsQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
