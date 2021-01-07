package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.WarehouseEntity;
import com.wms.mapper.warehouse.WarehouseMapper;
import com.wms.service.WarehouseService;
import com.wms.api.warehouse.WarehouseQueryParam;
import com.wms.model.bo.warehouse.WarehouseBo;
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
import java.util.ArrayList;
import java.util.List;


/**
 * <pre>
 * 库房定义表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-16
 */
@Slf4j
@Service
public class WarehouseServiceImpl extends BaseServiceImpl<WarehouseMapper, WarehouseEntity> implements WarehouseService
{

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveWarehouse(WarehouseBo warehouse)
    {
        WarehouseEntity entity = new WarehouseEntity();
        BeanUtils.copyProperties(warehouse , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateWarehouse(WarehouseBo warehouse)
    {
        WarehouseEntity entity = new WarehouseEntity();
        BeanUtils.copyProperties(warehouse , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteWarehouse(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public WarehouseBo getWarehouseById(Serializable id)
    {
        return warehouseMapper.getWarehouseById(id);
    }

    @Override
    public WarehouseBo queryWareHouseByCode(String warehouseCode)
    {
        return warehouseMapper.queryWarehouseByCode(warehouseCode);
    }

    @Override
    public Paging<WarehouseBo> getWarehousePageList(WarehouseQueryParam warehouseQueryParam)
    {
        Page page = setPageParam(warehouseQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<WarehouseBo> iPage = warehouseMapper.getWarehousePageList(page, warehouseQueryParam);
        return new Paging(iPage);
    }

    @Override
    public String queryIDByWarehouseCode(String warehouseCode)
    {
        return warehouseMapper.queryIDByWarehouseCode(warehouseCode);
    }

    @Override
    public boolean updateWarehouseState(String warehouseCode, String state)
    {
        return warehouseMapper.updateWarehouseState(warehouseCode,state);
    }

    @Override
    public boolean updateWarehouseConnectState(String warehouseCode, String state)
    {
        return warehouseMapper.updateWarehouseConnectionState(warehouseCode,state);
    }

    @Override
    public List<WarehouseBo> queryWarehouseList()
    {
        List<WarehouseBo> warehouseList = warehouseMapper.queryWarehouseList();
        if(null == warehouseList)
        {
            return new ArrayList<WarehouseBo>();
        }
        return warehouseList;
    }

}
