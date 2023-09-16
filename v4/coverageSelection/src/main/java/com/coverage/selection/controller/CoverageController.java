package com.coverage.selection.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coverage.selection.dto.CoverageCategoryWithTypesDTO;
import com.coverage.selection.dto.CoverageTypeDTO;
import com.coverage.selection.model.CoverageCategory;
import com.coverage.selection.model.CoverageType;
import com.coverage.selection.service.CoverageService;
//stores data in two tables
@RestController
@RequestMapping("/api")
public class CoverageController {
	@Autowired
	public CoverageService coverageservice;
	
	
//	@PostMapping("/coverage")
//	public CoverageCategory addCoverage(@RequestBody CoverageCategory cc) {
//		return this.coverageservice.addCategory(cc);
//	}
	
	@GetMapping("/coverage/{id}")	
	public CoverageCategory getCoverage(@PathVariable("id") int id) {
		return this.coverageservice.getCategoryById(id);
	}
	
	//get coverages only
	//http://localhost:8080/api/coverages
	@GetMapping("/coverages")	
	public List<CoverageCategory> allCoverages() {
		return this.coverageservice.getAllCategories();
	}
	
	//post categories with types
	@PostMapping("/categories-with-types")
	public ResponseEntity<String> createCoverageCategoryWithTypes(@RequestBody CoverageCategoryWithTypesDTO categoryWithTypesDTO){

		
		CoverageCategory category = new CoverageCategory();
		//change to getCoverageName
		category.setCoverageName(categoryWithTypesDTO.getCoverageName());
		category.setVehicleId(categoryWithTypesDTO.getVehicleId());
		this.coverageservice.addCategory(category);
		 for (CoverageTypeDTO coverageTypeDTO : categoryWithTypesDTO.getCoverageTypes()){
			 CoverageType coverageType = new CoverageType();
			 coverageType.setCoverageTypeName(coverageTypeDTO.getCoverageTypeName());
			 //coverageType.setMinPrice(coverageTypeDTO.getMinPrice());
			 coverageType.setPrice(coverageTypeDTO.getPrice());
			 coverageType.setAgentId(coverageTypeDTO.getAgentId());
			 coverageType.setEnabled(coverageTypeDTO.isEnabled());			 	
			 coverageType.setCategory(category);
			
			 this.coverageservice.addCategoryType(coverageType);
		 }
		return ResponseEntity.ok("Coverage category with types created successfully");
	}
	
	//by vehicle id
	@GetMapping("/categories/{vehicleid}")
	public List<CoverageCategory> getByVehicleId(@PathVariable("vehicleid") String id)
	{
		return this.coverageservice.getByVehicleId(id);
	}
	//by agent id
	@GetMapping("/categories-types/{agentid}")
	public List<CoverageType> getByAgentId(@PathVariable("agentid") String id)
	{
		return this.coverageservice.getByAgentId(id);
	}
	
	@PostMapping("/categories-with-types/multiple")
	public ResponseEntity<String> createCoverageCategoryWithTypesAll(@RequestBody List<CoverageCategoryWithTypesDTO> categoryWithTypesDTOs){

		
		
		//change to getCoverageName
		
		for(CoverageCategoryWithTypesDTO ccw:categoryWithTypesDTOs) {
			CoverageCategory category = new CoverageCategory();
			category.setCoverageName(ccw.getCoverageName());
			category.setVehicleId(ccw.getVehicleId());
			this.coverageservice.addCategory(category);
			for (CoverageTypeDTO coverageTypeDTO : ccw.getCoverageTypes()){
				 CoverageType coverageType = new CoverageType();
				 coverageType.setCoverageTypeName(coverageTypeDTO.getCoverageTypeName());
				 //coverageType.setMinPrice(coverageTypeDTO.getMinPrice());
				 coverageType.setPrice(coverageTypeDTO.getPrice());
				 coverageType.setAgentId(coverageTypeDTO.getAgentId());
				 coverageType.setEnabled(coverageTypeDTO.isEnabled());			 	
				 coverageType.setCategory(category);
				
				 this.coverageservice.addCategoryType(coverageType);
			 }
		}
		
		
		 
		return ResponseEntity.ok("Coverage category with all types created successfully");
	}
	
		
	

}
