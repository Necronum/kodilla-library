package com.kodillalibrary.library.repository;

import com.kodillalibrary.library.domain.copies.Copies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopiesRepository extends JpaRepository<Copies, Long> {
}
