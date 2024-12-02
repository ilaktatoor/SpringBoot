package com.devserc.FullstackCrud.respository;

import com.devserc.FullstackCrud.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployesRepository extends JpaRepository<Employe, Long> {
}
