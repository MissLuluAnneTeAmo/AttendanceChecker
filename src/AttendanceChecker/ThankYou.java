package AttendanceChecker;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

public class ThankYou extends JPanel
{
    JLabel thankYou;
    JLabel infoLabel;
    JButton okButton;
    public ThankYou(boolean isRegistered)
    {
        super();
        initializeComponent();
        if (isRegistered) {
            thankYou = createThankYou("THANK YOU");
            infoLabel = createInfoLabel("Registration confirmed! You're all set for this event");
        }
        else {
            thankYou = createThankYou("You've already responded");
            infoLabel = createInfoLabel("Hey there! Looks like you're already registered for this event. We're excited you can join us!");
        }
        okButton = createOkButton();

        add(thankYou);
        add(infoLabel);
        add(okButton);


    }

    private JButton createOkButton()
    {
        JButton button = new JButton();
        button.setText("OK");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(new Color(0x64CC3C));
        button.setLayout(null);

        FontMetrics metrics = button.getFontMetrics(button.getFont());
        int width =  metrics.stringWidth(button.getText().toUpperCase()) + 20;
        int height = metrics.getHeight();

        button.setSize(new Dimension(width, height));
        button.setLocation((getWidth() - width) / 2, 450);


        return button;

    }

    private JLabel createInfoLabel(String text)
    {
        JLabel label = new JLabel();
        label.setText(text);
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.BOLD, 20));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation((getWidth() - width) / 2, 150);


        return label;
    }

    private JLabel createThankYou(String text)
    {
        JLabel label = new JLabel();
        label.setText(text);
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.PLAIN, 40));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation((getWidth() - width) / 2, 100);


        return label;

    }

    private void initializeComponent()
    {
    }
}
