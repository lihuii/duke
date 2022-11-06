package taskList;

import java.time.LocalDateTime;

public class Task {
    protected String description;
    protected boolean isDone;
    protected LocalDateTime dateTime;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public String getDescription(){
        return this.description;
    }

    public LocalDateTime getDate(){
        return this.dateTime;
    }
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone(){
        this.isDone=true;
        System.out.println("____________________________________________________________\n" +
                "Nice! I've marked this task as done: \n "+this.getDescription()+
                "\n____________________________________________________________" );
    }

    public void markAsUndone(){
        this.isDone=false;
        System.out.println("____________________________________________________________\n" +
                "OK, I've marked this task as not done yet: \n" + this.getDescription()
                + "\n____________________________________________________________");
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "]   " + this.getDescription();
    }
}