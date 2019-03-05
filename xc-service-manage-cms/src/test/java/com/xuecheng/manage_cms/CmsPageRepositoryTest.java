package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author FJx
 * @date 2019/1/27 21:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsPageRepositoryTest {
    @Autowired
    private CmsPageRepository cmsPageRepository;

    //分页查询
    @Test
    public void testFindPage(){
        int page = 0;//从0开始
        int size = 10;//每页记录数
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> pages = cmsPageRepository.findAll(pageable);
        List<CmsPage> content = pages.getContent();
        System.out.println(content);
        System.out.println(pages+"/..");
    }

    //添加
    @Test
    public void testInsert(){
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    //删除
    @Test
    public void testDelete(){
        cmsPageRepository.deleteById("5c59914cecf1681928f80064");
    }

    //修改
    @Test
    public void testUpdate(){
        Optional<CmsPage> optional = cmsPageRepository.findById("5c59914cecf1681928f80064");
        if(optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("测试页面修改后");
            cmsPageRepository.save(cmsPage);
        }
    }

    //测试使用自定义Dao方法
    //根据页面名称查询
    @Test
    public void testFindPageName(){
        CmsPage name = cmsPageRepository.findByPageName("测试页面修改后");
        System.out.println(name);
    }
    //根据站点和页面类型分页查询
    @Test
    public void testFindBySiteIdAndPageType(){
        Pageable pageable = PageRequest.of(0,10);
        Page<CmsPage> page = cmsPageRepository.findBySiteIdAndPageType("5a751fab6abb5044e0d19ea1",
                "preview_4028e58161bd3b380161bd3bcd2f0000.html", pageable);
        System.out.println(page.getContent());
    }

    //在页面输入查询条件，查询符合条件的页面信息
    //站点Id：精确匹配 模板Id：精确匹配  页面别名：模糊匹配 条件分页查询测试demo
    @Test
    public void testFindAllParamsPage(){
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1"); //根据站点id  条件匹配器默认是精确查询
        cmsPage.setTemplateId("5a962bf8b00ffc514038fafa");//根据模板id 条件匹配器默认是精确查询
        cmsPage.setPageAliase("轮播");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        /**
         * Example.of()两个参数 参数1 是实体类 2 是 条件匹配器
         */
        Example example = Example.of(cmsPage,exampleMatcher);

        //分页
        Pageable pageable = PageRequest.of(0,10);
        Page all = cmsPageRepository.findAll(example, pageable);
        List content = all.getContent();
        System.out.println(content);
    }
}