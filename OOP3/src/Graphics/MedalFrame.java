package Graphics;

import Awards.Wearing;
import Badges.Medal;

import javax.swing.*;
import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

class MedalFrame {

    private JFrame jFrame = new JFrame();
    private JLabel topHeader = new JLabel("Медали");
    private JLabel addMedal = new JLabel("Добавить медаль");
    private JLabel removeMedal = new JLabel("Удалить медаль");
    private JLabel editMedal = new JLabel("Редактировать медаль");

    private JTextField uniqNum1Field = new JTextField();
    private JTextField thankedForField = new JTextField();
    private JTextField uniqNum2Field = new JTextField();
    private JTextField wearingField = new JTextField();
    private JTextField affiliationField = new JTextField();
    private JTextField branchMeritField = new JTextField();
    private JLabel uniqNum1Label = new JLabel("Номер");
    private JLabel uniqNum2Label = new JLabel("Номер");
    private JLabel thankedForLabel = new JLabel("Текст благодарности");
    private JLabel wearingLabel = new JLabel("Ношение");
    private JLabel affiliationLabel = new JLabel("Принадлежит к");
    private JLabel branchMeritLabel = new JLabel("Вручена за");

    private JButton addButton = new JButton("Добавить");
    private JButton editButton = new JButton("Изменить");
    private JButton removeButton = new JButton("Удалить");

    private JButton serBinaryButton = new JButton("Сереальзовать бинарно");
    private JButton serXMLButton = new JButton("Сереализовать XML");
    private JButton serJSONButton = new JButton("Сереализовать JSON");
    private JButton deserBinaryButton = new JButton("Десереальзовать бинарно");
    private JButton deserXMLButton = new JButton("Десереализовать XML");
    private JButton deserJSONButton = new JButton("Десереализовать JSON");

    private Font buttonFont = new Font("Font", Font.ITALIC, 13);

    private ArrayList<Medal> medals;

    MedalFrame(ArrayList<Medal> medals) {
        this.medals = medals;
        medalFrameComponentsSetUp();
        medalFrameAddComponents();
        medalFrameFinalSettings();
        addEventListeners();
    }

    private void medalFrameFinalSettings() {
        jFrame.setBounds(600, 150, 460, 550);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
    }

    private void medalFrameAddComponents() {

        jFrame.add(topHeader);

        jFrame.add(addMedal);
        jFrame.add(editMedal);
        jFrame.add(removeMedal);

        jFrame.add(addButton);
        jFrame.add(editButton);
        jFrame.add(removeButton);

        jFrame.add(serBinaryButton);
        jFrame.add(serJSONButton);
        jFrame.add(serXMLButton);
        jFrame.add(deserBinaryButton);
        jFrame.add(deserXMLButton);
        jFrame.add(deserJSONButton);

        jFrame.add(uniqNum1Field);
        jFrame.add(uniqNum2Field);
        jFrame.add(affiliationField);
        jFrame.add(branchMeritField);
        jFrame.add(thankedForField);
        jFrame.add(wearingField);

        jFrame.add(uniqNum1Label);
        jFrame.add(uniqNum2Label);
        jFrame.add(affiliationLabel);
        jFrame.add(branchMeritLabel);
        jFrame.add(thankedForLabel);
        jFrame.add(wearingLabel);

    }

