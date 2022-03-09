package Components;

public class ContainerElements extends Element {
    private Key behindKey;
    private boolean acquired;

    public ContainerElements(String name, Key behindKey) {
        super(name);
        this.behindKey = behindKey;
        this.acquired = false;
    }
    public Key acquireKey() {
        if (hasKey() && !acquired){
            acquired = true;
            return behindKey;
        }
        else return null;
    }

    public boolean hasKey() {
        return behindKey != null;
    }
}
