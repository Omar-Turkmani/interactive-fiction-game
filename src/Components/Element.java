package Components;

public abstract class Element {
    protected String name;

    public Element( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
