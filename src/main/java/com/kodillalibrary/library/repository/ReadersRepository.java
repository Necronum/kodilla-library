package com.kodillalibrary.library.repository;

import com.kodillalibrary.library.domain.readers.Readers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadersRepository extends JpaRepository<Readers, Long> {
}
