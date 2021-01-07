package com.wms.model.bo.transaction;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出入库事务 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-18
 */
@Data
@Accessors(chain = true)
public class WarehouseTransactionsBo extends BaseBo implements Serializable {
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
     * 事务编号
     */
    private String workCode;

    /**
     * 事务类型
     */
    private String transactionsType;

    /**
     * 状态
     */
    private String status;

}
