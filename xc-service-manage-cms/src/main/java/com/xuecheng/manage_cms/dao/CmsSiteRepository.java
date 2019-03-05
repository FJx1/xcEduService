package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author FJx
 * @date 2019/2/13 21:40
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {
}
