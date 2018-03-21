import java.util.ArrayList;
import java.util.Collections;

public class Bakery_Algorithm {
	
	private int numberOfThreads = 2;
	private ArrayList<Boolean> choosing = new ArrayList<Boolean>(); // holds  a value for the thread that wants to get in its critical area
	private ArrayList<Integer> num = new ArrayList<Integer>(); // priority number
	
	private int counter = 0;
	private int counterLimit;
	
	
	public Bakery_Algorithm(int counterLimit) {
		super();
		this.counterLimit = counterLimit;
		for(int i = 0;i<numberOfThreads;i++) {
			choosing.add(false);
			num.add(0);
		}
		
		for(int i=0;i<numberOfThreads;i++) {
			new Thread(new MyThread4(i,this)).start();
		}
	}


	public int getNumberOfThreads() {
		return numberOfThreads;
	}


	public void setNumberOfThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}


	public ArrayList<Boolean> getChoosing() {
		return choosing;
	}


	public void setChoosing(ArrayList<Boolean> choosing) {
		this.choosing = choosing;
	}


	public ArrayList<Integer> getNum() {
		return num;
	}


	public void setNum(ArrayList<Integer> num) {
		this.num = num;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	public int getCounterLimit() {
		return counterLimit;
	}
	
	
	
	
	
	
	
}

class MyThread4 implements Runnable{

	int id;
	Bakery_Algorithm bakery;
	
	
	
	public MyThread4(int id, Bakery_Algorithm lamp) {
		super();
		this.id = id;
		this.bakery = lamp;
	}



	public void run() {
		
		
		while(bakery.getCounter()<bakery.getCounterLimit()) {
			Entry_Protocol(id);
			bakery.setCounter(bakery.getCounter()+1);
			System.out.println("Counter Value : "+bakery.getCounter()+" from Thread "+id);
			Exit_Protocol(id);
		}
		
		
		
	}
	
	public void Entry_Protocol(int id) {
		bakery.getChoosing().set(id, true); // the thread wants to get into its critical area
		bakery.getNum().set(id, Collections.max(bakery.getNum())+1); // find the max value and add 1 to get next available ticket
		bakery.getChoosing().set(id,false);
		
		// if thread is is the current thread go to the next
		for(int i=0;i<bakery.getNumberOfThreads();i++) {
			if(i==id) {
				continue;
			}
			// wait if thread i is choosing right now
			while(bakery.getChoosing().get(i)) {
				
			}
			while(bakery.getNum().get(i)!=0 && (bakery.getNum().get(id)>bakery.getNum().get(i)||(bakery.getNum().get(id)==bakery.getNum().get(i)&&id>i))) {
				
			}
				
				
			
			
		}
		
	}
	
	public void Exit_Protocol(int id) {
		bakery.getNum().set(id, 0);
	}
	
	
}
