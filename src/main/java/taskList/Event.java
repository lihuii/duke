package taskList;

import parser.Parser;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event extends Task {
    protected String at;
    protected LocalDate localDate;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    // event string to print
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + convertDateFormat(getDate()) + ")";
    }

    // convert String date to LocalDate format
    @Override
    public LocalDate getDate() {
        return Parser.StringToDate(this.at);
    }

    // convert LocalDate to ideal date format
    public String convertDateFormat(LocalDate at){
        return Parser.DateToString(at);
    }


}
