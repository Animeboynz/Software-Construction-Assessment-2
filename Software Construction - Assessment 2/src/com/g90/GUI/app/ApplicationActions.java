package com.g90.gui.app;

/**
 * Represents an action within a menu system. 
 * Actions can be cancelled, affecting how they are processed.
 */
public class ApplicationActions {

    // Indicates whether the action has been cancelled.
    private boolean isCancelled = false;

    /**
     * Checks if the action has been marked as cancelled.
     *
     * @return true if the action is cancelled, false otherwise.
     */
    protected boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Marks this action as cancelled. 
     * Once cancelled, the action should typically not be executed.
     */
    public void cancel() {
        this.isCancelled = true;
    }
}
