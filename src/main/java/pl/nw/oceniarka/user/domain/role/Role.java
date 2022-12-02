package pl.nw.oceniarka.user.domain.role;

import lombok.Getter;

@Getter
public enum Role {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN"), MOD("ROLE_MOD"), SUPERADMIN("ROLE_SUPERADMIN");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
