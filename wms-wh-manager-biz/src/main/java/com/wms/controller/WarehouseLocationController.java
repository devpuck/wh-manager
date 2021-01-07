package com.wms.controller;

import com.wms.api.location.LocationProductionVo;
import com.wms.errorcode.ErrorCode;
import com.wms.model.bo.locationproduction.LocationProductionBo;
import com.wms.service.LocationProductionService;
import com.wms.util.check.CheckParameter;
import com.xac.core.api.ApiResultCode;
import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.WarehouseLocationEntity;
import com.wms.service.WarehouseLocationService;
import com.wms.api.location.WarehouseLocationQueryParam;
import com.wms.api.location.WarehouseLocationVo;
import com.wms.model.bo.location.WarehouseLocationBo;
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
 * 库位定义 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
@Slf4j
@RestController
@RequestMapping("/location")
@Api("库位定义 API")
public class WarehouseLocationController extends BaseController {

    @Autowired
    private WarehouseLocationService warehouseLocationService;
    @Autowired
    private LocationProductionService locationProductionService;

    /**
     * 添加库位定义
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加WarehouseLocation对象", notes = "添加库位定义", response = ApiResult.class)
    public ApiResult<Boolean> addWarehouseLocation(@Valid @RequestBody WarehouseLocationVo warehouseLocation) throws Exception
    {
        WarehouseLocationBo bo = new WarehouseLocationBo();
        BeanUtils.copyProperties(warehouseLocation,bo);

        String warehouseCode = warehouseLocation.getWarehouseCode();
        String locationCode = warehouseLocation.getLocationCode();
        if(ErrorCode.OK != CheckParameter.checkParameter(warehouseCode,locationCode))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        WarehouseLocationBo beforeBo = warehouseLocationService.queryWarehouseLocation(warehouseCode,locationCode);
        if(null != beforeBo)
        {
            ApiResult apiResult = new ApiResult();
            apiResult.setCode(ErrorCode.WAREHOUSE_LOCATION_CODE_REPEAT);
            apiResult.setMsg(ErrorCode.WAREHOUSE_LOCATION_CODE_REPEAT_MESSAGE);
            apiResult.setSuccess(false);
            return apiResult;
        }

        boolean flag = warehouseLocationService.saveWarehouseLocation(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改库位定义
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改WarehouseLocation对象", notes = "修改库位定义", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouseLocation(@Valid @RequestBody WarehouseLocationVo warehouseLocation) throws Exception {
        WarehouseLocationBo bo = new WarehouseLocationBo();
        BeanUtils.copyProperties(warehouseLocation,bo);

        boolean flag = warehouseLocationService.updateWarehouseLocation(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除库位定义
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除WarehouseLocation对象", notes = "删除库位定义", response = ApiResult.class)
    public ApiResult<Boolean> deleteWarehouseLocation(@PathVariable("id") Long id) throws Exception {
        boolean flag = warehouseLocationService.deleteWarehouseLocation(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取库位定义
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取WarehouseLocation对象详情", notes = "查看库位定义", response = WarehouseLocationVo.class)
    public ApiResult<WarehouseLocationVo> getWarehouseLocation(@PathVariable("id") Long id) throws Exception {
        WarehouseLocationBo warehouseLocationBo = warehouseLocationService.getWarehouseLocationById(id);
        WarehouseLocationVo queryVo = null;
        if (warehouseLocationBo != null) {
            queryVo = new WarehouseLocationVo();
            BeanUtils.copyProperties(warehouseLocationBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 获取库位定义
     */
    @PostMapping("/query/info")
    @ApiOperation(value = "获取WarehouseLocation对象详情", notes = "查看库位定义", response = WarehouseLocationVo.class)
    public ApiResult<WarehouseLocationVo> queryLocationInfo(@RequestParam String warehouseCode,@RequestParam String locationCode) throws Exception {
        WarehouseLocationBo warehouseLocationBo = warehouseLocationService.queryWarehouseLocation(warehouseCode,locationCode);
        WarehouseLocationVo queryVo = null;
        if (warehouseLocationBo != null) {
            queryVo = new WarehouseLocationVo();
            BeanUtils.copyProperties(warehouseLocationBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 库位定义分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取WarehouseLocation分页列表", notes = "库位定义分页列表", response = WarehouseLocationVo.class)
    public ApiResult<Paging<WarehouseLocationVo>> getWarehouseLocationPageList(@Valid @RequestBody WarehouseLocationQueryParam warehouseLocationQueryParam) throws Exception {
        Paging<WarehouseLocationBo> paging = warehouseLocationService.getWarehouseLocationPageList(warehouseLocationQueryParam);
        Paging<WarehouseLocationVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), WarehouseLocationVo.class));
        return ApiResult.ok(resultPage);
    }

