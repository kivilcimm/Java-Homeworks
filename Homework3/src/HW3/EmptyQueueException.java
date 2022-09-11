package hW3;
 
// this class is used by dequeue and getFront methods in FactoryLine class

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
	

		public EmptyQueueException() {
			super("EmptyQueueException");
		}
		public EmptyQueueException(String message) {
			super(message);
		}

	


}
