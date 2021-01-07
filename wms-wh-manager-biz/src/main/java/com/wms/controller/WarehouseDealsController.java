package com.wms.controller;

import com.wms.api.location.LocationProductionVo;
import com.wms.api.location.WarehouseLocationVo;
import com.wms.errorcode.ErrorCode;
import com.wms.model.bo.locationproduction.LocationProductionBo;
import com.wms.util.check.CheckParameter;
import com.xac.core.api.ApiResultCode;
import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.WarehouseDealsEntity;
import com.wms.service.WarehouseDealsService;
import com.wms.api.deal.WarehouseDealsQueryParam;
import com.wms.api.deal.WarehouseDealsVo;
import com.wms.model.bo.deal.WarehouseDealsBo;
import com.xac.core.api.ApiResult;
import com.xac.core.api.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;


import javax.validation.Valid;

import com.xac.core.api.Paging;

import java.util.List;

/**
 * <pre>
 * 处理过程定义，对事务的一个补充，相当于子事务 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Slf4j
@RestController
@RequestMapping("/deal")
@Api("处理过程定义，对事务的一个补充，相当于子事务 API")
public class WarehouseDealsController extends BaseController {

    @Autowired
    private WarehouseDealsService warehouseDealsService;

    /**
     * 添加处理过程定义，对事务的一个补充，相当于子事务
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加WarehouseDeals对象", notes = "添加处理过程定义，对事务的一个补充，相当于子事务", response = ApiResult.class)
    public ApiResult<Boolean> addWarehouseDeals(@Valid @RequestBody WarehouseDealsVo warehouseDeals) throws Exception
    {
        String dealCode = warehouseDeals.getDealCode();
        if(ErrorCode.OK != CheckParameter.checkParameter(dealCode))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        WarehouseDealsBo queryBo = warehouseDealsService.queryWarehouseDealsByCode(dealCode);
        if(null != queryBo)
        {
            ApiResult apiResult = new ApiResult();
            apiResult.setCode(ErrorCode.WAREHOUSE_DEAL_CODE_REPEAT);
            apiResult.setMsg(ErrorCode.WAREHOUSE_DEAL_CODE_REPEAT_MESSAGE);
            apiResult.setSuccess(false);
            return apiResult;
        }

        WarehouseDealsBo bo = new WarehouseDealsBo();
        BeanUtils.copyProperties(warehouseDeals,bo);

        boolean flag = warehouseDealsService.saveWarehouseDeals(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改处理过程定义，对事务的一个补充，相当于子事务
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改WarehouseDeals对象", notes = "修改处理过程定义，对事务的一个补充，相当于子事务", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouseDeals(@Valid @RequestBody WarehouseDealsVo warehouseDeals) throws Exception
    {
        WarehouseDealsBo bo = new WarehouseDealsBo();
        BeanUtils.copyProperties(warehouseDeals,bo);

        boolean flag = warehouseDealsService.updateWarehouseDeals(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除处理过程定义，对事务的一个补充，相当于子事务
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除WarehouseDeals对象", notes = "删除处理过程定义，对事务的一个补充，相当于子事务", response = ApiResult.class)
    public ApiResult<Boolean> deleteWarehouseDeals(@PathVariable("id") Long id) throws Exception {
        boolean flag = warehouseDealsService.deleteWarehouseDeals(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取处理过程定义，对事务的一个补充，相当于子事务
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取WarehouseDeals对象详情", notes = "查看处理过程定义，对事务的一个补充，相当于子事务", response = WarehouseDealsVo.class)
    public ApiResult<WarehouseDealsVo> getWarehouseDeals(@PathVariable("id") Long id) throws Exception {
        WarehouseDealsBo warehouseDealsBo = warehouseDealsService.getWarehouseDealsById(id);
        WarehouseDealsVo queryVo = null;
        if (warehouseDealsBo != null) {
            queryVo = new WarehouseDealsVo();
            BeanUtils.copyProperties(warehouseDealsBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 根据编码，获取处理过程定义，对事务的一个补充，相当于子事务
     */
    @PostMapping("/query/queryByCode")
    @ApiOperation(value = "根据编码，获取WarehouseDeals对象详情", notes = "查看处理过程定义，对事务的一个补充，相当于子事务", response = WarehouseDealsVo.class)
    public ApiResult<WarehouseDealsVo> getWarehouseDeals(@RequestParam  String dealCode) throws Exception {
        WarehouseDealsBo warehouseDealsBo = warehouseDealsService.queryWarehouseDealsByCode(dealCode);
        WarehouseDealsVo queryVo = null;
        if (warehouseDealsBo != null) {
            queryVo = new WarehouseDealsVo();
            BeanUtils.copyProperties(warehouseDealsBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 处理过程定义，对事务的一个补充，相当于子事务分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取WarehouseDeals分页列表", notes = "处理过程定义，对事务的一个补充，相当于子事务分页列表", response = WarehouseDealsVo.class)
    public ApiResult<Paging<WarehouseDealsVo>> getWarehouseDealsPageList(@Valid @RequestBody WarehouseDealsQueryParam warehouseDealsQueryParam) throws Exception {
        Paging<WarehouseDealsBo> paging = warehouseDealsService.getWarehouseDealsPageList(warehouseDealsQueryParam);
        Paging<WarehouseDealsVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), WarehouseDealsVo.class));
        return ApiResult.ok(resultPage);
    }

    /**
     * 查询处理列表
     */
    @PostMapping("/query/queryDealList")
    @ApiOperation(value = "查询处理过程列表", notes = "库位列表", response = WarehouseLocationVo.class)
    public ApiResult<List<WarehouseDealsVo>>  queryWarehouseDeals() throws Exception
    {
        List<WarehouseDealsBo> boList = warehouseDealsService.queryWarehouseDealList();
        List<WarehouseDealsVo> voList = BeanListUtil.copyListProperties(boList, WarehouseDealsVo.class);
        return ApiResult.ok(voList);
    }

}