    /**
     * 查询库房库位
     */
    @PostMapping("/query/warehouseLocation")
    @ApiOperation(value = "根据库房编号查询库位信息", notes = "库位列表", response = WarehouseLocationVo.class)
    public ApiResult<List<WarehouseLocationBo>>  queryWarehouseLocation(@RequestParam String warehouseCode) throws Exception
    {
        List<WarehouseLocationBo> locationBoList = warehouseLocationService.queryWarehouseLocationList(warehouseCode);
        return ApiResult.ok(locationBoList);
    }

    /**
     * 更新库位状态
     * @param warehouseCode
     * @param locationCode
     * @param state
     * @return
     * @throws Exception
     */
    @PostMapping("/updateState")
    @ApiOperation(value = "更新库位状态", notes = "修改库房定义表", response = ApiResult.class)
    public ApiResult<Boolean> updateWarehouseState(@RequestParam String warehouseCode,@RequestParam String locationCode,@RequestParam String state) throws Exception
    {
        if(ErrorCode.OK!=CheckParameter.checkParameter(warehouseCode,state))
        {
            return ApiResult.result(ApiResultCode.PARAMETER_EXCEPTION);
        }

        System.out.println("WAREHOUSECODE:"+warehouseCode);
        System.out.println("LOCATIONCODE:"+locationCode);
        System.out.println("STATE:"+state);

        boolean flag = true;
        flag = warehouseLocationService.updateLocationState(warehouseCode,locationCode,state);
        return ApiResult.result(flag);
    }

    /**
     * 添加库位物料绑定关系
     */
    @PostMapping("/bindProduction")
    @ApiOperation(value = "添加LocationProduction对象", notes = "添加库位物料绑定关系", response = ApiResult.class)
    public ApiResult<Boolean> addLocationProduction(@Valid @RequestBody LocationProductionVo locationProduction) throws Exception {
        LocationProductionBo bo = new LocationProductionBo();
        BeanUtils.copyProperties(locationProduction,bo);

        boolean flag = locationProductionService.saveLocationProduction(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除库位物料绑定关系
     */
    @PostMapping("/unBindProduction/{id}")
    @ApiOperation(value = "删除LocationProduction对象", notes = "删除库位物料绑定关系", response = ApiResult.class)
    public ApiResult<Boolean> deleteLocationProduction(@PathVariable("id") Long id) throws Exception {
        boolean flag = locationProductionService.deleteLocationProduction(id);
        return ApiResult.result(flag);
    }

    /**
     * 查询库位绑定的物料
     */
    @PostMapping("/query/queryLocationBindProduction")
    @ApiOperation(value = "查询库位绑定的物料", notes = "绑定信息", response = WarehouseLocationVo.class)
    public ApiResult<List<LocationProductionVo>>  queryLocationBindProduction(@RequestParam String warehouseCode,@RequestParam String locationCode) throws Exception
    {
        List<LocationProductionBo> locationBoList = locationProductionService.queryLocationProductionList(warehouseCode,locationCode);
        List<LocationProductionVo> voList = BeanListUtil.copyListProperties(locationBoList, LocationProductionVo.class);
        return ApiResult.ok(voList);
    }

    /**
     * 根据物料编码查询绑定的库位列表
     */
    @PostMapping("/query/queryProductionBindLocation")
    @ApiOperation(value = "根据物料编码查询绑定的库位列表", notes = "库位列表", response = WarehouseLocationVo.class)
    public ApiResult<List<LocationProductionVo>>  queryLocationBindProduction(@RequestParam String productionCode) throws Exception
    {
        List<LocationProductionBo> locationBoList = locationProductionService.queryLocationByBindProduction(productionCode);
        List<LocationProductionVo> voList = BeanListUtil.copyListProperties(locationBoList, LocationProductionVo.class);
        return ApiResult.ok(voList);
    }
}

