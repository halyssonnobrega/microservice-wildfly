package pt.link.sc.transaction.api.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.link.sc.transaction.api.business.entity.OfflineCardOperationEO;

public interface IOfflineCardOperationRepository extends JpaRepository<OfflineCardOperationEO, Long> {

}
