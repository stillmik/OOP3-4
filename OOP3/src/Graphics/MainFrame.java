package Graphics;

import Badges.*;
import Plugins.Controller;

import javax.swing.*;
import java.awt.*;
import java.beans.XMLEncoder;
import java.util.ArrayList;

public class MainFrame {

    private JFrame jFrame = new JFrame();
    private JLabel topHeader = new JLabel("Награды");

    private JButton editMedal = new JButton("Медали");
    private JButton editOrder = new JButton("Орден");
    private JButton editEmblem = new JButton("Эмблема");
    private JButton editAnniversary = new JButton("Юбилейный знак");
    private JButton editMilitary = new JButton("Воинский знак");

    private JButton showMedal = new JButton("Показать Медали");
    private JButton showOrder = new JButton("Показать Ордена");
    private JButton showEmblem = new JButton("Показать Эмблемы");
    private JButton showAnniversary = new JButton("Показать Юбилейные знаки");
    private JButton showMilitary = new JButton("Показать Воинские знаки");

    private ArrayList<Medal> medals = new ArrayList<>();
    private ArrayList<MilitaryBadge> militaryBadges=new ArrayList<>();
    private ArrayList<AnniversaryBadge> anniversaryBadges = new ArrayList<>();
    private ArrayList<Emblem> emblems = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public MainFrame() {
        mainFrameComponentsSetUp();
        mainFrameAddComponents();
        mainFrameFinalSettings();
        addEventListeners();
        showEventListener();
        new Controller(jFrame);
    }

    private void mainFrameFinalSettings() {
        jFrame.setBounds(600, 140, 460, 580);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void mainFrameAddComponents() {

        jFrame.add(editOrder);
        jFrame.add(editMedal);
        jFrame.add(editEmblem);
        jFrame.add(editAnniversary);
        jFrame.add(editMilitary);

        jFrame.add(showOrder);
        jFrame.add(showMedal);
        jFrame.add(showEmblem);
        jFrame.add(showAnniversary);
        jFrame.add(showMilitary);

        jFrame.add(topHeader);

    }

    private void mainFrameComponentsSetUp() {

        topHeader.setFont(new Font("Font", Font.ITALIC, 30));
        topHeader.setBounds(30, 10, 400, 35);

        editMedal.setBounds(120,125,200,25);
        editAnniversary.setBounds(120,150,200,25);
        editMilitary.setBounds(120,175,200,25);
        editEmblem.setBounds(120,200,200,25);
        editOrder.setBounds(120,225,200,25);

        showMedal.setBounds(120,300,200,25);
        showAnniversary.setBounds(120,325,200,25);
        showMilitary.setBounds(120,350,200,25);
        showEmblem.setBounds(120,375,200,25);
        showOrder.setBounds(120,400,200,25);

        editMilitary.setFocusPainted(false);
        editMedal.setFocusPainted(false);
        editAnniversary.setFocusPainted(false);
        editEmblem.setFocusPainted(false);
        editOrder.setFocusPainted(false);

        showMilitary.setFocusPainted(false);
        showMedal.setFocusPainted(false);
        showAnniversary.setFocusPainted(false);
        showEmblem.setFocusPainted(false);
        showOrder.setFocusPainted(false);
    }

    private void addEventListeners(){

        editMedal.addActionListener(e -> new MedalFrame(medals));

        editOrder.addActionListener(e -> new OrderFrame(orders));

        editMilitary.addActionListener(e -> new MilitaryFrame(militaryBadges));

        editEmblem.addActionListener(e -> new EmblemFrame(emblems));

        editAnniversary.addActionListener(e -> new AnniversaryFrame(anniversaryBadges));

    }

    private void showEventListener(){

        showMedal.addActionListener(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(Medal medal:medals){
                stringBuilder.append("Unique Number: ").append(medal.getUniqNum()).append("\nWearing: ").append(medal.getWearing()).append("\nAffiliation: ").append(medal.getAffiliation()).append("\nBranch Merit: ").append(medal.getBranchMerit()).append("\nThanked For: ").append(medal.getThankedFor()).append("\n\n\n");
            }
            new ShowFrame(stringBuilder.toString());
        });

        showEmblem.addActionListener(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(Emblem emblem: emblems){
                stringBuilder.append("Unique Number: ").append(emblem.getUniqNum()).append("\nWearing: ").append(emblem.getWearing()).append("\nAffiliation: ").append(emblem.getAffiliation()).append("\nUniversity Merit: ").append(emblem.getUniversityMerit()).append("\nThanked For: ").append(emblem.getThankedFor()).append("\n\n\n");
            }
            new ShowFrame(stringBuilder.toString());
        });

        showAnniversary.addActionListener(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(AnniversaryBadge anniversary:anniversaryBadges){
                stringBuilder.append("Unique Number: ").append(anniversary.getUniqNum()).append("\nWearing: ").append(anniversary.getWearing()).append("\nAffiliation: ").append(anniversary.getAffiliation()).append("\nAnniversary: ").append(anniversary.getAnniversary()).append("\nThanked For: ").append(anniversary.getThankedFor()).append("\n\n\n");
            }
            new ShowFrame(stringBuilder.toString());
        });
        showMilitary.addActionListener(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(MilitaryBadge military: militaryBadges){
                stringBuilder.append("Unique Number: ").append(military.getUniqNum()).append("\nWearing: ").append(military.getWearing()).append("\nAffiliation: ").append(military.getAffiliation()).append("\nPost: ").append(military.getPost()).append("\nThanked For: ").append(military.getThankedFor()).append("\n\n\n");
            }
            new ShowFrame(stringBuilder.toString());
        });
        showOrder.addActionListener(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(Order order: orders){
                stringBuilder.append("Unique Number: ").append(order.getUniqNum()).append("\nWearing: ").append(order.getWearing()).append("\nAffiliation: ").append(order.getAffiliation()).append("\nState Merit: ").append(order.getStateMerit()).append("\nThanked For: ").append(order.getThankedFor()).append("\n\n\n");
            }
            new ShowFrame(stringBuilder.toString());

        });

    }
}