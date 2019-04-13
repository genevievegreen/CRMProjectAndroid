package TaskPackage;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> list;

    public TaskList() {
        list = new ArrayList<Task>();
    }

    public void addTask(Task x) {
        list.add(x);
    }

    public void deleteTask(int position) {
        list.remove(position);
    }

    public String get(int position) {
        return list.get(position).getDesc();
    }

    public int size() {
        return list.size();
    }

}
