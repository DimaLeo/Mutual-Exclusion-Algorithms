import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Press 0 : Boolean Flag Algorithm\nPress 1 : Reentrant Lock Algorithm\n"
				+ "Press 2 : Petterson Algorithm\n1Press 3 : Bakery_Algorithm");
		System.out.print("Waiting for input : ");
		int algorithm = input.nextInt();
		input.close();
		
		
		switch(algorithm) {
		
		case 0 : new Boolean_Flag(5);
		break;
		case 1 : new Reentrant_Lock(5);
		break;
		case 2 : new Petterson_Algorithm(5);
		break;
		case 3 : new Bakery_Algorithm(5);
		
		}
		
        
		
		
	}

}
