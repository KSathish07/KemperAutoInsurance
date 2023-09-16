package com.coverage.selection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coverage.selection.model.CoverageCategory;
import com.coverage.selection.model.CoverageType;
import com.coverage.selection.repo.CoverageCategoryRepository;
import com.coverage.selection.repo.CoverageTypeRepository;

@Service
public class CoverageServiceImpl implements CoverageService  {
	
	@Autowired
	public CoverageCategoryRepository  ccrpo;
	
	@Autowired
	public CoverageTypeRepository ctrpo;

	@Override
	public CoverageCategory addCategory(CoverageCategory cc) {
		// TODO Auto-generated method stub
		return this.ccrpo.save(cc);
	}

	@Override
	public CoverageCategory getCategoryById(int id) {
		// TODO Auto-generated method stub
		return this.ccrpo.findById(id).orElse(null);
	}

	@Override
	public List<CoverageCategory> getAllCategories() {
		// TODO Auto-generated method stub
		return this.ccrpo.findAll();
	}

	@Override
	public CoverageType addCategoryType(CoverageType ct) {
		// TODO Auto-generated method stub
		return this.ctrpo.save(ct);
	}

	@Override
	public List<CoverageCategory> getByVehicleId(String id) {
		// TODO Auto-generated method stub
		return this.ccrpo.findByVehicleId(id);
	}

	@Override
	public List<CoverageType> getByAgentId(String id) {
		// TODO Auto-generated method stub
//		List<CoverageType> ctype= this.ctrpo.findByAgentId(id);
//		int count=0;
//		for(CoverageType c:ctype){
//			if(c.isEnabled()) {
//				count++;
//			}
//		}
//		System.out.println("count="+count);
//		return ctype;
		
		return this.ctrpo.findByAgentId(id);
	}
	
	

	

	

}
