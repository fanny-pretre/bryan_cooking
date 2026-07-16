package com.example.backend.mapper.groceryList;

import com.example.backend.mapper.groceryItem.GroceryItemResponseToGroceryItemEntityMapper;
import com.example.backend.mapper.week.WeekResponseToWeekEntityMapper;
import com.example.backend.model.entity.GroceryListEntity;
import com.example.backend.model.response.GroceryListResponse;
import com.example.backend.service.WeekService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GroceryListResponseToGroceryListEntityMapper {

    private final WeekResponseToWeekEntityMapper weekResponseToWeekEntityMapper;
    private final GroceryItemResponseToGroceryItemEntityMapper groceryItemResponseToGroceryItemEntityMapper;

    public GroceryListEntity mapper(GroceryListResponse groceryListResponse) {


        return GroceryListEntity.builder()
                .id(groceryListResponse.id())
                .week(weekResponseToWeekEntityMapper.mapper(groceryListResponse.week()))
                .items(groceryListResponse.items().stream().map(groceryItemResponseToGroceryItemEntityMapper::mapper).toList())
                .build();
    }
}
