package Graphics;

import javax.swing.*;

class ShowFrame {

    private JFrame jFrame = new JFrame();
    private JTextArea jTextArea = new JTextArea();
    private JScrollPane jScrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    private String text;
    ShowFrame(String text){
        this.text=text;
        showFrameComponentsSetUp();
        showFrameAddComponents();
        showFrameFinalSettings();
    }

    private void showFrameComponentsSetUp(){
        jFrame.setBounds(600, 140, 460, 580);
        jScrollPane.setBounds(0, 0, 446, 580);
        jTextArea.setEditable(false);
        jTextArea.setText(text);
    }

    private void showFrameAddComponents(){
        jFrame.add(jScrollPane);
    }

    private void showFrameFinalSettings(){
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
