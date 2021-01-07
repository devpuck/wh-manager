package com.wms.api.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 库房定义表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-16
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "WarehouseVo对象", description = "库房定义表查询参数")
public class WarehouseVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库房ID")
    private Long id;

    @ApiModelProperty(value = "库房名称")
    private String name;

    @ApiModelProperty(value = "库房编码")
    private String warehouseCode;

    @ApiModelProperty(value = "库房类型")
    private String warehouseType;

    @ApiModelProperty(value = "库房分类编码")
    private String warehouseClassify;

    @ApiModelProperty(value = "是否为自动仓")
    private String isAuto;

    @ApiModelProperty(value = "管理部门名称")
    private String departmentName;

    @ApiModelProperty(value = "管理部门编号")
    private String departmentNo;

    @ApiModelProperty(value = "管理人员电话")
    private String phone;

    @ApiModelProperty(value = "库房状态")
    private String state;

    @ApiModelProperty(value = "连接状态")
    private String connectState;

    @ApiModelProperty(value = "盘点类型")
    private String inventoryType;

    @ApiModelProperty(value = "是否是核销库")
    private String isVerification;

    @ApiModelProperty(value = "是否参与资金核算")
    private String isAccounting;

    @ApiModelProperty(value = "核销类型")
    private String verificationType;

    @ApiModelProperty(value = "库房级别，大库、车间库")
    private String warehouseLevel;

    private String projectCode;

    @ApiModelProperty(value = "库房位置")
    private String place;

    @ApiModelProperty(value = "版本号")
    private String version;

    @ApiModelProperty(value = "备注")
    private String details;

    private String keyid;

}
