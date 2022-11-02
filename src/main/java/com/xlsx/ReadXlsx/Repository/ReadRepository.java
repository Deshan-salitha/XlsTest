package com.xlsx.ReadXlsx.Repository;

import com.xlsx.ReadXlsx.model.Custormer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReadRepository extends JpaRepository<Custormer,Integer> {
}
