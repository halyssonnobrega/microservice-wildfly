package pt.link.sc.transaction.api.business.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Stopwatch;

import pt.link.sc.transaction.api.business.entity.OfflineCardOperationEO;
import pt.link.sc.transaction.api.business.entity.TransactionEO;

@Service
public class CardTransactionService extends AbstractService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public void registerCardTransactions(List<TransactionEO> cardTransactions) {
        for (TransactionEO cardTransaction : cardTransactions) {
            registerCardTransaction(cardTransaction);
        }
    }

    @Transactional
    public TransactionEO registerCardTransaction(TransactionEO cardTransaction) {
        return registerCardTransaction(cardTransaction, null);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public TransactionEO registerCardTransaction(TransactionEO cardTransaction, OfflineCardOperationEO offlineCardOperation) {
        Stopwatch timer = Stopwatch.createStarted();
        try {
            return transactionRepository.save(cardTransaction);
        } finally {
            log.debug(String.format("### PERFORMANCE -'registerCardTransaction' took [%s]", timer.stop()));
        }
    }
}