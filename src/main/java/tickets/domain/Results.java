package tickets.domain;

public enum Results {

    WIN("Winning"),
    LOSS("Loosing"),
    REFUND("Refund");

    private  String text;

    Results( String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
