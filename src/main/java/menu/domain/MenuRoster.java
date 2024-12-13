package menu.domain;

import java.time.DayOfWeek;
import java.util.List;

public class MenuRoster {
    private final String name;
    private final String menu;

    public MenuRoster(String name, String menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public String getMenu() {
        return menu;
    }
}
