import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;

public class Ventanaa extends JFrame {

    private JPanel frame;

    private int a=0;

    private ArrayList<Rect> paredes = new ArrayList<>();
    private int hh=10;
    private int ultima_tecla;
    private int player_x=30,player_y=30;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventanaa frame = new Ventanaa();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ventanaa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 636, 460);
        frame = new JPanel();

        setContentPane(frame);
        frame.setLayout(new BorderLayout(0, 0));

        Dibujo Juego = new Dibujo();
        Juego.setBackground(Color.cyan);
        frame.add(Juego, BorderLayout.CENTER);

        JPanel Panel = new JPanel();
        Panel.setBackground(new Color(124, 252, 0));
        frame.add(Panel, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("Reiniciar");
        Panel.add(btnNewButton);

        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if(e.getKeyCode()==38 && player_y>10) {
                    player_y-=hh;
                    ultima_tecla=38;
                }
                if(e.getKeyCode()==40 && player_y<360) {
                    player_y+=hh;
                    ultima_tecla=40;
                }
                if(e.getKeyCode()==37 && player_x>10) {
                    player_x-=hh;
                    ultima_tecla=37;
                }
                if(e.getKeyCode()==39 && player_x<600) {
                    player_x+=hh;
                    ultima_tecla=39;
                }


                Juego.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

        });
        frame.setFocusable(true);
        frame.requestFocus();
    }
    public class Dibujo extends JPanel{

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);


            Graphics2D g2 = (Graphics2D) g;

            g2.setStroke(new BasicStroke(5));

            g2.setColor(new Color(255, 255, 255));
            g2.fillRect(10, 10, 600, 360);

            Rect r = new Rect(player_x, player_y, hh, hh, Color.black);

            g2.setColor(r.c);
            g2.fillRect(r.x, r.y, r.w, r.h);

            Rect p = new Rect(10, 10, hh, 360, Color.decode("#FF5733"));

            g2.setColor(p.c);
            g2.fillRect(p.x, p.y, p.w, p.h);


            Rect p2 = new Rect(20, 360, 580, hh, Color.decode("#FF5733"));

            g2.setColor(p2.c);
            g2.fillRect(p2.x, p2.y, p2.w, p2.h);

        /*    Rect p3 = new Rect(20, 360, 580, hh, Color.decode("#FF5733"));

            g2.setColor(p3.c);
            g2.fillRect(p3.x, p3.y, p3.w, p3.h);*/

            if(a==0){
            paredes.add(p);
            paredes.add(p2);
            a=1;
            }




            for(int i=0;i<paredes.size();i++) {
                if (r.colision(paredes.get(i))) {
                    if (ultima_tecla == 38) {
                        player_y += hh;

                    }
                    if (ultima_tecla == 40) {
                        player_y -= hh;

                    }
                    if (ultima_tecla == 37) {
                        player_x += hh;

                    }
                    if (ultima_tecla == 39) {
                        player_x -= hh;


                    }
                    repaint();
                }
            }



        }


    }

    public class Rect {

        int x=0;
        int y=0;
        int w=0;
        int h=0;
        Color c = Color.BLACK;

        Rect(int x,int y, int w, int h, Color c){
            this.x=x;
            this.y=y;
            this.w=w;
            this.h=h;
            this.c=c;

        }

        public Boolean colision(Rect target) {

            if(this.x<target.x+target.w &&
                    this.x+w>target.x &&

                    this.y<target.y+target.h &&
                    this.y+this.h>target.y) {
                return true;
            }
            return false;
        }
    }
}
