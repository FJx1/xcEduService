package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author FJx
 * @date 2019/1/27 21:49
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

}
