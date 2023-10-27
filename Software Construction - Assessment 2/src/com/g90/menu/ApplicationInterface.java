package com.g90.menu;

//import com.g90.menu.mode.LightDarkMode;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
//import com.g90.menu.mode.ToolBarAccentColor;

/**
 *
 * @author Raven
 */
public class ApplicationInterface extends JPanel {

    private final String[][] main_Options_Available = {
        {"~MAIN~"},
        {"Dashboard"},
        {"List Inventory"},
        {"~Product Movements~"},
        {"Manage Inventory", "Add to Inv", "Remove from Inv", "Move Between Inv"},
        {"~Configuration~"},
        {"Create New Inventory"},
        {"Create New Product"},
        {"Logout"}
    };

    public boolean IsOptionsExtended() {
        return OptionsExtended;
    }

    public void OptionMenuExpanded(boolean menuFull) {
        this.OptionsExtended = menuFull;
        if (menuFull) {
            OptionHead.setText(headerName);
            OptionHead.setHorizontalAlignment(getComponentOrientation().isLeftToRight() ? JLabel.LEFT : JLabel.RIGHT);
        } else {
            OptionHead.setText("");
            OptionHead.setHorizontalAlignment(JLabel.CENTER);
        }
        
        Component[] components = panelMenu.getComponents();
        int i = 0;
        
        while (i < components.length) {
            Component component = components[i];
            
            i++;
        }
        //lightDarkMode.setMenuFull(menuFull);
//        toolBarAccentColor.setMenuFull(menuFull);
    }

    private final List<MenuEvent> events = new ArrayList<>();
    private boolean OptionsExtended = true;
    private final String headerName = "Inventory Manager";

    protected final boolean hideMenuTitleOnMinimum = true;
    protected final int menuTitleLeftInset = 5;
    protected final int menuTitleVgap = 5;
    protected final int menuMaxWidth = 250;
    protected final int menuMinWidth = 60;
    protected final int headerFullHgap = 5;

    public ApplicationInterface() {
        initialize();
    }

    private void initialize() {
        setLayout(new MenuLayout());
        putClientProperty(FlatClientProperties.STYLE, ""
                + "border:20,2,2,2;"
                + "background:$Menu.background;"
                + "arc:10");
        OptionHead = new JLabel(headerName);
        OptionHead.setIcon(new ImageIcon(getClass().getResource("/com/g90/icon/png/logo.png")));
        OptionHead.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$Menu.header.font;"
                + "foreground:$Menu.foreground");

        //  Menu
        OptionsScroll = new JScrollPane();
        panelMenu = new JPanel(new MenuItemLayout(this));
        panelMenu.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5;"
                + "background:$Menu.background");

        OptionsScroll.setViewportView(panelMenu);
        OptionsScroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:null");
        JScrollBar verticalScrollBar = OptionsScroll.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(10);
        verticalScrollBar.putClientProperty(FlatClientProperties.STYLE, ""
                + "width:$Menu.scroll.width;"
                + "trackInsets:$Menu.scroll.trackInsets;"
                + "thumbInsets:$Menu.scroll.thumbInsets;"
                + "background:$Menu.ScrollBar.background;"
                + "thumb:$Menu.ScrollBar.thumb");
        buildMenuItems();
        //lightDarkMode = new LightDarkMode();
//        toolBarAccentColor = new ToolBarAccentColor(this);
//        toolBarAccentColor.setVisible(FlatUIUtils.getUIBoolean("AccentControl.show", false));
        add(OptionHead);
        add(OptionsScroll);
        //add(lightDarkMode);
