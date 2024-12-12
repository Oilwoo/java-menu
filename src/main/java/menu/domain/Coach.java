package menu.domain;

import menu.exception.CoachNameLengthException;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> hateFoods = null;


    public Coach(String name) {
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() < 2 || name.length() > 4) {
            throw new CoachNameLengthException();
        }
    }
}
