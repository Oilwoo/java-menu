package menu.exception;

public class CoachNameLengthException extends CustomException{
    public CoachNameLengthException() {
        super("코치의 이름의 길이는 최소2자 최대4자 입니다. 다시 입력해주세요.");
    }
}
