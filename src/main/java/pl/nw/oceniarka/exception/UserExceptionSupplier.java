package pl.nw.oceniarka.exception;

import java.util.function.Supplier;

public class UserExceptionSupplier {

    public static Supplier<UserNotFoundException> userNotFound(Long id){
        return () -> new UserNotFoundException(id);
    }
}
