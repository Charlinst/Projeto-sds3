package com.devSuperior.Dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devSuperior.Dsvendas.dto.SaleSuccessDTO;
import com.devSuperior.Dsvendas.dto.SaleSumDTO;
import com.devSuperior.Dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devSuperior.Dsvendas.dto.SaleSumDTO(obj.seller,SUM(obj.amount))" 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedByseller();
	
	@Query("SELECT new successGroupedBySeller(obj.seller, SUM(obj.visited, SUM(obj.deals))" 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> SuccessGroupedByseller();
}
