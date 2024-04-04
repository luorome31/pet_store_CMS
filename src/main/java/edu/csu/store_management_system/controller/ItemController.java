package edu.csu.store_management_system.controller;

import edu.csu.store_management_system.service.ItemService;
import edu.csu.store_management_system.service.impl.ItemServiceImpl;
import edu.csu.store_management_system.vo.ItemDetail;
import edu.csu.store_management_system.vo.ItemSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/test")
    public String getItemList() {
        return "item/itemList";
    }

    @GetMapping("/")
    public String getItemList(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<ItemSummary> items = itemService.getItemListByPage(page, size, 1);

        model.addAttribute("items", items);
        return "item/itemList";
    }

    /*
        * @param itemId 商品id
        * @return 商品详情
        * @function 获取商品详情
        * @auther: Luo
     */
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDetail> getItemDetail(@PathVariable String itemId) {
        System.out.println(itemId);
        return ResponseEntity.ok(itemService.getItemDetail(itemId));
    }

}
