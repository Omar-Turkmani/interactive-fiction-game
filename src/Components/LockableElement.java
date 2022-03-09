package Components;

public abstract class LockableElement extends Element {
    protected boolean isLocked;
    protected Key lockKey;

    public LockableElement(boolean isLocked, String name, Key lockKey) {
        super(name);
        this.isLocked = isLocked;
        this.lockKey = lockKey;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public Key getLockKey() {
        return lockKey;
    }

    public void lock(Key key) {
        if (key.equals(this.lockKey))
            isLocked = true;
    }

    public void unlock(Key key) {
        if (key.equals(this.lockKey))
            isLocked = false;
    }
}
