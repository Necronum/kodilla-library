package com.kodillalibrary.library.repository;

import com.kodillalibrary.library.domain.rents.Rents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentsRepository extends JpaRepository<Rents, Long> {
}
