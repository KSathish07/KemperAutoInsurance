package com.coverage.selection.dto;

import java.math.BigDecimal;

import com.coverage.selection.model.CoverageCategory;

import lombok.Data;
@Data
public class CoverageTypeDTO {
	private Long id;

    private String coverageTypeName;
    //private BigDecimal minPrice;
    private BigDecimal price;
    private String agentId;
    private boolean isEnabled;
//	
}
