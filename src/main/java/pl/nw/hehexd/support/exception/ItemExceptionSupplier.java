package pl.nw.hehexd.support.exception;

import java.util.function.Supplier;

public class ItemExceptionSupplier {

    public static Supplier<ItemNotFoundException> itemNotFound(Long id){
        return ()-> new ItemNotFoundException(id);
    }

}
