package tickets.domain;

public enum TicketType  {
    PREMATCH("PreMatch"),
    LIVE("Live"),
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
