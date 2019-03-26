/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;


public class Task {
    
    private final String name;
    private final String desc;
    
    public Task(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
    
    public void viewTask() {
        System.out.println(name + ": " + desc);
    }
}
