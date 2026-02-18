package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exception.DomainException;

public class Reservation {
	private Integer nummber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer nummber, LocalDate checkIn, LocalDate checkOut) /*throws DomainException*/ {
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
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

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		return ChronoUnit.DAYS.between(checkIn, checkOut);
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) /*throws DomainException*/ {
		LocalDate now = LocalDate.now();
		if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		} 
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + nummber + " , check-in: " + DATE.format(checkIn) + ", check-out: " + DATE.format(checkOut) + ", " + duration() + " nights";
	}
	
}
