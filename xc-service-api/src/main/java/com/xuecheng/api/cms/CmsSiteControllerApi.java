package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author FJx
 * @date 2019/2/13 21:37
 */
@Api(value="cms站点管理接口",description = "cms站点管理接口，提供站点的增、删、改、查")
public interface CmsSiteControllerApi {
    @ApiOperation("查询站点列表")
    public QueryResponseResult findList();
}
