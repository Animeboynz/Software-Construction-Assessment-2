package com.g90.gui.menus;

import com.g90.gui.other.ListInventory;
import com.g90.gui.other.CreateNewInv;
import com.g90.gui.other.MoveItems;
import com.g90.gui.other.RemoveItems;
import com.g90.gui.other.CreateNewProduct;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.g90.GUI.Application;
import com.g90.gui.other.FormDashboard;
import com.g90.gui.other.AddItems;
import com.g90.gui.app.ApplicationInterface;
import com.g90.gui.app.ApplicationActions;

public class MainForm extends JLayeredPane {

    public MainForm() {
        init();
    }

    private void init() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new MainFormLayout());
        menu = new ApplicationInterface();
        panelBody = new JPanel(new BorderLayout());
        
        initMenuEvent();
        
        //add(menuButton);
        add(menu);
        add(panelBody);
    }

    @Override
    public void applyComponentOrientation(ComponentOrientation o) {
        super.applyComponentOrientation(o);
    }


    private void initMenuEvent() {
        menu.addMenuEvent((int index, int subIndex, ApplicationActions action) -> {
            // Application.mainForm.showForm(new DefaultForm("Form : " + index + " " + subIndex));
            if (index == 0) {
                Application.showForm(new FormDashboard());
            } else if (index == 1)
            {
                Application.showForm(new ListInventory());
            } else if (index == 2) {
                if (subIndex == 1) {
                    Application.showForm(new AddItems());
                } else if (subIndex == 2) {
                    Application.showForm(new RemoveItems());
                } else if (subIndex == 3) {
                    Application.showForm(new MoveItems());
                } else {
                    action.cancel();
                }
            } else if (index == 3) {
                Application.showForm(new CreateNewInv());
            } else if (index == 4) {
                Application.showForm(new CreateNewProduct());
            }else if (index == 5) {
                Application.logout();
            }else {
                action.cancel();
            }
        });
    }


    public void hideMenu() {
        menu.hideMenuItem();
    }

    public void showForm(Component component) {
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.repaint();
        panelBody.revalidate();
    }

    public void setSelectedMenu(int index, int subIndex) {
        menu.setSelectedMenu(index, subIndex);
    }

    private ApplicationInterface menu;
    private JPanel panelBody;
    private JButton menuButton;

    private class MainFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
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
                boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale.scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(menu.IsOptionsExtended() ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                menu.setBounds(menuX, y, menuWidth, height);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                int bodyy = y;
                panelBody.setBounds(bodyx, bodyy, bodyWidth, bodyHeight);
            }
        }
    }
}