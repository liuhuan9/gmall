package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.pms.constants.SysCacheConstants;
import com.atguigu.gmall.pms.entity.ProductCategory;
import com.atguigu.gmall.pms.mapper.ProductCategoryMapper;
import com.atguigu.gmall.pms.service.ProductCategoryService;
import com.atguigu.gmall.vo.PmsProductCategoryWithChildrenItem;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-12-15
 */
@Component
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Resource
    ProductCategoryMapper mapper;

    @Resource
    RedisTemplate<Object,Object> redisTemplate;

    @Override
    public List<PmsProductCategoryWithChildrenItem> listCatelogWithChildren(Integer i) {
        Object s= redisTemplate.opsForValue().get(SysCacheConstants.menuCaChe);
        List<PmsProductCategoryWithChildrenItem> items;
        if(s!=null){
            //缓存有
            items = (List<PmsProductCategoryWithChildrenItem>) s;
        }else{
            items  = mapper.listCatelogWithChildren(i);

            redisTemplate.opsForValue().set(SysCacheConstants.menuCaChe,items);
        }
        return items;
    }
}
