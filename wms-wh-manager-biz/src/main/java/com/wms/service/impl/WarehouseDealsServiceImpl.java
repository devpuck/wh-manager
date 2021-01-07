package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.model.bo.location.WarehouseLocationBo;
import com.wms.model.bo.transaction.WarehouseTransactionsBo;
import com.wms.model.entity.WarehouseLocationEntity;
import com.wms.model.entity.WarehouseTransactionsEntity;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.WarehouseDealsEntity;
import com.wms.mapper.deal.WarehouseDealsMapper;
import com.wms.service.WarehouseDealsService;
import com.wms.api.deal.WarehouseDealsQueryParam;
import com.wms.model.bo.deal.WarehouseDealsBo;
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
 * 处理过程定义，对事务的一个补充，相当于子事务 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Slf4j
@Service
public class WarehouseDealsServiceImpl extends BaseServiceImpl<WarehouseDealsMapper, WarehouseDealsEntity> implements WarehouseDealsService {

    @Autowired
    private WarehouseDealsMapper warehouseDealsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveWarehouseDeals(WarehouseDealsBo warehouseDeals) {
        WarehouseDealsEntity entity = new WarehouseDealsEntity();
        BeanUtils.copyProperties(warehouseDeals , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateWarehouseDeals(WarehouseDealsBo warehouseDeals) {
        WarehouseDealsEntity entity = new WarehouseDealsEntity();
        BeanUtils.copyProperties(warehouseDeals , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteWarehouseDeals(Long id) {
        return super.removeById(id);
    }

    @Override
    public WarehouseDealsBo getWarehouseDealsById(Serializable id) {
        return warehouseDealsMapper.getWarehouseDealsById(id);
    }

    @Override
    public WarehouseDealsBo queryWarehouseDealsByCode(String dealCode)
    {
        WarehouseDealsEntity entity = warehouseDealsMapper.selectOne(new QueryWrapper<WarehouseDealsEntity>().lambda()
                .eq(WarehouseDealsEntity::getDealCode,dealCode));

        if(null != entity)
        {
            WarehouseDealsBo bo = new WarehouseDealsBo();
            BeanUtils.copyProperties(entity,bo);
            return bo;
        }
        return null;
    }

    @Override
    public Paging<WarehouseDealsBo> getWarehouseDealsPageList(WarehouseDealsQueryParam warehouseDealsQueryParam) {
        Page page = setPageParam(warehouseDealsQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<WarehouseDealsBo> iPage = warehouseDealsMapper.getWarehouseDealsPageList(page, warehouseDealsQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<WarehouseDealsBo> queryWarehouseDealList() throws Exception
    {
        List<WarehouseDealsEntity> entityList = warehouseDealsMapper.selectList(new QueryWrapper<WarehouseDealsEntity>().lambda());
        if(null == entityList)
        {
            entityList = new ArrayList<WarehouseDealsEntity>();
        }

        return BeanListUtil.copyListProperties(entityList, WarehouseDealsBo.class);
    }

}
