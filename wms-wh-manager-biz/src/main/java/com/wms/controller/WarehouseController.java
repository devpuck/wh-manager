package com.wms.controller;

import com.wms.errorcode.ErrorCode;
import com.wms.util.check.CheckParameter;
import com.xac.core.api.ApiResultCode;
import com.xac.core.util.BeanListUtil;
import com.wms.service.WarehouseService;
import com.wms.api.warehouse.WarehouseQueryParam;
import com.wms.api.warehouse.WarehouseVo;
import com.wms.model.bo.warehouse.WarehouseBo;
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
 * 库房定义表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-16
 */
@Slf4j
@RestController
@RequestMapping("/warehouse")
@Api("库房定义表 API")
public class WarehouseController extends BaseController {

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 添加库房定义
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Warehouse对象", notes = "添加库房定义表", response = ApiResult.class)
    public ApiResult addWarehouse(@Valid @RequestBody WarehouseVo warehouse) throws Exception
    {
        String warehouseCode = warehouse.getWarehouseCode();
        if(ErrorCode.OK!=CheckParameter.checkParameter(warehouseCode))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        String ID = warehouseService.queryIDByWarehouseCode(warehouseCode);
        if(null !=ID )
        {
            ApiResult apiResult = new ApiResult();
            apiResult.setCode(ErrorCode.WAREHOUSE_CODE_REPEAT);
            apiResult.setMsg(ErrorCode.WAREHOUSE_CODE_REPEAT_MESSAGE);
            apiResult.setSuccess(false);
            return apiResult;
        }

        WarehouseBo bo = new WarehouseBo();
        BeanUtils.copyProperties(warehouse,bo);

        boolean flag = warehouseService.saveWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改库房定义
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Warehouse对象", notes = "修改库房定义表", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouse(@Valid @RequestBody WarehouseVo warehouse) throws Exception {
        WarehouseBo bo = new WarehouseBo();
        BeanUtils.copyProperties(warehouse,bo);

        boolean flag = warehouseService.updateWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除库房定义
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Warehouse对象", notes = "删除库房定义表", response = ApiResult.class)
    public ApiResult<Boolean> deleteWarehouse(@PathVariable("id") Long id) throws Exception {
        boolean flag = warehouseService.deleteWarehouse(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取库房定义
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Warehouse对象详情", notes = "查看库房定义表", response = WarehouseVo.class)
    public ApiResult<WarehouseVo> getWarehouse(@PathVariable("id") Long id) throws Exception {
        WarehouseBo warehouseBo = warehouseService.getWarehouseById(id);
        WarehouseVo queryVo = null;
        if (warehouseBo != null) {
            queryVo = new WarehouseVo();
            BeanUtils.copyProperties(warehouseBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 根据库房编码查询库房信息
     */
    @GetMapping("/query/{warehouseCode}")
    @ApiOperation(value = "获取Warehouse对象详情", notes = "查看库房定义表", response = WarehouseVo.class)
    public ApiResult<WarehouseVo> queryWarehouseByCode(@PathVariable("warehouseCode") String warehouseCode) throws Exception {
        WarehouseBo warehouseBo = warehouseService.queryWareHouseByCode(warehouseCode);
        WarehouseVo queryVo = null;
        if (warehouseBo != null)
        {
            queryVo = new WarehouseVo();
            BeanUtils.copyProperties(warehouseBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 库房定义表分页列
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取Warehouse分页列表", notes = "库房定义表分页列表", response = WarehouseVo.class)
    public ApiResult<Paging<WarehouseVo>> getWarehousePageList(@Valid @RequestBody WarehouseQueryParam warehouseQueryParam) throws Exception {
        Paging<WarehouseBo> paging = warehouseService.getWarehousePageList(warehouseQueryParam);
        Paging<WarehouseVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), WarehouseVo.class));
        return ApiResult.ok(resultPage);
    }

    @PostMapping("/updateState")
    @ApiOperation(value = "更新库房状态", notes = "更新库房状态", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouseState(@RequestParam String warehouseCode,@RequestParam String state) throws Exception
    {
        if(ErrorCode.OK!=CheckParameter.checkParameter(warehouseCode,state))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        System.out.println("WAREHOUSECODE:"+warehouseCode);
        System.out.println("STATE:"+state);
        boolean flag = true;
        flag = warehouseService.updateWarehouseState(warehouseCode,state);
        return ApiResult.result(flag);
    }

    @PostMapping("/updateConnectState")
    @ApiOperation(value = "修改Warehouse对象", notes = "修改库房定义表", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouseConnectState(@RequestParam String warehouseCode,@RequestParam String state) throws Exception
    {
        if(ErrorCode.OK!=CheckParameter.checkParameter(warehouseCode,state))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        boolean flag = warehouseService.updateWarehouseConnectState(warehouseCode,state);
        return ApiResult.result(flag);
    }

    @PostMapping("/queryAllWarehouse")
    @ApiOperation(value = "获取Warehouse分页列表", notes = "库房定义表分页列表", response = WarehouseVo.class)
    public ApiResult<List<WarehouseVo>> queryAllWarehouse() throws Exception {

        List<WarehouseBo> warehouseList = warehouseService.queryWarehouseList();

        List<WarehouseVo> voList = BeanListUtil.copyListProperties(warehouseList,WarehouseVo.class);
        return ApiResult.ok(voList);
    }

}

