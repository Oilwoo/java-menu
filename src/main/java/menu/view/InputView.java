package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.config.Config;
import menu.domain.Coach;
import menu.exception.CoachesMaxSizeException;
import menu.exception.CoachesMinSizeException;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public List<Coach> getCoaches() {
        String input = Console.readLine();
        String[] splitInput = input.split(DELIMITER);

        validateSize(splitInput);
        List<Coach> coaches = new ArrayList<>();
        for (String name : splitInput) {
            coaches.add(new Coach(name));
        }

        return coaches;
    }

    private void validateSize(String[] splitInput) {
        if (splitInput.length < Config.COACHES_MIN_SIZE) {
            throw new CoachesMinSizeException();
        }
        if (splitInput.length > Config.COACHES_MAX_SIZE) {
            throw new CoachesMaxSizeException();
        }
    }
}
