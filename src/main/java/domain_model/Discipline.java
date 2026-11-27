package domain_model;

public enum Discipline {
    BUTTERFLY,
    CRAWL,
    BACKCRAWL,
    CHEST;

    @Override
    public String toString() {
        return switch (this) {
            case BUTTERFLY -> "Butterfly";
            case CRAWL -> "Crawl";
            case BACKCRAWL -> "Rygcrawl";
            case CHEST -> "Brystsvømning";
        };
    }
}
