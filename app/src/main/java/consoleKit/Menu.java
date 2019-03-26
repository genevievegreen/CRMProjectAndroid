/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleKit;


import static consoleKit.Console.getChoice;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author abbypetersen
 */
public class Menu implements MenuItem{

    /**
     * @param args the command line arguments
     */
    private final String name;
    private final List<MenuItem> options;
    private MenuStack menus;
    
      // Put menu in a menu stack to support nested menus
    public Menu(String _name, MenuStack _menus) {
        name = _name;
        menus = _menus;
        menus.add(this);
        options = new ArrayList<>();
    }
    
    // add an option
    public void add(MenuItem option) {
        options.add(option);
    }

    // To "execute" a menu, we get the user to choose an option
    // and execute that option
    @Override
    public void execute() {
        options.get(getChoice(options)).execute();
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

