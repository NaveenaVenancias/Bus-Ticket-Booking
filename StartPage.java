package BusTicketBooking;

public class StartPage {
	public void startChoice() {
		GetInput getinput=new GetInput();
		Admin admin=new Admin();
		User user=new User();
		int choice=getinput.adminOrUser();
		switch(choice) {
		case 1:
			admin.login();
			break;
		case 2:
			user.userLogin();
			break;
		case 3:
			System.out.println("Thank You!!");
			break;
		default:
			System.out.println("Invalid Choice! Try another time! Thank you!! ");
			break;
		}
	}
}
