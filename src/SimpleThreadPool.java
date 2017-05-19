/**
 * 
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Swapnil Srivastav
 *
 */
public class SimpleThreadPool {
	 public static void main(String[] args) {
			if(args.length == 0 ) args = new String[] {"10"};
		        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(args[0]));
		        for (int i = 0; i < 10; i++) {
		            Runnable worker = new WorkerThread(i);
		            executor.execute(worker);
		          }
		        executor.shutdown();
		        while (!executor.isTerminated());
		        System.out.println("Finished all threads");
		    }
}
