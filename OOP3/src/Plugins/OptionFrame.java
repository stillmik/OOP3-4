package Plugins;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;


class OptionFrame {

    private JFrame jFrame = new PicturedJFrame();
    private JLabel keyLabel = new JLabel("Введите ключ");
    private JLabel openFileLabel = new JLabel("Выберите файл");
    private JLabel saveFileLabel = new JLabel("Сохранить файл");
    private JButton openFileButton = new JButton("directory");
    private JButton saveFileButton = new JButton("directory");
    private JButton encryptButton = new JButton("Шифровать");
    private JButton decryptButton = new JButton("Дешифровать");
    private JTextField keyField = new JTextField();
    private JFileChooser fileChooser = new JFileChooser();
    private FileNameExtensionFilter fileChooserFilter = new FileNameExtensionFilter("ONLY txt files", "txt");
    private Font LabelFont = new Font("Font", Font.ITALIC, 16);
    private Font buttonFont = new Font("Font", Font.ITALIC, 13);

    private String SAVE_FILE_PATH = "";
    private String LOADED_TEXT = "";
    private String MADEUP_TEXT = "";

    private boolean openFileSelected;
    private boolean saveFileSelected;

    private String encryption;

    OptionFrame(String encryptionType) {
        fenceFrameComponentsSetUp();
        fenceFrameAddComponents();
        fenceFrameFinalSettings();
        saveButtonListener();
        openButtonListener();
        encryptButtonListener();
        decryptButtonListener();
        exitOptionFrameListener();
        encryption = encryptionType;
    }


    private void fenceFrameComponentsSetUp() {
        keyLabel.setBounds(10, 27, 120, 30);
        keyLabel.setFont(LabelFont);
        saveFileLabel.setBounds(10, 147, 130, 30);
        saveFileLabel.setFont(LabelFont);
        openFileLabel.setBounds(10, 92, 130, 30);
        openFileLabel.setFont(LabelFont);
        saveFileButton.setBounds(150, 150, 150, 25);
        openFileButton.setBounds(150, 95, 150, 25);
        decryptButton.setBounds(50, 260, 150, 30);
        encryptButton.setBounds(335, 260, 150, 30);
        saveFileButton.setFont(buttonFont);
        openFileButton.setFont(buttonFont);
        decryptButton.setFont(buttonFont);
        encryptButton.setFont(buttonFont);
        keyField.setBounds(130, 30, 370, 25);
        saveFileButton.setFocusPainted(false);
        openFileButton.setFocusPainted(false);
        encryptButton.setFocusPainted(false);
        decryptButton.setFocusPainted(false);

    }

    private void fenceFrameAddComponents() {
        jFrame.add(keyLabel);
        jFrame.add(keyField);
        jFrame.add(saveFileLabel);
        jFrame.add(openFileLabel);
        jFrame.add(saveFileButton);
        jFrame.add(openFileButton);
        jFrame.add(encryptButton);
        jFrame.add(decryptButton);
    }

    private void fenceFrameFinalSettings() {
        jFrame.revalidate();
        jFrame.setBounds(500, 250, 550, 350);
        jFrame.setLayout(null);
    }


