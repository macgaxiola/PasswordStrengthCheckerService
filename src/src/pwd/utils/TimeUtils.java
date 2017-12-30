package src.pwd.utils;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import src.pwd.analyze.dictionary.DictionaryAttack;

/**
 * Manage time utils
 * 
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public class TimeUtils {

	private static int GREATER = -1;
	private static int CONSTANT = 60;

	private static int CONSTANT_HOURS = 24;
	private static int CONSTANT_DAY_IN_MONTH = 31;
	private static int CONSTANT_DAY_IN_YEAR = 365;
	private static String SPACE = " ";
	private static int THOUSAND = 1000;
	private static int ZERO = 0;

		
	public static String formatTime(BigDecimal milliseconds){
		StringBuilder builder = new StringBuilder();
		BigDecimal thousand = new BigDecimal(THOUSAND);
		// if we have zero
		int comp = milliseconds.compareTo(BigDecimal.ZERO);
		if( comp == 0){
			builder.append(StringHelper.getString("DateUtils.msg.instant"));
		}else{
			// less than one second
			int comp1 = milliseconds.compareTo(thousand);
			if(comp1 == GREATER){
				builder.append(StringHelper.getString("DateUtils.msg.instant"));
			}else{
				// Get Long value to use with TimeUnits that should be easier
				Long seconds =  milliseconds.longValue()/THOUSAND;
				long minutes = TimeUnit.SECONDS.toMinutes(seconds);
				long hours = TimeUnit.SECONDS.toHours(seconds); 
				long day = TimeUnit.SECONDS.toDays(seconds);
				long months = day/CONSTANT_DAY_IN_MONTH;
				long years = day/CONSTANT_DAY_IN_YEAR;
				
				if(seconds.longValue() != 0){
					if(seconds < CONSTANT){
						builder.append(seconds +SPACE+ StringHelper.getString("DateUtils.msg.seconds"));
					}else if(seconds > CONSTANT && minutes <= CONSTANT){
						builder.append(minutes +SPACE+ StringHelper.getString("DateUtils.msg.minutes"));
					}else if(minutes > CONSTANT && hours <= CONSTANT_HOURS){
						builder.append(hours +SPACE+ StringHelper.getString("DateUtils.msg.hours"));
					}else if(day > ZERO && day <= CONSTANT_DAY_IN_MONTH){
						builder.append(day +SPACE+ StringHelper.getString("DateUtils.msg.days"));
					}else if(day > CONSTANT_DAY_IN_MONTH && day <= CONSTANT_DAY_IN_YEAR){
						builder.append(months +SPACE+ StringHelper.getString("DateUtils.msg.months"));
					}else if(day > CONSTANT_DAY_IN_YEAR){
						builder.append(years +SPACE+ StringHelper.getString("DateUtils.msg.years"));
					}
				}else{
					builder.append(StringHelper.getString("DateUtils.msg.instant"));
				}
			}
		}
		return builder.toString();
	}
	
	public static BigDecimal getMillisecondsFromTimer(Stopwatch timer){
		long duration = timer.elapsed(TimeUnit.MILLISECONDS);
		BigDecimal total = new BigDecimal(duration);
		return total;
	}
}
