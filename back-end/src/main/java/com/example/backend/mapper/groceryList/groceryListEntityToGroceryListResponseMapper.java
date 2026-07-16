package com.example.backend.mapper.groceryList;

import com.example.backend.mapper.groceryItem.GroceryItemEntityToGroceryItemResponseMapper;
import com.example.backend.mapper.week.WeekEntityToWeekResponseMapper;
import com.example.backend.model.entity.GroceryListEntity;
import com.example.backend.model.response.GroceryListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class groceryListEntityToGroceryListResponseMapper {

    private final WeekEntityToWeekResponseMapper weekEntityToWeekResponseMapper;
    private final GroceryItemEntityToGroceryItemResponseMapper groceryItemEntityToGroceryItemResponseMapper;

    public GroceryListResponse mapper(GroceryListEntity groceryListEntity) {

        return GroceryListResponse.builder()
                .id(groceryListEntity.getId())
                .week(weekEntityToWeekResponseMapper.weekEntityToWeekResponse(groceryListEntity.getWeek()))
                .items(groceryListEntity.getItems().stream().map(groceryItemEntityToGroceryItemResponseMapper::mapper).toList())
                .build();
    }
}
