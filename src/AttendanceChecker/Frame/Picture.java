package AttendanceChecker.Frame;

import AttendanceChecker.Person;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class Picture extends JFrame {

    JPanel panel;
    JButton start;
    Picture frame = this;


    public Picture() {

        super();
        initializeComponent();
        panel = createContentPanel();
        start = createStartButton();


        add(panel);
        panel.add(start);

        //panel.add(label);


    }

    private JButton createStartButton() {
        JButton button = new JButton();
        button.setBackground(new Color(0x64CC3C));
        button.setText("Start");
        button.setFont(new Font("Open Sans", Font.BOLD, 20));
        button.setForeground(Color.white);
        button.setLayout(null);

        FontMetrics metrics = button.getFontMetrics(button.getFont());
        int width =  metrics.stringWidth(button.getText().toUpperCase()) + 30;
        int height = metrics.getHeight();

        button.setSize(100,50);
        button.setLocation(getWidth() - width - 200, 200);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                EventFrame frame = new EventFrame();
                frame.setVisible(true);
            }
        });
        return button;
    }


    private JPanel createContentPanel() {
        JPanel panel = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                try {
                    Image i = ImageIO.read(Objects.requireNonNull(Person.class.getResourceAsStream("Resources/image1.jpg")));
                    i = i.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                    g.drawImage(i, 0, 0, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        panel.setSize(800, 600);
        panel.setLayout(null);
        panel.setBackground(new Color(243, 191, 191));
        panel.setVisible(true);
        return panel;
    }

    private void initializeComponent() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Picture::new);
    }

}
