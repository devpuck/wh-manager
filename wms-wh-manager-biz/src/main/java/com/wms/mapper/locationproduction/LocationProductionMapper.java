package com.wms.mapper.locationproduction;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.LocationProductionEntity;
import com.wms.api.location.LocationProductionQueryParam;
import com.wms.model.bo.locationproduction.LocationProductionBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 库位物料绑定关系 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Repository
public interface LocationProductionMapper extends BaseMapper<LocationProductionEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    LocationProductionBo getLocationProductionById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param locationProductionQueryParam
     * @return
     */
    IPage<LocationProductionBo> getLocationProductionPageList(@Param("page") Page page, @Param("param") LocationProductionQueryParam locationProductionQueryParam);

}
