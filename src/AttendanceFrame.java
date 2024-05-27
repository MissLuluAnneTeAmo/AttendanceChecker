import javax.swing.*;
import java.awt.*;

public class AttendanceFrame extends JFrame
{
    AttendanceFrame frame = this;
    JPanel panel;
    JLabel title;
    JLabel username;
    JLabel password;
    JLabel sign_in_button;
    JButton sign_in_buttonButton;
    JTextField usernameField;
    JTextField passwordField;

    public AttendanceFrame()
    {
        super();
        initializeComponent();
        panel = createContentPanel();
        title = createTitle();
        username = createUsername();
        password = createPassword();
        usernameField = createUsernameField();
        passwordField = createPasswordField();
        sign_in_buttonButton = createSign_in_buttonButton();



        // adding components
        add(panel);
        panel.add(title);
        panel.add(username);
        panel.add(password);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(sign_in_buttonButton);

        repaint();

    }

    private JTextField createUsernameField() {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);


        field.setSize(225, username.getHeight());
        field.setLocation(150, 200);

        return field;
    }

    private JTextField createPasswordField() {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);

        field.setSize(225, password.getHeight());
        field.setLocation(150, 260);

        return field;
    }
    private JButton createSign_in_buttonButton() {
        JButton button = new JButton();
        button.setText("Sign in");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(Color.white);
        button.setLocation(175, 315);
        button.setSize(150,50);
        button.setLayout(null);

        return button;
    }

    private JLabel createTitle() {
        JLabel label = new JLabel();
        label.setText("Sign in as Student");
        label.setForeground(Color.black);
        label.setFont(new Font("Futura", Font.BOLD, 30));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation((getWidth() - width) / 2, 50);

        return label;
    }


    private JLabel createPassword() {
        JLabel label = new JLabel();
        label.setText("Password");
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.BOLD, 20));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(30, 260);

        return label;
    }

    private JLabel createUsername() {
        JLabel label = new JLabel();
        label.setText("Username");
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.BOLD, 20));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(30, 200);

        return label;
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255));
        return panel;
    }

    private void initializeComponent() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AttendanceFrame();
    }
}
