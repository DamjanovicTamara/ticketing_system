package tickets.domain;

public enum TicketType {

    LIVE("Live"),
    PREMATCH("PreMatch"),
    VIRTUAL("Virtual");


    private  String text;

    TicketType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
