package menu.exception;

import menu.config.Config;

public class CoachesMaxSizeException extends CustomException {
    public CoachesMaxSizeException() {
        super("코치는 최대 " + Config.COACHES_MAX_SIZE + "명 이하 입력해야 합니다.");
    }
}
