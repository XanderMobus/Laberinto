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
    private int player_x=20,player_y=10;
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
        setBounds(100, 100, 536, 460);
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
            g2.fillRect(10, 10, 500, 360);

            Rect r = new Rect(player_x, player_y, hh, hh, Color.black);
            g2.setColor(r.c);
            g2.fillRect(r.x, r.y, r.w, r.h);

            Rect p = new Rect(10, 10, hh, 360, Color.decode("#FF5733"));
            g2.setColor(p.c);
            g2.fillRect(p.x, p.y, p.w, p.h);


            Rect p2 = new Rect(20, 360, 470, hh, Color.decode("#FF5733"));
            g2.setColor(p2.c);
            g2.fillRect(p2.x, p2.y, p2.w, p2.h);

            Rect p3 = new Rect(30, 10, 480, hh, Color.decode("#FF5733"));
            g2.setColor(p3.c);
            g2.fillRect(p3.x, p3.y, p3.w, p3.h);

            Rect p4 = new Rect(500, 10, hh, 340, Color.decode("#FF5733"));
            g2.setColor(p4.c);
            g2.fillRect(p4.x, p4.y, p4.w, p4.h);

            Rect p5 = new Rect(20, 30, 20, hh, Color.decode("#FF5733"));
            g2.setColor(p5.c);
            g2.fillRect(p5.x, p5.y, p5.w, p5.h);

            Rect p6 = new Rect(30, 40, hh, 40, Color.decode("#FF5733"));
            g2.setColor(p6.c);
            g2.fillRect(p6.x, p6.y, p6.w, p6.h);

            Rect p7 = new Rect(50, 20, hh, hh, Color.decode("#FF5733"));
            g2.setColor(p7.c);
            g2.fillRect(p7.x, p7.y, p7.w, p7.h);

            Rect p8 = new Rect(40, 40, 30, hh, Color.decode("#FF5733"));
            g2.setColor(p8.c);
            g2.fillRect(p8.x, p8.y, p8.w, p8.h);

            Rect p9 = new Rect(70, 30, hh, 30, Color.decode("#FF5733"));
            g2.setColor(p9.c);
            g2.fillRect(p9.x, p9.y, p9.w, p9.h);

            Rect p10 = new Rect(80, 30, hh, hh, Color.decode("#FF5733"));
            g2.setColor(p10.c);
            g2.fillRect(p10.x, p10.y, p10.w, p10.h);

            Rect p11 = new Rect(100, 10, hh, 50, Color.decode("#FF5733"));
            g2.setColor(p11.c);
            g2.fillRect(p11.x, p11.y, p11.w, p11.h);

            Rect p12 = new Rect(20, 90, hh, hh, Color.decode("#FF5733"));
            g2.setColor(p12.c);
            g2.fillRect(p12.x, p12.y, p12.w, p12.h);

            Rect p13 = new Rect(30, 90, hh, 50, Color.decode("#FF5733"));
            g2.setColor(p13.c);
            g2.fillRect(p13.x, p13.y, p13.w, p13.h);

            Rect p14 = new Rect(90, 50, 50, hh, Color.decode("#FF5733"));
            g2.setColor(p14.c);
            g2.fillRect(p14.x, p14.y, p14.w, p14.h);

            Rect p15 = new Rect(120, 30, 70, hh, Color.decode("#FF5733"));
            g2.setColor(p15.c);
            g2.fillRect(p15.x, p15.y, p15.w, p15.h);

            Rect p16 = new Rect(190, 20, hh, 20, Color.decode("#FF5733"));
            g2.setColor(p16.c);
            g2.fillRect(p16.x, p16.y, p16.w, p16.h);

            Rect p17 = new Rect(50, 60, hh, 40, Color.decode("#FF5733"));
            g2.setColor(p17.c);
            g2.fillRect(p17.x, p17.y, p17.w, p17.h);

            Rect p18 = new Rect(60, 70, 50, hh, Color.decode("#FF5733"));
            g2.setColor(p18.c);
            g2.fillRect(p18.x, p18.y, p18.w, p18.h);

            Rect p19 = new Rect(120, 70, 40, hh, Color.decode("#FF5733"));
            g2.setColor(p19.c);
            g2.fillRect(p19.x, p19.y, p19.w, p19.h);

            Rect p20 = new Rect(150, 50, hh, 20, Color.decode("#FF5733"));
            g2.setColor(p20.c);
            g2.fillRect(p20.x, p20.y, p20.w, p20.h);

            Rect p21 = new Rect(160, 50, 50, hh, Color.decode("#FF5733"));
            g2.setColor(p21.c);
            g2.fillRect(p21.x, p21.y, p21.w, p21.h);

            Rect p22 = new Rect(210, 30, hh, 40, Color.decode("#FF5733"));
            g2.setColor(p22.c);
            g2.fillRect(p22.x, p22.y, p22.w, p22.h);

            Rect p23 = new Rect(220, 30, 50, hh, Color.decode("#FF5733"));
            g2.setColor(p23.c);
            g2.fillRect(p23.x, p23.y, p23.w, p23.h);

            Rect p24 = new Rect(280, 20, hh, 30, Color.decode("#FF5733"));
            g2.setColor(p24.c);
            g2.fillRect(p24.x, p24.y, p24.w, p24.h);

            Rect p25 = new Rect(290, 30, 40, hh, Color.decode("#FF5733"));
            g2.setColor(p25.c);
            g2.fillRect(p25.x, p25.y, p25.w, p25.h);

            Rect p26 = new Rect(430, 30, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p26.c);
            g2.fillRect(p26.x, p26.y, p26.w, p26.h);

            Rect p27 = new Rect(470, 40, hh, 20, Color.decode("#FF5733"));
            g2.setColor(p27.c);
            g2.fillRect(p27.x, p27.y, p27.w, p27.h);

            Rect p28 = new Rect(470, 50, 30, hh, Color.decode("#FF5733"));
            g2.setColor(p28.c);
            g2.fillRect(p28.x, p28.y, p28.w, p28.h);

            Rect p29 = new Rect(430, 50, 30, hh, Color.decode("#FF5733"));
            g2.setColor(p29.c);
            g2.fillRect(p29.x, p29.y, p29.w, p29.h);

            Rect p30 = new Rect(410, 70, 80, hh, Color.decode("#FF5733"));
            g2.setColor(p30.c);
            g2.fillRect(p30.x, p30.y, p30.w, p30.h);

            if(a==0){
            paredes.add(p);
            paredes.add(p2);
            paredes.add(p3);

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
