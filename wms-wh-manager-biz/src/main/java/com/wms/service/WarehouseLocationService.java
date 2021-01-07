package com.wms.service;

import com.wms.model.bo.warehouse.WarehouseBo;
import com.wms.model.entity.WarehouseLocationEntity;
import com.xac.core.service.BaseService;
import com.wms.api.location.WarehouseLocationQueryParam;
import com.wms.model.bo.location.WarehouseLocationBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 库位定义 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
public interface WarehouseLocationService extends BaseService<WarehouseLocationEntity> {

    /**
     * 保存
     *
     * @param warehouseLocation
     * @return
     * @throws Exception
     */
    boolean saveWarehouseLocation(WarehouseLocationBo warehouseLocation);

    /**
     * 修改
     *
     * @param warehouseLocation
     * @return
     * @throws Exception
     */
    boolean updateWarehouseLocation(WarehouseLocationBo warehouseLocation);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteWarehouseLocation(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    WarehouseLocationBo getWarehouseLocationById(Serializable id);

    WarehouseLocationBo queryWarehouseLocation(String warehouseCode,String locationCode);

    /**
     * 获取分页对象
     *
     * @param warehouseLocationQueryParam
     * @return
     * @throws Exception
     */
    Paging<WarehouseLocationBo> getWarehouseLocationPageList(WarehouseLocationQueryParam warehouseLocationQueryParam);

    String queryLocationID(String warehouseCode,String locationCode);

    List<WarehouseLocationBo> queryWarehouseLocationList(String warehouseCode)  throws Exception ;

    boolean updateLocationState(String warehouseCode,String locationCode,String state);

}
