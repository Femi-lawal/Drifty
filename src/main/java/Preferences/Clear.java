package Preferences;

import Utils.Environment;
import Utils.MessageBroker;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static Preferences.Labels.*;

public class Clear { // This class is used to clear the user preferences
    private static final MessageBroker M = Environment.getMessageBroker();
    private static final Clear INSTANCE = new Clear();
    private final Preferences preferences = Labels.PREFERENCES;

    private Clear() {
    }

    protected static Clear getInstance() {
        return INSTANCE;
    }

    public void folders() {
        preferences.remove(FOLDERS.toString());
    }

    public void mainAutoPaste() {
        preferences.remove(MAIN_AUTO_PASTE.toString());
    }

    public void lastDLPUpdateTime() {
        preferences.remove(LAST_DLP_UPDATE_TIME.toString());
    }

    public void lastFolder() {
        preferences.remove(LAST_FOLDER.toString());
    }

    public void jobs() {
        preferences.remove(JOBS.toString());
    }

    public void menuBarAsSystem() {
        preferences.remove(MENU_BAR_SYSTEM.toString());
    }

    public void alwaysAutoPaste() {
        preferences.remove(ALWAYS_AUTO_PASTE.toString());
    }

    public void clearAll() {
        try {
            preferences.clear();
        } catch (BackingStoreException e) {
            M.msgLogError("Failed to clear all the preferences! " + e.getMessage());
        }
    }
}
