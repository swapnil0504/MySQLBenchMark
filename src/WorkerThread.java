import java.sql.Connection;
import java.sql.PreparedStatement;


//insert ignore into table1(col1) values(?)

class WorkerThread implements Runnable {
    private int command;
    String query = "insert ignore into table1(col1) values(?)";
    public WorkerThread(int s){
        this.command=s;
    }

    @Override
    public void run() {
    	try{
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        MySQLConenctor mySQLConenctor = new MySQLConenctor();
    	Connection connection = mySQLConenctor.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for(int i=0;i<10;i++){
        	String threadName = command+"-"+Thread.currentThread().getName();
            preparedStatement.setString(1,threadName);
            System.out.println(preparedStatement.executeUpdate());
        }
        System.out.println(Thread.currentThread().getName()+" End.");
    	}catch(Exception e){
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
    }
    
}
