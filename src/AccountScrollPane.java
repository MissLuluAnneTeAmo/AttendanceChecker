import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class AccountScrollPane extends JScrollPane
{
    private JPanel container;
    private int size;
    ArrayList<Person> list;

    /**<editor-fold desc="Description">
     * citation: <a href="https://github.com/iid3rp/Pabunot/blob/main/src/pabunot/prize/PrizeListPane.java">pabunot</a>
     *</editor-fold>
     * */
    public AccountScrollPane(ArrayList<Person> list)
    {
        super();
        size = 0;
        this.list = list;
        initializeComponent();
        container.setSize(new Dimension(AccountPanel.WIDTH, ((AccountPanel.HEIGHT * list.size()) + list.size())));
        container.setPreferredSize(new Dimension(AccountPanel.WIDTH, ((AccountPanel.HEIGHT) * list.size()) + size));
        // add components into the container here :3
        addComponents();


        setBorder(new LineBorder(Color.black));
        setViewportView(container);
        getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        getViewport().setOpaque(false);
        getVerticalScrollBar().setVisible(false);
        getHorizontalScrollBar().setVisible(false);
        setSize(new Dimension(AccountPanel.WIDTH, 300));
        setDoubleBuffered(true);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setVisible(true);

        addMouseWheelListener(e ->
        {
            // Increase scroll sensitivity by multiplying the scroll distance
            double unitsToScroll = e.getWheelRotation() * e.getScrollAmount() * 5; // Adjust multiplier as needed
            JScrollBar verticalScrollBar = getVerticalScrollBar();
            verticalScrollBar.setValue((int) (verticalScrollBar.getValue() + unitsToScroll));
        });
    }

    public void initializeComponent()
    {
        // add a container to put stuff :3
        container = new JPanel();
        container.setLayout(null);
        container.setLocation(0, 0);
        container.setOpaque(false);
        setBackground(new Color(255, 255, 255, 60));
        setOpaque(true);
        container.setDoubleBuffered(true);
    }

    public void addComponents()
    {
        int index = 0; // iterator
        if(list != null)
        {
            for(Person p : list)
            {
                AccountPanel bankInterface = new AccountPanel(p);
                bankInterface.setBounds(0, (AccountPanel.HEIGHT * index++), bankInterface.getWidth(), bankInterface.getHeight());
                container.add(bankInterface);
            }
            container.repaint();
            repaint();
        }
    }

    public void restore()
    {
        container.removeAll();
        container.setSize(new Dimension(AccountPanel.WIDTH, (AccountPanel.HEIGHT * list.size()) + (list. size())));
        container.setPreferredSize(new Dimension(AccountPanel.WIDTH, (AccountPanel.HEIGHT * list.size()) + (list.size())));
        // add the components to the panel to be put into the scrollPane...
        addComponents();
        setViewportView(container);
        container.repaint();
        container.validate();
        repaint();
        validate();

    }

    @Deprecated
    public JScrollPane getPane()
    {
        return this;
    }

    @Deprecated
    public int getLength()
    {
        return size;
    }

    @Deprecated
    public void setSize(int size)
    {
        this.size = size;
    }
}

