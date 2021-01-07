package com.wms.controller;

import com.wms.api.deal.WarehouseDealsVo;
import com.wms.api.location.WarehouseLocationVo;
import com.wms.errorcode.ErrorCode;
import com.wms.util.check.CheckParameter;
import com.xac.core.api.ApiResultCode;
import com.xac.core.util.BeanListUtil;
import com.wms.service.WarehouseTransactionsService;
import com.wms.api.transaction.WarehouseTransactionsQueryParam;
import com.wms.api.transaction.WarehouseTransactionsVo;
import com.wms.model.bo.transaction.WarehouseTransactionsBo;
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
 * 出入库事务 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-18
 */
@Slf4j
@RestController
@RequestMapping("/transaction")
@Api("出入库事务 API")
public class WarehouseTransactionsController extends BaseController {

    @Autowired
    private WarehouseTransactionsService warehouseTransactionsService;

    /**
     * 添加出入库事务
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加WarehouseTransactions对象", notes = "添加出入库事务", response = ApiResult.class)
    public ApiResult<Boolean> addWarehouseTransactions(@Valid @RequestBody WarehouseTransactionsVo warehouseTransactions) throws Exception
    {
        String workCode = warehouseTransactions.getWorkCode();
        if(ErrorCode.OK != CheckParameter.checkParameter(workCode))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        WarehouseTransactionsBo queryBo = warehouseTransactionsService.queryWarehouseTransactionByCode(workCode);
        if(null != queryBo)
        {
            ApiResult apiResult = new ApiResult();
            apiResult.setCode(ErrorCode.WAREHOUSE_TRANSACTIONS_CODE_REPEAT);
            apiResult.setMsg(ErrorCode.WAREHOUSE_TRANSACTIONS_CODE_REPEAT_MESSAGE);
            apiResult.setSuccess(false);
            return apiResult;
        }

        WarehouseTransactionsBo bo = new WarehouseTransactionsBo();
        BeanUtils.copyProperties(warehouseTransactions,bo);

        WarehouseTransactionsBo beforeBo = warehouseTransactionsService.queryWarehouseTransactionByCode(bo.getWorkCode());
        boolean flag = warehouseTransactionsService.saveWarehouseTransactions(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出入库事务
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改WarehouseTransactions对象", notes = "修改出入库事务", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouseTransactions(@Valid @RequestBody WarehouseTransactionsVo warehouseTransactions) throws Exception
    {
        WarehouseTransactionsBo bo = new WarehouseTransactionsBo();
        BeanUtils.copyProperties(warehouseTransactions,bo);

        boolean flag = warehouseTransactionsService.updateWarehouseTransactions(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出入库事务
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除WarehouseTransactions对象", notes = "删除出入库事务", response = ApiResult.class)
    public ApiResult<Boolean> deleteWarehouseTransactions(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = warehouseTransactionsService.deleteWarehouseTransactions(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出入库事务
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取WarehouseTransactions对象详情", notes = "查看出入库事务", response = WarehouseTransactionsVo.class)
    public ApiResult<WarehouseTransactionsVo> getWarehouseTransactions(@PathVariable("id") Long id) throws Exception
    {
        WarehouseTransactionsBo warehouseTransactionsBo = warehouseTransactionsService.getWarehouseTransactionsById(id);
        WarehouseTransactionsVo queryVo = null;
        if (warehouseTransactionsBo != null) {
            queryVo = new WarehouseTransactionsVo();
            BeanUtils.copyProperties(warehouseTransactionsBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出入库事务分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取WarehouseTransactions分页列表", notes = "出入库事务分页列表", response = WarehouseTransactionsVo.class)
    public ApiResult<Paging<WarehouseTransactionsVo>> getWarehouseTransactionsPageList(@Valid @RequestBody WarehouseTransactionsQueryParam warehouseTransactionsQueryParam) throws Exception {
        Paging<WarehouseTransactionsBo> paging = warehouseTransactionsService.getWarehouseTransactionsPageList(warehouseTransactionsQueryParam);
        Paging<WarehouseTransactionsVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), WarehouseTransactionsVo.class));
        return ApiResult.ok(resultPage);
    }

    /**
     * 查询处理列表
     */
    @PostMapping("/query/transactionsList")
    @ApiOperation(value = "查询数据库事务列表", notes = "库位列表", response = WarehouseLocationVo.class)
    public ApiResult<List<WarehouseTransactionsVo>>  queryWarehouseTransactions() throws Exception
    {
        List<WarehouseTransactionsBo> boList = warehouseTransactionsService.queryWarehouseTransactionsBo();
        List<WarehouseTransactionsVo> voList = BeanListUtil.copyListProperties(boList, WarehouseTransactionsVo.class);
        return ApiResult.ok(voList);
    }

    /**
     * 根据编码，获取处理过程定义，对事务的一个补充，相当于子事务
     */
    @PostMapping("/query/queryByCode")
    @ApiOperation(value = "根据编码，库房事务详情", notes = "事务详情", response = WarehouseDealsVo.class)
    public ApiResult<WarehouseTransactionsVo> getWarehouseDeals(@RequestParam  String workCode) throws Exception {
        WarehouseTransactionsBo bo = warehouseTransactionsService.queryWarehouseTransactionByCode(workCode);
        WarehouseDealsVo vo = null;
        if (bo != null) {
            vo = new WarehouseDealsVo();
            BeanUtils.copyProperties(bo , vo);
        }
        return ApiResult.ok(vo);
    }
}

