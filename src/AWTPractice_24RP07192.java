import java.awt.*;
import java.awt.event.*;

public class AWTPractice_24RP07192 extends Frame implements ActionListener {


TextField numberField;
TextArea resultArea;
Button displayBtn, closeBtn;

public AWTPractice_24RP07192() {
    super("AWT Practice - Project_24RP07192");
    setSize(450, 350);
    setLayout(null);

    // ====== INPUT FIELD ======
    numberField = new TextField();
    numberField.setBounds(40, 90, 120, 30);
    add(numberField);

    // ====== DISPLAY BUTTON ======
    displayBtn = new Button("DISPLAY");
    displayBtn.setBounds(40, 130, 120, 35);
    displayBtn.setBackground(new Color(40, 80, 120));
    displayBtn.setForeground(Color.WHITE);
    displayBtn.setFont(new Font("Arial", Font.BOLD, 12));
    displayBtn.addActionListener(this);
    add(displayBtn);

    // ====== RESULT AREA ======
    resultArea = new TextArea();
    resultArea.setBounds(200, 90, 200, 150);
    resultArea.setBackground(new Color(230, 140, 40));
    resultArea.setEditable(false);
    add(resultArea);

    // ====== WINDOW CLOSE EVENT ======
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            dispose();
        }
    });

    setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == displayBtn) {
        try {
            int num = Integer.parseInt(numberField.getText().trim());
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 10; i++) {
                sb.append(num + " * " + i + " = " + (num * i) + "\n");
            }
            resultArea.setText(sb.toString());
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter a valid number.");
        }
    }
}

public static void main(String[] args) {
    new AWTPractice_24RP07192();
}


}
