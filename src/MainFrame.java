import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JTextArea textArea;
    JButton submitButton;
    JPanel southPanel;
    JLabel countLabel;

    public MainFrame(){

        textArea = new JTextArea();
        textArea.setLineWrap(true);

        southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 2));

        submitButton = new JButton("Submit");
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        countLabel = new JLabel("Word Count Displayed Here");
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);

        southPanel.add(countLabel);
        southPanel.add(submitButton);

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("CodeAlpha Word Counter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(textArea, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int wordCount = textArea.getText().split(" ").length;
        if(textArea.getText().equals(""))
            wordCount = 0;
        countLabel.setText("Word Count: " + wordCount);
    }
}
