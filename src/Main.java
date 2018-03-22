import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Press 0 : Boolean Flag Algorithm\nPress 1 : Reentrant Lock Algorithm\n"
				+ "Press 2 : Petterson Algorithm(Thread cap = 2)\n1Press 3 : Bakery_Algorithm");
		System.out.print("Waiting for input : ");
		
		int algorithm = input.nextInt();
		System.out.println("Specify the max value you want the threads to count to : ");
		int maxCounter = input.nextInt();
		int numberOfThreads=0;
		if(algorithm!=2) {
			System.out.println("Specify the number of threads you want to be used : ");
			numberOfThreads = input.nextInt();
		}
		
		
		input.close();
		
		
		switch(algorithm) {
		
		case 0 : new Boolean_Flag(maxCounter,numberOfThreads);
		break;
		case 1 : new Reentrant_Lock(maxCounter,numberOfThreads);
		break;
		case 2 : new Petterson_Algorithm(maxCounter);
		break;
		case 3 : new Bakery_Algorithm(maxCounter,numberOfThreads);
		
		}
		
        
		
		
	}

}
