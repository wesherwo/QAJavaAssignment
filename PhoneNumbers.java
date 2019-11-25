import java.util.Scanner;

public class PhoneNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a phone number: ");
		String number = scanner.nextLine();
		boolean valid = true;
		for(int i = 0; i < number.length() - 3; i++) {
			if(number.substring(i,i+3).equals("911")) {
				valid = false;
				break;
			}
		}
		if(number.length() != 10){
			valid = false;
		}
		if(valid)
			System.out.println("Valid number");
		else 
			System.out.println("Not a valid number");
		scanner.close();
	}

}
