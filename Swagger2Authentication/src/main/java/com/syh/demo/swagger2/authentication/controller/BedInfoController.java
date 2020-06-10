package com.syh.demo.swagger2.authentication.controller;

import com.syh.demo.swagger2.authentication.entity.BedInfo;
import com.syh.demo.swagger2.authentication.service.BedInfoService;
import com.syh.demo.swagger2.authentication.util.NurseResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 床位信息表 前端控制器
 * </p>
 *
 * @author HSY
 * @since 2020-06-08
 */
@RestController
@Api(tags = "床位信息表 API")
public class BedInfoController {
    private final static String ONE_RESOURCE = "/bed_info";
    private final static String MANY_RESOURCE = "/bed_infos";

    private final BedInfoService service;

    private BedInfoController(BedInfoService service) {
        this.service = service;
    }

    @ApiOperation(value = "查询单个")
    @GetMapping(ONE_RESOURCE + "/{id}")
    public NurseResponseUtil getById (@PathVariable Long id) {
        return service.getById(id);
    }

    @ApiOperation(value = "查询多个")
    @GetMapping(MANY_RESOURCE + "/{ids}")
    public NurseResponseUtil getByIds (@PathVariable List<Long> ids) {
        return service.getByIds(ids);
    }

    @ApiOperation(value = "新增")
    @PostMapping(ONE_RESOURCE)
    public NurseResponseUtil save (@RequestBody BedInfo paramBedInfo) {
        return service.save(paramBedInfo);
    }

    @ApiOperation(value = "批量新增")
    @PostMapping(MANY_RESOURCE)
    public NurseResponseUtil saveBatch (@RequestBody List<BedInfo> paramBedInfos){
        return service.saveBatch(paramBedInfos);
    }

    @ApiOperation(value = "更新")
    @PutMapping(ONE_RESOURCE)
    public NurseResponseUtil update (@RequestBody BedInfo paramBedInfo){
        return service.update(paramBedInfo);
    }

    @ApiOperation(value = "批量更新")
    @PutMapping(MANY_RESOURCE)
    public NurseResponseUtil updateBatch (@RequestBody List<BedInfo> paramBedInfos){
        return service.updateBatch(paramBedInfos);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping(ONE_RESOURCE + "/{id}")
    public NurseResponseUtil delete (@PathVariable Long id){
        return service.delete(id);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping(MANY_RESOURCE + "/{ids}")
    public NurseResponseUtil deleteBatch (@PathVariable List<Long> ids){
        return service.deleteBatch(ids);
    }
}