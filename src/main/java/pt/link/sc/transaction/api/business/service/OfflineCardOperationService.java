package pt.link.sc.transaction.api.business.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pt.link.sc.transaction.api.business.entity.ChannelPointEO;
import pt.link.sc.transaction.api.business.entity.OfflineCardOperationEO;
import pt.link.sc.transaction.api.common.enums.OfflineOperationStatus;
import pt.link.sc.transaction.api.resources.model.ReloadTransaction;

@Service
public class OfflineCardOperationService extends AbstractService {

    private Logger logger = LoggerFactory.getLogger(OfflineCardOperationService.class);
    
    public OfflineCardOperationEO registerOfflineCardTransactions(ReloadTransaction[] cardTransactions, String correlationId, ChannelPointEO channelPoint) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String writeValueAsString = mapper.writeValueAsString(cardTransactions);
    		OfflineCardOperationEO offlineCardOperations = new OfflineCardOperationEO();
            offlineCardOperations.setJsonContent(writeValueAsString);
            offlineCardOperations.setJsonContentClassTypeName(cardTransactions.getClass().getName());
            offlineCardOperations.setOfflineOperationStatus(OfflineOperationStatus.NOT_PROCESSED);
            offlineCardOperations.setUuid(UUID.randomUUID().toString());
            offlineCardOperations.setCorrelationId(correlationId);
            offlineCardOperations.setChannelPoint(channelPoint);
            return offlineCardOperationRepository.save(offlineCardOperations);
        } catch (JsonProcessingException e) {
        	logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
