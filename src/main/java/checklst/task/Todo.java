package checklst.task;

import checklst.exception.ChecklstException;

/**
 * The Deadline class represents a basic Task.
 */
public class Todo extends Task {

    /**
     * Creates a Todo Object.
     * @param name - Name of Todo.
     * @return - Todo Object.
     */
    public static Todo makeTodo(String name) throws ChecklstException {
        if (name.equals("")) {
            throw new ChecklstException("Todo needs a name!");
        }
        return new Todo(name);
    }
    
    protected Todo(String name) {
        super(name);
    }

    protected Todo(String name, boolean completed) {
        super(name, completed);
    }

    @Override
    public Task complete() {
        return new Todo(this.name, true);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}