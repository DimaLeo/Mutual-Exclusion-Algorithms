
public class Boolean_Flag {
	
	private int numberOfThreads;
	private int counter = 0;
	private boolean lock = false;
	private int counterLimit;

	public Boolean_Flag(int counterLimit,int numberOfThreads) {
		super();
		this.counterLimit=counterLimit;
		this.numberOfThreads=numberOfThreads;
		
		for(int i=0;i<numberOfThreads;i++){
			new Thread(new MyThread(i,this)).start();
		}
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean flag) {
		this.lock = flag;
	}

	public int getCounterLimit() {
		return counterLimit;
	}
	
	
	
	
	
	

}

class MyThread implements Runnable{

	int id;
	Boolean_Flag flag;
	
	
	MyThread(int id,Boolean_Flag lock){
		
		this.id=id;
		this.flag = lock; 
		
	}
	
	public void run() {
		
		while(flag.getCounter()<flag.getCounterLimit()) {
			 
			//before critical selection
			while(flag.isLock()) {}
			flag.setLock(true);
			//critical selection starts
			if(flag.getCounter()<flag.getCounterLimit()) {
		    	flag.setCounter(flag.getCounter()+1);
				System.out.println("Counter Value : "+flag.getCounter()+" from Thread "+id);
		    }
			
		
		
			flag.setLock(false);
			//critical selection ends    
			
			// after critical selection 
			
			
			
			
			
		}
		
	}
	
}
