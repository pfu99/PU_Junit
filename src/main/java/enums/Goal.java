package enums;

import java.util.Objects;

public enum Goal {
    WORKWITHMINORS("Trabajar con menores"),
    GAMESECTOR("Sector del juego"),
    PUBLICWORKERS("Trabajadores públicos"),
    PUBLICADMINCONSORTIUM("Consorcio de administración pública");

    private final String description;

    Goal(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name();
    }
}
