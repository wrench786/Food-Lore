package com.minhajcse.controller;

import com.minhajcse.model.Food;
import com.minhajcse.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/yo")
    public String yo(){
        return "yo";
    }
}
