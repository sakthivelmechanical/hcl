package com.example.hcl.transaction.Repository;

import com.example.hcl.transaction.enitiy.Wallet;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
//@Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "SELECT * FROM wallet WHERE id = :id FOR UPDATE", nativeQuery = true)
    Optional<Wallet> findByIdForUpdateNative(@Param("id") Integer id);
}