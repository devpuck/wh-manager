package com.wms.mapper.transaction;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.WarehouseTransactionsEntity;
import com.wms.api.transaction.WarehouseTransactionsQueryParam;
import com.wms.model.bo.transaction.WarehouseTransactionsBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出入库事务 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Repository
public interface WarehouseTransactionsMapper extends BaseMapper<WarehouseTransactionsEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    WarehouseTransactionsBo getWarehouseTransactionsById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param warehouseTransactionsQueryParam
     * @return
     */
    IPage<WarehouseTransactionsBo> getWarehouseTransactionsPageList(@Param("page") Page page, @Param("param") WarehouseTransactionsQueryParam warehouseTransactionsQueryParam);

}
