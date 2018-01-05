package io.github.zerthick.protectionperms;

import org.spongepowered.api.service.permission.Subject;

public class PermHandler {

    private static PermHandler instance = new PermHandler();

    private boolean invert;

    private PermHandler() {
        // Singleton Design Pattern
    }

    public static PermHandler getInstance() {
        return instance;
    }

    public void init(boolean invert) {
        this.invert = invert;
    }

    public boolean checkPerm(Subject subject, String... perms) {

        boolean result = false;

        for (String perm : perms) {
            result = result || subject.hasPermission(perm);
        }

        if (invert) {
            return !result;
        } else {
            return result;
        }
    }
}
