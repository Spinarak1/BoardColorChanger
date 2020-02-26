import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingConstants.HORIZONTAL;

public class MyFrame extends JFrame{
    public static int width = 800;
    public static int height = 600;
    public MyFrame(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        CheckerBoard checkerBoard = new CheckerBoard();
        checkerBoard.setMinimumSize(new Dimension(500, 500));
        mainPanel.add(checkerBoard);

        JPanel optionPanel = new JPanel();
        JTextField inputText = new JTextField();
        inputText.setMaximumSize(new Dimension(500, 100));
        inputText.setText(""+checkerBoard.getCellSize());
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.X_AXIS));
        optionPanel.add(new JLabel("Wielkość pola: "));
        Button kolor1 = new Button("Zmien kolor 1.");
        Button kolor2 = new Button("Zmien kolor 2.");
        kolor1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Color chooser", checkerBoard.getC1());
                checkerBoard.setColor1(color);
            }
        });
        kolor2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Color chooser", checkerBoard.getC2());
                checkerBoard.setColor2(color);
            }
        });
        optionPanel.add(kolor1);
        optionPanel.add(kolor2);
        optionPanel.add(inputText);
        mainPanel.add(optionPanel);
        setContentPane(mainPanel);
        inputText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e){
                onlyCorrectSize();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {

            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                onlyCorrectSize();
            }
            public void onlyCorrectSize(){
                try {
                    int input = Integer.parseInt(inputText.getText());
                    if(input <= 0)
                        return;
                    checkerBoard.setCellSize(input);
                }catch(Exception e){}
            }
        });

        setVisible(true);

    }//ułożyć przyciski w oknie
    //poprawić nieodświeżanie się
}
