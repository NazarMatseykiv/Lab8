import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyDialog extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton addButton;
    private JButton printButton;
    private JTextArea textArea;
    private ArrayList<String> itemList;

    public MyDialog() {
        super("Мій список");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // створення компонентів
        textField = new JTextField(20);
        addButton = new JButton("Додати");
        addButton.addActionListener(this);
        printButton = new JButton("Друкувати");
        printButton.addActionListener(this);
        textArea = new JTextArea(10, 30);
        itemList = new ArrayList<>();

        // розміщення компонентів на формі
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(addButton);
        panel.add(printButton);
        add(panel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String item = textField.getText();
            itemList.add(item);
            textField.setText("");
            updateTextArea();
        } else if (e.getSource() == printButton) {
            for (String item : itemList) {
                System.out.println(item);
            }
        }
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        for (String item : itemList) {
            sb.append(item).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new MyDialog();
    }
}
