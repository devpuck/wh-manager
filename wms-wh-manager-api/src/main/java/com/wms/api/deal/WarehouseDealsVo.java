package com.wms.api.deal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 处理过程定义，对事务的一个补充，相当于子事务 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WarehouseDealsVo对象", description = "处理过程定义，对事务的一个补充，相当于子事务查询参数")
public class WarehouseDealsVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表ID")
    private Long id;

    @ApiModelProperty(value = "事务名称")
    private String name;

    @ApiModelProperty(value = "处理编号")
    private String dealCode;

    @ApiModelProperty(value = "事务编号")
    private String transactionsCode;

    @ApiModelProperty(value = "状态")
    private String status;

}
