package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	public static final DateFormat DATE = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		//String stringCheckin = sc.nextLine();
		//LocalDateTime checkIn = (LocalDateTime) DATE.parse(stringCheckin);
		//Date checkIn = new Date(DATE.format(sc.nextLine()));
		Date checkIn = DATE.parse(sc.nextLine()); 
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = DATE.parse(sc.nextLine());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation rev = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + rev);
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = DATE.parse(sc.nextLine()); 
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = DATE.parse(sc.nextLine());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				rev.update(checkIn, checkOut);
				System.out.println("Reservation: " + rev);
			}
		}
		
		
		
		sc.close();
	}

}
