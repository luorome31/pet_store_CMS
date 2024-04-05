package edu.csu.store_management_system.service;

import edu.csu.store_management_system.vo.ProductPreview;
import edu.csu.store_management_system.vo.ProductVO;

import java.util.List;

public interface ProductService {
    boolean addProduct(ProductVO productVO);
    boolean deleteProduct(String productId);
    boolean updateProduct(ProductVO productVO);

    List<ProductPreview> getProductsBasicInfo();
    List<ProductVO> getProductsByPage(Integer page, Integer size);
    ProductVO getProductDetail(String productId);
}
