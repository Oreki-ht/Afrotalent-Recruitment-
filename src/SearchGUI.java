import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchGUI extends JFrame implements ActionListener
 {
    JTextField searchField;
    JButton sr;
    public String srTxt;
    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    public SearchGUI()
     {
        setTitle("AFROTALENT: Search Records");
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setLocationRelativeTo(null);

        // Create a label with the search message
        JLabel searchLabel = new JLabel("Search By Passport Number:");
        searchLabel.setHorizontalAlignment(JLabel.RIGHT);

        // Add the label to the window
        add(searchLabel);

        // Create a text field for entering values
        searchField = new JTextField(20);
        add(searchField);

        sr = new JButton("Search ");
        add(sr);

        setSize(300, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        addActionEvent();
    }

        public void addActionEvent()
        {
            sr.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == sr)
            {
              srTxt = searchField.getText();
                try
                {
                    Class.forName("org.postgresql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1412/afrotalent", "postgres", "conanendou23");
                    String query = "SELECT * FROM intake";
                    PreparedStatement statement = con.prepareStatement(query);
                    ResultSet rs = statement.executeQuery();

                    boolean matchFound = false;
                    while(rs.next())
                    {
                        String searched = rs.getString("passnum");
                        if(srTxt.equals(searched))
                        {
                            JOptionPane.showMessageDialog(null, "Found");
                            matchFound = true;
                            dispose();
                            break;  
                        }
                    }
                    if(!matchFound)
                    {
                        JOptionPane.showMessageDialog(null, "Failure");
                    }

                    if (matchFound) {
                    JFrame frame = new JFrame();
                    frame.setTitle("Found Record");

                    JPanel panel = new JPanel(new BorderLayout());
                    frame.add(panel);

                    String[] columns = {"fullname", "passnum", "passexpiry", "birthdate", "martial", "med", "iden", "eid", "img", "coc", "experience", "expcountry", "expyears", "phonenum", "countrychoice", "brokername", "tday", "tmonth", "tyear"};
                    model.setColumnIdentifiers(columns);

                    String name = rs.getString("fullname");
                    String passnum = rs.getString("passnum");
                    String passexp = rs.getString("passexpiry");
                    String birthdate = rs.getString("birthdate");
                    String martial = rs.getString("martial");
                    String med = rs.getString("med");
                    String iden = rs.getString("iden");
                    String eid = rs.getString("eid");
                    String img = rs.getString("img");
                    String coc = rs.getString("coc");
                    String exp = rs.getString("experience");
                    String expcountry = rs.getString("expcountry");
                    String expyears = rs.getString("expyears");
                    String phonenum = rs.getString("phonenum");
                    String countrychoice = rs.getString("countrychoice");
                    String brokername = rs.getString("brokername");
                    String tday = rs.getString("tday");
                    String tmonth = rs.getString("tmonth");
                    String tyear = rs.getString("tyear");

                    Object[] row = {name, passnum, passexp, birthdate, martial, med, iden, eid, img, coc, exp, expcountry, expyears, phonenum, countrychoice, brokername, tday, tmonth, tyear};
                    model.addRow(row);
                    table.setModel(model);

                    panel.add(new JScrollPane(table), BorderLayout.CENTER);
                    table.getColumnModel().getColumn(0).setPreferredWidth(200);
                    table.getColumnModel().getColumn(1).setPreferredWidth(100);
                    table.getColumnModel().getColumn(2).setPreferredWidth(100);
                    table.getColumnModel().getColumn(3).setPreferredWidth(100);
                    table.getColumnModel().getColumn(5).setPreferredWidth(50);
                    table.getColumnModel().getColumn(6).setPreferredWidth(50);
                    table.getColumnModel().getColumn(7).setPreferredWidth(50);
                    table.getColumnModel().getColumn(8).setPreferredWidth(50);
                    table.getColumnModel().getColumn(9).setPreferredWidth(50);
                    table.getColumnModel().getColumn(10).setPreferredWidth(50);
                    table.getColumnModel().getColumn(12).setPreferredWidth(70);
                    table.getColumnModel().getColumn(13).setPreferredWidth(120);
                    table.getColumnModel().getColumn(15).setPreferredWidth(150);
                    table.getColumnModel().getColumn(16).setPreferredWidth(50);
                    table.getColumnModel().getColumn(17).setPreferredWidth(50);
                    table.getColumnModel().getColumn(18).setPreferredWidth(50);

                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    frame.setSize(500, 500);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setUndecorated(true);
                }

                con.close();
                    } 
                catch (Exception fe){System.out.println(fe);}
            }
        }
}


