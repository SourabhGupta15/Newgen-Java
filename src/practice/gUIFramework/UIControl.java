package practice.gUIFramework;

public abstract class UIControl {
    private boolean isEnabled = true;

    // public UIControl(boolean isEnabled) {
    //     this.isEnabled = isEnabled;
    //     // System.out.println("UIControl");
    // }

    public abstract void render();

    public void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
