package pt.link.sc.transaction.api.business.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import pt.link.sc.transaction.api.business.entity.CardEO;

@Service
public class CardExpirationService {

    private static final Integer CARD_VALIDITY_YEARS = 5;
    private static final Integer CARD_VALIDITY_MONTHS = 0;
    private static final Integer CARD_VALIDITY_DAYS = 1;
    private static final Integer CARD_REFUND_VALIDITY_YEARS = 5;
    private static final Integer CARD_REFUND_VALIDITY_MONTHS = 0;
    private static final Integer CARD_REFUND_VALIDITY_DAYS = -1;
    
    public Date getExpirationDateForStartDate(Date date) {
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate().plus(Period.ofYears(CARD_VALIDITY_YEARS)).plus(Period.ofMonths(CARD_VALIDITY_MONTHS)).plus(Period.ofDays(CARD_VALIDITY_DAYS));
        LocalTime localTime = LocalTime.MAX;

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public boolean isCardExpired(CardEO physicalCard) {
        Assert.notNull(physicalCard, "card cannot be null");
        return physicalCard.getExpirationDate() != null && physicalCard.getExpirationDate().before(new Date());
    }


    public Date getLimitDateForRefundOperationBasedOnActivationDate(Date activationDate) {
        LocalDate localDate = LocalDateTime.ofInstant(activationDate.toInstant(), ZoneId.systemDefault()).toLocalDate().plus(Period.ofYears(CARD_REFUND_VALIDITY_YEARS)).plus(Period.ofMonths(CARD_REFUND_VALIDITY_MONTHS)).plus(Period.ofDays(CARD_REFUND_VALIDITY_DAYS));
        LocalTime localTime = LocalTime.MAX;

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

}
