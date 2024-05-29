package AttendanceChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountPanel extends JPanel
{
    public static int WIDTH = 325;
    public static int HEIGHT = 100;
    private JLabel name;
    private JLabel id;
    private JLabel password;
    private JButton deleteButton;
    private JButton editButton;
    private JButton savebutton;
    ArrayList<Person> list = new ArrayList<>();
    AccountScrollPane pane;
    public AccountPanel(Person person, AccountScrollPane accountScrollPane, ArrayList<Person> list)
    {
        super();
        this.list=list;
        this.pane = accountScrollPane;
        initializeComponent();
        name = createName(person.getName());
        id = createId(person.getId());
        password = createPassword(person.getCode());
        deleteButton = createDeleteButton(person);
        editButton = createEditButton(person);



        setLocation(200, 200);
        add(name);
        add(id);
        add(password);
        add(deleteButton);
        add(editButton);
        repaint();

    }

    private JButton createEditButton(Person person) {
        JButton button = new JButton();
        button.setText("EDIT");
        button.setFont(new Font ("Open Sans",Font.BOLD,15));
        button.setForeground(Color.black);
        button.setBackground(new Color(0xF6E368));
        button.setSize(100,30);
        button.setLocation(120,70);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditAccountMaker maker = new EditAccountMaker(person);
                Person updatePerson = maker.showDialog();
                if (updatePerson != null){
                    person.setName(updatePerson.getName());
                    person.setSection(updatePerson.getSection());
                    person.setCode(updatePerson.getCode());
                    pane.restore();
                }
            }
        });
        return button;
    }


    private JButton createDeleteButton(Person person) {
        JButton button = new JButton();
        button.setText("DELETE");
        button.setFont(new Font ("Open Sans",Font.BOLD,15));
        button.setForeground(Color.black);
        button.setBackground(new Color(0xffcccc));
        button.setSize(100,30);
        button.setLocation(10,70);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePerson(person, pane);


            }
        });
        return button;
    }


    private void deletePerson(Person person, AccountScrollPane pane) {
        list.remove(person);
        pane.setList(new ArrayList<>(list));
        pane.restore();

    }

    private void initializeComponent()
    {
        setSize(WIDTH, HEIGHT);
        setBackground(new Color(0xffffff));
        setLayout(null);

    }

    private JLabel createPassword(String password)
    {
        JLabel label = new JLabel();
        label.setText("Password: "+ password.charAt(0) + "*****" + password.charAt(password.length() - 1));
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

    private JLabel createId(String id)
    {
        JLabel label = new JLabel();
        label.setText("ID number: " + id);
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

    private JLabel createName(String name)
    {
        JLabel label = new JLabel();
        label.setText("Name: " + name);
        label.setForeground(Color.black);
        label.setFont(new Font("Open Sans", Font.BOLD, 20));
        label.setLayout(null);

        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width =  metrics.stringWidth(label.getText().toUpperCase());
        int height = metrics.getHeight();

        label.setSize(new Dimension(width, height));
        label.setLocation(10, 5);

        return label;
    }
}
