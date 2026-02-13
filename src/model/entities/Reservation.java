package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer nummber;
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	
	public static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer nummber, LocalDateTime checkIn, LocalDateTime checkOut) {
		this.nummber = nummber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNummber() {
		return nummber;
	}

	public void setNummber(Integer nummber) {
		this.nummber = nummber;
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getSecond() - checkIn.getSecond();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void update(LocalDateTime checkIn, LocalDateTime checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + nummber + " , check-in: " + DATE.format(checkIn) + ", check-out: " + DATE.format(checkOut) + ", " + duration() + " nights";
	}
	
}
