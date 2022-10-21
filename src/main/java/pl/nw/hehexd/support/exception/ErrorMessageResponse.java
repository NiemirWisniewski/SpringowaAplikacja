package pl.nw.hehexd.support.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorMessageResponse {

    private final String message;
}
