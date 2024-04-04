package edu.csu.store_management_system.service;

import edu.csu.store_management_system.service.impl.ItemServiceImpl;
import edu.csu.store_management_system.vo.ItemDetail;
import edu.csu.store_management_system.vo.ItemSummary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Test
    void getItemList() {
    }

    @Test
    void getItemListByPage() {
        //给出测试该方法的实例代码
        List<ItemSummary> itemListByPage = itemService.getItemListByPage(1, 10, 1);
        assertNotNull(itemListByPage);
        itemListByPage.forEach(System.out::println);
    }
    @Test
    void getItemDetail() {
        //给出测试该方法的实例代码
        ItemDetail itemDetail = itemService.getItemDetail("EST-1");
        assertNotNull(itemDetail);
        System.out.println(itemDetail);


    }
}