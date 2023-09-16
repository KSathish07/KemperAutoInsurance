package com.coverage.selection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coverage.selection.model.CoverageCategory;
import com.coverage.selection.model.CoverageType;

public interface CoverageTypeRepository extends JpaRepository<CoverageType,Integer> {
	List<CoverageType> findByAgentId(String id);

}
