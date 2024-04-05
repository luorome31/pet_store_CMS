package edu.csu.store_management_system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.csu.store_management_system.domain.Category;
import edu.csu.store_management_system.mapper.CategoryMapper;
import edu.csu.store_management_system.service.CategoryService;
import edu.csu.store_management_system.utils.RegexUtils;
import edu.csu.store_management_system.vo.CategoryPreview;
import edu.csu.store_management_system.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 添加分类
     * @author Luo
     * @param categoryVO
     * @return 是否添加成功
     */
    @Override
    public boolean addCategory(CategoryVO categoryVO) {
        Category category = new Category();
        category.setCatid(categoryVO.getName().toUpperCase());
        category.setName(categoryVO.getName());
        String description = "<image src=\"../images/"+categoryVO.getImage()+"\"><font size=\"5\" color=\"blue\"> "+categoryVO.getName()+"</font>";
        category.setDescn(description);
        int insert = categoryMapper.insert(category);
        if(insert == 0){
            return false;
        }
        return true;
    }

    /**
     * 获取现在已有的Category的基本信息：种类名，用作添加item时供选择的下拉列表（controller中返回的是json数据）后期还不一定用得上就是
     * @author Luo
     * @return  CategoryPreview列表
     */
    @Override
    public List<CategoryPreview> getCategoriesBasicInfo() {
        List<Category> categories = categoryMapper.selectList(null);
        List<CategoryPreview> categoryPreviews = categories.stream().map(category -> {
            CategoryPreview categoryPreview = new CategoryPreview();
            categoryPreview.setName(category.getName());
            return categoryPreview;
        }).toList();
        return  categoryPreviews;
    }

    /**
     * 分页获取分类的详细信息，用于展示在thymeleaf页面，需要注意对图片路径的处理
     * @author Luo
     * @param page
     * @param size
     * @return CategoryVO列表(具体信息)
     */
    @Override
    public List<CategoryVO> getCategoriesByPage(Integer page, Integer size) {
        Page<Category> categoryPage = new Page<>(page, size);
        categoryPage = categoryMapper.selectPage(categoryPage, null);
        List<Category> categories = categoryPage.getRecords();
        List<CategoryVO> categoryVOS = categories.stream().map(category -> {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setName(category.getName());
            categoryVO.setImage(RegexUtils.extractSrc(category.getDescn()));
            return categoryVO;
        }).toList();
        return categoryVOS;
    }

}
