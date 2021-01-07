package com.wms.mapper.location;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.WarehouseLocationEntity;
import com.wms.api.location.WarehouseLocationQueryParam;
import com.wms.model.bo.location.WarehouseLocationBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 库位定义 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Repository
public interface WarehouseLocationMapper extends BaseMapper<WarehouseLocationEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    WarehouseLocationBo getWarehouseLocationById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param warehouseLocationQueryParam
     * @return
     */
    IPage<WarehouseLocationBo> getWarehouseLocationPageList(@Param("page") Page page, @Param("param") WarehouseLocationQueryParam warehouseLocationQueryParam);

    String queryLocationID(String warehouseCode, String locationCode);

    boolean updateLocationCode(String warehouseCode, String locationCode,String state);
}
