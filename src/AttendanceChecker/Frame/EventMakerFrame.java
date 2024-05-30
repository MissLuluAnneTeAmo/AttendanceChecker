package AttendanceChecker.Frame;

import AttendanceChecker.AccountScrollPane;
import AttendanceChecker.EventScrollPane;
import AttendanceChecker.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class EventMakerFrame extends JFrame
{
    EventMakerFrame frame = this;
    private EventScrollPane eventScrollPane;
    public static String directory = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "AttendanceCheckerEvents";
    String eventTitle;
    String eventDesc;
    String eventTime;
    String eventDate;
    JPanel panel;
    JLabel title;
    JLabel titleLabel;
    JLabel descriptionLabel;
    JLabel dateLabel;
    JLabel timeLabel;
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
        pane.setLocation( getWidth() - pane.getWidth() - 30, 100);
        addAccount = createAddAccount();
        createEvent = createCreateEvent();
        titleLabel = createCustomLabel("Title:", 30, 80);
        descriptionLabel = createCustomLabel("Description: ", 30,150);
        dateLabel = createCustomLabel("Date: ",30,380);
        timeLabel = createCustomLabel("Time: ", 230, 380);

        // adding components
        add(panel);
        panel.add(title);
        panel.add(pane);
        panel.add(descriptionField);
        panel.add(timeField);
        panel.add(dateField);
        panel.add(titleField);
        panel.add(addAccount);
        panel.add(createEvent);
        panel.add(titleLabel);
        panel.add(descriptionLabel);
        panel.add(dateLabel);
        panel.add(timeLabel);
        repaint();

    }


    private JLabel createCustomLabel(String s, int x, int y) {
        JLabel label = new JLabel();
        label.setText(s);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();
        label.setSize(new Dimension(width, height));

        label.setLocation(x, y);

        return label;
    }
    private JButton createAddAccount() {
        JButton button = new JButton();
        button.setBackground(new Color(0x64CC3C));
        button.setText("Add Account");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(Color.white);
        button.setLayout(null);

        FontMetrics metrics = button.getFontMetrics(button.getFont());
        int width =  metrics.stringWidth(button.getText().toUpperCase()) + 20;
        int height = metrics.getHeight();

        button.setSize(new Dimension(width, height));
        button.setLocation(getWidth() - width - 95, 60);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountMaker maker = new AccountMaker();
                Person p = maker.showDialog();
                if (p != null) {
                    pane.list.add(p);
                    pane.restore();
                }
            }
        });
        return button;
    }



    private JButton createCreateEvent() {

        JButton button = new JButton();
        button.setBackground(new Color(0x64CC3C));
        button.setText("Create Event");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(Color.white);
        button.setLayout(null);

        FontMetrics metrics = button.getFontMetrics(button.getFont());
        int width =  metrics.stringWidth(button.getText().toUpperCase()) + 20;
        int height = metrics.getHeight();

        button.setSize(new Dimension(width, height));
        button.setLocation(getWidth() - width - 95, 415);
        button.addActionListener(e -> {
            // Assuming all fields are validated and ready to go
            if(!saveEventDetails()) {
                var x = new File(directory).mkdirs();
                var y = new File(directory + File.separator + titleField.getText()).mkdirs();

                try {
                    FileWriter writer = new FileWriter(directory + File.separator + titleField.getText() + File.separator + "EventInfo.csv");
                    writer.write("Event," + titleField.getText() + ",,\n");
                    writer.write("Description," + descriptionField.getText().replace(",", "") + ",,\n");
                    writer.write("Date," + dateField.getText() + ",,\n");
                    writer.write("Time," + timeField.getText() + ",,\n");
                    writer.write("Name,Section,ID number,Passcode\n");
                    for (Person p : pane.list) {
                        writer.write(p.getName() + "," + p.getSection() + "," + p.getId() + "," + p.getCode() + "\n");
                    }
                    writer.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                finally
                {
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "You have successfully made an event");
                    this.dispose();
                }
            }


        });

        return button;

    }

    private boolean saveEventDetails() {
        if (titleField.getText().isEmpty() || descriptionField.getText().isEmpty() || dateField.getText().isEmpty() || timeField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }



    private JTextField createTitleField()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setSize(300, 35);
        field.setFont(new Font("Open Sans", Font.BOLD, 20));
        field.setLocation(30, 100);


        return field;
    }
    private JTextField createDateField()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setSize(100, 30);
        field.setFont(new Font("Open Sans", Font.PLAIN, 15));
        field.setLocation(30, 400);
        return field;
    }
    private JTextField createTimeField()
    {
        JTextField field = new JTextField();
        field.setText("");
        field.setSize(100, 30);
        field.setFont(new Font("Open Sans", Font.PLAIN, 15));
        field.setLocation(230, 400);
        return field;
    }
    private JTextArea createDescription()
    {
        JTextArea area = new JTextArea();
        area.setText("");
        area.setSize(300, 200);
        area.setLineWrap(true);
        area.setFont(new Font("Open Sans", Font.PLAIN, 15));
        area.setLocation(30, 170);
        return area;
    }


    private JLabel createTitle() {
        JLabel label = new JLabel();
        label.setText("Create Event");
        label.setForeground(new Color(0xCC7474));
        label.setFont(new Font("Script MT Bold", Font.BOLD, 50));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();
        label.setSize(new Dimension(width, height));

        label.setLocation(30, 15);

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
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventMakerFrame::new);
    }
}
