package checklst.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import checklst.exception.ChecklstException;

/**
 * The Event class represents a Task which has a specific DateTime.
 */
public class Event extends Task {

    protected final LocalDate dateTime;

    protected Event(String name, LocalDate dateTime) {
        super(name);
        this.dateTime = dateTime;
    }

    protected Event(String name, boolean completed, LocalDate dateTime) {
        super(name, completed);
        this.dateTime = dateTime;
    }

    /**
     * Creates a new Event object.
     * @param input Input for the Event in the form "{ name } /at { date }".
     * @return New Event object.
     */
    public static Event makeEvent(String input) throws ChecklstException {
        String[] splitInput = input.split(" /at ");
        if (splitInput.length == 1) {
            throw new ChecklstException("Inproper Event format used! Please use { name } /at { event }");
        }

        LocalDate dateTime;
        try {
            dateTime = LocalDate.parse(splitInput[1]);
        } catch (DateTimeParseException e) {
            throw new ChecklstException("Incorrect DateTime format! Please use YYYY-MM-DD");
        }

        return new Event(splitInput[0], dateTime);
    }

    public static Event parseEvent(String input) {
        String[] splitInput = input.split(" ; ");
        String name = splitInput[2];
        boolean completed = splitInput[1].equals("X") ? true : false;
        LocalDate dateTime = LocalDate.parse(splitInput[3]);

        return new Event(name, completed, dateTime);
    }

    @Override
    public String export() {
        String output = "E ; ";

        if (this.completed) {
            output += "X ; ";
        } else {
            output += "O ; ";
        }

        output += this.name + " ; " + this.dateTime.toString();

        return output;
    } 

    @Override
    public Task complete() {
        return new Event(this.name, true, this.dateTime);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: "
            + this.dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

}
