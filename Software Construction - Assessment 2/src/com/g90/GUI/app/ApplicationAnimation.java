package com.g90.gui.app;

import com.formdev.flatlaf.util.Animator;
import java.util.HashMap;

/**
 * Handles animations for menu items.
 * Animations are controlled and tracked using a HashMap.
 * This class provides functionality to animate the showing and hiding of menu items.
 */
public class ApplicationAnimation {

    // A map to track animations for each menu item.
    private static final HashMap<MenuItem, Animator> menuItemAnimators = new HashMap<>();

    /**
     * Animates a menu item's visibility.
     *
     * @param menuItem The menu item to be animated.
     * @param shouldShow Flag to indicate whether to show (true) or hide (false) the menu item.
     */
    public static void animate(MenuItem menuItem, boolean shouldShow) {
        // Stop any running animation for this menu item.
        if (menuItemAnimators.containsKey(menuItem) && menuItemAnimators.get(menuItem).isRunning()) {
            menuItemAnimators.get(menuItem).stop();
        }

        menuItem.setMenuShow(shouldShow);

        // Define the animation for the menu item.
        Animator animator = new Animator(400, new Animator.TimingTarget() {
            @Override
            public void timingEvent(float fraction) {
                // Set animation progress.
                if (shouldShow) {
                    menuItem.setAnimate(fraction);
                } else {
                    menuItem.setAnimate(1f - fraction);
                }
                menuItem.revalidate();
            }

            @Override
            public void end() {
                // Remove the animator from the map when the animation ends.
                menuItemAnimators.remove(menuItem);
            }
        });

        // Configure the animator.
        animator.setResolution(1);
        animator.setInterpolator(fraction -> (float) (1 - Math.pow(1 - fraction, 3)));
        
        // Start the animation and track it.
        animator.start();
        menuItemAnimators.put(menuItem, animator);
    }
}
