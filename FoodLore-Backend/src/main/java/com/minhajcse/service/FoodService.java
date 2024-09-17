package com.minhajcse.service;

import com.minhajcse.model.Food;
import com.minhajcse.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getTopTenFoods() {
        List<Food> topTenFoods = new ArrayList<>();
        List<Food> allFoods = foodRepository.findAll();

        allFoods.sort(
                new Comparator<Food>() {
                    @Override
                    public int compare(Food a, Food b) {
                        // swap happens if positive, (x-y)
                        return Integer.compare(b.getLikes(), a.getLikes());
                    }
                }
        );
        for(int i=0;i<10;i++){
            topTenFoods.add(allFoods.get(i));
        }
        return topTenFoods;
    }
}
