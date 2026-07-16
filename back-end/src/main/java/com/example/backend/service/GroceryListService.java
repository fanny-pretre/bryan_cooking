package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.groceryList.groceryListEntityToGroceryListResponseMapper;
import com.example.backend.mapper.week.WeekResponseToWeekEntityMapper;
import com.example.backend.model.entity.GroceryListEntity;
import com.example.backend.model.input.GroceryListInput;
import com.example.backend.model.response.GroceryListResponse;
import com.example.backend.model.response.WeekResponse;
import com.example.backend.repository.GroceryListRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroceryListService {
    private final GroceryListRepository groceryListRepository;
    private final groceryListEntityToGroceryListResponseMapper groceryListEntityToGroceryListResponseMapper;
    private final WeekService weekService;
    private final WeekResponseToWeekEntityMapper weekResponseToWeekEntityMapper;

    public List<GroceryListResponse> getAllGroceryLists() {
        return groceryListRepository.findAllWithItems()
                .stream()
                .map(groceryListEntityToGroceryListResponseMapper::mapper)
                .toList();
    }

    public GroceryListResponse findGroceryListById(BigInteger id) {

        return groceryListEntityToGroceryListResponseMapper.mapper(findById(id));
    }

    public GroceryListResponse createGroceryList(@Valid GroceryListInput groceryListInput) {
        WeekResponse week = weekService.findWeekById(groceryListInput.weekId());

        GroceryListEntity savedEntity = groceryListRepository.save(
                GroceryListEntity.builder()
                        .week(weekResponseToWeekEntityMapper.mapper(week))
                        .build());

        return groceryListEntityToGroceryListResponseMapper.mapper(savedEntity);
    }

    public void deleteGroceryList(BigInteger id) {
        groceryListRepository.delete(findById(id));
    }

    private GroceryListEntity findById(BigInteger id) {
        return groceryListRepository.findById(id)
                .orElseThrow(() ->
                        new DataNotFound("groceryList", id));
    }
}
