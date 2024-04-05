package edu.csu.store_management_system.service.impl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.csu.store_management_system.domain.Product;
import edu.csu.store_management_system.mapper.ProductMapper;
import edu.csu.store_management_system.service.ProductService;
import edu.csu.store_management_system.utils.RegexUtils;
import edu.csu.store_management_system.vo.ProductPreview;
import edu.csu.store_management_system.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;
    /**
     * 添加product，需要对productVO中的信息进行处理，加入product表中
     * @author Luo
     * @param productVO 产品信息
     * @return 是否添加成功
     */
    @Override
    public boolean addProduct(ProductVO productVO) {
        Product product = new Product();
        product.setProductid(productVO.getProductid());
        product.setCategory(productVO.getCategory());
        product.setName(productVO.getName());
        //<image src="images/fish4.gif">Salt Water fish from Australia
        String description = "<image src=\"images/"+productVO.getImage()+"\">"+productVO.getInformation();
        product.setDescn(description);

        int insert = productMapper.insert(product);
        if(insert == 0){
            return false;
        }
        return true;
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
     * @author Luo
     * @param productVO 产品信息
     * @return 是否更新成功
     */
    @Override
    public boolean updateProduct(ProductVO productVO) {

        Product product = new Product();
        product.setProductid(productVO.getProductid());
        product.setCategory(productVO.getCategory());
        product.setName(productVO.getName());
        //<image src="images/fish4.gif">Salt Water fish from Australia
        String description = "<image src=\"images/"+productVO.getImage()+"\">"+productVO.getInformation();
        product.setDescn(description);

        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<Product>().eq("productid", productVO.getProductid());
        int update = productMapper.update(product,updateWrapper);
        if(update == 0){
            return false;
        }
        return true;
    }

    /**
     * 获取现在已有的Product的基本信息：id+种类，用作添加item时供选择的下拉列表（controller中返回的是json数据）
     * @author Luo
     * @return ProductPreview列表
     */
    @Override
    public List<ProductPreview> getProductsBasicInfo() {
        List<Product> products = productMapper.selectList(null);
        List<ProductPreview> productPreviews = new ArrayList<>();
        for (Product product : products) {
            ProductPreview productPreview = new ProductPreview();
            productPreview.setProductId(product.getProductid());
            productPreview.setCategory(product.getCategory());
            productPreviews.add(productPreview);
        }
        return productPreviews;
    }

    /**
     * 分页获取product的详细信息，用于展示在thymeleaf页面，需要注意对图片路径的处理（可以用我写好了的utils包下的正则表达式工具类）
     * @author Luo
     * @param page
     * @param size
     * @return ProductVO列表(具体信息)
     */
    @Override
    public List<ProductVO> getProductsByPage(Integer page, Integer size) {
        Page<Product> productPage = new Page<>(page, size);
        productPage = productMapper.selectPage(productPage, null);
        List<Product> products = productPage.getRecords();
        List<ProductVO> productVOS = products.stream().map(product -> {
            ProductVO productVO = new ProductVO();
            productVO.setProductid(product.getProductid());
            productVO.setCategory(product.getCategory());
            productVO.setName(product.getName());
            String image = RegexUtils.extractSrc(product.getDescn());
            String information = RegexUtils.extractTextDescription(product.getDescn());

            productVO.setImage("../"+image);
            productVO.setInformation(information);

            return productVO;
        }).toList();
        return productVOS;
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
