import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListContacts extends JFrame {
    private JTable table;
    private DefaultTableModel dtm;
    private JButton sortname;
    private JButton sortsalary;
    private JButton sortbday;

    ListContacts() {
        setSize(600, 500);
        setTitle("View Customer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("List Contacts");
        title.setFont(new Font("", 1, 35));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(38, 166, 154));
        title.setForeground(Color.WHITE);
        add("North", title);

        String[] column = {"Contact ID", "Name", "Phone", "Company Name", "Salary", "Birthday"};
        dtm = new DefaultTableModel(column, 0);
        table = new JTable(dtm);
        JScrollPane Scroll = new JScrollPane(table);
        add("Center", Scroll);

        JPanel buttonpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonpanel.setBackground(new Color(224, 242, 241));

        sortname = new JButton("List By Name");
        sortname.setFont(new Font("", 1, 15));
        sortname.setBackground(new Color(38, 166, 154));
        sortname.setForeground(Color.WHITE);
        sortname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dtm.setRowCount(0);
                Contact[] contact = new Management().SortByName();
                for (Contact value : contact) {
                    Object[] rowData = {value.getId(), value.getName(), value.getPhone(), value.getCompany(), value.getSalary(), value.getBday()};
                    dtm.addRow(rowData);
                }
            }
        });
        buttonpanel.add(sortname);

        sortsalary = new JButton("List By Salary");
        sortsalary.setFont(new Font("", 1, 15));
        sortsalary.setBackground(new Color(38, 166, 154));
        sortsalary.setForeground(Color.WHITE);
        sortsalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dtm.setRowCount(0);
                Contact[] contact = new Management().SortBySalary();
                for (Contact value : contact) {
                    Object[] rowData = {value.getId(), value.getName(), value.getPhone(), value.getCompany(), value.getSalary(), value.getBday()};
                    dtm.addRow(rowData);
                }
            }
        });
        buttonpanel.add(sortsalary);

        sortbday = new JButton("List By Birthday");
        sortbday.setFont(new Font("", 1, 15));
        sortbday.setBackground(new Color(38, 166, 154));
        sortbday.setForeground(Color.WHITE);
        sortbday.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dtm.setRowCount(0);
                Contact[] contact = new Management().SortBybday();
                for (Contact value : contact) {
                    Object[] rowData = {value.getId(), value.getName(), value.getPhone(), value.getCompany(), value.getSalary(), value.getBday()};
                    dtm.addRow(rowData);
                }
            }
        });
        buttonpanel.add(sortbday);

        add("South", buttonpanel);
    }

}
