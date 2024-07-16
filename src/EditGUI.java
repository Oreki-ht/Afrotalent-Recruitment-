import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EditGUI extends JFrame implements ActionListener
 {
    JTextField searchField;
    JButton sr;
    public static String srTxt;

      public EditGUI()
     {
        setTitle("AFROTALENT: Edit A Record");
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
                      EditPageGUI edp = new EditPageGUI();
                }

                con.close();
                    } 
                catch (Exception fe){System.out.println(fe);}
            }
        }
}


