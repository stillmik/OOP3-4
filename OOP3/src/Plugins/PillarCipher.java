package Plugins;

import javax.swing.*;
import java.util.Arrays;

class PillarCipher {

    private static String selectedKey;
    private static char[] sortedLettersInKey;
    private static int[] positionsOfLettersInKey;

    static boolean keyIsNotCorrect(String readKey) {

        readKey = readKey.replaceAll("[^A-Za-z]", "");
        if (readKey.length() < 3) {
            JOptionPane.showMessageDialog(null, "Минимальное кол-во англ.\nсимволов в ключе равна трем", "Critical error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        selectedKey = readKey;
        return false;
    }

    static String encryptPillar(String text) {

        doProcessOnKey();
        //сотворение матрицы
        int rowTemp = (int) Math.ceil((double) text.length() / selectedKey.length());
        int rowsCount = rowTemp;
        int columnTemp = -1;
        int totalKeyLen = rowTemp * selectedKey.length();
        char[][] plainMatrix = new char[(rowTemp)][(selectedKey.length())];
        char[] craftedText = new char[totalKeyLen];

        rowTemp = 0;

        for (int i = 0; i < totalKeyLen; i++) {
            columnTemp++;
            if (i < text.length()) {
                if (columnTemp == (selectedKey.length())) {
                    rowTemp++;
                    columnTemp = 0;
                }
                plainMatrix[rowTemp][columnTemp] = text.charAt(i);
            } else {
                plainMatrix[rowTemp][columnTemp] = '-';
            }
        }
        for (int i=0;i<rowTemp+1;i++) {
            for (int j = 0; j < columnTemp + 1; j++) {
                System.out.print(plainMatrix[i][j]+" ");
            }
            System.out.println();
        }
        //вывод по нужным столбцам
        int len = -1, pos;
        for (int value = 1; value <= selectedKey.length(); value++) {
            for (pos = 0; pos < sortedLettersInKey.length; pos++) {
                if (value == positionsOfLettersInKey[pos]) {
                    break;
                }
            }

            for (int u = 0; u < rowsCount; u++) {
                len++;
                craftedText[len] = plainMatrix[u][pos];
            }
        }

        return (new String(craftedText));
    }

    static String decryptPillar(String cipheredText) {

        char bookPos ='*';
        char[] cipheredTextArr = cipheredText.toCharArray();

        doProcessOnKey();

        int rowCount = (int) Math.ceil((double) cipheredText.length() / selectedKey.length());
        char[][] matrix = new char[rowCount][(selectedKey.length())];
        int arrI = -1;

        //filling matrix with stars to mark book positions
        int quantOfStars=-1;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < selectedKey.length(); j++) {
                quantOfStars++;
                if (quantOfStars == cipheredText.length())
                    break;
                matrix[i][j] = bookPos;
            }
        }

        int j, rowPos;
        for (int rowValue = 1; rowValue <= selectedKey.length(); rowValue++) {//+1
            for (rowPos = 0; rowPos < selectedKey.length(); rowPos++) {
                if (rowValue == positionsOfLettersInKey[rowPos]) {
                    break;
                }
            }
            for (j = 0; j < rowCount; j++) {
                arrI++;
                if (arrI >= cipheredTextArr.length) {
                    break;
                }
                if (matrix[j][rowPos] == bookPos) {
                    matrix[j][rowPos] = cipheredTextArr[arrI];
                }else {
                    arrI--;
                }
            }
        }

        //creating string from matrix
        char[] p1 = new char[rowCount * selectedKey.length()];

        rowPos = 0;
        for (int i = 0; i < rowCount; i++) {
            for (j = 0; j < selectedKey.length(); j++) {
                p1[rowPos++] = matrix[i][j];
            }
        }
        for (int i=0;i<rowCount;i++) {
            for (int p = 0; p < selectedKey.length() ; p++) {
                System.out.print(matrix[i][p]+" ");
            }
            System.out.println();
        }

        return (new String(p1));
    }

    private static void doProcessOnKey() {
        selectedKey = selectedKey.toUpperCase();
        sortedLettersInKey = selectedKey.toCharArray();
        positionsOfLettersInKey = new int[selectedKey.length()];
        int begin = 65;
        int count = 1;
        while (begin != 91) {
            for (int i = 0; i < selectedKey.length(); i++) {

                if (sortedLettersInKey[i] == begin && positionsOfLettersInKey[i] == 0) {
                    positionsOfLettersInKey[i] = count;
                    count++;
                    i = 0;
                }
            }
            begin++;
        }
        System.out.println(Arrays.toString(positionsOfLettersInKey));

    }

}
