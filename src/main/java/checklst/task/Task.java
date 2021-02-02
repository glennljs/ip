package checklst.task;

/**
 * The Task class is an abstract skeleton that all Tasks (Todo, Event, Deadline) inherit from.
 */
public abstract class Task {
    
    protected final String name;
    protected final boolean completed;

    protected Task(String name) {
        this.name = name;
        this.completed = false;
    }

    protected Task(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    /**
     * Returns a new Task object which has been completed.
     * @return New completed Task.
     */
    public abstract Task complete();

    @Override
    public String toString() {
        String completed = this.completed ? "[X]" : "[]";
        return completed + " " + this.name;
    }

}