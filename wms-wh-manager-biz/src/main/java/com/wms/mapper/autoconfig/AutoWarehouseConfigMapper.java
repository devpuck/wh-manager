package com.wms.mapper.autoconfig;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.AutoWarehouseConfigEntity;
import com.wms.api.autoconfig.AutoWarehouseConfigQueryParam;
import com.wms.model.bo.autoconfig.AutoWarehouseConfigBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 自动仓配置 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
@Repository
public interface AutoWarehouseConfigMapper extends BaseMapper<AutoWarehouseConfigEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    AutoWarehouseConfigBo getAutoWarehouseConfigById(Serializable id);

    AutoWarehouseConfigBo queryAutoWarehouseConfigByCode(String warehouseCode);

    /**
     * 获取分页对象
     *
     * @param page
     * @param autoWarehouseConfigQueryParam
     * @return
     */
    IPage<AutoWarehouseConfigBo> getAutoWarehouseConfigPageList(@Param("page") Page page, @Param("param") AutoWarehouseConfigQueryParam autoWarehouseConfigQueryParam);

    boolean reCreateAppSecret(String warehouseCode,String appSecret);
}
