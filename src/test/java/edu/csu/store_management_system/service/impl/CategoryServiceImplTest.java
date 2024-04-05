package edu.csu.store_management_system.service.impl;

import edu.csu.store_management_system.service.CategoryService;
import edu.csu.store_management_system.vo.CategoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;
    @Test
    void addCategory() {
        //编写测试代码
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setName("FOX");
        categoryVO.setImage("fox.gif");
        boolean b = categoryService.addCategory(categoryVO);
        assertTrue(b);

    }

    @Test
    void getCategoriesBasicInfo() {
        categoryService.getCategoriesBasicInfo().forEach(System.out::println);
    }

    @Test
    void getCategoriesByPage() {
        categoryService.getCategoriesByPage(1, 10).forEach(System.out::println);
    }
}