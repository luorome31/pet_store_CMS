package edu.csu.store_management_system.service;

import edu.csu.store_management_system.vo.CategoryPreview;
import edu.csu.store_management_system.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    boolean addCategory(String categoryName);
    List<CategoryPreview> getCategoriesBasicInfo();
    List<CategoryVO> getCategoriesByPage(Integer page, Integer size);
}
