import java.util.Scanner;

public class PhoneNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a phone number: ");
		String number = scanner.nextLine();
		number = number.replace("-", "");
		number = number.replace("(", "");
		number = number.replace(")", "");
		number = number.replace(" ", "");
		boolean valid = true;
		if(number.contains("911")){
			valid = false;
		}
		if(number.length() != 10){
			valid = false;
		}
		try {
			Long.parseLong(number);
		}catch(NumberFormatException e) {
			valid = false;
		}
		if(valid)
			System.out.println("Valid number");
		else 
			System.out.println("Not a valid number");
		scanner.close();
	}

}
