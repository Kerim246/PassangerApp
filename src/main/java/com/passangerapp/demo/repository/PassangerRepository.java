package com.passangerapp.demo.repository;

import com.passangerapp.demo.entity.Passanger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassangerRepository extends JpaRepository<Passanger, Integer> {

    boolean existsByPassportId(int passportId);

    Passanger findByPassportId(int passportId);

    @Query("select max(id) from Passanger")
    Integer findMaxId();
}
