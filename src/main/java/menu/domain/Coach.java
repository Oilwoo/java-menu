package menu.domain;

import menu.exception.CoachNameLengthException;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> hateMenus = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() < 2 || name.length() > 4) {
            throw new CoachNameLengthException();
        }
    }

    public String getName() {
        return name;
    }

    public void setHateMenus(List<String> menus) {
        hateMenus = menus;
    }
}
