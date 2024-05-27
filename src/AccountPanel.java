import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class AccountPanel extends JPanel
{
    public static int WIDTH = 250;
    public static int HEIGHT = 75;
    private JLabel name;
    private JLabel username;
    private JLabel password;
    public AccountPanel(Person person)
    {
        super();
        initializeComponent();
        name = createName();
        username = createUsername();
        password = createPassword();

        setLocation(200, 200);
        add(name);
        add(username);
        add(password);

        repaint();

    }

    private void initializeComponent()
    {
        setSize(WIDTH, HEIGHT);
        setBackground(new Color(0xffffff));
        setLayout(null);
    }

    private JLabel createPassword()
    {
        JLabel label = new JLabel();
        label.setText("Password: ");
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.PLAIN, 15));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(10, 50);

        return label;
    }

    private JLabel createUsername()
    {
        JLabel label = new JLabel();
        label.setText("Username: ");
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.PLAIN, 15));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(10,30);

        return label;
    }

    private JLabel createName()
    {
        JLabel label = new JLabel();
        label.setText("Name: ");
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.BOLD, 25));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(10, 5);

        return label;
    }
}
