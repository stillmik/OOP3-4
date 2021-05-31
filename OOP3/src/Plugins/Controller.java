package Plugins;

import javax.swing.*;

public class Controller {

    private JFrame jFrame;
    private JButton jButton1 = new JButton("Шифрование/Дешифрование");
    public Controller(JFrame jFrame){
        this.jFrame=jFrame;
        editComponents();
        setComponents();
        addListeners();
    }

    private void editComponents(){
        jButton1.setBounds(20,500,400,25);
    }

    private void setComponents(){
        jFrame.add(jButton1);
    }

    private void addListeners(){
        jButton1.addActionListener(e ->{
            new OptionFrame("Pillar");
        });
    }
}
