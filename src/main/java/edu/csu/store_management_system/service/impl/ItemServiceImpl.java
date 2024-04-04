package edu.csu.store_management_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.csu.store_management_system.domain.Inventory;
import edu.csu.store_management_system.domain.Item;
import edu.csu.store_management_system.domain.Product;
import edu.csu.store_management_system.mapper.InventoryMapper;
import edu.csu.store_management_system.mapper.ItemMapper;
import edu.csu.store_management_system.mapper.ProductMapper;
import edu.csu.store_management_system.service.ItemService;
import edu.csu.store_management_system.utils.RegexUtils;
import edu.csu.store_management_system.vo.ItemDetail;
import edu.csu.store_management_system.vo.ItemSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private InventoryMapper inventoryMapper;
    public List<ItemSummary> getItemList() {
        return null;
    }
    /*

        * @param page 页码
        * @param size 每页大小
        * @param supplierId 供应商id
        * @return 分页后的商品列表
        * @author: Luo
     */
    public List<ItemSummary> getItemListByPage(Integer page, Integer size ,Integer supplierId) {
        QueryWrapper<Item> supplierId_equ = new QueryWrapper<Item>().eq("supplier", supplierId);
        Page<Item> itemPage = new Page<>(page, size);
        itemPage= itemMapper.selectPage(itemPage, supplierId_equ);
        List<Item> items = itemPage.getRecords();

        List<ItemSummary> itemSummaries = items.stream().map(item -> {
            ItemSummary itemSummary = new ItemSummary();
            String itemid = item.getItemid();
            String productid = item.getProductid();

            itemSummary.setItemId(itemid);
            itemSummary.setProduct(productid);
            itemSummary.setPrice(item.getListprice());

            QueryWrapper<Product> productid_equ = new QueryWrapper<Product>().select("category").eq("productid", productid);
            Product product = productMapper.selectOne(productid_equ);
            itemSummary.setCategory(product.getCategory());

            QueryWrapper<Inventory> itemid_equ = new QueryWrapper<Inventory>().select("qty").eq("itemid", itemid);
            Inventory inventory = inventoryMapper.selectOne(itemid_equ);
            itemSummary.setQuantity(inventory.getQty());

            return itemSummary;
        }).toList();
        return itemSummaries;
    }

    /*
     * @param itemId 商品id
     * @return 商品详情
     * @Author: Luo
     * @function: 根据商品id获取商品详情
     */
    @Override
    public ItemDetail getItemDetail(String itemId) {
        QueryWrapper<Item> itemid_equ = new QueryWrapper<Item>().eq("itemid", itemId);
        Item item = itemMapper.selectOne(itemid_equ);
        ItemDetail itemDetail = new ItemDetail();
        itemDetail.setItemId(item.getItemid());
        itemDetail.setProduct(item.getProductid());
        itemDetail.setList_price(item.getListprice());
        itemDetail.setUnit_cost(item.getUnitcost());

        QueryWrapper<Inventory> inventoryQueryWrapper = new QueryWrapper<Inventory>().select("qty").eq("itemid", item.getItemid());
        Inventory inventory = inventoryMapper.selectOne(inventoryQueryWrapper);
        itemDetail.setQuantity(inventory.getQty());

        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<Product>().select("descn,category").eq("productid", item.getProductid());
        Product product = productMapper.selectOne(productQueryWrapper);
        String descn = RegexUtils.extractTextDescription(product.getDescn());
        String image = RegexUtils.extractSrc(product.getDescn());

        itemDetail.setCategory(product.getCategory());
        itemDetail.setImage("../"+image);
        itemDetail.setDescription(item.getAttr1()+" "+descn);

        return itemDetail;

    }


}
