import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SortGUI extends JFrame implements ActionListener
 {
    JButton srd, srm;
    JComboBox tdayBox, tmonthBox, tyearBox;
    static public String sortedday;
    static public String sortedmonth;
    static public String sortedyear;
    static public String sortedmonth1;
    static public String sortedyear1;

    private JTable table;    
    public SortGUI()
     {
        String day[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String month[] = {"1","2","3","4","5","6","7","8","9","10","11","12", "13"};
        String year[] = {"2015", "2016", "2017", "2018", "2019"};
        setTitle("AFROTALENT: Sort Records");
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setLocationRelativeTo(null);

        // Create a label with the search message
        JLabel searchLabel = new JLabel("Sort:");
        searchLabel.setHorizontalAlignment(JLabel.RIGHT);

        // Add the label to the window
        add(searchLabel);

        // Create a text field for entering values
        tdayBox = new JComboBox<>(day);
        add(tdayBox);

        tmonthBox = new JComboBox<>(month);
        add(tmonthBox);

        tyearBox = new JComboBox<>(year);
        add(tyearBox);

        srd = new JButton("Sort by day");
        add(srd);

        srm = new JButton("Sort by month: ");
        add(srm);

        setSize(300, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        addActionEvent();
    }

        public void addActionEvent()
        {
            srd.addActionListener(this);
            srm.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == srd)
            {
                sortedday = (String) tdayBox.getSelectedItem();
                sortedmonth = (String) tmonthBox.getSelectedItem();
                sortedyear = (String) tyearBox.getSelectedItem();
                Sort1GUI sd = new Sort1GUI();
            } 
            if(e.getSource()== srm)
            {
                sortedmonth1 = (String) tmonthBox.getSelectedItem();
                sortedyear1 = (String) tyearBox.getSelectedItem();
                Sort2GUI sm = new Sort2GUI();
            }
        } 
}


