package model.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer nummber;
	private Date checkIn;
	private Date checkOut;
	
	public static final DateFormat DATE = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer nummber, Date checkIn, Date checkOut) {
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

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void update(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room " + nummber + " , check-in: " + DATE.format(checkIn) + ", check-out: " + DATE.format(checkOut) + ", " + duration() + " nights";
	}
	
}
