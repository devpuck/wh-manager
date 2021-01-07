package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.WarehouseLocationEntity;
import com.wms.mapper.location.WarehouseLocationMapper;
import com.wms.service.WarehouseLocationService;
import com.wms.api.location.WarehouseLocationQueryParam;
import com.wms.model.bo.location.WarehouseLocationBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import com.xac.core.util.BeanListUtil;
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
 * 库位定义 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
@Slf4j
@Service
public class WarehouseLocationServiceImpl extends BaseServiceImpl<WarehouseLocationMapper, WarehouseLocationEntity> implements WarehouseLocationService {

    @Autowired
    private WarehouseLocationMapper warehouseLocationMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveWarehouseLocation(WarehouseLocationBo warehouseLocation) {
        WarehouseLocationEntity entity = new WarehouseLocationEntity();
        BeanUtils.copyProperties(warehouseLocation , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateWarehouseLocation(WarehouseLocationBo warehouseLocation) {
        WarehouseLocationEntity entity = new WarehouseLocationEntity();
        BeanUtils.copyProperties(warehouseLocation , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteWarehouseLocation(Long id) {
        return super.removeById(id);
    }

    @Override
    public WarehouseLocationBo getWarehouseLocationById(Serializable id) {
        return warehouseLocationMapper.getWarehouseLocationById(id);
    }

    @Override
    public WarehouseLocationBo queryWarehouseLocation(String warehouseCode, String locationCode)
    {
        WarehouseLocationEntity locationEntity = warehouseLocationMapper.selectOne(new QueryWrapper<WarehouseLocationEntity>().lambda()
                .eq(WarehouseLocationEntity::getWarehouseCode,warehouseCode)
                .eq(WarehouseLocationEntity::getLocationCode,locationCode));

        if(null != locationEntity)
        {
            WarehouseLocationBo warehouseLocationBo = new WarehouseLocationBo();
            BeanUtils.copyProperties(locationEntity,warehouseLocationBo);
            return warehouseLocationBo;
        }
        return null;
    }

    @Override
    public Paging<WarehouseLocationBo> getWarehouseLocationPageList(WarehouseLocationQueryParam warehouseLocationQueryParam) {
        Page page = setPageParam(warehouseLocationQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<WarehouseLocationBo> iPage = warehouseLocationMapper.getWarehouseLocationPageList(page, warehouseLocationQueryParam);
        return new Paging(iPage);
    }

    @Override
    public String queryLocationID(String warehouseCode, String locationCode)
    {
        return warehouseLocationMapper.queryLocationID(warehouseCode,locationCode);
    }

    @Override
    public List<WarehouseLocationBo> queryWarehouseLocationList(String warehouseCode) throws Exception
    {
        List<WarehouseLocationEntity> entityList = warehouseLocationMapper.selectList(new QueryWrapper<WarehouseLocationEntity>().lambda()
                .eq(WarehouseLocationEntity::getWarehouseCode,warehouseCode));
        if(null == entityList)
        {
            entityList = new ArrayList<WarehouseLocationEntity>();
        }

        return BeanListUtil.copyListProperties(entityList,WarehouseLocationBo.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateLocationState(String warehouseCode, String locationCode, String state)
    {
        return warehouseLocationMapper.updateLocationCode(warehouseCode,locationCode,state);
    }

}
