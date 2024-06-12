import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddContacts extends JFrame {
    private JButton btnAddCustomer;
    private JButton btnCancel;
    private JButton btnhome;

    private String id;
    private JTextField name;
    private JTextField phone;
    private JTextField company;
    private JTextField salary;
    private JTextField bday;

    AddContacts f1;

    AddContacts() {
        setSize(500, 500);
        setTitle("Add Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Add Customer Form");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(38, 166, 154));
        titlePanel.add(titleLabel);
        add("North", titlePanel);

        JPanel displayPanel = new JPanel(new GridLayout(6, 2));
        displayPanel.setBackground(new Color(224, 242, 241));

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("", 1, 20));
        lblid.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblidpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblidpanel.setBackground(new Color(224, 242, 241));
        lblidpanel.add(lblid);
        displayPanel.add(lblidpanel);

        JLabel txtid = new JLabel(id = Management.contactidgenarate());
        txtid.setFont(new Font("",1, 20));
        JPanel txtidpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtidpanel.setBackground(new Color(224, 242, 241));
        txtidpanel.add(txtid);
        displayPanel.add(txtidpanel);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("", 1, 20));
        lblname.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblnamepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblnamepanel.setBackground(new Color(224, 242, 241));
        lblnamepanel.add(lblname);
        displayPanel.add(lblnamepanel);

        name = new JTextField(10);
        name.setFont(new Font("", 1, 20));
        JPanel txtnamepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtnamepanel.setBackground(new Color(224, 242, 241));
        txtnamepanel.add(name);
        displayPanel.add(txtnamepanel);

        JLabel lblphone = new JLabel("Phone No");
        lblphone.setFont(new Font("", 1, 20));
        lblphone.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblphonepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblphonepanel.setBackground(new Color(224, 242, 241));
        lblphonepanel.add(lblphone);
        displayPanel.add(lblphonepanel);

        phone = new JTextField(10);
        phone.setFont(new Font("", 1, 20));
        JPanel txtphonepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtphonepanel.setBackground(new Color(224, 242, 241));
        txtphonepanel.add(phone);
        displayPanel.add(txtphonepanel);

        JLabel lblcompany = new JLabel("Company");
        lblcompany.setFont(new Font("", 1, 20));
        lblcompany.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblcompanypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblcompanypanel.setBackground(new Color(224, 242, 241));
        lblcompanypanel.add(lblcompany);
        displayPanel.add(lblcompanypanel);

        company = new JTextField(10);
        company.setFont(new Font("", 1, 20));
        JPanel txtcompanypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtcompanypanel.setBackground(new Color(224, 242, 241));
        txtcompanypanel.add(company);
        displayPanel.add(txtcompanypanel);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setFont(new Font("", 1, 20));
        lblsalary.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblsalarypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblsalarypanel.setBackground(new Color(224, 242, 241));
        lblsalarypanel.add(lblsalary);
        displayPanel.add(lblsalarypanel);

        salary = new JTextField(10);
        salary.setFont(new Font("", 1, 20));
        JPanel txtsalarypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtsalarypanel.setBackground(new Color(224, 242, 241));
        txtsalarypanel.add(salary);
        displayPanel.add(txtsalarypanel);

        JLabel lblbday = new JLabel("Birthday");
        lblbday.setFont(new Font("", 1, 20));
        lblbday.setHorizontalAlignment(JLabel.CENTER);
        JPanel lblbdaypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblbdaypanel.setBackground(new Color(224, 242, 241));
        lblbdaypanel.add(lblbday);
        displayPanel.add(lblbdaypanel);

        bday = new JTextField(10);
        bday.setFont(new Font("", 1, 20));
        JPanel txtbdaypanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        txtbdaypanel.setBackground(new Color(224, 242, 241));
        txtbdaypanel.add(bday);
        displayPanel.add(txtbdaypanel);

        add("Center", displayPanel);

        JPanel footerPanel = new JPanel(new GridBagLayout());
        footerPanel.setBackground(new Color(224, 242, 241));
        JPanel HomebtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        HomebtnPanel.setBackground(new Color(224, 242, 241));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(224, 242, 241));
        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("", 1, 20));
        btnAddCustomer.setBackground(new Color(38, 166, 154));
        btnAddCustomer.setForeground(Color.WHITE);
        btnAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                notification n1 = new notification();
                String idtemp = id;
                String nametemp = name.getText();
                String phonetemp = phone.getText();
                String companytemp = company.getText();
                double salarytemp = Double.parseDouble(salary.getText());
                String bdaytemp = bday.getText();
                if (!new Management().validatephone(phonetemp)) {
                    n1.invalidphone();
                } else if (!new Management().validatesalary(salarytemp)) {
                    n1.invalidsalary();
                } else if (!new Management().validatebday(bdaytemp)) {
                    n1.invalidbday();
                } else {
                    Contact customer = new Contact(idtemp, nametemp, phonetemp, companytemp, salarytemp, bdaytemp);
                    Mainform.customerList.add(customer);
                    n1.Sucssadd();
                    dispose();
                    f1 = new AddContacts();
                    f1.setVisible(true);
                }
            }
        });
        buttonPanel.add(btnAddCustomer);

        btnCancel = new JButton("Reset");
        btnCancel.setFont(new Font("", 1, 20));
        btnCancel.setBackground(new Color(38, 166, 154));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new AddContacts().setVisible(true);
            }
        });
        buttonPanel.add(btnCancel);

        JPanel Home = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        Home.setBackground(new Color(224, 242, 241));
        btnhome = new JButton("Go To Home");
        btnhome.setFont(new Font("", 1, 20));
        btnhome.setBackground(new Color(38, 166, 154));
        btnhome.setForeground(Color.WHITE);
        btnhome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new Mainform().setVisible(true);
            }
        });
        HomebtnPanel.add(btnhome);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0.5;
        footerPanel.add(buttonPanel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        footerPanel.add(HomebtnPanel, gbc);

        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add("East",footerPanel);
        containerPanel.setBackground(new Color(224, 242, 241));

        add("South", containerPanel);
    }
}
