import java.awt.*;
import java.awt.event.*;

public class AWTMenuPractice {
    AWTMenuPractice() {
        Frame frame = new Frame("AWT MENU Practice");

        // ===== MENU BAR =====
        MenuBar menuBar = new MenuBar();

        // Menus
        Menu pagesMenu = new Menu("Pages");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        // Submenu items under "Pages"
        MenuItem loginItem = new MenuItem("Login");
        MenuItem studentItem = new MenuItem("Student");

        // Add submenu items to "Pages"
        pagesMenu.add(loginItem);
        pagesMenu.add(studentItem);

        // Add Menus to MenuBar
        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Set menu bar on frame
        frame.setMenuBar(menuBar);

        // ===== HEADER PANEL =====
        Panel headerPanel = new Panel(new BorderLayout());
        Label title = new Label("SIMPLE JAVA AWT LAYOUT", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setForeground(Color.WHITE);
        headerPanel.setBackground(new Color(0, 32, 96)); // dark blue
        headerPanel.add(title, BorderLayout.CENTER);

        // ===== CENTER (Login Form) =====
        Panel formPanel = new Panel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(235, 236, 230));

        Label lblUser = new Label("Username:");
        lblUser.setFont(new Font("Arial", Font.BOLD, 12));
        TextField txtUser = new TextField(15);

        Label lblPass = new Label("Password:");
        lblPass.setFont(new Font("Arial", Font.BOLD, 12));
        TextField txtPass = new TextField(15);
        txtPass.setEchoChar('*');

        Button loginBtn = new Button("LOGIN");
        loginBtn.setBackground(new Color(0, 32, 96));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 12));

        // Empty label to align the button to the right side
        Label empty = new Label("");

        formPanel.add(lblUser);
        formPanel.add(txtUser);
        formPanel.add(lblPass);
        formPanel.add(txtPass);
        formPanel.add(empty);
        formPanel.add(loginBtn);

        // ===== BODY LAYOUT =====
        Panel bodyPanel = new Panel(new BorderLayout());
        Label loginLabel = new Label("LOGIN PAGE", Label.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 13));
        bodyPanel.add(loginLabel, BorderLayout.NORTH);
        bodyPanel.add(formPanel, BorderLayout.CENTER);

        // ===== SIDE PANELS (for layout color effect) =====
        Panel leftPanel = new Panel();
        leftPanel.setBackground(new Color(180, 200, 220));

        Panel rightPanel = new Panel();
        rightPanel.setBackground(new Color(180, 200, 220));

        Panel footerPanel = new Panel();
        footerPanel.setBackground(new Color(90, 130, 150));

        // ===== FRAME LAYOUT =====
        frame.setLayout(new BorderLayout(10, 10));
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(bodyPanel, BorderLayout.CENTER);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(footerPanel, BorderLayout.SOUTH);

        // ===== FRAME SETTINGS =====
        frame.setSize(500, 400);
        frame.setVisible(true);

        // Window closing event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // ===== MENU ITEM ACTIONS =====
        loginItem.addActionListener(e -> {
            System.out.println("Login page selected");
        });

        studentItem.addActionListener(e -> {
            System.out.println("Student page selected");
        });
    }

    public static void main(String[] args) {
        new AWTMenuPractice();
    }
}
