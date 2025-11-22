package com.example.hcl.transaction.Repository;


 import com.example.hcl.transaction.enitiy.Settlement;
 import jakarta.persistence.LockModeType;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Lock;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from Settlement s where s.id = :id")
    Optional<Settlement> findByIdForUpdate(Long id);
    
    @Query("SELECT s FROM Settlement s WHERE s.status IN ('HOLD')")
    List<Settlement> findPendingSettlements();

}

