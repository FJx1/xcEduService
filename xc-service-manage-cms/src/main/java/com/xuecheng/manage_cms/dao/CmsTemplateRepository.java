package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author FJx
 * @date 2019/2/14 21:41
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
}
