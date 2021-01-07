package com.wms.service.impl;

import com.wms.util.RandomString;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.AutoWarehouseConfigEntity;
import com.wms.mapper.autoconfig.AutoWarehouseConfigMapper;
import com.wms.service.AutoWarehouseConfigService;
import com.wms.api.autoconfig.AutoWarehouseConfigQueryParam;
import com.wms.model.bo.autoconfig.AutoWarehouseConfigBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.UUID;


/**
 * <pre>
 * 自动仓配置 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
@Slf4j
@Service
public class AutoWarehouseConfigServiceImpl extends BaseServiceImpl<AutoWarehouseConfigMapper, AutoWarehouseConfigEntity> implements AutoWarehouseConfigService {

    @Autowired
    private AutoWarehouseConfigMapper autoWarehouseConfigMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveAutoWarehouseConfig(AutoWarehouseConfigBo autoWarehouseConfig)
    {
        produceAppSecret(autoWarehouseConfig);

        AutoWarehouseConfigEntity entity = new AutoWarehouseConfigEntity();
        BeanUtils.copyProperties(autoWarehouseConfig , entity);
        return super.save(entity);
    }

    /**
     * 生成appKey和appSecrect
     * @param autoWarehouseConfig
     */
    public void produceAppSecret(AutoWarehouseConfigBo autoWarehouseConfig)
    {
        String appKey = UUID.randomUUID().toString().replaceAll("-", "");
        String appSecret = RandomString.getRandomString(255);
        autoWarehouseConfig.setAppKey(appKey);
        autoWarehouseConfig.setAppSecret(appSecret);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateAutoWarehouseConfig(AutoWarehouseConfigBo autoWarehouseConfig)
    {
        AutoWarehouseConfigEntity entity = new AutoWarehouseConfigEntity();
        //如果之前已经删除，则新增后，改为非删除状态
        autoWarehouseConfig.setIsDeleted(0);
        BeanUtils.copyProperties(autoWarehouseConfig , entity);

        String warehouseCode = autoWarehouseConfig.getWarehouseCode();
        AutoWarehouseConfigBo beforeConfig = autoWarehouseConfigMapper.queryAutoWarehouseConfigByCode(warehouseCode);
        if(null == beforeConfig)
        {
            return saveAutoWarehouseConfig(autoWarehouseConfig);
        }

        return super.updateById(entity);
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteAutoWarehouseConfig(Long id) {
        return super.removeById(id);
    }

    @Override
    public AutoWarehouseConfigBo getAutoWarehouseConfigById(Serializable id) {
        return autoWarehouseConfigMapper.getAutoWarehouseConfigById(id);
    }

    @Override
    public AutoWarehouseConfigBo queryAutoWarehouseConfigByCode(String warehouseCode)
    {
        return autoWarehouseConfigMapper.queryAutoWarehouseConfigByCode(warehouseCode);
    }

    @Override
    public Paging<AutoWarehouseConfigBo> getAutoWarehouseConfigPageList(AutoWarehouseConfigQueryParam autoWarehouseConfigQueryParam) {
        Page page = setPageParam(autoWarehouseConfigQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<AutoWarehouseConfigBo> iPage = autoWarehouseConfigMapper.getAutoWarehouseConfigPageList(page, autoWarehouseConfigQueryParam);
        return new Paging(iPage);
    }

    @Override
    public boolean reCreateAppSecret(String warehouseCode)
    {
        String appSecret = RandomString.getRandomString(255);
        return autoWarehouseConfigMapper.reCreateAppSecret(warehouseCode,appSecret);
    }

}
