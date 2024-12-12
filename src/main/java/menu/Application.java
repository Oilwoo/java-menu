package menu;

import menu.controller.CustomController;
import menu.service.CustomService;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CustomService customService = new CustomService();

        CustomController controller = new CustomController(inputView, outputView, customService);
        controller.run();
    }
}