    private void medalFrameComponentsSetUp() {
        addButton.setFont(buttonFont);
        editButton.setFont(buttonFont);
        removeButton.setFont(buttonFont);


        serBinaryButton.setFont(buttonFont);
        serJSONButton.setFont(buttonFont);
        serXMLButton.setFont(buttonFont);
        deserBinaryButton.setFont(buttonFont);
        deserXMLButton.setFont(buttonFont);
        deserJSONButton.setFont(buttonFont);

        topHeader.setFont(new Font("Font", Font.ITALIC, 30));
        topHeader.setBounds(30, 10, 400, 35);

        addMedal.setBounds(135, 65, 400, 35);
        editMedal.setBounds(135, 90, 400, 35);
        removeMedal.setBounds(135, 295, 400, 35);

        uniqNum1Field.setBounds(135, 120, 300, 25);
        affiliationField.setBounds(135, 145, 300, 25);
        branchMeritField.setBounds(135, 170, 300, 25);
        thankedForField.setBounds(135, 195, 300, 25);
        wearingField.setBounds(135, 220, 300, 25);

        addButton.setBounds(284, 70, 150, 25);
        editButton.setBounds(284, 95, 150, 25);
        removeButton.setBounds(284, 300, 150, 25);
        uniqNum2Field.setBounds(135, 325, 300, 25);

        serBinaryButton.setBounds(23, 400, 200, 25);
        deserBinaryButton.setBounds(223, 400, 200, 25);
        serXMLButton.setBounds(23, 425, 200, 25);
        deserXMLButton.setBounds(223, 425, 200, 25);
        serJSONButton.setBounds(23, 450, 200, 25);
        deserJSONButton.setBounds(223, 450, 200, 25);

        uniqNum1Label.setBounds(10, 120, 300, 25);
        uniqNum2Label.setBounds(10, 325, 300, 25);
        affiliationLabel.setBounds(10, 145, 300, 25);
        branchMeritLabel.setBounds(10, 170, 300, 25);
        thankedForLabel.setBounds(10, 195, 300, 25);
        wearingLabel.setBounds(10, 220, 300, 25);

        addButton.setFocusPainted(false);
        editButton.setFocusPainted(false);
        removeButton.setFocusPainted(false);

        serBinaryButton.setFocusPainted(false);
        serJSONButton.setFocusPainted(false);
        serXMLButton.setFocusPainted(false);
        deserBinaryButton.setFocusPainted(false);
        deserXMLButton.setFocusPainted(false);
        deserJSONButton.setFocusPainted(false);
    }

