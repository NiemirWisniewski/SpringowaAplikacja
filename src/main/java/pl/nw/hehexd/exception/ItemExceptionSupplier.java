package pl.nw.hehexd.exception;

import java.util.function.Supplier;

public class ItemExceptionSupplier {

    public static Supplier<ItemNotFoundException> itemNotFound(Long id){
        return ()-> new ItemNotFoundException(id);
    }

}
