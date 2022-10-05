package BusTicketBooking;

import java.util.ArrayList;
import java.util.List;

public class User{
	static ArrayList<InputDetaills> userList=new ArrayList<InputDetaills>();
	
	public ArrayList<InputDetaills> getAdmin() {
		ArrayList<InputDetaills> details = Admin.adminList;
		return details;
	}
	
	public  void userLogin() {
		GetInput getInput=new GetInput();
		InputValidation inputValidation=new InputValidation();
		StartPage startPage=new StartPage();
		String login[]=getInput.userLogin();
		boolean value=inputValidation.userloginValidation(login[0], login[1]);
		
		if(value==true) {
			System.out.println("Welcome User!!");
			userDisplayChoice();
		}
		else if(value==false) {
			System.out.println("UserName and Password Mismatch. Kindly Try again!!");
			startPage.startChoice();
		}
	}
	private  void userDisplayChoice() {
		GetInput getInput=new GetInput();
		StartPage startPage=new StartPage();
		int choice=getInput.userDisplay();
		switch(choice) {
		case 1:
			bookTicket();
			break;
		case 2:
			cancelTicket();
			break;
		case 3:
			viewMyTicket();
			break;
		case 4:
			System.out.println("Thank You!!");
			startPage.startChoice();
			break;
		default:
			System.out.println("Please Enter Correct Choice!!");
			userDisplayChoice();
		}
	}
	
	private void bookTicket() {
		ArrayList<InputDetaills> adminList=getAdmin();
		GetInput getInput=new GetInput();
		InputValidation inputValidation=new InputValidation();
		InputDetaills details=new InputDetaills();
		
		String source=getInput.getSourceforBookTicket();
		String destination=getInput.getDestinationforBookTicket();
		
		for(int index=0;index<adminList.size();index++) {
			
			if((source.equalsIgnoreCase(adminList.get(index).getSource()))&&(destination.equalsIgnoreCase(adminList.get(index).getDestination()))) {
				
				String passengerInfo[]=getInput.getPassengerInfo();
				
				boolean valueNoOfSeats=inputValidation.noOfSeatsValidation(passengerInfo[0]);
				int passengerSeats=Integer.parseInt(passengerInfo[0]);
				if(valueNoOfSeats==true) {
					if(details.getNoOfSeats()>=details.getPassengerSeat()) {
						details.setPassengerSeat(passengerSeats);;
						details.setNoOfSeats(details.getNoOfSeats()-passengerSeats);
					}
				}
				else {
					System.out.println("Invalid no of seats");
				}
				
				boolean valueName=inputValidation.nameValidation(passengerInfo[1]);
				if(valueName==true) {
						details.setPassengerName(passengerInfo[1]);
				}
				else {
					System.out.println("Invalid name");
				}
				
				boolean valueMbleNo=inputValidation.numberValidation(passengerInfo[2]);
				if(valueMbleNo==true) {
						details.setPassengerMobileNo(passengerInfo[2]);
				}
				else {
					System.out.println("Invalid Mobile number");
				}
				break;
			}
		}
		userList.add(details);
		System.out.println("Bus Tickets Booked Successfully");
		userDisplayChoice();
	}
	private void cancelTicket() {
		ArrayList<InputDetaills> adminList=getAdmin();
		GetInput getInput=new GetInput();
		InputDetaills details=new InputDetaills();
		
		String source=getInput.getSource();
		String destination=getInput.getDestination();
		String passengerName=getInput.getPassengerName();
		String passengerSeats=getInput.getPassengerNoOfSeats();
		int NoOfSeatToCancel=Integer.parseInt(passengerSeats);
		
		for(int index=0;index<adminList.size();index++) {
			if((source.equalsIgnoreCase(adminList.get(index).getSource()))&&(destination.equalsIgnoreCase(adminList.get(index).getDestination()))&&(adminList.get(index).getStatus().equalsIgnoreCase("available"))) {
				if((passengerName.equalsIgnoreCase(userList.get(index).getPassengerName()))&&(userList.get(index).getPassengerSeat()>=NoOfSeatToCancel)) {
					int remainingPassengerSeat=userList.get(index).getPassengerSeat()-NoOfSeatToCancel;
					details.setPassengerSeat(remainingPassengerSeat);
					details.setNoOfSeats(details.getNoOfSeats()-remainingPassengerSeat);
					System.out.println("Tickets Cancelled");
				}
			}
		}
		adminList.add(details);
		userList.add(details);
		userDisplayChoice();
	}
	
	private void viewMyTicket() {
		ArrayList<InputDetaills> adminList=getAdmin();
		GetInput getInput=new GetInput();
		InputDetaills details=new InputDetaills();
		
		String source=getInput.getSource();
		String destination=getInput.getDestination();
		String passengerName=getInput.getPassengerName();
		for(int index=0;index<adminList.size();index++) {
			if((source.equalsIgnoreCase(adminList.get(index).getSource()))&&(destination.equalsIgnoreCase(adminList.get(index).getDestination()))&&(adminList.get(index).getStatus().equalsIgnoreCase("available"))) {
				if((passengerName.equalsIgnoreCase(userList.get(index).getPassengerName()))) {
					System.out.println("*****************************************************");
					System.out.println("Bus Route: "+adminList.get(index).getSource()+" - "+adminList.get(index).getDestination());
					System.out.println("Bus Number: "+adminList.get(index).getBusNo());
					System.out.println("Bus Date&Time: "+adminList.get(index).getDate()+" "+adminList.get(index).getTime());
					System.out.println("Bus Driver Details: "+adminList.get(index).getDriverName()+" "+adminList.get(index).getMobileNo());
					System.out.println("Passenger Details: "+userList.get(index).getPassengerName()+" "+userList.get(index).getPassengerMobileNo());
					System.out.println("No of seats Booked: "+userList.get(index).getPassengerSeat());
					System.out.println("*****************************************************");
				}
			}
		}
		userDisplayChoice();
	}
}
