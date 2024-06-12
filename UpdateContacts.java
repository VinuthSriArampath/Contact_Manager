import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateContacts extends JFrame {
    private String gotID;
    private String gotName;
    private String gotPhone;
    private String gotCompany;
    private String gotSalary;
    private String gotBday;

    private JLabel txtid;
    private JTextField txtname;
    private JTextField txtphone;
    private JTextField txtcompany;
    private JTextField txtsalary;
    private JTextField txtbday;

    UpdateContacts() {
        setSize(500, 500);
        setTitle("Update Customer Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel Top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Top.setBackground(new Color(38, 166, 154));
        JLabel heading = new JLabel("Update Contacts");
        heading.setFont(new Font("",1, 35));
        heading.setForeground(Color.WHITE); // Heading text color
        Top.add(heading);

        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setBackground(new Color(224, 242, 241));
        GridBagConstraints gbc = new GridBagConstraints();

        JTextField searchby = new JTextField("", 15);
        searchby.setFont(new Font("", 0, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 0);
        searchPanel.add(searchby, gbc);
        JButton search = new JButton("Search");
        search.setFont(new Font("", Font.BOLD, 20));
        search.setBackground(new Color(38, 166, 154));
        search.setForeground(Color.WHITE);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = new Management().search(searchby.getText());
                if (index >= 0) {
                    gotID = Mainform.customerList.get(index).getId();
                    gotName = Mainform.customerList.get(index).getName();
                    gotPhone = Mainform.customerList.get(index).getPhone();
                    gotCompany = Mainform.customerList.get(index).getCompany();
                    gotSalary = String.valueOf(Mainform.customerList.get(index).getSalary());
                    gotBday = Mainform.customerList.get(index).getBday();

                    txtid.setText(gotID);
                    txtname.setText(gotName);
                    txtphone.setText(gotPhone);
                    txtcompany.setText(gotCompany);
                    txtsalary.setText(gotSalary);
                    txtbday.setText(gotBday);
                } else {
                    JOptionPane.showMessageDialog(null, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 0);
        searchPanel.add(search, gbc);

        JPanel TopPanel = new JPanel(new BorderLayout());
        TopPanel.add("North", Top);
        TopPanel.add("South", searchPanel);

        add("North", TopPanel);

        JPanel Displayl = new JPanel(new GridLayout(6, 2));
        Displayl.setBackground(new Color(224, 242, 241));

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("",1, 20));
        lblid.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblidpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblidpanel.setBackground(new Color(224, 242, 241));
        lblidpanel.add(lblid);
        Displayl.add(lblidpanel);

        txtid = new JLabel(gotID);
        txtid.setFont(new Font("",1, 20));
        JPanel txtidpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtidpanel.setBackground(new Color(224, 242, 241));
        txtidpanel.add(txtid);
        Displayl.add(txtidpanel);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("",1, 20));
        lblname.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblnamepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblnamepanel.setBackground(new Color(224, 242, 241));
        lblnamepanel.add(lblname);
        Displayl.add(lblnamepanel);

        txtname = new JTextField(gotName, 10);
        txtname.setFont(new Font("",1, 20));
        JPanel txtnamepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtnamepanel.setBackground(new Color(224, 242, 241));
        txtnamepanel.add(txtname);
        Displayl.add(txtnamepanel);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setFont(new Font("",1, 20));
        lblphone.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblphonepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblphonepanel.setBackground(new Color(224, 242, 241));
        lblphonepanel.add(lblphone);
        Displayl.add(lblphonepanel);

        txtphone = new JTextField(gotPhone, 10);
        txtphone.setFont(new Font("",1, 20));
        JPanel txtphonepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtphonepanel.setBackground(new Color(224, 242, 241));
        txtphonepanel.add(txtphone);
        Displayl.add(txtphonepanel);

        JLabel lblcompany = new JLabel("Company");
        lblcompany.setFont(new Font("",1, 20));
        lblcompany.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblcompanypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblcompanypanel.setBackground(new Color(224, 242, 241));
        lblcompanypanel.add(lblcompany);
        Displayl.add(lblcompanypanel);

        txtcompany = new JTextField(gotCompany, 10);
        txtcompany.setFont(new Font("",1, 20));
        JPanel txtcompanypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtcompanypanel.setBackground(new Color(224, 242, 241));
        txtcompanypanel.add(txtcompany);
        Displayl.add(txtcompanypanel);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setFont(new Font("",1, 20));
        lblsalary.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblsalarypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblsalarypanel.setBackground(new Color(224, 242, 241));
        lblsalarypanel.add(lblsalary);
        Displayl.add(lblsalarypanel);

        txtsalary = new JTextField(gotSalary, 10);
        txtsalary.setFont(new Font("",1, 20));
        JPanel txtsalarypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtsalarypanel.setBackground(new Color(224, 242, 241));
        txtsalarypanel.add(txtsalary);
        Displayl.add(txtsalarypanel);

        JLabel lblbday = new JLabel("Birthday");
        lblbday.setFont(new Font("",1, 20));
        lblbday.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblbdaypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblbdaypanel.setBackground(new Color(224, 242, 241));
        lblbdaypanel.add(lblbday);
        Displayl.add(lblbdaypanel);

        txtbday = new JTextField(gotBday, 10);
        txtbday.setFont(new Font("",1, 20));
        JPanel txtbdaypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtbdaypanel.setBackground(new Color(224, 242, 241));
        txtbdaypanel.add(txtbday);
        Displayl.add(txtbdaypanel);

        add("Center", Displayl);

        JPanel ButtonPanel = new JPanel(new BorderLayout());
        ButtonPanel.setBackground(new Color(224, 242, 241));
        JPanel btntoppanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btntoppanel.setBackground(new Color(224, 242, 241));
        JPanel btnbottompanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnbottompanel.setBackground(new Color(224, 242, 241));

        JButton upt = new JButton("Update");
        upt.setFont(new Font("",1, 20));
        upt.setBackground(new Color(38, 166, 154));
        upt.setForeground(Color.WHITE);
        upt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                notification n1 = new notification();
                if (gotID != null) {
                    String idtemp = gotID;
                    String nametemp = txtname.getText();
                    String phonetemp = txtphone.getText();
                    String companytemp = txtcompany.getText();
                    double salarytemp = Double.parseDouble(txtsalary.getText());
                    String bdaytemp = txtbday.getText();
                    if (!new Management().validatephone(phonetemp)) {
                        n1.invalidphone();
                    } else if (!new Management().validatesalary(salarytemp)) {
                        n1.invalidsalary();
                    } else if (!new Management().validatebday(bdaytemp)) {
                        n1.invalidsalary();
                    } else {
                        int index = new Management().search(searchby.getText());
                        Mainform.customerList.get(index).setId(gotID);
                        Mainform.customerList.get(index).setName(nametemp);
                        Mainform.customerList.get(index).setPhone(phonetemp);
                        Mainform.customerList.get(index).setCompany(companytemp);
                        Mainform.customerList.get(index).setSalary(salarytemp);
                        Mainform.customerList.get(index).setBday(bdaytemp);
                        n1.Sucssupt();
                        dispose();
                        new UpdateContacts().setVisible(true);
                    }
                } else {
                    n1.searchcontact();
                }
            }
        });
        btntoppanel.add(upt);

        JButton cns = new JButton("Cancel");
        cns.setFont(new Font("", Font.BOLD, 20));
        cns.setBackground(new Color(38, 166, 154));
        cns.setForeground(Color.WHITE);
        cns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new UpdateContacts().setVisible(true);
            }
        });
        btntoppanel.add(cns);

        ButtonPanel.add("North", btntoppanel);

        JButton Home = new JButton("Go To HomePage");
        Home.setFont(new Font("", Font.BOLD, 20));
        Home.setBackground(new Color(38, 166, 154));
        Home.setForeground(Color.WHITE);
        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new Mainform().setVisible(true);
            }
        });
        btnbottompanel.add(Home);

        ButtonPanel.add("South", btnbottompanel);

        add("South", ButtonPanel);
    }

}
