package pl.nw.hehexd.support.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(Long id) {
        super(String.format("Item with id %d not found", id));
    }
}
