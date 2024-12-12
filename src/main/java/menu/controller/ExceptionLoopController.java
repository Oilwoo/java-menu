package menu.controller;

import menu.exception.CustomException;

import java.util.function.Supplier;

public abstract class ExceptionLoopController {
    protected <T> T repeatUntilValid(Supplier<T> function) {
        while(true) {
            try {
                return function.get();
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
