package com.example.hcl.transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hcl.transaction.enitiy.WalletFeeRecords;


public interface WalletFeeRecordsRepository extends JpaRepository<WalletFeeRecords, Integer> {

}
