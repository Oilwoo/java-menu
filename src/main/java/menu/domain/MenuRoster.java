package menu.domain;

import java.time.DayOfWeek;

public class MenuRoster {
    private final DayOfWeek dayOfWeek;
    private final String name;
    private final String menu;

    public MenuRoster(DayOfWeek dayOfWeek, String name, String menu) {
        this.dayOfWeek = dayOfWeek;
        this.name = name;
        this.menu = menu;
    }
}
