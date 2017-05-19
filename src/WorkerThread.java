import java.sql.Connection;
import java.sql.PreparedStatement;


//insert ignore into table1(col1) values(?)

class WorkerThread implements Runnable {
    private String command;
    String query = "insert ignore into table1(col1) values(?)";
    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
    	MySQLConenctor mySQLConenctor = new MySQLConenctor();
        try {
           Connection connection = mySQLConenctor.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1,"");
           int i = preparedStatement.executeUpdate();
           if(i==1)
        	   System.out.println("Inserted Successfully");
           else
        	   System.out.println("Insert Failed");
        	
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
