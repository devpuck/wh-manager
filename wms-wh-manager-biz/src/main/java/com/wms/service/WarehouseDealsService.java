package com.wms.service;

import com.wms.model.entity.WarehouseDealsEntity;
import com.xac.core.service.BaseService;
import com.wms.api.deal.WarehouseDealsQueryParam;
import com.wms.model.bo.deal.WarehouseDealsBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 处理过程定义，对事务的一个补充，相当于子事务 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
public interface WarehouseDealsService extends BaseService<WarehouseDealsEntity> {

    /**
     * 保存
     *
     * @param warehouseDeals
     * @return
     * @throws Exception
     */
    boolean saveWarehouseDeals(WarehouseDealsBo warehouseDeals);

    /**
     * 修改
     *
     * @param warehouseDeals
     * @return
     * @throws Exception
     */
    boolean updateWarehouseDeals(WarehouseDealsBo warehouseDeals);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteWarehouseDeals(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    WarehouseDealsBo getWarehouseDealsById(Serializable id);

    /**
     * 根据编码查询处理类型
     * @param dealCode
     * @return
     */
    WarehouseDealsBo queryWarehouseDealsByCode(String dealCode);

    /**
     * 获取分页对象
     *
     * @param warehouseDealsQueryParam
     * @return
     * @throws Exception
     */
    Paging<WarehouseDealsBo> getWarehouseDealsPageList(WarehouseDealsQueryParam warehouseDealsQueryParam);

    /**
     * 查询所有的处理类型
     * @return
     * @throws Exception
     */
    List<WarehouseDealsBo> queryWarehouseDealList() throws Exception;

}
