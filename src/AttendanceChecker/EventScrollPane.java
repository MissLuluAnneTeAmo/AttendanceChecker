package AttendanceChecker;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class EventScrollPane extends JScrollPane
{
    private JPanel container;
    private int size;
    public ArrayList<Event> list;

    /**<editor-fold desc="Description">
     * citation: <a href="https://github.com/iid3rp/Pabunot/blob/main/src/pabunot/prize/PrizeListPane.java">pabunot</a>
     *</editor-fold>
     * */
    public EventScrollPane()
    {
        super();
        size = 0;
        this.list = new ArrayList<>();
        initializeComponent();
        container.setSize(new Dimension(EventPanel.WIDTH, ((EventPanel.HEIGHT * list.size()) + list.size())));
        container.setPreferredSize(new Dimension(EventPanel.WIDTH, ((EventPanel.HEIGHT) * list.size()) + size));
        // add components into the container here :3
        addComponents(list);


        setBorder(new LineBorder(Color.black));
        setViewportView(container);
        getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        getViewport().setOpaque(false);
        getVerticalScrollBar().setVisible(false);
        getHorizontalScrollBar().setVisible(false);
        setSize(new Dimension(EventPanel.WIDTH, 400));
        setPreferredSize(new Dimension(EventPanel.WIDTH, 400));
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

    public void setList(ArrayList<Event> newList) {
        this.list = newList;
        restore();
    }
    public void initializeComponent()
    {
        // add a container to put stuff :3
        container = new JPanel();
        container.setLayout(null);
        container.setLocation(0, 0);
        container.setOpaque(false);
        setBackground(new Color(244, 121, 172, 160));
        setOpaque(true);
        container.setDoubleBuffered(true);
    }

    public void restore() {
        container.removeAll();
        // Create a copy of the list to avoid modification issues
        ArrayList<Event> copyList = new ArrayList<>(list);
        container.setSize(new Dimension(EventPanel.WIDTH, (EventPanel.HEIGHT * copyList.size()) + (copyList.size())));
        container.setPreferredSize(new Dimension(EventPanel.WIDTH, (EventPanel.HEIGHT * copyList.size()) + (copyList.size())));
        // Add components based on the copied list
        addComponents(copyList);
        setViewportView(container);
        container.repaint();
        container.validate();
        repaint();
        validate();
    }

    private void addComponents(ArrayList<Event> copyList) {
        int index = 0;
        if (copyList != null) {
            for (Event e : copyList) {
                EventPanel eventPanel = new EventPanel(e); // Pass the list here
                eventPanel.setBounds(0, (EventPanel.HEIGHT * index++), eventPanel.getWidth(), eventPanel.getHeight());
                container.add(eventPanel);
            }
        }
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


