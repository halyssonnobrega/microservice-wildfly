package pt.link.sc.transaction.api.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pt.link.sc.transaction.api.business.entity.AuthorizationEO;

public interface IAuthorizationRepository extends JpaRepository<AuthorizationEO, Long> {
	
	@Query("select a from AuthorizationEO a where a.uuid = ?1")
	AuthorizationEO findAuthorizationByUUID(String uuid);
}
