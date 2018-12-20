package pt.link.sc.transaction.api.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pt.link.sc.transaction.api.business.entity.ChannelPointEO;

public interface IChannelPointRepository extends JpaRepository<ChannelPointEO, Long> {

	@Query("select cp FROM ChannelPointEO cp where cp.externalId = ?1")
	List<ChannelPointEO> findChannelPointByExternalId(String externalId);

}
