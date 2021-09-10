package com.devSuperior.Dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devSuperior.Dsvendas.dto.SaleDTO;
import com.devSuperior.Dsvendas.dto.SaleSuccessDTO;
import com.devSuperior.Dsvendas.dto.SaleSumDTO;
import com.devSuperior.Dsvendas.entities.Sale;
import com.devSuperior.Dsvendas.repositories.SaleRepository;
import com.devSuperior.Dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedByseller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.SuccessGroupedByseller();
	}
	
	
}
