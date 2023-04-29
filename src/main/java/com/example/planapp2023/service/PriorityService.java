package com.example.planapp2023.service;

import com.example.planapp2023.domain.entity.PriorityEntity;
import com.example.planapp2023.domain.entity.enums.PriorityNameEnum;

public interface PriorityService {
    void initCategories();

    PriorityEntity findByPriorityNameEnum(PriorityNameEnum priorityNameEnum);
}
