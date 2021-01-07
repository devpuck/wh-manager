package com.wms.service;

import com.wms.model.entity.LocationProductionEntity;
import com.xac.core.service.BaseService;
import com.wms.api.location.LocationProductionQueryParam;
import com.wms.model.bo.locationproduction.LocationProductionBo;
import com.xac.core.api.Paging;

import javax.xml.stream.Location;
import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 库位物料绑定关系 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
public interface LocationProductionService extends BaseService<LocationProductionEntity> {

    /**
     * 保存
     *
     * @param locationProduction
     * @return
     * @throws Exception
     */
    boolean saveLocationProduction(LocationProductionBo locationProduction);

    /**
     * 修改
     *
     * @param locationProduction
     * @return
     * @throws Exception
     */
    boolean updateLocationProduction(LocationProductionBo locationProduction);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteLocationProduction(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    LocationProductionBo getLocationProductionById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param locationProductionQueryParam
     * @return
     * @throws Exception
     */
    Paging<LocationProductionBo> getLocationProductionPageList(LocationProductionQueryParam locationProductionQueryParam);

    /**
     * 查询库位绑定的物料信息
     * @param warehouseCode
     * @param locationCode
     * @return
     */
    List<LocationProductionBo> queryLocationProductionList(String warehouseCode, String locationCode) throws Exception;

    /**
     * 根据物料编码查询绑定的库位列表
     * @param productionCode
     * @return
     * @throws Exception
     */
    List<LocationProductionBo> queryLocationByBindProduction(String productionCode) throws Exception;

    LocationProductionBo queryLocationProduction(String warehouseCode,String locationCode,String productionCode);

}