//        add(toolBarAccentColor);
    }

    private void buildMenuItems() {
        int index = 0;
        for (int i = 0; i < main_Options_Available.length; i++) {
            String menuName = main_Options_Available[i][0];
            if (menuName.startsWith("~") && menuName.endsWith("~")) {
                panelMenu.add(createTitle(menuName));
            } else {
                MenuItem menuItem = new MenuItem(this, main_Options_Available[i], index++, events);
                panelMenu.add(menuItem);
            }
        }
    }

    private JLabel createTitle(String title) {
        String menuName = title.substring(1, title.length() - 1);
        JLabel lbTitle = new JLabel(menuName);
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$Menu.label.font;"
                + "foreground:$Menu.title.foreground");
        return lbTitle;
    }

    public void setSelectedMenu(int index, int subIndex) {
        runEvent(index, subIndex);
    }

    protected void setSelected(int index, int subIndex) {
        int size = panelMenu.getComponentCount();
        for (int i = 0; i < size; i++) {
            Component com = panelMenu.getComponent(i);
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getMenuIndex() == index) {
                    item.setSelectedIndex(subIndex);
                } else {
                    item.setSelectedIndex(-1);
                }
            }
        }
    }

    protected void runEvent(int index, int subIndex) {
        MenuAction menuAction = new MenuAction();
        for (MenuEvent event : events) {
            event.menuSelected(index, subIndex, menuAction);
        }
        if (!menuAction.isCancel()) {
            setSelected(index, subIndex);
        }
    }

    public void addMenuEvent(MenuEvent event) {
        events.add(event);
    }

    public void hideMenuItem() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                ((MenuItem) com).hideMenuItem();
            }
        }
        revalidate();
    }

    public boolean isHideMenuTitleOnMinimum() {
        return hideMenuTitleOnMinimum;
    }

    public int getMenuTitleLeftInset() {
        return menuTitleLeftInset;
    }

    public int getMenuTitleVgap() {
        return menuTitleVgap;
    }

    public int getMenuMaxWidth() {
        return menuMaxWidth;
    }

    public int getMenuMinWidth() {
        return menuMinWidth;
    }

    private JLabel OptionHead;
    private JScrollPane OptionsScroll;
    private JPanel panelMenu;
    //private LightDarkMode lightDarkMode;
//    private ToolBarAccentColor toolBarAccentColor;

    private class MenuLayout implements LayoutManager {

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
                Insets insets = parent.getInsets();
                int x = insets.left;
                int y = insets.top;
                int gap = UIScale.scale(5);
                int sheaderFullHgap = UIScale.scale(headerFullHgap);
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int iconWidth = width;
                int iconHeight = OptionHead.getPreferredSize().height;
                int hgap = OptionsExtended ? sheaderFullHgap : 0;
                int accentColorHeight = 0;
//                if (toolBarAccentColor.isVisible()) {
//                    accentColorHeight = toolBarAccentColor.getPreferredSize().height+gap;
//                }

                OptionHead.setBounds(x + hgap, y, iconWidth - (hgap * 2), iconHeight);
                int ldgap = UIScale.scale(10);
                int ldWidth = width - ldgap * 2;
                //int ldHeight = lightDarkMode.getPreferredSize().height;
                int ldHeight = 10;
                int ldx = x + ldgap;
                int ldy = y + height - ldHeight - ldgap  - accentColorHeight;

                int menux = x;
                int menuy = y + iconHeight + gap;
                int menuWidth = width;
                int menuHeight = height - (iconHeight + gap) - (ldHeight + ldgap * 2) - (accentColorHeight);
                OptionsScroll.setBounds(menux, menuy, menuWidth, menuHeight);

                //lightDarkMode.setBounds(ldx, ldy, ldWidth, ldHeight);

//                if (toolBarAccentColor.isVisible()) {
//                    int tbheight = toolBarAccentColor.getPreferredSize().height;
//                    int tbwidth = Math.min(toolBarAccentColor.getPreferredSize().width, ldWidth);
//                    int tby = y + height - tbheight - ldgap;
//                    int tbx = ldx + ((ldWidth - tbwidth) / 2);
//                    toolBarAccentColor.setBounds(tbx, tby, tbwidth, tbheight);
//                }
            }
        }
    }
}
