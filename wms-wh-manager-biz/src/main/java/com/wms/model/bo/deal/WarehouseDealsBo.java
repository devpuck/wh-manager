package com.wms.model.bo.deal;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 处理过程定义，对事务的一个补充，相当于子事务 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
public class WarehouseDealsBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表ID
     */
    private Long id;

    /**
     * 事务名称
     */
    private String name;

    /**
     * 处理编号
     */
    private String dealCode;

    /**
     * 事务编号
     */
    private String transactionsCode;

    /**
     * 状态
     */
    private String status;

}
