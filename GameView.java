import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;

public class GameView extends JPanel {

                         
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;


    public GameView() {
        //initialize buttons
        initButtons();
    }
                         
    private void initButtons() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();

        
        this.setBackground(new Color(51, 51, 51));
        this.setLayout(new java.awt.GridLayout(3, 3));

        btn1.setBackground(new Color(51, 51, 51));
        btn1.setForeground(new Color(204, 204, 255));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn1);

        btn2.setBackground(new Color(51, 51, 51));
        btn2.setForeground(new Color(204, 204, 255));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn2);

        btn3.setBackground(new Color(51, 51, 51));
        btn3.setForeground(new Color(204, 204, 255));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn3);

        btn4.setBackground(new Color(51, 51, 51));
        btn4.setForeground(new Color(204, 204, 255));
        btn4.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn4);

        btn5.setBackground(new Color(51, 51, 51));
        btn5.setForeground(new Color(204, 204, 255));
        btn5.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn5);

        btn6.setBackground(new Color(51, 51, 51));
        btn6.setForeground(new Color(204, 204, 255));
        btn6.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn6);

        btn7.setBackground(new Color(51, 51, 51));
        btn7.setForeground(new Color(204, 204, 255));
        btn7.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn7);

        btn8.setBackground(new Color(51, 51, 51));
        btn8.setForeground(new Color(204, 204, 255));
        btn8.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn8);

        btn9.setBackground(new Color(51, 51, 51));
        btn9.setForeground(new Color(204, 204, 255));
        btn9.setFont(new java.awt.Font("Tahoma", 1, 80)); 
        this.add(btn9);
    }

    //getters for buttons

    public JButton getBtn1() {
        return btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public JButton getBtn4() {
        return btn4;
    }

    public JButton getBtn5() {
        return btn5;
    }

    public JButton getBtn6() {
        return btn6;
    }

    public JButton getBtn7() {
        return btn7;
    }

    public JButton getBtn8() {
        return btn8;
    }

    public JButton getBtn9() {
        return btn9;
    } 
     
}
