package com.example.hcl.transaction.Repository;

import com.example.hcl.transaction.enitiy.Merchant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Optional<Merchant> findById(Integer id);
}
