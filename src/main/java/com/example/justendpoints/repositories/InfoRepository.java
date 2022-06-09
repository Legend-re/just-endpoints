package com.example.justendpoints.repositories;

import com.example.justendpoints.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InfoRepository extends JpaRepository<PersonalInfo, Long> {


    @Override
    Optional<PersonalInfo> findById(Long id);
}
