package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.AutoWarehouseConfigEntity;
import com.wms.service.AutoWarehouseConfigService;
import com.wms.api.autoconfig.AutoWarehouseConfigQueryParam;
import com.wms.api.autoconfig.AutoWarehouseConfigVo;
import com.wms.model.bo.autoconfig.AutoWarehouseConfigBo;
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

/**
 * <pre>
 * 自动仓配置 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-17
 */
@Slf4j
@RestController
@RequestMapping("/autoconfig")
@Api("自动仓配置 API")
public class AutoWarehouseConfigController extends BaseController {

    @Autowired
    private AutoWarehouseConfigService autoWarehouseConfigService;

    /**

     * 添加自动仓配置,全部改为更新
     */
/*    @PostMapping("/add")
    @ApiOperation(value = "添加AutoWarehouseConfig对象", notes = "添加自动仓配置", response = ApiResult.class)
    public ApiResult<Boolean> addAutoWarehouseConfig(@Valid @RequestBody AutoWarehouseConfigVo autoWarehouseConfig) throws Exception {
         AutoWarehouseConfigBo bo = new AutoWarehouseConfigBo();
        BeanUtils.copyProperties(autoWarehouseConfig,bo);

        boolean flag = autoWarehouseConfigService.saveAutoWarehouseConfig(bo);
        return ApiResult.result(flag);
    }*/

    /**
     * 修改自动仓配置
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改AutoWarehouseConfig对象", notes = "修改自动仓配置", response = ApiResult.class)
    public ApiResult<Boolean> updateAutoWarehouseConfig(@Valid @RequestBody AutoWarehouseConfigVo autoWarehouseConfig) throws Exception {
        AutoWarehouseConfigBo bo = new AutoWarehouseConfigBo();
        BeanUtils.copyProperties(autoWarehouseConfig,bo);

        boolean flag = autoWarehouseConfigService.updateAutoWarehouseConfig(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除自动仓配置
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除AutoWarehouseConfig对象", notes = "删除自动仓配置", response = ApiResult.class)
    public ApiResult<Boolean> deleteAutoWarehouseConfig(@PathVariable("id") Long id) throws Exception {
        boolean flag = autoWarehouseConfigService.deleteAutoWarehouseConfig(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取自动仓配置
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取AutoWarehouseConfig对象详情", notes = "查看自动仓配置", response = AutoWarehouseConfigVo.class)
    public ApiResult<AutoWarehouseConfigVo> getAutoWarehouseConfig(@PathVariable("id") Long id) throws Exception {
        AutoWarehouseConfigBo autoWarehouseConfigBo = autoWarehouseConfigService.getAutoWarehouseConfigById(id);
        AutoWarehouseConfigVo queryVo = null;
        if (autoWarehouseConfigBo != null) {
            queryVo = new AutoWarehouseConfigVo();
            BeanUtils.copyProperties(autoWarehouseConfigBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 获取自动仓配置
     */
    @GetMapping("/query/{warehouseCode}")
    @ApiOperation(value = "获取AutoWarehouseConfig对象详情", notes = "查看自动仓配置", response = AutoWarehouseConfigVo.class)
    public ApiResult<AutoWarehouseConfigVo> getAutoWarehouseConfig(@PathVariable("warehouseCode") String warehouseCode) throws Exception {
        AutoWarehouseConfigBo autoWarehouseConfigBo = autoWarehouseConfigService.queryAutoWarehouseConfigByCode(warehouseCode);
        AutoWarehouseConfigVo queryVo = null;
        if (autoWarehouseConfigBo != null) {
            queryVo = new AutoWarehouseConfigVo();
            BeanUtils.copyProperties(autoWarehouseConfigBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 重制自动仓密钥
     */
    @PostMapping("/secret/recreate")
    @ApiOperation(value = "获取AutoWarehouseConfig对象详情", notes = "查看自动仓配置", response = AutoWarehouseConfigVo.class)
    public ApiResult reCreateAppSecret(@RequestParam String warehouseCode) throws Exception {

        boolean flag = autoWarehouseConfigService.reCreateAppSecret(warehouseCode);
        return ApiResult.ok(flag);
    }

}

