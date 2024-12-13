package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.WeeklyRoster;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printGetCoachesMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printGetHateMenus(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printWeeklyRoster(List<Coach> coaches, List<WeeklyRoster> weeklyRosters) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        String printCategory = "";
        for (WeeklyRoster roster : weeklyRosters) {
            Category category = Category.getCategoryByIndex(roster.getCategoryIndex());
            printCategory += " | " + category.getName();
        }
        System.out.println("[ 카테고리"+ printCategory +" ]");
        for (Coach coach : coaches) {
            String name = coach.getName();
            String menus = "";
            for (WeeklyRoster roster : weeklyRosters) {
                menus += " | " + roster.getMenusByName(name).getMenu();
            }
            System.out.println("[ " + name + menus + " ]");
        }
        System.out.println("추천을 완료했습니다.");
    }
}
