import java.awt.*;
import java.awt.event.*;

public class AWT_MENU_Practice_24RP07192 extends Frame implements ActionListener {
    MenuItem login;
    String userName; // declare the variable

    public AWT_MENU_Practice_24RP07192() {
        // initialize username
        userName = "Dear Student"; // default value

        // setting menu bar
        MenuBar menuBar = new MenuBar();
        Menu pagesMenu = new Menu("Pages");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        menuBar.setFont(new Font("Ariel", Font.BOLD, 14));

        login = new MenuItem("Login");
        MenuItem student = new MenuItem("Student");

        pagesMenu.add(login);
        pagesMenu.add(student);

        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setMenuBar(menuBar);

        // layout and panels
        setLayout(new BorderLayout(20,0));
        Panel header = new Panel();
        Panel mainPanel = new Panel();
        Panel leftPanel = new Panel();
        Panel rightPanel = new Panel();
        Panel footerPanel = new Panel();

        Label lblHeader = new Label("EXAMPLE JAVA AWT LAYOUT");
        Label mainHeader = new Label("Welcome, " + userName);

        lblHeader.setFont(new Font("Arial", Font.BOLD,25));
        mainHeader.setFont(new Font("Arial", Font.BOLD,20));

        header.setBackground(new Color(0x333333)); // correct color format
        lblHeader.setForeground(new Color(0xFFFFFF));
        mainPanel.setBackground(new Color(0xFFFFFF));
        leftPanel.setBackground(new Color(0x6FACE8));
        rightPanel.setBackground(new Color(0x6FACE8));
        footerPanel.setBackground(new Color(0x418FED));

        header.add(lblHeader);
        mainPanel.add(mainHeader);

        add(header, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.LINE_END);
        add(rightPanel, BorderLayout.LINE_START);
        add(footerPanel, BorderLayout.SOUTH);

        setTitle("AWT MENU Practice");
        setSize(600,500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            dispose();
            new MenuPractice_24rp07192(); // make sure this class exists
        }

    }

    public static void main(String[] args) {
        new AWT_MENU_Practice_24RP07192();
    }
}