    private void saveButtonListener() {
        saveFileButton.addActionListener(e -> {
            saveFileSelected = false;
            SAVE_FILE_PATH="";

            fileChooserSettings("save");
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                SAVE_FILE_PATH = fileChooser.getSelectedFile().getPath();
                if (saveFilePathIsCorrect()) {
                    saveFileSelected = true;
                }
            }
        });
    }

    private void openButtonListener() {

        openFileButton.addActionListener(e -> {
            openFileSelected = false;
            LOADED_TEXT="";

            fileChooserSettings("open");
            int returnOfFileChooser = fileChooser.showDialog(null, "Открыть файл");
            if (returnOfFileChooser == JFileChooser.APPROVE_OPTION) {
                loadTextFromFile();
            }
        });
    }

    private void encryptButtonListener() {

        encryptButton.addActionListener(e -> {
                if (!runPillarEncrypt()) {
                    return;
                }
            JOptionPane.showMessageDialog(null, "Шифровка выполнена!", "Critical luck", JOptionPane.INFORMATION_MESSAGE);
            jFrame.dispose();
        });

    }

    private void decryptButtonListener() {
        decryptButton.addActionListener(e -> {
                if (!runPillarDecrypt()) {
                    return;
                }
            JOptionPane.showMessageDialog(null, "Дешифровка выполнена!", "Critical luck", JOptionPane.INFORMATION_MESSAGE);
            jFrame.dispose();
        });
    }


    private void exitOptionFrameListener() {
        jFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                openFileSelected = false;
                saveFileSelected = false;
                SAVE_FILE_PATH = "";
                LOADED_TEXT = "";
                MADEUP_TEXT = "";
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private boolean OpenSaveNotPressed() {
        if (!openFileSelected) {
            JOptionPane.showMessageDialog(null, "Файл не был выбран", "Critical error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (!saveFileSelected) {
            JOptionPane.showMessageDialog(null, "Место сохранения нового файла не выбрано", "Critical error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean saveFilePathIsCorrect() {
        if (!SAVE_FILE_PATH.endsWith(".txt")) {
            JOptionPane.showMessageDialog(null, "Введите название txt файла", "Critical error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void fileChooserSettings(String operation) {

        if (operation.equals("save")) {
            fileChooser.setDialogTitle("Сохранение файла");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        } else if (operation.equals("open")) {
            fileChooser.setDialogTitle("Открытие файла");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileFilter(fileChooserFilter);
        }
    }

    private void loadTextFromFile() {
        File readingFile = fileChooser.getSelectedFile();
        Path ReadingFilePath = Paths.get(readingFile.getPath());
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(String.valueOf(ReadingFilePath)), StandardCharsets.UTF_8));
            String lineInFile;

            while ((lineInFile = fileReader.readLine()) != null) {
                LOADED_TEXT = LOADED_TEXT.concat(lineInFile + "\n");
            }

            if (loadedTextIsNotCorrect()) {
                return;
            }
            openFileSelected = true;

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка чтения txt файла", "Critical error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean loadedTextIsNotCorrect() {
            if (LOADED_TEXT.length() == 0) {
                JOptionPane.showMessageDialog(null, "В тексте отсутствуют A-Za-z символы", "Critical luck", JOptionPane.ERROR_MESSAGE);
                LOADED_TEXT = "";
                return true;
            }
            if (LOADED_TEXT.length() < 4) {
                JOptionPane.showMessageDialog(null, "Нельзя закодировать A-Za-z \nсимволы длиной менее 4x", "Critical luck", JOptionPane.ERROR_MESSAGE);
                LOADED_TEXT = "";
                return true;
            }
        return false;
    }

    private void saveTextInFile() {
        File file = new File(SAVE_FILE_PATH);
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter output = new BufferedWriter(writer);
            output.write("");
            output.write(MADEUP_TEXT);
            output.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("new text: " + MADEUP_TEXT + "\nLoaded text: " + LOADED_TEXT + "\nCipher: " + keyField.getText());

    }

    private boolean runPillarEncrypt() {
        if (PillarCipher.keyIsNotCorrect(keyField.getText())) {
            return false;
        }
        if (OpenSaveNotPressed()) {
            return false;
        }
        MADEUP_TEXT = PillarCipher.encryptPillar(LOADED_TEXT);
        saveTextInFile();
        MADEUP_TEXT = "";
        return true;
    }

    private boolean runPillarDecrypt(){
        if (PillarCipher.keyIsNotCorrect(keyField.getText())) {
            return false;
        }
        if (OpenSaveNotPressed()) {
            return false;
        }
        MADEUP_TEXT = MADEUP_TEXT.concat(PillarCipher.decryptPillar(LOADED_TEXT));
        saveTextInFile();
        MADEUP_TEXT = "";
        return true;
    }

}
