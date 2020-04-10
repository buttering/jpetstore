package org.csu.jpetstore;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.csu.jpetstore.domain.Category;
import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.service.CatalogService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.jpetstore.persistence")
class JpetstoreApplicationTests {
    @Autowired
    CatalogService catalogService;

    @Test
    void contextLoads() {
    }

    @Test
    void testCategory(){
        Category category = catalogService.getCategory("BIRDS");
        System.out.print(category.getCategoryId()+','+ category.getName()+','+ category.getDescription());
    }

    @Test
    void testProduct(){
        List<Product> productsList = catalogService.getProductListByCategory("BIRDS");
        System.out.print(productsList.size());
    }

    @Test
    void testPageInfo(){
        PageHelper.startPage(1, 3);
        List<Category> categoryList= catalogService.getCategoryList();
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        System.out.print(pageInfo);
    }
}
