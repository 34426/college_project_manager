package com.javanoteany.dict.controller;

import com.javanoteany.common.aop.AutoErrorhandler;
import com.javanoteany.common.base.V;
import com.javanoteany.common.result.PageResult;
import com.javanoteany.common.result.Result;
import com.javanoteany.common.utils.BeanCopyUtils;
import com.javanoteany.dict.entity.DataDictDetail;
import com.javanoteany.dict.query.DictQuery;
import com.javanoteany.dict.service.IDataDictDetailService;
import com.javanoteany.dict.view.DataDictView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Api("数据字典明细")
@RestController
@RequestMapping("/dict_detail")
public class DataDictDetailController {

    @Autowired
    private IDataDictDetailService dataDictionaryService;

    @ApiOperation(value="添加字典明细")
    @PostMapping("")
    @AutoErrorhandler
    public Result save(@RequestBody @Validated(V.Save.class)DataDictView dataDictView, BindingResult bindingResult) throws Exception {
        DataDictDetail saved = dataDictionaryService.save(BeanCopyUtils.copy(dataDictView, DataDictDetail.class));
        return Result.getSuccess(saved);
    }

    @ApiOperation(value="修改字典明细")
    @PutMapping("")
    @AutoErrorhandler
    public Result update(@RequestBody @Validated(V.Save.class)DataDictView dataDictView, BindingResult bindingResult) throws Exception {
        DataDictDetail updated = dataDictionaryService.update(BeanCopyUtils.copy(dataDictView, DataDictDetail.class));
        return Result.getSuccess(updated);
    }

    @ApiOperation(value="字典明细列表")
    @GetMapping("/query")
    public Result list(DictQuery query) throws Exception {
        PageResult pageResult = dataDictionaryService.queryPage(query);
        List<DataDictDetail> rows = pageResult.getRows();
        pageResult.setRows(BeanCopyUtils.copyList(rows,DataDictView.class));
        return Result.getSuccess(pageResult);
    }

    @ApiOperation(value = "根据id查询字典明细")
    @GetMapping(value = "",params = {"id"})
    public Result findById(String id) throws Exception {
        DataDictDetail dataDictDetail = dataDictionaryService.findById(id);
        Assert.notNull(dataDictDetail,"字典明细不存在");
        return Result.getSuccess(BeanCopyUtils.copy(dataDictDetail,DataDictView.class));
    }

    @ApiOperation(value = "删除字典明细")
    @DeleteMapping(value = "",params = {"id"})
    public Result delete(String id)  {
        dataDictionaryService.delete(id);
        return Result.getSuccess();
    }
}
