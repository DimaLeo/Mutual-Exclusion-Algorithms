import java.util.ArrayList;

public class Petterson_Algorithm {
	private final int limitOfThreads=2;
	private ArrayList<Boolean> lock = new ArrayList<Boolean>();
	
	
	private int turn=0;
	private int counterLimit;
	private int counter=0;
	
	
	

	public Petterson_Algorithm(int counterLimit) {
		super();
		this.counterLimit = counterLimit;
		
		for(int i=0;i<2;i++) {
			lock.add(false);
		}
		
		for(int i=0;i<limitOfThreads;i++){
			
			new Thread(new MyThread3(i,this)).start();
		}
	}



	public ArrayList<Boolean> getLock() {
		return lock;
	}



	public int getTurn() {
		return turn;
	}




	public void setTurn(int turn) {
		this.turn = turn;
	}




	public int getCounter() {
		return counter;
	}




	public void setCounter(int counter) {
		this.counter = counter;
	}




	public int getLimitOfThreads() {
		return limitOfThreads;
	}




	public int getCounterLimit() {
		return counterLimit;
	}
	
	
	
	
	
	
	
	
	

}

class MyThread3 implements Runnable{
	int id;
	Petterson_Algorithm protocol;
	
	MyThread3(int id, Petterson_Algorithm protocol){
		this.id = id;
		this.protocol = protocol;
		
	}

	
	public void run() {
		
		while(protocol.getCounter()<protocol.getCounterLimit()) {
			//before critical selection
			protocol.getLock().set(id, true);
			protocol.setTurn(1-id);
			while(protocol.getLock().get(1-id) && protocol.getTurn()==1-id) {}
			// enter critical selection
			if(protocol.getCounter()<protocol.getCounterLimit())
			{
				protocol.setCounter(protocol.getCounter()+1);
				System.out.println("Counter Value : "+protocol.getCounter()+" from Thread "+id);
			}
			
			// exit critical selection
			protocol.getLock().set(id,false);
			//after critical selection
			
		}
		
	}
}
