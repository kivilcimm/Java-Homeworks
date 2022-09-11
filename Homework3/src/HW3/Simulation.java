package hW3;

public class Simulation {
	
	public int processNumber;
	
	
	public Simulation(int processNum) {
		 processNumber = processNum;
	}
	
	
	public PriorityQueue<Computation> simulation() {
		
		List<Process> processList = new List<Process>();
		PriorityQueue<Computation> computationQueue = new PriorityQueue<Computation>();
		
		
		
		for(int i=0; i<processNumber; i++) {
			
			Process process = new Process();
			processList.add(process);
			
		}
		
		for(int j=0; j<processList.getLength(); j++) {
			
			Computation computation = new Computation(processList.getEntry(j),j);
			computationQueue.enqueue(computation);
			
		}
		
		return(computationQueue);
		}
	
}
		

