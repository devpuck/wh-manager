package com.wms.model.bo.location;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 库位定义 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
public class WarehouseLocationBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 库位号
     */
    private String locationCode;

    /**
     * 库房编码
     */
    private String warehouseCode;

    /**
     * 库位类型
     */
    private String locationType;

    /**
     * 是否为空库位
     */
    private String isEmpty;

    /**
     * 状态
     */
    private String state;

    /**
     * 库位大小
     */
    private String locationSize;

    /**
     * 长，单位cm
     */
    private BigDecimal length;

    /**
     * 宽，单位cm
     */
    private BigDecimal width;

    /**
     * 高，单位cm
     */
    private BigDecimal heigh;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 版本号
     */
    private String version;

}
