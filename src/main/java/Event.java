public class Event extends Task {
    private static final String CODE = "[E]";
    private String at;

    public Event(String description, String at) {
        super(description);
        setAt(at);
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    @Override
    public String getCode() {
        return CODE;
    }

    @Override
    public String getDatetime() {
        return "(at: " + getAt() + ")";
    }
}
