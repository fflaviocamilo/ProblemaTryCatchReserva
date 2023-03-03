package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Entre com a data checkIn: ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Entre com a data checkOut: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation : Check-out date must be after check-in date");

		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println( 
					"Reservation : " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation ");
			System.out.print("Entre com a data checkIn: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data checkOut: ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null ) {
				System.out.println("Erros in reservaion : " + error);
								
			}else {
				System.out.println("Reservation: " + reservation);
			}
				
		}

	}

}
 