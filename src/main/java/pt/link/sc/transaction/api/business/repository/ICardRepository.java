package pt.link.sc.transaction.api.business.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pt.link.sc.transaction.api.business.entity.CardEO;

public interface ICardRepository extends JpaRepository<CardEO, Long> {

    @Query("SELECT c " +
            "FROM CardEO c " +
            "WHERE c.cardSerialNumber = ?1 " +
            " AND c.cardType = ?2")
    CardEO findCardByCardSerialNumber(BigInteger cardSerialNumber, Integer cardType);
}
