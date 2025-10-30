import java.awt.*;
import java.awt.event.*;

class MenuPractice_24rp07192 extends Frame implements ActionListener {

    MenuItem studentMenu;
    TextField txtUsername;
    TextField txtPassword;
    Button btnLogin;

    public MenuPractice_24rp07192() {
        // ---- Menu Bar ----
        MenuBar menuBar = new MenuBar();
        Menu pagesMenu = new Menu("Pages");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        menuBar.setFont(new Font("Arial", Font.BOLD, 14));

        MenuItem loginMenu = new MenuItem("Login");
        studentMenu = new MenuItem("Student");

        pagesMenu.add(loginMenu);
        pagesMenu.add(studentMenu);

        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setMenuBar(menuBar);

        // ---- Layout ----
        setLayout(new BorderLayout());

        // Header panel
        Panel header = new Panel();
        header.setBackground(new Color(0x333333));
        header.setLayout(new FlowLayout());
        Label lblHeader = new Label("EXAMPLE JAVA AWT LAYOUT");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 25));
        lblHeader.setForeground(Color.WHITE);
        header.add(lblHeader);

        // Main login panel
        Panel mainPanel = new Panel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);

        Label lblLogin = new Label("LOGIN PAGE");
        lblLogin.setFont(new Font("Arial", Font.BOLD, 20));
        lblLogin.setBounds(200, 30, 200, 30);

        Label lblUsername = new Label("Username:");
        lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
        lblUsername.setBounds(100, 80, 100, 25);

        txtUsername = new TextField();
        txtUsername.setBounds(200, 80, 200, 25);

        Label lblPassword = new Label("Password:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
        lblPassword.setBounds(100, 120, 100, 25);

        txtPassword = new TextField();
        txtPassword.setEchoChar('*');
        txtPassword.setBounds(200, 120, 200, 25);

        btnLogin = new Button("LOGIN");
        btnLogin.setBounds(200, 170, 100, 30);
        btnLogin.setBackground(Color.BLUE);
        btnLogin.setForeground(Color.WHITE);

        mainPanel.add(lblLogin);
        mainPanel.add(lblUsername);
        mainPanel.add(txtUsername);
        mainPanel.add(lblPassword);
        mainPanel.add(txtPassword);
        mainPanel.add(btnLogin);

        // Left and right panels
        Panel leftPanel = new Panel();
        leftPanel.setBackground(new Color(0x6FACE8));
        leftPanel.setPreferredSize(new Dimension(100, 0)); // width 100px

        Panel rightPanel = new Panel();
        rightPanel.setBackground(new Color(0x6FACE8));
        rightPanel.setPreferredSize(new Dimension(100, 0)); // width 100px

        // Footer panel
        Panel footer = new Panel();
        footer.setBackground(new Color(0x418FED));
        footer.setPreferredSize(new Dimension(0, 50)); // height 50px

        // Add panels to frame
        add(header, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(footer, BorderLayout.SOUTH);

        // ---- Window settings ----
        setTitle("AWT MENU Practice");
        setSize(700, 400); // slightly wider for left/right panels
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        // ---- Action Listeners ----
        loginMenu.addActionListener(this);
        studentMenu.addActionListener(this);
        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnLogin || src == studentMenu) {
            String username = txtUsername.getText();
            if (username.isEmpty()) username = "Dear Student";
            dispose();
            new StudentsPage(username);
        }
    }

    public static void main(String[] args) {
        new MenuPractice_24rp07192();
    }
}
