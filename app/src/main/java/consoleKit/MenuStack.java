/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleKit;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 *
 * @author abbypetersen
 */
public class MenuStack {
       private final Deque<Menu> menus;

    public MenuStack() {
        menus = new ArrayDeque<>();
    }

    public Menu getCurrent() {
        return menus.getFirst();
    }

    public void add(Menu menu) {
        menus.addFirst(menu);
    }
    
    public void toPreviousMenu() {
        menus.removeFirst();
    }
    
    public void run() {
        menus.getFirst().execute();
    }
}
