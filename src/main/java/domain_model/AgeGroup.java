package domain_model;

public enum AgeGroup {
    JUNIOR,
    SENIOR;

    @Override
    public String toString() {
        return switch (this) {
            case JUNIOR -> "Junior";
            case SENIOR -> "Senior";
        };
    }
}
