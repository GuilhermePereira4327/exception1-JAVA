package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {
	
	public static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), DATE); 
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), DATE); 
			Reservation rev = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + rev);
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), DATE); 
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), DATE); 
			
			rev.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + rev);
			
		} /*catch(ParseException e) {
			System.out.println("Invalid in date formatter");
		}*/
		//mesmo com a RuntimeException, é algo obrigatorio para não deixar o programa quebrar, tratar o erro com o bloco catch
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();
	}

}
