package com.coverage.selection.dto;

import java.util.List;

import lombok.Data;

@Data
public class CoverageCategoryWithTypesDTO {
	private Long id;
	private String coverageName;
	private String vehicleId;
    
	private String coverageTypeName;
    private List<CoverageTypeDTO> coverageTypes;
    
	
}
