package edu.csu.store_management_system.service.impl;

import edu.csu.store_management_system.service.CategoryService;
import edu.csu.store_management_system.vo.CategoryPreview;
import edu.csu.store_management_system.vo.CategoryVO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * 添加分类
     * @author
     * @param categoryName
     * @return 是否添加成功
     */
    @Override
    public boolean addCategory(String categoryName) {
        return false;
    }

    /**
     * 获取现在已有的Category的基本信息：种类名，用作添加item时供选择的下拉列表（controller中返回的是json数据）后期还不一定用得上就是
     * @author
     * @return  CategoryPreview列表
     */
    @Override
    public List<CategoryPreview> getCategoriesBasicInfo() {
        return null;
    }

    /**
     * 分页获取分类的详细信息，用于展示在thymeleaf页面，需要注意对图片路径的处理（这个我还没写工具类）
     * @param page
     * @param size
     * @return CategoryVO列表(具体信息)
     */
    @Override
    public List<CategoryVO> getCategoriesByPage(Integer page, Integer size) {
        return null;
    }

}
