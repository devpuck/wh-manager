package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.model.bo.location.WarehouseLocationBo;
import com.wms.model.entity.WarehouseLocationEntity;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.LocationProductionEntity;
import com.wms.mapper.locationproduction.LocationProductionMapper;
import com.wms.service.LocationProductionService;
import com.wms.api.location.LocationProductionQueryParam;
import com.wms.model.bo.locationproduction.LocationProductionBo;
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
 * 库位物料绑定关系 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Slf4j
@Service
public class LocationProductionServiceImpl extends BaseServiceImpl<LocationProductionMapper, LocationProductionEntity> implements LocationProductionService {

    @Autowired
    private LocationProductionMapper locationProductionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveLocationProduction(LocationProductionBo locationProduction)
    {
        String productionCode = locationProduction.getProductionCode();
        String warehouseCode = locationProduction.getWarehouseCode();
        String locationCode = locationProduction.getWarehouseLocationCode();

        //如果之前绑定，直接返回成功
        LocationProductionBo queryLocationProductionBo = queryLocationProduction(warehouseCode,locationCode,productionCode);
        if(null != queryLocationProductionBo)
        {
            return true;
        }

        LocationProductionEntity entity = new LocationProductionEntity();
        BeanUtils.copyProperties(locationProduction , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateLocationProduction(LocationProductionBo locationProduction) {
        LocationProductionEntity entity = new LocationProductionEntity();
        BeanUtils.copyProperties(locationProduction , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteLocationProduction(Long id) {
        return super.removeById(id);
    }

    @Override
    public LocationProductionBo getLocationProductionById(Serializable id) {
        return locationProductionMapper.getLocationProductionById(id);
    }

    @Override
    public Paging<LocationProductionBo> getLocationProductionPageList(LocationProductionQueryParam locationProductionQueryParam) {
        Page page = setPageParam(locationProductionQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<LocationProductionBo> iPage = locationProductionMapper.getLocationProductionPageList(page, locationProductionQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<LocationProductionBo> queryLocationProductionList(String warehouseCode, String locationCode)  throws Exception
    {
        List<LocationProductionEntity> entityList = locationProductionMapper.selectList(new QueryWrapper<LocationProductionEntity>().lambda()
                .eq(LocationProductionEntity::getWarehouseCode,warehouseCode)
                .eq(LocationProductionEntity::getWarehouseLocationCode,locationCode));

        if(null == entityList)
        {
            entityList = new ArrayList<LocationProductionEntity>();
        }

        return BeanListUtil.copyListProperties(entityList,LocationProductionBo.class);
    }

    @Override
    public List<LocationProductionBo> queryLocationByBindProduction(String productionCode) throws Exception
    {
        List<LocationProductionEntity> entityList = locationProductionMapper.selectList(new QueryWrapper<LocationProductionEntity>().lambda()
                .eq(LocationProductionEntity::getProductionCode,productionCode));

        if(null == entityList)
        {
            entityList = new ArrayList<LocationProductionEntity>();
        }

        return BeanListUtil.copyListProperties(entityList,LocationProductionBo.class);
    }

    @Override
    public LocationProductionBo queryLocationProduction(String warehouseCode, String locationCode, String productionCode)
    {
        LocationProductionEntity entity = locationProductionMapper.selectOne(new QueryWrapper<LocationProductionEntity>().lambda()
                .eq(LocationProductionEntity::getWarehouseCode,warehouseCode)
                .eq(LocationProductionEntity::getWarehouseLocationCode,locationCode)
                .eq(LocationProductionEntity::getProductionCode,productionCode));

        if(null != entity)
        {
            LocationProductionBo bo = new LocationProductionBo();
            BeanUtils.copyProperties(entity,bo);
            return bo;
        }
        return null;
    }

}
