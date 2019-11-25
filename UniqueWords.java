import java.util.ArrayList;
import java.util.Scanner;

public class UniqueWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		String words = scanner.nextLine();
		findWords(words);
		scanner.close();
	}

	public static void findWords(String s) {
		s = s.replace(".", "");
		s = s.replace(",", "");
		String[] words = s.split(" ");
		ArrayList<String> uWords = new ArrayList<String>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		boolean found = false;
		for(String currWord : words) {
			if(currWord.trim().length() > 0) {
				found = false;
				for(int i = 0; i < uWords.size() && !found; i++) {
					if(uWords.get(i).equalsIgnoreCase(currWord)) {
						counts.set(i, counts.get(i) + 1);
						found = true;
					}
				}
				if(!found) {
					int loc = 0;
					while(loc < uWords.size() && currWord.compareToIgnoreCase(uWords.get(loc)) > 0) {
						loc++;
					}
					uWords.add(loc, currWord);
					counts.add(loc, 1);
				}
			}
		}
		for(int i = 0; i < uWords.size(); i++) {
			System.out.println(uWords.get(i).toLowerCase() + " - " + counts.get(i));
		}
	}

}
