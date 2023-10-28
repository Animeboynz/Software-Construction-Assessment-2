package com.g90.gui.app;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JLabel;


public class CustomApplicationOptionsLayout implements LayoutManager {

   private final ApplicationInterface appInterface;

    public CustomApplicationOptionsLayout(ApplicationInterface appInterface) {
        this.appInterface = appInterface;
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets parentInsets = parent.getInsets();
            int totalHeight = parentInsets.top + parentInsets.bottom;
            int componentCount = parent.getComponentCount();
            int i = 0;  // Initialize the while loop counter
            while (i < componentCount) {
                Component currentComponent = parent.getComponent(i);
                if (currentComponent.isVisible()) {
                    if (currentComponent instanceof JLabel) {
                        if (appInterface.IsOptionsExtended() || !appInterface.isHideMenuTitleOnMinimum()) {
                            totalHeight += currentComponent.getPreferredSize().height 
                                           + (UIScale.scale(appInterface.getMenuTitleVgap()) * 2);
                        }
                    } else {
                        totalHeight += currentComponent.getPreferredSize().height;
                    }
                }
                i++;  // Increment the counter
            }
            return new Dimension(5, totalHeight);
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            return new Dimension(0, 0);
        }
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets parentInsets = parent.getInsets();
            int xCoordinate = parentInsets.left;
            int yCoordinate = parentInsets.top;
            int parentWidth = parent.getWidth() - (parentInsets.left + parentInsets.right);
            int componentCount = parent.getComponentCount();
            int i = 0;  // Initialize the while loop counter
            while (i < componentCount) {
                Component currentComponent = parent.getComponent(i);
                if (currentComponent.isVisible()) {
                    int componentHeight = currentComponent.getPreferredSize().height;
                    if (currentComponent instanceof JLabel) {
                        if (appInterface.IsOptionsExtended() || !appInterface.isHideMenuTitleOnMinimum()) {
                            int menuTitleInset = UIScale.scale(appInterface.getMenuTitleLeftInset());
                            int menuTitleVerticalGap = UIScale.scale(appInterface.getMenuTitleVgap());
                            int titleWidth = parentWidth - menuTitleInset;
                            yCoordinate += menuTitleVerticalGap;
                            currentComponent.setBounds(xCoordinate + menuTitleInset, yCoordinate, titleWidth, componentHeight);
                            yCoordinate += componentHeight + menuTitleVerticalGap;
                        } else {
                            currentComponent.setBounds(0, 0, 0, 0);
                        }
                    } else {
                        currentComponent.setBounds(xCoordinate, yCoordinate, parentWidth, componentHeight);
                        yCoordinate += componentHeight;
                    }
                }
                i++;  // Increment the counter
            }
        }
    }
    
    @Override
    public void addLayoutComponent(String name, Component component) {
    }

    
     @Override
    public void removeLayoutComponent(Component component) {
    }
}