import java.awt.*;
import java.awt.event.*;

public class StudentsPage extends Frame implements ActionListener {

    MenuItem loginMenu;

    public StudentsPage(String userName) {
        if (userName == null || userName.isEmpty()) {
            userName = "Dear Student";
        }

        // ---- Menu Bar ----
        MenuBar menuBar = new MenuBar();
        Menu pagesMenu = new Menu("Pages");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        loginMenu = new MenuItem("Login");
        MenuItem studentMenu = new MenuItem("Student");

        pagesMenu.add(loginMenu);
        pagesMenu.add(studentMenu);

        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setMenuBar(menuBar);

        // ---- Layout ----
        setLayout(new BorderLayout());

        // Header
        Panel header = new Panel();
        header.setBackground(new Color(0x333333));
        header.setLayout(new FlowLayout());
        Label lblHeader = new Label("EXAMPLE JAVA AWT LAYOUT");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 25));
        lblHeader.setForeground(Color.WHITE);
        header.add(lblHeader);

        // Main panel
        Panel mainPanel = new Panel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBackground(Color.WHITE);
        Label welcomeLabel = new Label("Welcome, " + userName);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(welcomeLabel);

        // Footer
        Panel footer = new Panel();
        footer.setBackground(new Color(0x418FED));

        add(header, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

        // Window settings
        setTitle("Students Page");
        setSize(600, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        // Action listeners
        loginMenu.addActionListener(this);
        studentMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == loginMenu) {
            dispose();
            new MenuPractice_24rp07192();
        }
    }
}
