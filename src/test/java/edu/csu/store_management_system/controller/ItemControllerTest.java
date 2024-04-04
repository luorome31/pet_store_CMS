package edu.csu.store_management_system.controller;

import edu.csu.store_management_system.service.ItemService;
import edu.csu.store_management_system.vo.ItemDetail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;
    @Test
    void getItemList() {
    }

    @Test
    void testGetItemList() {

    }

    @Test
    void getItemDetail() throws Exception {
        ItemDetail itemDetail = new ItemDetail();
        itemDetail.setItemId("itemId");
        itemDetail.setCategory("Item");
        itemDetail.setProduct("Description");
        itemDetail.setList_price(19.0);
        Mockito.when(itemService.getItemDetail("itemId"))
                .thenReturn(itemDetail);
        // Perform GET request to /items/{itemId}
        mockMvc.perform(MockMvcRequestBuilders.get("/items/{itemId}", "itemId"))
                // Verify that status is OK (200)
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Verify that response contains the correct item detail JSON
                .andExpect(MockMvcResultMatchers.jsonPath("$.itemId").value("itemId"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.itemName").value("Item"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.itemDescription").value("Description"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(10.0));
    }
}