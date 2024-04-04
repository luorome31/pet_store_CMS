package edu.csu.store_management_system.controller;

import edu.csu.store_management_system.service.ProductService;
import edu.csu.store_management_system.utils.ResponseMessage;
import edu.csu.store_management_system.vo.ProductPreview;
import edu.csu.store_management_system.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 获取数据并跳转到products列表页面
     * @param model 需要将获取的数据放入model中
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/")
    public String getProductByPage(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){

        List<ProductVO> products = productService.getProductsByPage(page, size);
        model.addAttribute("products", products);
        return "product/productList";
    }

    /**
     * 获取现在已有的product的基本信息，用于异步请求中的下拉列表
     * @return JSON数据格式，包含所有product的基本信息
     */
    @GetMapping("/info")
    public ResponseEntity<List<ProductPreview>> getProductInfo() {
        List<ProductPreview> productPreviews = productService.getProductsBasicInfo();
        return ResponseEntity.ok(productPreviews);
    }


    /**
     * 处理添加Product
     * @author Luo
     * @param product
     * @return JSON数据格式，指示添加是否成功和具体的提示信息
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addProduct(@RequestBody ProductVO product) {
        boolean isSuccess = productService.addProduct(product);
        ResponseMessage responseMessage = new ResponseMessage();
        if (!isSuccess) {
            responseMessage.setMessage("add failed");
            return ResponseEntity.badRequest().body(responseMessage);
        }
        responseMessage.setMessage("add success");
        return ResponseEntity.ok(responseMessage);
    }

    /**
     * 更新Product具体信息
     * @author Luo
     * @param productId
     * @param product
     * @return
     */
    @PutMapping("/{productId}")
    public ResponseEntity<ResponseMessage> updateProduct(@PathVariable String productId, @RequestBody ProductVO product) {
        boolean isSuccess = productService.updateProduct(productId, product);
        ResponseMessage responseMessage = new ResponseMessage();
        if (!isSuccess) {
            responseMessage.setMessage("update failed");
            return ResponseEntity.badRequest().body(responseMessage);
        }
        responseMessage.setMessage("update success");
        return ResponseEntity.ok(responseMessage);

    }
}
