package com.wms.service;

import com.wms.model.entity.WarehouseEntity;
import com.xac.core.service.BaseService;
import com.wms.api.warehouse.WarehouseQueryParam;
import com.wms.model.bo.warehouse.WarehouseBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 库房定义表 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-16
 */
public interface WarehouseService extends BaseService<WarehouseEntity> {

    /**
     * 保存
     *
     * @param warehouse
     * @return
     * @throws Exception
     */
    boolean saveWarehouse(WarehouseBo warehouse);

    /**
     * 修改
     *
     * @param warehouse
     * @return
     * @throws Exception
     */
    boolean updateWarehouse(WarehouseBo warehouse);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteWarehouse(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    WarehouseBo getWarehouseById(Serializable id);

    /**
     * 根据库房编号查询库房信息
     * @param warehouseCode
     * @return
     */
    WarehouseBo queryWareHouseByCode(String warehouseCode);

    /**
     * 获取分页对象
     *
     * @param warehouseQueryParam
     * @return
     * @throws Exception
     */
    Paging<WarehouseBo> getWarehousePageList(WarehouseQueryParam warehouseQueryParam);

    /**
     * 根据库房编号查询库房ID，可以作为库房编码是否重复使用
     * @param warehouseCode
     * @return
     */
    public String queryIDByWarehouseCode(String warehouseCode);

    /**
     * 更新库房状态，使用或者启用
     * @param warehouseCode
     * @param state
     * @return
     */
    public boolean updateWarehouseState(String warehouseCode,String state);

    /**
     * 更新立体库链接状态
     * @param warehouseCode
     * @param state
     * @return
     */
    public boolean updateWarehouseConnectState(String warehouseCode,String state);

    public List<WarehouseBo> queryWarehouseList();
}
