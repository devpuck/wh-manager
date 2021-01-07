package com.wms.model.bo.locationproduction;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 库位物料绑定关系 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
public class LocationProductionBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 库位号
     */
    private String warehouseLocationCode;

    /**
     * 物料编码
     */
    private String productionCode;
    /**
     * 库房编码
     */
    private String warehouseCode;


}
