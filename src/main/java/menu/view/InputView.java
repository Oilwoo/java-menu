package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.config.Config;
import menu.domain.Category;
import menu.domain.Coach;
import menu.exception.CoachesMaxSizeException;
import menu.exception.CoachesMinSizeException;
import menu.exception.HateMenuMaxSizeException;
import menu.exception.MenuNotExistException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public List<Coach> getCoaches() {
        String input = Console.readLine();
        String[] splitInput = input.split(DELIMITER);

        validateCoachSize(splitInput);
        List<Coach> coaches = new ArrayList<>();
        for (String name : splitInput) {
            coaches.add(new Coach(name));
        }

        return coaches;
    }

    public List<String> getHateMenus() {
        String input = Console.readLine();

        String[] splitInput = input.split(DELIMITER);
        validateMenuSize(splitInput);
        validateMenuExist(splitInput);

        return Arrays.asList(splitInput);
    }

    private void validateCoachSize(String[] splitInput) {
        if (splitInput.length < Config.COACHES_MIN_SIZE) {
            throw new CoachesMinSizeException();
        }
        if (splitInput.length > Config.COACHES_MAX_SIZE) {
            throw new CoachesMaxSizeException();
        }
    }

    private void validateMenuSize(String[] splitInput) {
        if (splitInput.length <= Config.HateMenuMaxSizeException) {
            throw new HateMenuMaxSizeException();
        }
    }

    private void validateMenuExist(String[] splitinput) {
        for (String menu : splitinput) {
            boolean exist = false;
            for (Category c : Category.values()) {
                if (c.getFoods().stream().anyMatch(v -> v.equals(menu))) {
                    exist = true;
                }
            }
            if (!exist) {
                throw new MenuNotExistException();
            }
        }
    }
}
