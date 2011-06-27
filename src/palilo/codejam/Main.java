package palilo.codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File(args[0]));
		int numberOfTests = s.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numberOfTests ; i++)
			sb.append(String.format("Case #%s: %s\n", 
					i, numberOfSecondsToExecuteSequence(s)));
		
		System.out.println(sb.toString());
	}

	private static String numberOfSecondsToExecuteSequence(Scanner s) {
		return new BotTrust(s.nextInt(), s.nextLine().substring(1)).getSecondsToExecute();
	}
}
