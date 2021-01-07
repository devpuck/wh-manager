package com.wms.service;

import com.wms.model.entity.WarehouseTransactionsEntity;
import com.xac.core.service.BaseService;
import com.wms.api.transaction.WarehouseTransactionsQueryParam;
import com.wms.model.bo.transaction.WarehouseTransactionsBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 出入库事务 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
public interface WarehouseTransactionsService extends BaseService<WarehouseTransactionsEntity> {

    /**
     * 保存
     *
     * @param warehouseTransactions
     * @return
     * @throws Exception
     */
    boolean saveWarehouseTransactions(WarehouseTransactionsBo warehouseTransactions);

    /**
     * 修改
     *
     * @param warehouseTransactions
     * @return
     * @throws Exception
     */
    boolean updateWarehouseTransactions(WarehouseTransactionsBo warehouseTransactions);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteWarehouseTransactions(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    WarehouseTransactionsBo getWarehouseTransactionsById(Serializable id);

    /**
     * 根据事务编码查询库房详情
     * @param workCode
     * @return
     */
    WarehouseTransactionsBo queryWarehouseTransactionByCode(String workCode);

    /**
     * 获取分页对象
     *
     * @param warehouseTransactionsQueryParam
     * @return
     * @throws Exception
     */
    Paging<WarehouseTransactionsBo> getWarehouseTransactionsPageList(WarehouseTransactionsQueryParam warehouseTransactionsQueryParam);

    /**
     * 查询所有的库饭事务
     * @return
     * @throws Exception
     */
    List<WarehouseTransactionsBo> queryWarehouseTransactionsBo() throws Exception;

}
