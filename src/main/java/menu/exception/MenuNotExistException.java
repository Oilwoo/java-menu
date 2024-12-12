package menu.exception;

public class MenuNotExistException extends CustomException{
    public MenuNotExistException() {
        super("메뉴가 카테고리에 존재하지 않습니다.");
    }
}
