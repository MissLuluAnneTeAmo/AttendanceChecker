import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.util.ArrayList;

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
    JTextArea descriptionField;
    JTextField dateField;
    JTextField timeField;
    JScrollPane accountPane;
    JButton createEvent;
    JButton addAccount;
    AccountScrollPane pane;

    public EventMakerFrame()
    {
        super();
        initializeComponent();
        panel = createContentPanel();
        title = createTitle();
        titleField = createTitleField();
        descriptionField = createDescription();
        timeField = createTimeField();
        dateField = createDateField();
        pane = new AccountScrollPane(new ArrayList<>());
        pane.setLocation(200, 50);

        // adding components
        add(panel);
        panel.add(title);
        panel.add(pane);
        panel.add(descriptionField);
        repaint();

    }


    private JTextField createTitleField()
    {
        JTextField field = new JTextField();
        field.setSize(200, 30);
        field.setFont(new Font("Open Sans", Font.BOLD, 20));
        field.setLocation(10, 50);
        return field;
    }
    private JTextField createDateField()
    {
        JTextField field = new JTextField();
        field.setSize(120, 30);
        field.setFont(new Font("Open Sans", Font.BOLD, 20));
        field.setLocation(10, 240);
        return field;
    }
    private JTextField createTimeField()
    {
        JTextField field = new JTextField();
        field.setSize(100, 30);
        field.setFont(new Font("Open Sans", Font.BOLD, 20));
        field.setLocation(150, 240);
        return field;
    }
    private JTextArea createDescription()
    {
        JTextArea area = new JTextArea();
        area.setSize(200, 100);
        area.setLineWrap(true);
        area.setFont(new Font("Open Sans", Font.BOLD, 20));
        area.setLocation(10, 120);
        return area;
    }


    private JLabel createTitle() {
        JLabel label = new JLabel();
        label.setText("Create Event");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation((getWidth() - width) / 2, 30);

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
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventMakerFrame::new);
    }
}
