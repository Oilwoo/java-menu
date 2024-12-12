package menu.controller;

import menu.domain.Coach;
import menu.service.CustomService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class CustomController extends ExceptionLoopController{
    private final InputView input;
    private final OutputView output;
    private final CustomService service;

    public CustomController(InputView input, OutputView output, CustomService service) {
        this.input = input;
        this.output = output;
        this.service = service;
    }

    public void run() {
        output.printStartMessage();
        List<Coach> coaches = repeatUntilValid(this::getCoaches);

    }

    private List<Coach> getCoaches() {
        output.printGetCoachesMessage();
        return input.getCoaches();
    }
}
