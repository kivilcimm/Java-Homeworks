package hW3;

import java.util.*;

public class Process implements IProcess{
	
	//computation içine girer

	private int Priority;

	public Process() {
		
		setPriority();
		
	}
	
	private void setPriority() {
		
		Random random = new Random();
		Priority = (random.nextInt(3) + 1);
		
	}

	
	@Override
	public int getPriority() {
		
		 return this.Priority;
		
	}
	
	
	@Override
	public String getType() {
		
		if(Priority==1) {
			return "High";
		}
		else if(Priority==2) {
			return "Medium";
		}
		else {
			return "Low";
		}
		
	}
	
	
}
