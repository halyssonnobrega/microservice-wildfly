package pt.link.sc.transaction.api.business.schedules;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.link.sc.transaction.api.common.util.TimerProperties;

@Singleton
@Startup
public class VALANotificationAcknowledgementProcess implements Serializable {

	private static final long serialVersionUID = 1223678612340966554L;

	private static final Logger logger = LoggerFactory.getLogger(VALANotificationAcknowledgementProcess.class);

	private static final String PREFIX_PROP_TIMER = "VALANotificationAcknowledgementProcess";

	@Resource
	private TimerService timerService;

	@PostConstruct
	public void createTimer() {
		logger.info("starting timer");

		ScheduleExpression scheduleExpression = TimerProperties.getScheduleExpression(PREFIX_PROP_TIMER);

		logger.info("ScheduleExpression: " + scheduleExpression.toString());

		if (timerService.getTimers().isEmpty()) {
			timerService.createCalendarTimer(scheduleExpression, new TimerConfig("VALANotificationAcknowledgementProcess", false));
			logger.info("Started timer");
		} else {
			logger.info("timer not started");
		}

	}

	@Timeout
	public void runProcess() {
		logger.info("starting cancel expired hold voucher processing scheduler");
		try {
			logger.info("=================> Run process...CancelExpiredHoldVoucher at " + new Date());


		} catch (Exception e) {
			logger.error("error when canceling hold of expired voucher consumptions : " + e.getMessage());
		}
	}
}
