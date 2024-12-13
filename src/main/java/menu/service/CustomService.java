package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.MenuRoster;
import menu.domain.WeeklyRoster;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomService {
    private static final int CATEGORY_MIN_SIZE = 1;
    private static final int CATEGORY_MAX_SIZE = 5;

    public List<WeeklyRoster> makeWeeklyRoster(List<Coach> coaches) {
        List<WeeklyRoster> weeklyRosters = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Category category = getCategoryRandom(weeklyRosters);
            List<MenuRoster> menuRosters = getMenuRoster(category, coaches, weeklyRosters);
            weeklyRosters.add(new WeeklyRoster(DayOfWeek.of(i), category.getCategoryIndex(), menuRosters));
        }
        return weeklyRosters;
    }

    private List<MenuRoster> getMenuRoster(Category category, List<Coach> coaches, List<WeeklyRoster> weeklyRoster) {
        List<MenuRoster> menuRosters = new ArrayList<>();
        for (Coach coach : coaches) {
            List<String> unavailableMenus = new ArrayList<>();
            unavailableMenus.addAll(coach.getHateMenus());
            unavailableMenus.addAll(getAlreadyMenus(weeklyRoster, coach.getName()));
            String menu = getAvailableMenu(category, unavailableMenus);
            menuRosters.add(new MenuRoster(coach.getName(), menu));
        }
        return menuRosters;
    }

    private List<String> getAlreadyMenus(List<WeeklyRoster> weeklyRoster, String name) {
        List<String> alreadyMenus = new ArrayList<>();
        for (WeeklyRoster roster : weeklyRoster) {
            MenuRoster menu = roster.getMenusByName(name);
            if (menu != null) {
                alreadyMenus.add(menu.getMenu());
            }
        }
        return alreadyMenus;
    }

    private Category getCategoryRandom(List<WeeklyRoster> weeklyRosters) {
        while (true) {
            int index = Randoms.pickNumberInRange(CATEGORY_MIN_SIZE, CATEGORY_MAX_SIZE);
            List<Integer> categoryIndexes = weeklyRosters.stream().map(WeeklyRoster::getCategoryIndex).collect(Collectors.toList());
            int duplicateCount = Collections.frequency(categoryIndexes, index);
            if (duplicateCount <= 2) {
                return Category.getCategoryByIndex(index);
            }
        }
    }

    private String getAvailableMenu(Category category, List<String> unavailableMenus) {
        while (true) {
            String menu = Randoms.shuffle(category.getFoods()).get(0);
            if (!unavailableMenus.contains(menu)) {
                return menu;
            }
        }
    }
}
