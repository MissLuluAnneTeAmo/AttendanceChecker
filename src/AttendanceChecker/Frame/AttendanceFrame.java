package AttendanceChecker.Frame;

import javax.swing.*;
import java.awt.*;

public class AttendanceFrame extends JFrame
{
    AttendanceFrame frame = this;
    JPanel panel;
    JLabel title;
    JLabel id;
    JLabel password;
    JLabel sign_in_button;
    JButton sign_in_buttonButton;
    JTextField idField;
    JTextField passwordField;

    public AttendanceFrame()
    {
        super();
        initializeComponent();
        panel = createContentPanel();
        title = createTitle();
        id = createId();
        password = createPassword();
        idField = createIdField();
        passwordField = createPasswordField();
        sign_in_buttonButton = createSign_in_buttonButton();



        // adding components
        add(panel);
        panel.add(title);
        panel.add(id);
        panel.add(password);
        panel.add(idField);
        panel.add(passwordField);
        panel.add(sign_in_buttonButton);

        repaint();

    }

    private JTextField createIdField() {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);


        field.setSize(225, 30);
        field.setLocation((getWidth() - field.getWidth()) / 2 , 180);

        return field;
    }

    private JTextField createPasswordField() {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);

        field.setSize(225, 30);
        field.setLocation((getWidth() - field.getWidth()) / 2 , 240);

        return field;
    }
    private JButton createSign_in_buttonButton() {
        JButton button = new JButton();
        button.setText("Sign in");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(Color.white);
        button.setBackground(new Color(0x64CC3C));
        button.setSize(140,50);
        button.setLocation((getWidth() - button.getWidth()) / 2 , 315);
        button.setLayout(null);

        return button;
    }

    private JLabel createTitle() {
        JLabel label = new JLabel();
        label.setText("Log in");
        label.setForeground(new Color(0xC16B6B));
        label.setFont(new Font("Script MT Bold", Font.BOLD, 50));
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
        label.setFont(new Font("Open Sans", Font.PLAIN, 15));
        label.setLayout(null);



        label.setSize(150,150);
        label.setLocation(137,155);

        return label;
    }

    private JLabel createId() {
        JLabel label = new JLabel();
        label.setText("ID number");
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.PLAIN, 15));
        label.setLayout(null);


        label.setSize(150,150);
        label.setLocation(137, 95);

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
        new AttendanceFrame();
    }
}
