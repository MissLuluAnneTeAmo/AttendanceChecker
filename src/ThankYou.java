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
    public ThankYou()
    {
        super();
        initializeComponent();
        thankYou = createThankYou();
        infoLabel = createInfoLabel();
        okButton = createOkButton();


    }

    private JButton createOkButton()
    {
        JButton button = new JButton();
        button.setText("OK");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(new Color(0x64CC3C));
        button.setLocation(175, 315);
        button.setSize(150,50);
        button.setLayout(null);

        return button;

    }

    private JLabel createInfoLabel()
    {
        JLabel label = new JLabel();
        label.setText(" ");
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

    private JLabel createThankYou()
    {
    }

    private void initializeComponent()
    {
    }

    // you already responded...
    public ThankYou(int x)
    {

    }
}
