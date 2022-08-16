package exception;

public class Test09 {

	public static void main(String[] args) {
		try {
			Thread.sleep(5000L);
		}
		catch(InterruptedException e ) {
			e.printStackTrace();
		}
	}
	

}
