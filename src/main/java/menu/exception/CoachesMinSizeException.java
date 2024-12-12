package menu.exception;

import menu.config.Config;

public class CoachesMinSizeException extends CustomException {
    public CoachesMinSizeException() {
        super("코치는 최소 " + Config.COACHES_MIN_SIZE + "명 이상 입력해야 합니다.");
    }
}
