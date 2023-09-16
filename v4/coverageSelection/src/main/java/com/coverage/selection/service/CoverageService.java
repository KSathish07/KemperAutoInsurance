package com.coverage.selection.service;

import java.util.List;

import com.coverage.selection.model.CoverageCategory;
import com.coverage.selection.model.CoverageType;


public interface CoverageService {
	public CoverageCategory addCategory(CoverageCategory cc);
	public CoverageCategory getCategoryById(int id);	
	List<CoverageCategory> getAllCategories();
	public CoverageType addCategoryType(CoverageType ct);
	public List<CoverageCategory> getByVehicleId(String id);
	public List<CoverageType> getByAgentId(String id);

}
