package com.atguigu.gmall.pms;

import com.atguigu.gmall.pms.entity.Brand;
import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.pms.service.BrandService;
import com.atguigu.gmall.pms.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {

    @Resource
    ProductService productService;

    @Resource
    BrandService brandService;

    @Test
    public void contextLoads() {

        /*Product product = productService.getById(1);
        System.out.println(product.getBrandName());*/

        //测试主从
        /*Brand brand = new Brand();
        brand.setName("测试主从");
        brandService.save(brand);*/

        Brand brand = brandService.getById(53);

        System.out.println(brand.getName());

    }



}