    private void addEventListeners() {

        serBinaryButton.addActionListener(e -> {

            try {
                FileOutputStream fileOutputStream = new FileOutputStream("serMedals.bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeInt(medals.size());

                for (Medal medal : medals) {
                    objectOutputStream.writeObject(medal);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        deserBinaryButton.addActionListener(e -> {
            try {
                FileInputStream fileInputStream = new FileInputStream("serMedals.bin");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                int quant = objectInputStream.readInt();
                ArrayList<Medal> readMedals = new ArrayList<>();
                for (int i = 0; i < quant; i++) {
                    Medal readMedal = (Medal) objectInputStream.readObject();

                    boolean exist = false;
                    for (Medal medal : medals) {
                        if (medal.getUniqNum() == readMedal.getUniqNum()) {
                            JOptionPane.showMessageDialog(null, "Медаль с номером " + medal.getUniqNum() + " уже существует", "Critical error", JOptionPane.ERROR_MESSAGE);
                            exist=true;
                            break;
                        }
                    }
                    if(!exist)
                        readMedals.add(readMedal);
                }
                if (readMedals.size() != 0)
                    medals.addAll(readMedals);

            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        serXMLButton.addActionListener(e ->{
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream("serMedals.xml");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                XMLEncoder xmlEncoder = new XMLEncoder(bufferedOutputStream);

                xmlEncoder.writeObject(medals.size());
                for (Medal medal : medals) {
                    xmlEncoder.writeObject(medal);
                }
                xmlEncoder.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        });

        deserXMLButton.addActionListener(e ->{
            try {
                XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("serMedals.xml")));

                int quant = (int) xmlDecoder.readObject();
                ArrayList<Medal> readMedals = new ArrayList<>();
                for (int i = 0; i < quant; i++) {
                    Medal readMedal = (Medal) xmlDecoder.readObject();

                    boolean exist = false;
                    for (Medal medal : medals) {
                        if (medal.getUniqNum() == readMedal.getUniqNum()) {
                            JOptionPane.showMessageDialog(null, "Медаль с номером " + medal.getUniqNum() + " уже существует", "Critical error", JOptionPane.ERROR_MESSAGE);
                            exist=true;
                            break;
                        }
                    }
                    if(!exist)
                        readMedals.add(readMedal);
                }
                if (readMedals.size() != 0)
                    medals.addAll(readMedals);
                xmlDecoder.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        addButton.addActionListener(e -> {
            int uniqNum;
            try {
                uniqNum = Integer.parseInt(uniqNum1Field.getText());
            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(null, "Вы ввели некорректный номер", "Critical error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Medal value : medals) {
                if (value.getUniqNum() == uniqNum) {
                    JOptionPane.showMessageDialog(null, "Медаль с таким номером уже существут", "Critical error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String affilication = affiliationField.getText();
            String branchMerit = branchMeritField.getText();
            String thankedFor = thankedForField.getText();
            String wearing = wearingField.getText();
            if (affilication.length() == 0 || branchMerit.length() == 0 || thankedFor.length() == 0 || wearing.length() == 0) {
                JOptionPane.showMessageDialog(null, "Не все поля заполнены", "Critical error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Wearing wearingType;
            if (!(wearing.equals("LEFT") || wearing.equals("CENTER") || wearing.equals("RIGHT"))) {
                JOptionPane.showMessageDialog(null, "Вы ввели некорректное значение", "Critical error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            switch (wearing) {
                case "LEFT":
                    wearingType = Wearing.LEFT;
                    break;
                case "RIGHT":
                    wearingType = Wearing.RIGHT;
                    break;
                case "CENTER":
                    wearingType = Wearing.CENTER;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + wearing);
            }
            medals.add(new Medal(thankedFor, uniqNum, wearingType, affilication, branchMerit));
            for (Medal medal : medals) {
                medal.getMedalInfo();
            }
        });

        editButton.addActionListener(e -> {
            int uniqNum;
            try {
                uniqNum = Integer.parseInt(uniqNum1Field.getText());
            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(null, "Вы ввели некорректный номер", "Critical error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Medal value : medals) {
                if (value.getUniqNum() == uniqNum) {
                    JOptionPane.showMessageDialog(null, "Медаль с таким номером уже существут", "Critical error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            boolean existFlag = false;
            for (int i = 0; i < medals.size(); i++) {

                if (medals.get(i).getUniqNum() == uniqNum) {

                    Medal medal = medals.get(i);
                    String affilication = affiliationField.getText();
                    if (affilication.length() != 0) {
                        medal.setAffiliation(affilication);
                    }
                    String branchMerit = branchMeritField.getText();
                    if (branchMerit.length() != 0) {
                        medal.setBranchMerit(branchMerit);
                    }
                    String thankedFor = thankedForField.getText();
                    if (thankedFor.length() != 0) {
                        medal.setThankedFor(thankedFor);
                    }
                    String wearing = wearingField.getText();
                    Wearing wearingType;
                    if (!(wearing.equals("LEFT") || wearing.equals("CENTER") || wearing.equals("RIGHT"))) {
                        JOptionPane.showMessageDialog(null, "Вы ввели некорректное значение", "Critical error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    switch (wearing) {
                        case "LEFT":
                            wearingType = Wearing.LEFT;
                            break;
                        case "RIGHT":
                            wearingType = Wearing.RIGHT;
                            break;
                        case "CENTER":
                            wearingType = Wearing.CENTER;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + wearing);
                    }
                    medal.setWearing(wearingType);
                    medals.set(i, new Medal(thankedFor, uniqNum, wearingType, affilication, branchMerit));
                    existFlag = true;
                    break;
                }
            }
            if (!existFlag) {
                JOptionPane.showMessageDialog(null, "Медали с таким номером нет", "Critical error", JOptionPane.ERROR_MESSAGE);
            }
        });

        removeButton.addActionListener(e -> {
            int uniqNum;
            try {
                uniqNum = Integer.parseInt(uniqNum2Field.getText());
            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(null, "Вы ввели некорректный номер", "Critical error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean existFlag = false;
            for (int i = 0; i < medals.size(); i++) {

                if (medals.get(i).getUniqNum() == uniqNum) {
                    medals.remove(i);
                    existFlag = true;
                    break;
                }
            }
            if (!existFlag) {
                JOptionPane.showMessageDialog(null, "Медали с таким номером нет", "Critical error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
