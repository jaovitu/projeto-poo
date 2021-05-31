import javax.swing.*;

public abstract class Screen extends JFrame {

    private final int height;
    private final String title;
    private final int width;
    private final boolean isDefaultVisible;

    public Screen(String title, int height, int width, boolean isDefaultVisible) {
        this.height = height;
        this.width = width;
        this.title = title;
        this.isDefaultVisible = isDefaultVisible;

        generalConfigs();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getWidth() {
        return width;
    }

    protected void generalConfigs() {
        this.setSize(this.getWidth(), this.getHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(isDefaultVisible) {
            this.setVisible(true);
        }
    }

    static public void changeScreen(Screen from, Screen to) {
        from.setVisible(false);
        to.setVisible(true);
    }
}
