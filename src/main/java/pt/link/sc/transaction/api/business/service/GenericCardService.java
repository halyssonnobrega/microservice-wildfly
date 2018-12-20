package pt.link.sc.transaction.api.business.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pt.link.sc.transaction.api.business.dto.CardOperationResultDto;
import pt.link.sc.transaction.api.business.entity.CardEO;
import pt.link.sc.transaction.api.business.entity.TransactionEO;
import pt.link.sc.transaction.api.business.exceptions.InvalidOperationException;
import pt.link.sc.transaction.api.common.util.CardId;


@Service
public class GenericCardService extends AbstractService {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public CardOperationResultDto registerCardTransactions(List<TransactionEO> cardTransactions) throws InvalidOperationException {
		cardTransactionService.registerCardTransactions(cardTransactions);
		return CardOperationResultDto.builder().withGeneratedWarnings(null).build();
	}
	
    public Optional<CardEO> getCardByCardSerialNumber(CardId cardId) {
        return Optional.ofNullable(cardRepository.findCardByCardSerialNumber(cardId.getCardSerialNumber(), cardId.getCardTechType()));
    }
}
