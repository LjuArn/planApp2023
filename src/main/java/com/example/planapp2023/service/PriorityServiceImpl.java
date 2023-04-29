package com.example.planapp2023.service;

import com.example.planapp2023.domain.entity.PriorityEntity;
import com.example.planapp2023.domain.entity.enums.PriorityNameEnum;
import com.example.planapp2023.repository.PriorityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;
    private final ModelMapper modelMapper;

    public PriorityServiceImpl(PriorityRepository priorityRepository,
                               ModelMapper modelMapper) {
        this.priorityRepository = priorityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {

        if (priorityRepository.count() != 0) {
            return;
        }


        Arrays.stream(PriorityNameEnum.values())
                .forEach(priorityNameEnum -> {
                    PriorityEntity priorityEntity = new PriorityEntity();
                    priorityEntity.setName(priorityNameEnum);
                    switch (priorityNameEnum) {
                        case URGENT -> priorityEntity.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                        case IMPORTANT -> priorityEntity.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                        case LOW -> priorityEntity.setDescription("Should be fixed if time permits but can be postponed.");
                    }
                    priorityRepository.save(priorityEntity);
                });


    }

    @Override
    public PriorityEntity findByPriorityNameEnum(PriorityNameEnum priorityNameEnum) {
        return priorityRepository.findByName(priorityNameEnum).orElse(null);
    }
}
