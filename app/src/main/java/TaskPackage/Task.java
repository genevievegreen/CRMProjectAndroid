package TaskPackage;

public class Task {

    private String desc;
    private boolean isCompleted;

    public Task(String desc) {
        this.desc = desc;
        isCompleted = false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
