import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

public class EditPageGUI extends JFrame implements ActionListener
{
  private JLabel nameLabel, pnoLabel, pexpLabel, birthLabel, statusLabel, medLabel, idLabel, eidLabel, imgLabel, cocLabel, expLabel, phoneLabel, countryLabel, brokerLabel, rdLabel;
  private JTextField nameField, pnoField, pexpField, birthField, phoneField, brokerField;
  private JComboBox statusBox, medBox, idBox, eidBox, imgBox, cocBox, expBox, expCountryBox, expnumbox, countryBox, dayBox, monthBox, yearBox;
  private JButton cancelButton, registerButton;
  private String defname, defpass, defpexp, defbirth, defphone, defbroker;
  private String ep;

  public EditPageGUI(){

    setVisible(true);
    setTitle("AFROTALENT: New Record Entry Page");
    setSize(700,700);
    setLocationRelativeTo(null); 
    setResizable(true);
    setExtendedState(JFrame.MAXIMIZED_BOTH);

    //JPanel pp = new JPanel();
    //add(pp);

    Container pp = getContentPane();
    pp.setLayout(null);
       
    ep = EditGUI.srTxt;
    try{
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1412/afrotalent", "postgres", "conanendou23");
    // create a prepared statement with the query
    PreparedStatement pst = con.prepareStatement("SELECT * FROM intake where passnum = ?");
    // set the parameter for the query
    pst.setString(1, ep);
    // execute the query and get a result set
    ResultSet rs = pst.executeQuery();
    // check if the result set has any row
    if (rs.next()) {
      // get the value of the fullname column and assign it to a variable
      defname = rs.getString("fullname");
      defpass = rs.getString("passnum");
      defbirth = rs.getString("birthdate");
      defpexp = rs.getString("passexpiry");
      defphone = rs.getString("phonenum");
      defbroker = rs.getString("brokername");
    }
// close the connection
con.close();


    }
    catch(Exception fec)
    {
      System.out.println(fec);
    }
    nameLabel = new JLabel("Enter Full Name: ");
    nameField = new JTextField(defname, 20);
    pp.add(nameLabel);
    pp.add(nameField);
    nameLabel.setBounds(340,100,100,50);
    nameField.setBounds(440, 115, 200, 30 );

    pnoLabel = new JLabel("Passport no: ");
    pnoField = new JTextField(defpass, 10);
    pp.add(pnoLabel);
    pp.add(pnoField);
    pnoLabel.setBounds(660, 100, 80, 50);
    pnoField.setBounds(750, 115, 200, 30);

    pexpLabel = new JLabel( "Passport Expiry Date: ");
    pexpField = new JTextField(defpexp, 10);
    pp.add(pexpLabel);
    pp.add(pexpField);
    pexpLabel.setBounds(340, 150, 150, 50);
    pexpField.setBounds(470, 165, 100, 30 );

    birthLabel = new JLabel("Birth Date: ");
    birthField = new JTextField(defbirth, 10);
    pp.add(birthLabel);
    pp.add(birthField);
    birthLabel.setBounds(600, 150, 100, 50);
    birthField.setBounds(670, 165, 100, 30);

    String status[] = {"Single", "Married"};
    String yesno[] = {"Yes", "No"};
    String xyesno[] = {"--", "Yes", "No"};
    String expcounts[] = {"None", "Saudi", "Lebanon", "Sudan", "Qatar", "Kuwait", "UAE", "Jordan", "Bahrain"};
    String nums[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "10+"};
    String countries[] = {"Saudi", "Jordan", "Dubai"};
    String day[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String month[] = {"1","2","3","4","5","6","7","8","9","10","11","12", "13"};
    String year[] = {"2015", "2016", "2017", "2018", "2019"};

    statusLabel = new JLabel("Marital Status: ");
    statusBox = new JComboBox<>(status);
    pp.add(statusLabel);
    pp.add(statusBox);
    statusLabel.setBounds(800, 150, 100, 50);
    statusBox.setBounds(890, 161, 70, 30);

    medLabel = new JLabel("Medical?");
    medBox = new JComboBox<>(yesno);
    pp.add(medLabel);
    pp.add(medBox);
    medLabel.setBounds(340, 200, 100, 50);
    medBox.setBounds(400, 210, 80, 30);

    idLabel = new JLabel("ID?");
    idBox = new JComboBox<>(yesno);
    pp.add(idLabel);
    pp.add(idBox);
    idLabel.setBounds(500, 200, 100, 50);
    idBox.setBounds(530, 210, 80, 30);

    eidLabel = new JLabel("Electronic ID?");
    eidBox = new JComboBox<>(yesno);
    pp.add(eidLabel);
    pp.add(eidBox);
    eidLabel.setBounds(630, 200, 100, 50);
    eidBox.setBounds(720, 210, 80, 30);

    imgLabel = new JLabel("Image?");
    imgBox = new JComboBox<>(yesno);
    pp.add(imgLabel);
    pp.add(imgBox);
    imgLabel.setBounds(820, 200, 100, 50);
    imgBox.setBounds(880, 210, 80, 30);

    cocLabel = new JLabel("COC?");
    cocBox = new JComboBox<>(yesno);
    pp.add(cocLabel);
    pp.add(cocBox);
    cocLabel.setBounds(340, 250, 100, 50);
    cocBox.setBounds(380,260, 80, 30);

    expLabel = new JLabel("Have Experience? ");
    expBox = new JComboBox<>(xyesno);
    pp.add(expLabel);
    pp.add(expBox);
    expLabel.setBounds(470, 250, 120, 50);
    expBox.setBounds(580, 260, 80, 30);

    JLabel expCountryLabel = new JLabel("Experience Country: ");
    expCountryBox = new JComboBox<>(expcounts);
    expnumbox = new JComboBox<>(nums);
    pp.add(expCountryLabel);
    pp.add(expCountryBox);
    pp.add(expnumbox);
    expCountryLabel.setBounds(680, 250, 130, 50);
    expCountryBox.setBounds(800, 260, 80, 30);
    expnumbox.setBounds(900, 260, 80, 30);

    phoneLabel = new JLabel("Phone no: ");
    phoneField = new JTextField(defphone, 10);
    pp.add(phoneLabel);
    pp.add(phoneField);
    phoneLabel.setBounds(340, 300, 100, 50);
    phoneField.setBounds(410, 315, 100, 30);

    countryLabel = new JLabel("Country of Choice: ");
    countryBox = new JComboBox<>(countries);
    pp.add(countryLabel);
    pp.add(countryBox);
    countryLabel.setBounds(530, 300, 150, 50);
    countryBox.setBounds(650, 310, 80, 30);

    brokerLabel = new JLabel("Broker Name: ");
    brokerField = new JTextField(defbroker, 10);
    pp.add(brokerLabel);
    pp.add(brokerField);
    brokerLabel.setBounds(750, 300, 100, 50);
    brokerField.setBounds(840, 310, 140, 30);

    rdLabel = new JLabel("Today's Date: ");
    dayBox = new JComboBox<>(day);
    monthBox = new JComboBox<>(month);
    yearBox = new JComboBox<>(year);
    pp.add(rdLabel);
    pp.add(dayBox);
    pp.add(monthBox);
    pp.add(yearBox);
    rdLabel.setBounds(460, 350, 120, 50);
    dayBox.setBounds(550, 360, 80, 30);
    monthBox.setBounds(640, 360, 80, 30);
    yearBox.setBounds(740, 360, 80, 30);

    registerButton = new JButton("Edit");
    registerButton.setIcon(resizeImageIcon("pics/addd.png", 30, 30));
    pp.add(registerButton);
    registerButton.setBounds(450, 500, 150, 50);
    registerButton.addActionListener(this);

    cancelButton = new JButton("Cancel");
    cancelButton.setIcon(resizeImageIcon("pics/cancel.png", 30, 30));
    pp.add(cancelButton);
    cancelButton.setBounds(700, 500, 150, 50);
    cancelButton.addActionListener(this);

    pp.revalidate();
  }

  public static ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        try {
           BufferedImage image = ImageIO.read(new File(imagePath));
          Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
  }

  @Override
  public void actionPerformed(ActionEvent e) 
  {
    if(e.getSource() == registerButton)
    {

      String name = nameField.getText();
      String passnum = pnoField.getText();
      String passexp = pexpField.getText();
      String birthdate = birthField.getText();
      String martial = (String) statusBox.getSelectedItem();
      String med = (String) medBox.getSelectedItem();
      String iden = (String) idBox.getSelectedItem();
      String eid = (String) eidBox.getSelectedItem();
      String img = (String) imgBox.getSelectedItem();
      String coc = (String) cocBox.getSelectedItem();
      String exp = (String) expBox.getSelectedItem();
      String expcountry = (String) expCountryBox.getSelectedItem();
      String expyears = (String) expnumbox.getSelectedItem();
      String phonenum = phoneField.getText();
      String countrychoice = (String) countryBox.getSelectedItem();
      String brokername = brokerField.getText();
      String tday = (String) dayBox.getSelectedItem();
      String tmonth = (String) monthBox.getSelectedItem();
      String tyear = (String) yearBox.getSelectedItem();

      try
      {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:1412/afrotalent", "postgres", "conanendou23");
        String query = "UPDATE intake SET fullname = ?, passnum = ?, passexpiry = ?, birthdate = ?, martial = ?, med = ?, iden = ?, eid = ?, img = ?, coc = ?, experience = ?, expcountry = ?, expyears = ?, phonenum = ?, countrychoice = ?, brokername = ?, tday = ?, tmonth = ?, tyear = ? WHERE passnum = ?";

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, passnum);
        ps.setString(3, passexp);
        ps.setString(4, birthdate);
        ps.setString(5, martial);
        ps.setString(6, med);
        ps.setString(7, iden);
        ps.setString(8,eid);
        ps.setString(9, img);
        ps.setString(10, coc);
        ps.setString(11, exp);
        ps.setString(12,expcountry);
        ps.setString(13, expyears);
        ps.setString(14, phonenum);
        ps.setString(15, countrychoice);
        ps.setString(16, brokername);
        ps.setString(17, tday);
        ps.setString(18, tmonth);
        ps.setString(19, tyear);
        ps.setString(20, ep);

        ps.executeUpdate();
        ps.close();
        conn.close();
        JOptionPane.showMessageDialog(this, "Edit Performed Successfully!");
        dispose();

      }
      catch(Exception fe){
        System.out.println(fe);
      }
    }
    if(e.getSource() == cancelButton)
    {
      dispose();
      
    }

  }
}