package edu.csu.store_management_system.controller;

import edu.csu.store_management_system.service.CategoryService;
import edu.csu.store_management_system.utils.ResponseMessage;
import edu.csu.store_management_system.vo.CategoryPreview;
import edu.csu.store_management_system.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /**
     * 添加分类
     *
     * @param categoryName
     * @return 是否添加成功
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addCategory(String categoryName) {
        return null;
    }

    /**
     * 获取现在已有的Category的基本信息
     *
     * @return CategoryPreview列表
     */
    @RequestMapping("/info")
    public ResponseEntity<List<CategoryPreview>> getCategoriesBasicInfo() {
        return null;
    }

    /**
     * 分页获取分类的详细信息，用于展示在thymeleaf页面，需要注意对图片路径的处理（这个我还没写工具类）
     *
     * @param page
     * @param size
     * @param model
     * @return CategoryVO列表(具体信息)
     */
    @RequestMapping("/")
    public String getCategoriesByPage(Model model, Integer page, Integer size) {
        return "category/categoryList";
    }

}
