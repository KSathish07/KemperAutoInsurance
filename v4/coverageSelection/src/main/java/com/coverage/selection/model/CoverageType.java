package com.coverage.selection.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoverageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coverageTypeName;
    //private BigDecimal minPrice;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CoverageCategory category;

	private String agentId;
	private boolean isEnabled;

}
