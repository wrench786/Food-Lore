package com.minhajcse.food.controller;

import com.minhajcse.food.service.FoodService;
import com.minhajcse.food.model.Food;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/food")
public class FoodController {
    private final FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/top-ten-foods")
    public ResponseEntity<List<Food>> getTopTenFoods() {
        List<Food> topTenFoods = foodService.getTopTenFoods();
        return new ResponseEntity<>(topTenFoods, HttpStatus.OK);
    }
}
