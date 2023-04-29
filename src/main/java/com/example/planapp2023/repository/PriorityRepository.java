package com.example.planapp2023.repository;

import com.example.planapp2023.domain.entity.PriorityEntity;
import com.example.planapp2023.domain.entity.enums.PriorityNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity, Long> {


    Optional<PriorityEntity> findByName(PriorityNameEnum name);

}
