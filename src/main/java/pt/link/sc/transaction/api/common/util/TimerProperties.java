package pt.link.sc.transaction.api.common.util;

import java.util.Properties;

import javax.ejb.ScheduleExpression;


public class TimerProperties {
	private static final String PROPS_FILE_NAME = "timer.properties";
	private static final String SUFFIX_PROP_TIMER_SEC = ".schedule.timer.second";
	private static final String SUFFIX_TIMER_MIN = ".schedule.timer.minute";
	private static final String SUFFIX_TIMER_HOUR = ".schedule.timer.hour";
	private static final String SUFFIX_TIMER_DAYS_OF_WEEK = ".schedule.timer.dayOfWeek";
	
	public enum TimerPropertiesEnum {
		
		CVC_NOTIFICATION_TIMER_SECOND("cvcnotificationprocess.schedule.timer.second"),
		CVC_NOTIFICATION_TIMER_MINUTE("cvcnotificationprocess.schedule.timer.minute"),
		CVC_NOTIFICATION_TIMER_HOUR("cvcnotificationprocess.schedule.timer.hour"),
		
		CVC_ANOTIFICATION_ACKNOWLEDGEMENT_TIMER_SECOND("cvcanotificationacknowledgementprocess.schedule.timer.second"),
		CVC_ANOTIFICATION_ACKNOWLEDGEMENT_TIMER_MINUTE("cvcanotificationacknowledgementprocess.schedule.timer.minute"),
		CVC_ANOTIFICATION_ACKNOWLEDGEMENT_TIMER_HOUR("cvcanotificationacknowledgementprocess.schedule.timer.hour"),
		
		VAL_NOTIFICATION_TIMER_SECOND("valnotificationprocess.schedule.timer.second"),
		VAL_NOTIFICATION_TIMER_MINUTE("valnotificationprocess.schedule.timer.minute"),
		VAL_NOTIFICATION_TIMER_HOUR("valnotificationprocess.schedule.timer.hour"),
		
		VALA_NOTIFICATION_ACKNOWLEDGEMENT_TIMER_SECOND("valanotificationacknowledgementprocess.schedule.timer.second"),
		VALA_NOTIFICATION_ACKNOWLEDGEMENT_TIMER_MINUTE("valanotificationacknowledgementprocess.schedule.timer.minute"),
		VALA_NOTIFICATION_ACKNOWLEDGEMENT_TIMER_HOUR("valanotificationacknowledgementprocess.schedule.timer.hour");
		
		String name;

		TimerPropertiesEnum(String name) {
			this.name = name;
		}
	}
	
	public static String getPropertyStatically(TimerPropertiesEnum parameterKey) {

		Properties prop = new Properties();
		String value = "";

		PropertyUtils.loadProperties(prop,PROPS_FILE_NAME);
		value = prop.getProperty(parameterKey.name);
		
		return value;

	}
	
	public static String getPropertyStatically(String parameterKey) {

		Properties prop = new Properties();
		String value = "";

		PropertyUtils.loadProperties(prop,PROPS_FILE_NAME);
		value = prop.getProperty(parameterKey);
		
		return value;

	}
	
	public static ScheduleExpression getScheduleExpression(String timerPropBase) {
		final ScheduleExpression schedule = new ScheduleExpression();
		
		final String sec = getPropertyStatically(timerPropBase + SUFFIX_PROP_TIMER_SEC);
		if (sec != null) schedule.second(sec);
		
		final String min = getPropertyStatically(timerPropBase + SUFFIX_TIMER_MIN);
		if (min != null) schedule.minute(min);
		
		final String hour = getPropertyStatically(timerPropBase + SUFFIX_TIMER_HOUR);
		if (hour != null) schedule.hour(hour);
		
		final String dayOfWeek = getPropertyStatically(timerPropBase + SUFFIX_TIMER_DAYS_OF_WEEK);
		if (dayOfWeek != null) schedule.dayOfWeek(dayOfWeek);
		
		return schedule;
	}
}
