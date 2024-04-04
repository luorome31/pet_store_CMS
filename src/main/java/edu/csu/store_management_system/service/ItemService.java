package edu.csu.store_management_system.service;

import edu.csu.store_management_system.vo.ItemDetail;
import edu.csu.store_management_system.vo.ItemSummary;

import java.util.List;

public interface ItemService {
    public List<ItemSummary> getItemListByPage(Integer page, Integer size, Integer supplierId);
    public ItemDetail getItemDetail(String itemId);
    public boolean updateItem(int itemId, ItemDetail itemDetail);
    public boolean removeItem(int itemId);
    public List<ItemSummary> searchItems(String keyword, int page, int size);
    public boolean addItem(ItemDetail itemDetail);

    }
