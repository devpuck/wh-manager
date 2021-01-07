package com.wms.mapper.deal;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.WarehouseDealsEntity;
import com.wms.api.deal.WarehouseDealsQueryParam;
import com.wms.model.bo.deal.WarehouseDealsBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 处理过程定义，对事务的一个补充，相当于子事务 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Repository
public interface WarehouseDealsMapper extends BaseMapper<WarehouseDealsEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    WarehouseDealsBo getWarehouseDealsById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param warehouseDealsQueryParam
     * @return
     */
    IPage<WarehouseDealsBo> getWarehouseDealsPageList(@Param("page") Page page, @Param("param") WarehouseDealsQueryParam warehouseDealsQueryParam);

}
