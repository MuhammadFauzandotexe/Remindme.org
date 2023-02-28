package Email;

import io.quarkus.logging.Log;

public class SendEmail {
    public String email;
    public String sender;
    public String task;
    public String taskName;
    public SendEmail(String email, String sender, String task, String taskName){
        this.email = email;
        this.sender = sender;
        this.task = task;
        this.taskName = taskName;
    }
    public void emailSend(){
        System.out.println("task from remindme.org "+ taskName +" " + task);
        //Log.info("task from remindme.org"+ taskName +"\n" + task);
    }
}
