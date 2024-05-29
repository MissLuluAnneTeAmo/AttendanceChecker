package AttendanceChecker.Frame;

import AttendanceChecker.Person;

import javax.swing.*;
import java.awt.*;

public class AccountMaker extends JDialog
{
    JTextField name;
    JTextField id;
    JTextField section;
    JTextField code;
    JPanel panel;
    JLabel nameLabel;
    JLabel usernameLabel;
    JLabel sectionLabel;
    JLabel codeLabel;
    JButton ok;
    public AccountMaker()
    {
        super();
        initializeComponent();
        panel = createPanel();
        name = createName();
        id = createId();
        section = createSection();
        code = createCode();
        nameLabel =  createCustomLabel("Name: ", 40);
        usernameLabel =  createCustomLabel("ID number:", 100);
        sectionLabel =  createCustomLabel("College: " , 160);
        codeLabel = createCustomLabel("Password:" , 220);
        ok = createOk();

        add(panel);
        panel.add(name);
        panel.add(id);
        panel.add(section);
        panel.add(code);
        panel.add(nameLabel);
        panel.add(usernameLabel);
        panel.add(sectionLabel);
        panel.add(codeLabel);
        panel.add(ok);
    }
    private JButton createOk(){
        JButton button = new JButton();
        button.setBackground(new Color(0x64CC3C));
        button.setText("Add Account");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(Color.white);
        button.setLayout(null);
        button.setSize(200, 30);
        button.setLocation(150, 290);
        button.addActionListener(e ->
        {
            dispose();
        });
        return button;
    }
    private JLabel createCustomLabel(String s, int y) {
        JLabel label = new JLabel();
        label.setText(s);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();
        label.setSize(new Dimension(width, height));

        label.setLocation(150, y);

        return label;
    }

    private JTextField createName()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);

        field.setSize(new Dimension(200, 30));
        field.setLocation((getWidth() - field.getWidth())/2,60);
        return field;
    }

    private JTextField createId()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);

        field.setSize(new Dimension(200, 30));
        field.setLocation((getWidth() - field.getWidth())/2,120);

        return field;
    }

    private JTextField createSection()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);

        field.setSize(new Dimension(200, 30));
        field.setLocation((getWidth() - field.getWidth())/2,180);

        return field;
    }

    private JTextField createCode()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setLayout(null);

        field.setSize(new Dimension(200, 30));
        field.setLocation((getWidth() - field.getWidth())/2,240);

        return field;

    }


    private JPanel createPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xFFFFFF));
        panel.setLayout(null);
        return panel;
    }

    private void initializeComponent()
    {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setTitle("Create Account");
    }

    public Person showDialog() {
        setVisible(true);
        return new Person(name.getText(), section.getText(), id.getText(), code.getText());
    }
}
