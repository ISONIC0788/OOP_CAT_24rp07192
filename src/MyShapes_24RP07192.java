import java.awt.*;
import java.awt.event.*;

public class MyShapes_24RP07192 extends Frame {

    MyShapes_24RP07192() {
        // Set title with project name + reg number
        super("MyShapes Project - 24RP07192");

        // Frame size and layout
        setSize(500, 400);
        setLayout(new BorderLayout());






        // ===== CENTER DRAW PANEL =====
        Panel drawPanel = new Panel() {
            public void paint(Graphics g) {
                g.setColor(new Color(150, 75, 0)); // brown color for shapes

                // Draw face circle
                g.drawOval(150, 100, 100, 100);

                // Eyes
                g.fillOval(175, 130, 15, 15);
                g.fillOval(210, 130, 15, 15);

                // Smile (arc)
                g.drawArc(175, 160, 60, 30, 180, 180);
            }
        };
        drawPanel.setBackground(Color.WHITE);
        add(drawPanel, BorderLayout.CENTER);



        // Window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyShapes_24RP07192();
    }
}
