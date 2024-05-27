import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

public class AccountMaker extends JDialog
{
    JTextField name;
    JTextField username;
    JTextField section;
    JTextField code;
    JPanel panel;
    public AccountMaker()
    {
        super();
        initializeComponent();
        panel = createPanel();
        name = createName();
        username = createUsername();
        section = createSection();
        code = createCode();
    }

    private JTextField createName()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);


        field.setSize(225, 30);
        field.setLocation(150, 200);

        return field;
    }

    private JTextField createUsername()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);


        field.setSize(225, 30);
        field.setLocation(150, 200);

        return field;
    }

    private JTextField createSection()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);


        field.setSize(225, 30);
        field.setLocation(150, 200);

        return field;
    }

    private JTextField createCode()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);


        field.setSize(225,30);
        field.setLocation(150, 200);

        return field;

    }


    private JPanel createPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0));
        panel.setLayout(null);
        return panel;
    }

    private void initializeComponent()
    {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setTitle("Create Account");
    }
}
