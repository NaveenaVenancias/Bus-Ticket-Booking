package BusTicketBooking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
	public boolean loginValidation(String username,String password) {
		boolean value=false;
		if((username.equals("admin"))&&(password.equals("admin"))) {
			value=true;
			}
		return value;
	}
	
	public boolean busNoValidation(String busNo) {
		boolean value=false;
		Pattern p=Pattern.compile("[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{1,2}\\s[0-9]{4}");
		Matcher m=p.matcher(busNo);
		if(m.find()) {
			value=true;
		}
		return value;
	}

	public boolean sourceValidation(String source) {
		boolean value=false;
		Pattern p=Pattern.compile("[a-zA-Z]*");
		Matcher m=p.matcher(source);
		if(m.find()) {
			value=true;
		}
		return value;
	}

	public boolean destinationValidation(String destination) {
		boolean value=false;
		Pattern p=Pattern.compile("[a-zA-Z]*");
		Matcher m=p.matcher(destination);
		if(m.find()) {
			value=true;
		}
		return value;
	}

	public boolean dateValidation(String date) {
		boolean value=false;
		Pattern p=Pattern.compile("[0-3][0-9]\\-[1][0-2]\\-[2][0][2][2]");
		Matcher m=p.matcher(date);
		if(m.find()) {
			value=true;
		}
		return value;
	}

	public boolean timeValidation(String time) {
		boolean value=false;
		Pattern p=Pattern.compile("[0-2][0-9][:][0-5][0-9]");
		Matcher m=p.matcher(time);
		if(m.find()) {
			value=true;
		}
		return value;
	}

	public boolean nameValidation(String name) {
		boolean value=false;
		Pattern p=Pattern.compile("[a-zA-Z]*");
		Matcher m=p.matcher(name);
		if(m.find()) {
			value=true;
		}
		return value;
	}

	public boolean numberValidation(String number) {
		boolean value=false;
		Pattern p=Pattern.compile("[6-9][0-9]{9}");
		Matcher m=p.matcher(number);
		if(m.find()) {
			value=true;
		}
		return value;
	}

	public boolean userloginValidation(String username, String password) {
		boolean value=false;
		if((username.equals("user"))&&(password.equals("user"))) {
			value=true;
			}
		return value;
	}

	public boolean noOfSeatsValidation(String noOfSeats) {
		boolean value=false;
		Pattern p=Pattern.compile("[1-40]");
		Matcher m=p.matcher(noOfSeats);
		if(m.find()) {
			value=true;
		}
		return value;
	}
}
