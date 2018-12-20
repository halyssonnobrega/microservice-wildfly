package pt.link.sc.transaction.api.business.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pt.link.sc.transaction.api.business.entity.ChannelPointEO;

@Service
public class ChannelPointService extends AbstractService{

    private Logger logger = LoggerFactory.getLogger(ChannelPointService.class);

    public Optional<ChannelPointEO> mapToChannelPoint(String channelPointExternalId, String channelPointDescription) {
        return findOrCreate(channelPointExternalId, channelPointDescription);
    }
    
    public Optional<ChannelPointEO> find(String externalId) {
        if (StringUtils.isBlank(externalId)) {
            return Optional.empty();
        }
        return channelPointRepository.findChannelPointByExternalId(externalId).stream().findFirst();
    }

    public Optional<ChannelPointEO> findOrCreate(String externalId, String description) {
        if (StringUtils.isBlank(externalId)) {
            return Optional.empty();
        }
        ChannelPointEO entity = channelPointRepository.findChannelPointByExternalId(externalId).stream().findFirst().orElse(null);
        if (entity != null) {
            if (StringUtils.isNotBlank(entity.getDescription()) && !entity.getDescription().equals(description)) {
            	logger.warn(String.format("Expected channel point description=[%s] for externalId[%s] but found description=[%s].", entity.getDescription(), externalId, description));
            }
            return Optional.of(entity);
        }

        entity = new ChannelPointEO();
        entity.setExternalId(externalId);
        entity.setDescription(description);
        return Optional.of(channelPointRepository.save(entity));
    }

    @Transactional
    public List<ChannelPointEO> findAllForDistribution() {
        return channelPointRepository.findAll();
    }

    @Transactional
    public ChannelPointEO createOrUpdate(ChannelPointEO detail) {
        return channelPointRepository.save(detail);

    }
}
