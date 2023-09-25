package controller.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateService {
	
	public static LocalDate toLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Date toDate(LocalDate date) {
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static boolean dateIsPassed(LocalDate date) {
		return date.isBefore(LocalDate.now());
	}
}
