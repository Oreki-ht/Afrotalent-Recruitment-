import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class WelcomeGUI extends JFrame implements ActionListener{
    private JLabel welcomeLabel;    
    private JButton enterButton, viewButton, searchButton, sortButton, editButton, deleteButton;
    
    public WelcomeGUI() 
        {    
            // Set frame properties
        setTitle("Afrotalent Intake Program");      
        setLayout(new BorderLayout());    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeLabel = new JLabel("--- Welcome To AfroTalent Intake Program ---");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));    
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        ImageIcon imageIcon = new ImageIcon("pics/logo.jpg");
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        enterButton = new JButton("Enter new record:");
        enterButton.addActionListener(this);
        enterButton.setIcon(resizeImageIcon("pics/entnew.jpg", 50, 50));

        viewButton = new JButton("View all: "); 
        viewButton.addActionListener(this);
        viewButton.setIcon(resizeImageIcon("pics/viewall.png", 50, 50));

        searchButton=new JButton("Search:");   
        searchButton.addActionListener(this); 
        searchButton.setIcon(resizeImageIcon("pics/search.png", 50, 50));

        sortButton=new JButton("Sort:");   
        sortButton.addActionListener(this); 
        sortButton.setIcon(resizeImageIcon("pics/sort.png", 50, 50));

        editButton = new JButton("Edit:");
        editButton.addActionListener(this);
        editButton.setIcon(resizeImageIcon("pics/edit.png", 50, 50));

        deleteButton = new JButton("Delete: ");
        deleteButton.addActionListener(this);

         // Add buttons to a panel and set panel to the south        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(enterButton);        
        //UserButton.addActionListner(this);
        buttonPanel.add(viewButton);
        add(imageLabel, BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(searchButton);  
        buttonPanel.add(sortButton); 
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
        // Set frame visibility
        setLocationRelativeTo(null);       
        setVisible(true);
        setSize(700,700);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()== enterButton)
            {
                NewGUI newgui = new NewGUI();  
            }    

            if(e.getSource()== viewButton)
            {
                ViewAllGUI vall = new ViewAllGUI();
            }
            
            if(e.getSource()== searchButton)
            {
                SearchGUI srch = new SearchGUI();
            }

            if(e.getSource()== sortButton)
            {
                SortGUI srt = new SortGUI();
            }

            if(e.getSource()== editButton)
            {
                EditGUI edt = new EditGUI();
            }

            if(e.getSource()== deleteButton)
            {
                DeleteGUI dlt = new DeleteGUI();
            }
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

}