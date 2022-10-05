package BusTicketBooking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Admin {
	
	static ArrayList<InputDetaills> adminList=new ArrayList<InputDetaills>();

	public void login() {
		GetInput getInput=new GetInput();
		InputValidation inputValidation=new InputValidation();
		StartPage startPage=new StartPage();
		String login[]=getInput.login();
		boolean value=inputValidation.loginValidation(login[0], login[1]);
		if(value==true) {
			System.out.println("Welcome Admin!!");
			DisplayChoice();
		}
		else if(value==false) {
			System.out.println("UserName and Password Mismatch. Kindly Try again!!");
			startPage.startChoice();
		}
	}
	public List <InputDetaills>receiveBusDetails()
	{
		return adminList;
	}
	public void DisplayChoice() {
		GetInput getInput=new GetInput();
		StartPage startPage=new StartPage();
		int choice1=getInput.choiceForAdmin();
		switch(choice1) {
		case 1:
			addNewBus();
			break;
		case 2:
			viewBusDetails();
			break;
		case 3:
			searchBus();
			break;
		case 4:
			cancelBus();
			break;
		case 5:
			System.out.println("Thank You!!");
			startPage.startChoice();
			break;
		default:
			System.out.println("Please enter the correct choice!!");
			DisplayChoice();
		}
	}
	public void addNewBus() {
		GetInput getInput=new GetInput();
		InputValidation inputValidation=new InputValidation();
		InputDetaills details=new InputDetaills();
		String busarray[]=getInput.getBusdetails();
		
		boolean value=inputValidation.busNoValidation(busarray[0]);
		if(value==true) {
			details.setBusNo(busarray[0]);
		}
		else {
			System.out.println("Invalid Bus No!! Enter Valid details!!");
		}
		
		boolean valueSource=inputValidation.sourceValidation(busarray[1]);
		if(valueSource==true) {
			details.setSource(busarray[1]);
		}
		else {
			System.out.println("Invalid Source");
		}
		
		boolean valueDestination=inputValidation.destinationValidation(busarray[2]);
		if(valueDestination==true) {
			details.setDestination(busarray[2]);
		}
		else {
			System.out.println("Invalid Destination");
		}
		
		boolean valueDate=inputValidation.dateValidation(busarray[3]);
		if(valueDate==true) {
			details.setDate(busarray[3]);
		}
		else {
			System.out.println("Invalid Date");
		}
		
		boolean valueTime=inputValidation.timeValidation(busarray[4]);
		if(valueTime==true) {
			details.setTime(busarray[4]);
		}
		else {
			System.out.println("Invalid Time");
		}
		
		boolean valueName=inputValidation.nameValidation(busarray[5]);
		if(valueName==true) {
			details.setDriverName(busarray[5]);
		}
		else {
			System.out.println("Invalid Name");
		}
		
		boolean valueMobileNo=inputValidation.numberValidation(busarray[6]);
		if(valueMobileNo==true) {
			details.setMobileNo(busarray[6]);;
		}
		else {
			System.out.println("Invalid Mobile Number");
		}
		details.setNoOfSeats(40);
		details.setStatus("available");
		adminList.add(details);
		System.out.println("New Bus Details are added Successfully");
		DisplayChoice();
	}
	public void viewBusDetails() {
		new ArrayList<InputDetaills>();
		for(int index=0;index<adminList.size();index++) {
			System.out.println("*****************************************************");
			System.out.println("Bus Route: "+adminList.get(index).getSource()+" - "+adminList.get(index).getDestination());
			System.out.println("Bus Number: "+adminList.get(index).getBusNo());
			System.out.println("Bus Date&Time: "+adminList.get(index).getDate()+" "+adminList.get(index).getTime());
			System.out.println("Bus Driver Details: "+adminList.get(index).getDriverName()+" "+adminList.get(index).getMobileNo());
			System.out.println("No of Seats Available: "+adminList.get(index).getNoOfSeats());
			System.out.println("Bus Status: "+adminList.get(index).getStatus());
			System.out.println("*****************************************************");
		}
		DisplayChoice();
	}
	public void searchBus() {
		GetInput getInput=new GetInput();
		String source=getInput.getSource();
		String destination=getInput.getDestination();
		for(int index=0;index<adminList.size();index++) {
			if((source.equalsIgnoreCase(adminList.get(index).getSource()))&&(destination.equalsIgnoreCase(adminList.get(index).getDestination()))) {
				System.out.println("*****************************************************");
				System.out.println("Bus Route: "+adminList.get(index).getSource()+" - "+adminList.get(index).getDestination());
				System.out.println("Bus Number: "+adminList.get(index).getBusNo());
				System.out.println("Bus Date&Time: "+adminList.get(index).getDate()+" "+adminList.get(index).getTime());
				System.out.println("Bus Driver Details: "+adminList.get(index).getDriverName()+" "+adminList.get(index).getMobileNo());
				System.out.println("No of Seats Available: "+adminList.get(index).getNoOfSeats());
				System.out.println("Bus Status: "+adminList.get(index).getStatus());
				System.out.println("*****************************************************");
			}
		}
		DisplayChoice();
	}
	public void cancelBus() {
		GetInput getInput=new GetInput();
		String source=getInput.getSource();
		String destination=getInput.getDestination();
		for(int index=0;index<adminList.size();index++) {
			if((source.equalsIgnoreCase(adminList.get(index).getSource()))&&(destination.equalsIgnoreCase(adminList.get(index).getDestination()))&&(adminList.get(index).getStatus().equalsIgnoreCase("available"))) {
				adminList.get(index).setStatus("cancelled");
				System.out.println("Bus is Cancelled");
				break;
			}
		}
		DisplayChoice();
	}
	
}
