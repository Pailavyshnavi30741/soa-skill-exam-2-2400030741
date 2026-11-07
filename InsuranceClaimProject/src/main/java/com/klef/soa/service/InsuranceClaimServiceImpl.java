package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.InsuranceClaim;
import com.klef.soa.repository.InsuranceClaimRepository;

@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService {

    @Autowired
    private InsuranceClaimRepository repository;

    @Override
    public InsuranceClaim addClaim(InsuranceClaim ic)
    {
        ic.setInsuranceClaimId(null);
        return repository.save(ic);
    }

    @Override
    public String updateClaim(InsuranceClaim ic) {
        Optional<InsuranceClaim> obj =
                repository.findById(ic.getInsuranceClaimId());

        if (obj.isPresent()) {
            repository.save(ic);
            return "Insurance Claim Updated Successfully";
        } else {
            return "Insurance Claim ID Not Found";
        }
    }

    @Override
    public String deleteClaim(Long id) {
        Optional<InsuranceClaim> obj = repository.findById(id);

        if (obj.isPresent()) {
            repository.deleteById(id);
            return "Insurance Claim Deleted Successfully";
        } else {
            return "Insurance Claim ID Not Found";
        }
    }

    @Override
    public List<InsuranceClaim> displayAll() {
        return repository.findAll();
    }

    @Override
    public Optional<InsuranceClaim> displayById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<InsuranceClaim> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<InsuranceClaim> findByType(String type) {
        return repository.findByType(type);
    }
}