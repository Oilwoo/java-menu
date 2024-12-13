package menu.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeeklyRoster {
    private final DayOfWeek dayOfWeek;
    private final int categoryIndex;

    private final List<MenuRoster> menuRosters;

    public WeeklyRoster(DayOfWeek dayOfWeek, int categoryIndex, List<MenuRoster> menuRosters) {
        this.dayOfWeek = dayOfWeek;
        this.categoryIndex = categoryIndex;
        this.menuRosters = menuRosters;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getCategoryIndex() {
        return categoryIndex;
    }

    public MenuRoster getMenusByName(String name) {
        return menuRosters.stream().filter(v -> v.getName().equals(name)).findFirst().orElse(null);
    }

    public List<MenuRoster> getMenuRosters() {
        return menuRosters;
    }


}
