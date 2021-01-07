package com.wms.api.transaction;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出入库事务 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WarehouseTransactionsVo对象", description = "出入库事务查询参数")
public class WarehouseTransactionsVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表ID")
    private Long id;

    @ApiModelProperty(value = "事务名称")
    private String name;

    @ApiModelProperty(value = "事务编号")
    private String workCode;

    @ApiModelProperty(value = "事务类型")
    private String transactionsType;

    @ApiModelProperty(value = "状态")
    private String status;

}
