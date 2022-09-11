package hW3;

import java.util.*;


public class Computation implements Comparable<Computation>{
	
	private int id;
	
	private IProcess process;
	
	private int occupation;
	
	private int Priority;
    
	public Computation(IProcess process, int id) {
		
		this.process = process;
		this.id = id;
		this.occupation = set_occupation();
		
		
	}
	
	private int set_occupation() {
		
		Random random = new Random();
		occupation = (random.nextInt(10)+1);
		
		return occupation;
	}
	
	public int getId() {
		
		return this.id;
	}
	
	public int get_occupation() {
		
		return this.occupation;
	}
	
	public int getPriority() {
		
		Priority = process.getPriority();

        return this.Priority;
	}
	
	public int compareTo(Computation o) {
		if (o.getPriority() == Priority)
			return 0;
		
		else if (o.getPriority() > Priority) 
			return -1;
		
		else
			return 1;
		
	}	
	
	
}
