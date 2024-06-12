import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class Mainform extends JFrame {
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnList;

    public static final ArrayList<Contact> customerList = new ArrayList<>();
    private AddContacts add;
    private UpdateContacts update;
    private DeleteContact delete;
    private SearchContacts search;
    private ListContacts list;

    Mainform() {
        setSize(700, 500);
        setTitle("Contacts | Main Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel Body = new JPanel(new BorderLayout());
        Body.setBackground(new Color(224, 242, 241));

        JPanel title = new JPanel(new BorderLayout());
        title.setBackground(new Color(38, 166, 154));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        JLabel heading = new JLabel("Home Page");
        heading.setFont(new Font("", 1, 35));
        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setForeground(Color.WHITE);
        title.add(heading);

        add("North", title);
        add(Body, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 40));
        buttonPanel.setBackground(new Color(224, 242, 241));

        btnAdd = new JButton("Add Contacts");
        btnAdd.setPreferredSize(new Dimension(300, 30));
        btnAdd.setBackground(new Color(38, 166, 154));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (add == null) {
                    add = new AddContacts();
                    dispose();
                }
                add.setVisible(true);
            }
        });
        buttonPanel.add(btnAdd);

        btnUpdate = new JButton("Update Contacts");
        btnUpdate.setPreferredSize(new Dimension(300, 30));
        btnUpdate.setBackground(new Color(38, 166, 154));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (update == null) {
                    update = new UpdateContacts();
                    dispose();
                }
                update.setVisible(true);
            }
        });
        buttonPanel.add(btnUpdate);

        btnDelete = new JButton("Delete Contacts");
        btnDelete.setBackground(new Color(38, 166, 154));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (delete == null) {
                    delete = new DeleteContact();
                    dispose();
                }
                delete.setVisible(true);
            }
        });
        buttonPanel.add(btnDelete);

        btnSearch = new JButton("Search Contacts");
        btnSearch.setBackground(new Color(38, 166, 154));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (search == null) {
                    search = new SearchContacts();
                    dispose();
                }
                search.setVisible(true);
            }
        });
        buttonPanel.add(btnSearch);

        btnList = new JButton("List Contacts");
        btnList.setBackground(new Color(38, 166, 154));
        btnList.setForeground(Color.WHITE);
        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (list == null) {
                    list = new ListContacts();

                }
                list.setVisible(true);
            }
        });
        buttonPanel.add(btnList);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 10));
        centerPanel.setBackground(new Color(224, 242, 241));
        centerPanel.add(buttonPanel);

        Body.add("Center",centerPanel);
    }

}
