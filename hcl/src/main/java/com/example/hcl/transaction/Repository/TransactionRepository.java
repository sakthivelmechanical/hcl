package com.example.hcl.transaction.Repository;


 import com.example.hcl.transaction.enitiy.TransactionTable;
 import jakarta.persistence.LockModeType;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Lock;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;

 import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionTable, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
   // @Query("select t from transaction_record t where t.id = :id")
    Optional<TransactionTable> findByIdForUpdate(Integer id);
}
