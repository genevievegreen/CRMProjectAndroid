/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleKit;

/**
 *
 * @author Genevieve
 */
public class ReturnFromMenu implements MenuItem{
     private final String msg;
    private final MenuStack menus;
    
    public ReturnFromMenu(String prevMenuName, MenuStack _menus) {
        msg = "Return to " + prevMenuName;
        menus = _menus;
    }

    @Override
    public void execute() {
        menus.toPreviousMenu();
    }
    
    @Override
    public String toString() {
        return msg;
    }
}
