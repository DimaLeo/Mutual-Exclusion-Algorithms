
public class Reentrant_Lock {
	private int numberOfThreads=2;
	private int counter = 0;
	private int turn = 0;
	private int counterLimit;
	
	public Reentrant_Lock(int counterLimit) {
		super();
		this.counterLimit = counterLimit;
		
		for(int i=0;i<numberOfThreads;i++) {
			new Thread(new MyThread2(i,this)).start();;
		}
		
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getCounterLimit() {
		return counterLimit;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getNumberOfThreads() {
		return numberOfThreads;
	}
	

	
	
	
	
	
	
	

}

class MyThread2 implements Runnable{
	
	int id;
	Reentrant_Lock lock;
	
	
	MyThread2(int id, Reentrant_Lock lock) {
		super();
		this.id = id;
		this.lock = lock;
	}




	public void run() {
		
		while(lock.getCounter()<lock.getCounterLimit()) {
			// before critical selection
	        while(lock.getTurn()!=id) {}
			// entered critical selection
	        if(lock.getCounter()<lock.getCounterLimit()) {
	        	lock.setCounter(lock.getCounter()+1);
				System.out.println("Counter Value : "+lock.getCounter()+" from Thread "+id);
	        }
			
			// exit critical selection
		    lock.setTurn((id+1)%lock.getNumberOfThreads());
		    //after critical selection
			
		}
		
		
	}
	
}
