package menu.exception;

import menu.config.Config;

public class HateMenuMaxSizeException extends CustomException {
    public HateMenuMaxSizeException() {
        super("싫어하는 메뉴는 최대 " + Config.HateMenuMaxSizeException + "개 이하로 입력해야 합니다.");
    }
}
