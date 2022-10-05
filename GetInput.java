package BusTicketBooking;

import java.util.Scanner;

public class GetInput {
	Scanner sc=new Scanner(System.in);
	
	public int adminOrUser() {
		System.out.println("1.Admin \n2.User \n3.Logout ");
		System.out.println("Enter the choice(1/2/3): ");
		int choice=sc.nextInt();
		return choice;
	}
	public String[] login() {
		System.out.println("UserName: ");
		String username=sc.next();
		System.out.println("Password: ");
		String password=sc.next();
		String login[]=new String[2];
		login[0]=username;
		login[1]=password;
		return login;
	}
	public int choiceForAdmin() {
		System.out.println("1.Add new Bus: ");
		System.out.println("2.View All bus Details: ");
		System.out.println("3.Search the bus: ");
		System.out.println("4.Cancel one bus: ");
		System.out.println("5.Logout");
		System.out.println("Enter your choice(1/2/3/4/5): ");
		int choice=sc.nextInt();
		return choice;
	}
	public String[] getBusdetails() {
		String busArray[]=new String[7];
		System.out.println("Enter Bus Number: ");
		busArray[0]=sc.nextLine();
		System.out.println("Enter Source: ");
		busArray[1]=sc.next();
		System.out.println("Enter Destination: ");
		busArray[2]=sc.next();
		System.out.println("Enter Date: ");
		busArray[3]=sc.next();
		System.out.println("Enter Time: ");
		busArray[4]=sc.next();
		System.out.println("Enter Driver Name: ");
		busArray[5]=sc.next();
		System.out.println("Enter Mobile Number: ");
		busArray[6]=sc.next();
		return busArray;
	}
	public String getSource() {
		System.out.println("Enter Source: ");
		return sc.next();
	}
	public String getDestination() {
		System.out.println("Enter Destination: ");
		return sc.next();
	}
	public String[] userLogin() {
		System.out.println("UserName: ");
		String username=sc.next();
		System.out.println("Password: ");
		String password=sc.next();
		String login[]=new String[2];
		login[0]=username;
		login[1]=password;
		return login;
	}
	public int userDisplay() {
		System.out.println("1.Book Ticket");
		System.out.println("2.Cancel Ticket");
		System.out.println("3.View My Ticket");
		System.out.println("4.LogOut");
		System.out.println("Enter your choice(1/2/3/4): ");
		int choice=sc.nextInt();
		return choice;
	}
	public String[] getPassengerInfo() {
		String passengerInfo[]=new String[3];
		System.out.println("Enter No of seats: ");
		passengerInfo[0]=sc.next();
		System.out.println("Name of the primary passenger: ");
		passengerInfo[1]=sc.next();
		System.out.println("Enter the Mobile Number to contact: ");
		passengerInfo[2]=sc.next();
		return passengerInfo;
	}
	public String getPassengerName() {
		System.out.println("Enter the passenger Name: ");
		return sc.next();
	}
	public String getPassengerNoOfSeats() {
		System.out.println("Enter the No of seats to be cancelled: ");
		return sc.next();
	}
	public String getSourceforBookTicket() {
		System.out.println("Enter Source: ");
		return sc.next();
	}
	public String getDestinationforBookTicket() {
		System.out.println("Enter Destination: ");
		return sc.next();
	}
	
}
