import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sort2GUI extends JFrame {
    private JTable table;
    public Sort2GUI() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1412/afrotalent", "postgres", "conanendou23");
            Statement stmt = con.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT * FROM intake WHERE tmonth = '" + SortGUI.sortedmonth1 + "' AND tyear = '" + SortGUI.sortedyear1 + "' ORDER BY tday ASC");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            DefaultTableModel model = new DefaultTableModel();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }
            model.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }
            table = new JTable(model);
            add(new JScrollPane(table));

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

            table.setAutoCreateRowSorter(true);
            pack();
            setTitle("AFROTALENT: All Records");
            setVisible(true);
            setSize(1000,1000);
            setLocationRelativeTo(null);
            setResizable(true);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
