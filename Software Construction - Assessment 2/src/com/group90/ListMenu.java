
package com.group90;

import com.group90.swing.MenuItem;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class ListMenu<E extends Object> extends JList<E> {
    
    private final DefaultListModel model;
    
    public ListMenu(){
       model = new DefaultListModel();
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer(){
        return new DefaultListCellRenderer(){
           @Override
           public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1){
               ModelMenu data;
               if(o instanceof ModelMenu){
                   data = (ModelMenu) o;
                   
               }else{
                   data = new ModelMenu("",o + "",ModelMenu.MenuType.EMPTY);
               }
               MenuItem item = new MenuItem(data);
               return item;
           }
        }; 
    }
    
}
