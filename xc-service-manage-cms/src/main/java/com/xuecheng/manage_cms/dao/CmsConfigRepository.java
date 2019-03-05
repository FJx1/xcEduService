package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author FJx
 * @date 2019/2/17 20:57
 */
public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}
