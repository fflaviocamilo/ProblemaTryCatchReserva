package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date CheckOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		CheckOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return CheckOut;
	}
	
	public long duration() {
		long diff = CheckOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}

	public String updateDates(Date checkIn , Date checkOut) {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for updates must be future dates";
		}else if (!checkOut.after(checkIn)) {
			return "Error in reservation : check-out date must be after chech-in date";
		}else {
			Reservation resevation = new Reservation(roomNumber, checkIn, checkOut); 
		}
		
		this.checkIn = checkIn;
		this.CheckOut = checkOut;
		return null;
		
	}
	@Override
	public String toString() {
	return "Romm "
		+ roomNumber
		+ ", checkin : "
		+ sdf.format(checkIn)
		+ ", checkout : "
		+ sdf.format(CheckOut)
		+ ", "
		+ duration()
		+ " nights";
					
	}

}

