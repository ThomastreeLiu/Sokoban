//Name:
//Date:
//Purpose:

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Sokoban extends JPanel implements ActionListener{

    private JPanel p_card;  //to hold all of the screens
    private JPanel card1, card2, card3, card4, card5;
    private CardLayout cdLayout = new CardLayout();
    private JLabel feedback = new JLabel("");

    //grid
    private int row = 7;
    private int col = 7;

    private int level = 1;


    private int x = 3;
    private int y = 2;
    private JLabel iconArray[] = new JLabel[row * col];

    private char ground[][] =
            {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
                    {'w', 'b', 'n', 'g', 'b', 'n', 'w'},
                    {'w', 'n', 'n', 'n', 'n', 'n', 'w'},
                    {'w', 'n', 'n', 'n', 'n', 'g', 'w'},
                    {'w', 'g', 'n', 'n', 'n', 'b', 'w'},
                    {'w', 'b', 'n', 'n', 'g', 'n', 'w'},
                    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    private char top[][] =
            {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
                    {'w', 'z', 'n', 'n', 'z', 'n', 'w'},
                    {'w', 'n', 'n', 'b', 'n', 'n', 'w'},
                    {'w', 'n', 'n', 'n', 'b', 'n', 'w'},
                    {'w', 'n', 'b', 'n', 'b', 'z', 'w'},
                    {'w', 'z', 'n', 'n', 'n', 'n', 'w'},
                    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    public Sokoban(){

        p_card = new JPanel();
        p_card.setLayout(cdLayout);
        screen1();
        screen2();
        screen3();
        screen4();
        screen5();
        setLayout(new BorderLayout());
        add("Center", p_card);
    }


    public void screen1(){
        //screen 1 is set up.
        card1 = new JPanel();
        card1.setBackground(Color.white);
        JLabel title = new JLabel("Welcome");
        JButton next = new JButton("Next");
        next.setActionCommand("s2");
        next.addActionListener(this);
        card1.add(title);
        card1.add(next);
        p_card.add("1", card1);
    }


    public void screen2(){
        //screen 2 is set up.
        card2 = new JPanel();
        card2.setBackground(Color.white);
        JLabel title = new JLabel("Instructions");
        JButton next = new JButton("Next");
        next.setActionCommand("s3");
        next.addActionListener(this);
        card2.add(title);
        card2.add(next);
        p_card.add("2", card2);
    }


    public void screen3(){
        //screen 3 is set up.
        card3 = new JPanel();
        card3.setBackground(Color.white);
        JLabel title = new JLabel("Sokoban Game");
        JButton next = new JButton("Next");
        next.setActionCommand("s4");
        next.addActionListener(this);

        //Set up grid
        JPanel pane = new JPanel(new GridLayout(row, col));
        int move = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                iconArray[move] = new JLabel(createImageIcon(ground[i][j] + "" + top[i][j] + ".png"));
                iconArray[move].setPreferredSize(new Dimension(127, 127));
                pane.add(iconArray[move]);
                move++;
            }
        }

        //iconArray[x * col + y].setIcon(createImageIcon(ground[x][y] + "down.png"));

        JButton up = new JButton("Up");
        up.setActionCommand("up");
        up.addActionListener(this);
        JButton down = new JButton("Down");
        down.setActionCommand("down");
        down.addActionListener(this);
        JButton right = new JButton("Right");
        right.setActionCommand("right");
        right.addActionListener(this);
        JButton left = new JButton("Left");
        left.setActionCommand("left");
        left.addActionListener(this);

        card3.add(title);
        card3.add(next);

        card3.add(pane);

        JPanel dir = new JPanel(new GridLayout(2, 3));
        JLabel filler = new JLabel("");
        JLabel filler2 = new JLabel("");
        dir.add(filler);
        dir.add(up);
        dir.add(filler2);

        dir.add(left);
        dir.add(down);
        dir.add(right);
        card3.add(dir);


        p_card.add("3", card3);
    }


    public void screen4(){
        //screen 4 is set up.
        card4 = new JPanel();
        card4.setBackground(Color.yellow);
        JLabel title = new JLabel("You Win!");
        JButton next = new JButton("Next");
        next.setActionCommand("s5");
        next.addActionListener(this);
        card4.add(title);
        card4.add(next);
        p_card.add("4", card4);
    }


    public void screen5(){
        //screen 5 is set up.
        card5 = new JPanel();
        card5.setBackground(Color.cyan);
        JLabel title = new JLabel("You Lose.");
        JButton next = new JButton("Back to Introduction?");
        next.setActionCommand("s1");
        next.addActionListener(this);
        JButton end = new JButton("Quit?");
        end.setActionCommand("s6");
        end.addActionListener(this);
        card5.add(title);
        card5.add(next);
        card5.add(end);
        p_card.add("5", card5);
    }



    protected static ImageIcon createImageIcon(String path){
        //change the red to your class name
        java.net.URL imgURL = Sokoban.class.getResource(path);
        if(imgURL != null){
            return new ImageIcon(imgURL);
        }
        else{
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    public void redraw(){

        int move = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                iconArray[move].setIcon(createImageIcon(ground[i][j] + "" + top[i][j] + ".png"));
                move++;
            }
        }

    }



    public void moveUp()
    {
    }


    public void moveDown()
    {
    }


    public void moveLeft()
    {
    }


    public void moveRight()
    {
    }


    public void copyOver(char a[][], char b[][]){

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                a[i][j] = b[i][j];
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //moves between the screens
        if(e.getActionCommand().equals("s1"))
            cdLayout.show(p_card, "1");
        else if(e.getActionCommand().equals("s2"))
            cdLayout.show(p_card, "2");
        else if(e.getActionCommand().equals("s3"))
            cdLayout.show(p_card, "3");
        else if(e.getActionCommand().equals("s4"))
            cdLayout.show(p_card, "4");
        else if(e.getActionCommand().equals("s5"))
            cdLayout.show(p_card, "5");
        else if(e.getActionCommand().equals("s6"))
            System.exit(0);
        else if(e.getActionCommand().equals("up"))
            moveUp();
        else if(e.getActionCommand().equals("down"))
            moveDown();
        else if(e.getActionCommand().equals("left"))
            moveLeft();
        else if(e.getActionCommand().equals("right"))
            moveRight();

    }

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("PLACEHOLDER: Sokoban");

        frame.setSize(1920, 1080);         //resizes JFrame pane size
        frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Sokoban panel = new Sokoban();
        panel.setOpaque(true);  //sets menu bar colour in MacOS
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
