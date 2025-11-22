package com.example.hcl.transaction.service;

import com.example.hcl.transaction.enitiy.Settlement;
import com.example.hcl.transaction.enitiy.Merchant;
import com.example.hcl.transaction.enitiy.Wallet;
import com.example.hcl.transaction.enitiy.WalletFeeRecords;
import com.example.hcl.transaction.Repository.SettlementRepository;
import com.example.hcl.transaction.Repository.WalletFeeRecordsRepository;
import com.example.hcl.transaction.Repository.MerchantRepository;
import com.example.hcl.transaction.Repository.WalletRepository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SettlementCronService {

    private final SettlementRepository settlementRepo;
    private final MerchantRepository merchantRepo;
    private final WalletRepository walletRepo;
    private final WalletFeeRecordsRepository walletFeeRecordsRepository;

    public SettlementCronService(SettlementRepository settlementRepo, MerchantRepository merchantRepo, WalletRepository walletRepo, 
    		WalletFeeRecordsRepository walletFeeRecordsRepository) {
        this.settlementRepo = settlementRepo;
        this.merchantRepo = merchantRepo;
        this.walletRepo = walletRepo;
        this.walletFeeRecordsRepository = walletFeeRecordsRepository;
    }

    // Runs every 1 minute
    @Scheduled(cron = "0 */1 * * * *")
    public void processPendingSettlements() {

        List<Settlement> settlements = settlementRepo.findPendingSettlements();

        for (Settlement s : settlements) {

            Merchant merchant = merchantRepo.findById(s.getMerchantId()).orElse(null);
            if (merchant == null) continue;

            Wallet wallet = walletRepo.findById(merchant.getWalletId()).orElse(null);
            if (wallet == null) continue;

            long fee = wallet.getCurrencyType().equalsIgnoreCase("INR") ? 20 : 2;

            long creditAmount = s.getAmount()>fee ? s.getAmount() - fee
            										: s.getAmount();

            wallet.setBalance(wallet.getBalance() + creditAmount);
            walletRepo.save(wallet);
            WalletFeeRecords walletFeeRecords = new WalletFeeRecords(fee, s.getMerchantId(), LocalDateTime.now());
            walletFeeRecordsRepository.save(walletFeeRecords);
            	
            s.setStatus("PROCESSED");
            settlementRepo.save(s);
        }
    }
}
