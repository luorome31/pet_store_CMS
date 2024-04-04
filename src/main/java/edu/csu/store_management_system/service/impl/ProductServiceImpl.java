package edu.csu.store_management_system.service.impl;
import edu.csu.store_management_system.service.ProductService;
import edu.csu.store_management_system.vo.ProductPreview;
import edu.csu.store_management_system.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    /**
     * 添加product，需要对productVO中的信息进行处理，加入product表中
     * @author
     * @param productVO 产品信息
     * @return 是否添加成功
     */
    @Override
    public boolean addProduct(ProductVO productVO) {
        return false;
    }
    /**
     * 删除product，从product表中删除
     * @param productId 产品id
     * @return 是否删除成功
     */
    @Override
    public boolean deleteProduct(String productId) {
        return false;
    }

    /**
     * 更新product，更新product表中的信息，修改图片的问题还我在thinking。。。。
     * @param productId 产品id
     * @param productVO 产品信息
     * @return 是否更新成功
     */
    @Override
    public boolean updateProduct(String productId, ProductVO productVO) {
        return false;
    }

    /**
     * 获取现在已有的Product的基本信息：id+种类，用作添加item时供选择的下拉列表（controller中返回的是json数据）
     * @author
     * @return ProductPreview列表
     */
    @Override
    public List<ProductPreview> getProductsBasicInfo() {
        return null;
    }

    /**
     * 分页获取product的详细信息，用于展示在thymeleaf页面，需要注意对图片路径的处理（可以用我写好了的utils包下的正则表达式工具类）
     * @author
     * @param page
     * @param size
     * @return ProductVO列表(具体信息)
     */
    @Override
    public List<ProductVO> getProductsByPage(Integer page, Integer size) {
        return null;
    }

    /**
     * 获取product的详细信息，用于展示在修改某个具体的product的弹出框中，通用需要注意对图片路径的处理，实现上是上面一个方法的简化版
     * @param productId
     * @return  ProductVO具体信息
     */
    @Override
    public ProductVO getProductDetail(String productId) {
        return null;
    }
}
