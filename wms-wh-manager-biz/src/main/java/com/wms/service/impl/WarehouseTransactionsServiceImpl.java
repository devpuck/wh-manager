package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wms.model.bo.deal.WarehouseDealsBo;
import com.wms.model.bo.location.WarehouseLocationBo;
import com.wms.model.entity.WarehouseDealsEntity;
import com.wms.model.entity.WarehouseLocationEntity;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.WarehouseTransactionsEntity;
import com.wms.mapper.transaction.WarehouseTransactionsMapper;
import com.wms.service.WarehouseTransactionsService;
import com.wms.api.transaction.WarehouseTransactionsQueryParam;
import com.wms.model.bo.transaction.WarehouseTransactionsBo;
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
 * 出入库事务 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Slf4j
@Service
public class WarehouseTransactionsServiceImpl extends BaseServiceImpl<WarehouseTransactionsMapper, WarehouseTransactionsEntity> implements WarehouseTransactionsService {

    @Autowired
    private WarehouseTransactionsMapper warehouseTransactionsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveWarehouseTransactions(WarehouseTransactionsBo warehouseTransactions) {
        WarehouseTransactionsEntity entity = new WarehouseTransactionsEntity();
        BeanUtils.copyProperties(warehouseTransactions , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateWarehouseTransactions(WarehouseTransactionsBo warehouseTransactions) {
        WarehouseTransactionsEntity entity = new WarehouseTransactionsEntity();
        BeanUtils.copyProperties(warehouseTransactions , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteWarehouseTransactions(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public WarehouseTransactionsBo getWarehouseTransactionsById(Serializable id)
    {
        return warehouseTransactionsMapper.getWarehouseTransactionsById(id);
    }

    @Override
    public WarehouseTransactionsBo queryWarehouseTransactionByCode(String workCode)
    {
        WarehouseTransactionsEntity entity = warehouseTransactionsMapper.selectOne(new QueryWrapper<WarehouseTransactionsEntity>().lambda()
                .eq(WarehouseTransactionsEntity::getWorkCode,workCode));

        if(null != entity)
        {
            WarehouseTransactionsBo bo = new WarehouseTransactionsBo();
            BeanUtils.copyProperties(entity,bo);
            return bo;
        }
        return null;
    }

    @Override
    public Paging<WarehouseTransactionsBo> getWarehouseTransactionsPageList(WarehouseTransactionsQueryParam warehouseTransactionsQueryParam) {
        Page page = setPageParam(warehouseTransactionsQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<WarehouseTransactionsBo> iPage = warehouseTransactionsMapper.getWarehouseTransactionsPageList(page, warehouseTransactionsQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<WarehouseTransactionsBo> queryWarehouseTransactionsBo() throws Exception
    {
        List<WarehouseTransactionsEntity> entityList = warehouseTransactionsMapper.selectList(new QueryWrapper<WarehouseTransactionsEntity>().lambda());
        if(null == entityList)
        {
            entityList = new ArrayList<WarehouseTransactionsEntity>();
        }

        return BeanListUtil.copyListProperties(entityList, WarehouseTransactionsBo.class);
    }

}
