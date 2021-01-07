package com.wms.service;

import com.wms.model.entity.AutoWarehouseConfigEntity;
import com.xac.core.service.BaseService;
import com.wms.api.autoconfig.AutoWarehouseConfigQueryParam;
import com.wms.model.bo.autoconfig.AutoWarehouseConfigBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 自动仓配置 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
public interface AutoWarehouseConfigService extends BaseService<AutoWarehouseConfigEntity> {

    /**
     * 保存
     *
     * @param autoWarehouseConfig
     * @return
     * @throws Exception
     */
    boolean saveAutoWarehouseConfig(AutoWarehouseConfigBo autoWarehouseConfig);

    /**
     * 修改
     *
     * @param autoWarehouseConfig
     * @return
     * @throws Exception
     */
    boolean updateAutoWarehouseConfig(AutoWarehouseConfigBo autoWarehouseConfig);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteAutoWarehouseConfig(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    AutoWarehouseConfigBo getAutoWarehouseConfigById(Serializable id);

    /**
     * 根据库房编号查询自动仓配置
     * @param warehouseCode
     * @return
     */
    AutoWarehouseConfigBo queryAutoWarehouseConfigByCode(String warehouseCode);

    /**
     * 获取分页对象
     *
     * @param autoWarehouseConfigQueryParam
     * @return
     * @throws Exception
     */
    Paging<AutoWarehouseConfigBo> getAutoWarehouseConfigPageList(AutoWarehouseConfigQueryParam autoWarehouseConfigQueryParam);

    boolean reCreateAppSecret(String warehouseCode);

}
