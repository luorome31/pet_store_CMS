package edu.csu.store_management_system.service.impl;

import edu.csu.store_management_system.vo.ProductPreview;
import edu.csu.store_management_system.vo.ProductVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    void addProduct() {
        ProductVO productVO = new ProductVO();
        productVO.setProductid("FISH-110");
        productVO.setCategory("FISH");
        productVO.setName("lord");
        productVO.setImage("fish4.gif");
        productVO.setInformation("Salt Water fish from Asia");
        boolean b = productService.addProduct(productVO);
        assertTrue(b);

    }

    @Test
    void deleteProduct() {

    }

    @Test
    void updateProduct() {
        ProductVO productVO = new ProductVO();
        productVO.setProductid("FISH-110");
        productVO.setCategory("FISH");
        productVO.setName("york");
        productVO.setImage("fish101.gif");
        productVO.setInformation("Salt Water fish from Asia");
        boolean b = productService.updateProduct(productVO);
        assertTrue(b);
    }

    @Test
    void getProductsBasicInfo() {
        List<ProductPreview> productPreviews = productService.getProductsBasicInfo();
        productPreviews.forEach(System.out::println);
    }

    @Test
    void getProductsByPage() {
        List<ProductVO> productsByPage = productService.getProductsByPage(1, 10);
        productsByPage.forEach(System.out::println);
    }

    @Test
    void getProductDetail() {
    }
}