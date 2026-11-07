package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import com.klef.soa.entity.InsuranceClaim;

public interface InsuranceClaimService {

	InsuranceClaim addClaim(InsuranceClaim ic);

	String updateClaim(InsuranceClaim ic);

	String deleteClaim(Long id);

	List<InsuranceClaim> displayAll();

	Optional<InsuranceClaim> displayById(Long id);

	List<InsuranceClaim> findByName(String name);

	List<InsuranceClaim> findByType(String type);

}
