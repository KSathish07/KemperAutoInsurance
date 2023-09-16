package com.coverage.selection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coverage.selection.model.CoverageCategory;

@Repository
public interface CoverageCategoryRepository extends JpaRepository<CoverageCategory,Integer> {
	List<CoverageCategory> findByVehicleId(String id);

}
