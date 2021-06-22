package tickets.domain;

public enum TicketType  {

    LIVE("Live"),
    PREMATCH("PreMatch"),
    VIRTUAL("Virtual");

    private  String text;

    TicketType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
