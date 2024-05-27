import javax.swing.*;
import java.awt.*;

public class EventMakerFrame extends JFrame
{
    EventMakerFrame frame = this;
    String eventTitle;
    String eventDesc;
    String eventTime;
    String eventDate;
    JPanel panel;
    JLabel title;
    JTextField titleField;
    JTextField descriptionField;
    JTextField dateField;
    JTextField timeField;

    public EventMakerFrame()
    {
        super();
        initializeComponent();
        panel = createContentPanel();
        title = createTitle();
        descriptionField = createPasswordField();



        // adding components
        add(panel);
        panel.add(title);
        panel.add(descriptionField);
        repaint();

    }

    private JTextField createPasswordField() {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);

        field.setSize(250, getHeight());
        field.setLocation(150, 260);

        return field;
    }

    private JLabel createTitle() {
        JLabel label = new JLabel();
        label.setText("Welcome to the attendance checker");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation((getWidth() - width) / 2, 50);

        return label;
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setLayout(null);
        panel.setBackground(new Color(243, 191, 191));
        return panel;
    }

    private void initializeComponent() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new EventMakerFrame();
    }
}
