package pl.nw.hehexd.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    CUSTOMER("CUSTOMER"), MOD("MOD"), ADMIN("ADMIN"), SUPERADMIN("SUPERADMIN");

    private final String role;
}
