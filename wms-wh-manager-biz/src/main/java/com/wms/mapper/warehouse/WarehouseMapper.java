package com.wms.mapper.warehouse;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.WarehouseEntity;
import com.wms.api.warehouse.WarehouseQueryParam;
import com.wms.model.bo.warehouse.WarehouseBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 库房定义表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-16
 */
@Repository
public interface WarehouseMapper extends BaseMapper<WarehouseEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    WarehouseBo getWarehouseById(Serializable id);

    /**
     * 根据库房编号获取查询对象
     * @param code
     * @return
     */
    WarehouseBo queryWarehouseByCode(String code);

    /**
     * 获取分页对象
     *
     * @param page
     * @param warehouseQueryParam
     * @return
     */
    IPage<WarehouseBo> getWarehousePageList(@Param("page") Page page, @Param("param") WarehouseQueryParam warehouseQueryParam);

    String queryIDByWarehouseCode(String code);

    boolean updateWarehouseState(String code,String state);
    boolean updateWarehouseConnectionState(String code,String state);

    /**
     *
     * @return
     */
    List<WarehouseBo> queryWarehouseList();
}
