package pt.link.sc.transaction.api.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.link.sc.transaction.api.business.repository.IAuthorizationRepository;
import pt.link.sc.transaction.api.business.repository.ICardRepository;
import pt.link.sc.transaction.api.business.repository.IChannelPointRepository;
import pt.link.sc.transaction.api.business.repository.IOfflineCardOperationRepository;
import pt.link.sc.transaction.api.business.repository.ITransactionRepository;
import pt.link.sc.transaction.api.common.util.CardMapper;

@Service
public class AbstractService {
	
	@Autowired
	protected CardTransactionService cardTransactionService;
	
	@Autowired
	protected ICardRepository cardRepository;
	
    @Autowired
    protected IChannelPointRepository channelPointRepository;
    
    @Autowired
    protected ChannelPointService channelPointService;
    
    @Autowired
    protected IAuthorizationRepository authorizationRepository;
    
    @Autowired
    protected CardMapper cardMapper;

    @Autowired
    protected CardExpirationService cardExpirationService;
    
    @Autowired
    protected GenericCardService genericCardService;
    
    @Autowired
    protected ITransactionRepository transactionRepository;
    
    @Autowired
    protected IOfflineCardOperationRepository offlineCardOperationRepository;
}
