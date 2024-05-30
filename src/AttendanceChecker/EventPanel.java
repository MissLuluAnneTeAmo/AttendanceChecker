package AttendanceChecker;

import AttendanceChecker.Frame.AttendanceFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EventPanel extends JPanel
{
    public static int WIDTH = 600;
    public static int HEIGHT = 150;
    private static String s;
    JLabel title;
    JLabel description;
    JButton login;
    JLabel date;
    JLabel time;
    EventScrollPane pane;

    public EventPanel(Event event)
    {
        super();
        initializeComponent();
        title = createTitle(event.getName());
        description = createDescription(event.getDescription());
        date = createDate(event.getDate());
        time = createTime(event.getTime());
        login = createLogin();

        add(title);
        add(description);
        add(date);
        add(time);
        add(login);
    }


    public static Event createEventFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Extract data from the eventData list and create an Event object
            String title = reader.readLine().split(",")[1];
            String description = reader.readLine().split(",")[1];
            String date = reader.readLine().split(",")[1];
            String time = reader.readLine().split(",")[1];

            reader.readLine(); // skip the thingy...
            ArrayList<Person> eventData = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                // Process each line of the CSV file
                String[] data = line.split(",");
                String name = data[0];
                String section = data[1];
                String id = data[2];
                String passcode = data[3];
                eventData.add(new Person(name, section, id, passcode));
            }

            return new Event(title, description, date, time, eventData);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    private JLabel createTime(String time) {
        JLabel label = new JLabel();
        label.setText("Time: " + time);
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.PLAIN, 15));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(5 , 70);


        return label;
    }

    private JLabel createDate(String date) {
        JLabel label = new JLabel();
        label.setText("Date: " + date);
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.PLAIN, 15));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(5, 50);


        return label;

    }

    private JButton createLogin() {
        JButton button = new JButton();
        button.setText("Log in");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(new Color(0xFFFFFF));
        button.setBackground(new Color(0x64CC3C));
        button.setLayout(null);

        FontMetrics metrics = button.getFontMetrics(button.getFont());
        int width =  metrics.stringWidth(button.getText().toUpperCase()) + 20;
        int height = metrics.getHeight();
        button.setSize(200,30);
        button.setLocation(200, 110);
        button.addActionListener(e -> {
            AttendanceFrame attendanceFrame = new AttendanceFrame();
            attendanceFrame.setVisible(true);
        });
        return button;
    }

    private JLabel createDescription(String description) {
        JLabel label = new JLabel();
        label.setText("Description: \n" + description);
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.PLAIN, 15));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(5, 30);


        return label;

    }

    private JLabel createTitle(String title) {
        JLabel label = new JLabel();
        label.setText("Event: " + title);
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.BOLD, 20));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(5, 5);


        return label;

    }

    private void initializeComponent() {
        setSize(WIDTH, HEIGHT);
        setBorder(new LineBorder(Color.black));
        setBackground(new Color(0xF4A2CB));
        setLayout(null);
    }
}
