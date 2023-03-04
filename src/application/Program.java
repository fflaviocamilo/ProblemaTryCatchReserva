package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import exeption.DomainExeption;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Entre com a data checkIn: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data checkOut: ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation : " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation ");
			System.out.print("Entre com a data checkIn: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Entre com a data checkOut: ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			System.out.println("reservation : " + reservation);
		}catch (ParseException e) {
			System.out.println("invalida date");
		}catch(DomainExeption e) {
			System.out.println("Erro in reservation : " + e.getMessage());
		}
		
		sc.close();

	}

}
