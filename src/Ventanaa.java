import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

public class Ventanaa extends JFrame {

    private JPanel frame;

    private int a=0;

    private int segundos=0,minutos;

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
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos=0;
                minutos=0;
                player_x=20;
                player_y=10;
                frame.requestFocus();
                repaint();
            }
        });
        Panel.add(btnNewButton);

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            public void run() {
                segundos++;

                if(segundos==60){
                    minutos++;
                    segundos=0;
                }
            }
        };
        timer.scheduleAtFixedRate(tarea, 0, 1000);


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
                if(e.getKeyCode()==39 && player_x<500) {
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

            Rect meta = new Rect(490, 360, hh, hh, Color.MAGENTA);
            g2.setColor(meta.c);
            g2.fillRect(meta.x, meta.y, meta.w, meta.h);

            Rect p = new Rect(10, 10, hh, 360, Color.decode("#FF5733"));
            g2.setColor(p.c);
            g2.fillRect(p.x, p.y, p.w, p.h);


            Rect p2 = new Rect(20, 360, 470, hh, Color.decode("#FF5733"));
            g2.setColor(p2.c);
            g2.fillRect(p2.x, p2.y, p2.w, p2.h);

            Rect p3 = new Rect(30, 10, 480, hh, Color.decode("#FF5733"));
            g2.setColor(p3.c);
            g2.fillRect(p3.x, p3.y, p3.w, p3.h);

            Rect p4 = new Rect(500, 10, hh, 360, Color.decode("#FF5733"));
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


            Rect p31 = new Rect(70, 90, 100, hh, Color.decode("#FF5733"));
            g2.setColor(p31.c);
            g2.fillRect(p31.x, p31.y, p31.w, p31.h);

            Rect p32 = new Rect(170, 70, hh, 40, Color.decode("#FF5733"));
            g2.setColor(p32.c);
            g2.fillRect(p32.x, p32.y, p32.w, p32.h);

            Rect p33 = new Rect(190, 70, 30, hh, Color.decode("#FF5733"));
            g2.setColor(p33.c);
            g2.fillRect(p33.x, p33.y, p33.w, p33.h);

            Rect p34 = new Rect(190, 90, 40, hh, Color.decode("#FF5733"));
            g2.setColor(p34.c);
            g2.fillRect(p34.x, p34.y, p34.w, p34.h);

            Rect p35 = new Rect(230, 50, hh, 50, Color.decode("#FF5733"));
            g2.setColor(p35.c);
            g2.fillRect(p35.x, p35.y, p35.w, p35.h);

            Rect p36 = new Rect(240, 50, 30, hh, Color.decode("#FF5733"));
            g2.setColor(p36.c);
            g2.fillRect(p36.x, p36.y, p36.w, p36.h);

            Rect p37 = new Rect(280, 50, 70, hh, Color.decode("#FF5733"));
            g2.setColor(p37.c);
            g2.fillRect(p37.x, p37.y, p37.w, p37.h);

            Rect p38 = new Rect(340, 30, hh, 20, Color.decode("#FF5733"));
            g2.setColor(p38.c);
            g2.fillRect(p38.x, p38.y, p38.w, p38.h);

            Rect p39 = new Rect(350, 30, 70, hh, Color.decode("#FF5733"));
            g2.setColor(p39.c);
            g2.fillRect(p39.x, p39.y, p39.w, p39.h);

            Rect p40 = new Rect(410, 50, hh, 20, Color.decode("#FF5733"));
            g2.setColor(p40.c);
            g2.fillRect(p40.x, p40.y, p40.w, p40.h);

            Rect p41 = new Rect(360, 50, 40, hh, Color.decode("#FF5733"));
            g2.setColor(p41.c);
            g2.fillRect(p41.x, p41.y, p41.w, p41.h);

            Rect p42 = new Rect(250, 70, 150, hh, Color.decode("#FF5733"));
            g2.setColor(p42.c);
            g2.fillRect(p42.x, p42.y, p42.w, p42.h);

            Rect p43 = new Rect(440, 90, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p43.c);
            g2.fillRect(p43.x, p43.y, p43.w, p43.h);


            Rect p44 = new Rect(440, 110, 50, hh, Color.decode("#FF5733"));
            g2.setColor(p44.c);
            g2.fillRect(p44.x, p44.y, p44.w, p44.h);

            Rect p45 = new Rect(480, 120, hh, 80, Color.decode("#FF5733"));
            g2.setColor(p45.c);
            g2.fillRect(p45.x, p45.y, p45.w, p45.h);

            Rect p46 = new Rect(460, 130, hh, 80, Color.decode("#FF5733"));
            g2.setColor(p46.c);
            g2.fillRect(p46.x, p46.y, p46.w, p46.h);

            Rect p47 = new Rect(470, 200, 20, hh, Color.decode("#FF5733"));
            g2.setColor(p47.c);
            g2.fillRect(p47.x, p47.y, p47.w, p47.h);

            Rect p48 = new Rect(430, 220, 70, hh, Color.decode("#FF5733"));
            g2.setColor(p48.c);
            g2.fillRect(p48.x, p48.y, p48.w, p48.h);

            Rect p49 = new Rect(440, 130, hh, 90, Color.decode("#FF5733"));
            g2.setColor(p49.c);
            g2.fillRect(p49.x, p49.y, p49.w, p49.h);

            Rect p50 = new Rect(420, 90, hh, 120, Color.decode("#FF5733"));
            g2.setColor(p50.c);
            g2.fillRect(p50.x, p50.y, p50.w, p50.h);

            Rect p51 = new Rect(330, 90, 80, hh, Color.decode("#FF5733"));
            g2.setColor(p51.c);
            g2.fillRect(p51.x, p51.y, p51.w, p51.h);

            Rect p52 = new Rect(320, 80, hh, 70, Color.decode("#FF5733"));
            g2.setColor(p52.c);
            g2.fillRect(p52.x, p52.y, p52.w, p52.h);

            Rect p53 = new Rect(340, 110, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p53.c);
            g2.fillRect(p53.x, p53.y, p53.w, p53.h);

            Rect p54 = new Rect(400, 110, hh, 30, Color.decode("#FF5733"));
            g2.setColor(p54.c);
            g2.fillRect(p54.x, p54.y, p54.w, p54.h);

            Rect p55 = new Rect(340, 130, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p55.c);
            g2.fillRect(p55.x, p55.y, p55.w, p55.h);

            Rect p56 = new Rect(340, 130, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p56.c);
            g2.fillRect(p56.x, p56.y, p56.w, p56.h);

            Rect p57 = new Rect(480, 320, hh, 40, Color.decode("#FF5733"));
            g2.setColor(p57.c);
            g2.fillRect(p57.x, p57.y, p57.w, p57.h);

            Rect p58 = new Rect(450, 300, 50, hh, Color.decode("#FF5733"));
            g2.setColor(p58.c);
            g2.fillRect(p58.x, p58.y, p58.w, p58.h);

            Rect p59 = new Rect(460, 320, hh, 30, Color.decode("#FF5733"));
            g2.setColor(p59.c);
            g2.fillRect(p59.x, p59.y, p59.w, p59.h);

            Rect p60 = new Rect(420, 330, 40, hh, Color.decode("#FF5733"));
            g2.setColor(p60.c);
            g2.fillRect(p60.x, p60.y, p60.w, p60.h);

            Rect p61 = new Rect(440, 240, hh, 80, Color.decode("#FF5733"));
            g2.setColor(p61.c);
            g2.fillRect(p61.x, p61.y, p61.w, p61.h);

            Rect p62 = new Rect(460, 280, 30, hh, Color.decode("#FF5733"));
            g2.setColor(p62.c);
            g2.fillRect(p62.x, p62.y, p62.w, p62.h);

            Rect p63 = new Rect(480, 240, hh, 40, Color.decode("#FF5733"));
            g2.setColor(p63.c);
            g2.fillRect(p63.x, p63.y, p63.w, p63.h);

            Rect p64 = new Rect(460, 240, hh, 30, Color.decode("#FF5733"));
            g2.setColor(p64.c);
            g2.fillRect(p64.x, p64.y, p64.w, p64.h);

            Rect p65 = new Rect(380, 220, 40, hh, Color.decode("#FF5733"));
            g2.setColor(p65.c);
            g2.fillRect(p65.x, p65.y, p65.w, p65.h);

            Rect p66 = new Rect(400, 150, hh, 70, Color.decode("#FF5733"));
            g2.setColor(p66.c);
            g2.fillRect(p66.x, p66.y, p66.w, p66.h);

            Rect p67 = new Rect(380, 160, hh, 50, Color.decode("#FF5733"));
            g2.setColor(p67.c);
            g2.fillRect(p67.x, p67.y, p67.w, p67.h);

            Rect p68 = new Rect(340, 150, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p68.c);
            g2.fillRect(p68.x, p68.y, p68.w, p68.h);

            Rect p69 = new Rect(360, 170, hh, 80, Color.decode("#FF5733"));
            g2.setColor(p69.c);
            g2.fillRect(p69.x, p69.y, p69.w, p69.h);

            Rect p70 = new Rect(60, 110, 70, hh, Color.decode("#FF5733"));
            g2.setColor(p70.c);
            g2.fillRect(p70.x, p70.y, p70.w, p70.h);

            Rect p71 = new Rect(50, 110, hh, 30, Color.decode("#FF5733"));
            g2.setColor(p71.c);
            g2.fillRect(p71.x, p71.y, p71.w, p71.h);

            Rect p72 = new Rect(20, 150, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p72.c);
            g2.fillRect(p72.x, p72.y, p72.w, p72.h);

            Rect p73 = new Rect(30, 170, hh,50, Color.decode("#FF5733"));
            g2.setColor(p73.c);
            g2.fillRect(p73.x, p73.y, p73.w, p73.h);

            Rect p74 = new Rect(60, 130, 40, hh, Color.decode("#FF5733"));
            g2.setColor(p74.c);
            g2.fillRect(p74.x, p74.y, p74.w, p74.h);

            Rect p75 = new Rect(90, 140, hh,40, Color.decode("#FF5733"));
            g2.setColor(p75.c);
            g2.fillRect(p75.x, p75.y, p75.w, p75.h);

            Rect p76 = new Rect(50, 170, 30,hh, Color.decode("#FF5733"));
            g2.setColor(p76.c);
            g2.fillRect(p76.x, p76.y, p76.w, p76.h);

            Rect p77 = new Rect(50, 180, hh,80, Color.decode("#FF5733"));
            g2.setColor(p77.c);
            g2.fillRect(p77.x, p77.y, p77.w, p77.h);

            Rect p78 = new Rect(30, 230, 20,hh, Color.decode("#FF5733"));
            g2.setColor(p78.c);
            g2.fillRect(p78.x, p78.y, p78.w, p78.h);

            Rect p79 = new Rect(30, 240, hh,40, Color.decode("#FF5733"));
            g2.setColor(p79.c);
            g2.fillRect(p79.x, p79.y, p79.w, p79.h);

            Rect p80 = new Rect(60, 240, 30,hh, Color.decode("#FF5733"));
            g2.setColor(p80.c);
            g2.fillRect(p80.x, p80.y, p80.w, p80.h);

            Rect p81 = new Rect(50, 270, 30,hh, Color.decode("#FF5733"));
            g2.setColor(p81.c);
            g2.fillRect(p81.x, p81.y, p81.w, p81.h);


            Rect p82 = new Rect(70, 250, hh,20, Color.decode("#FF5733"));
            g2.setColor(p82.c);
            g2.fillRect(p82.x, p82.y, p82.w, p82.h);

            Rect p83 = new Rect(140, 110, 110,hh, Color.decode("#FF5733"));
            g2.setColor(p83.c);
            g2.fillRect(p83.x, p83.y, p83.w, p83.h);

            Rect p84 = new Rect(250, 90, hh,60, Color.decode("#FF5733"));
            g2.setColor(p84.c);
            g2.fillRect(p84.x, p84.y, p84.w, p84.h);

            Rect p85 = new Rect(270, 90, 40,hh, Color.decode("#FF5733"));
            g2.setColor(p85.c);
            g2.fillRect(p85.x, p85.y, p85.w, p85.h);

            Rect p86 = new Rect(270, 100, hh,70, Color.decode("#FF5733"));
            g2.setColor(p86.c);
            g2.fillRect(p86.x, p86.y, p86.w, p86.h);

            Rect p87 = new Rect(300, 100, hh,60, Color.decode("#FF5733"));
            g2.setColor(p87.c);
            g2.fillRect(p87.x, p87.y, p87.w, p87.h);

            Rect p88 = new Rect(290, 110, hh,hh, Color.decode("#FF5733"));
            g2.setColor(p88.c);
            g2.fillRect(p88.x, p88.y, p88.w, p88.h);

            Rect p89 = new Rect(290, 130, hh,hh, Color.decode("#FF5733"));
            g2.setColor(p89.c);
            g2.fillRect(p88.x, p89.y, p89.w, p89.h);

            Rect p90 = new Rect(290, 150, hh,hh, Color.decode("#FF5733"));
            g2.setColor(p90.c);
            g2.fillRect(p90.x, p90.y, p90.w, p90.h);

            Rect p91 = new Rect(270, 170, 60, hh, Color.decode("#FF5733"));
            g2.setColor(p91.c);
            g2.fillRect(p91.x, p91.y, p91.w, p91.h);

            Rect p92 = new Rect(320, 160, hh, hh, Color.decode("#FF5733"));
            g2.setColor(p92.c);
            g2.fillRect(p92.x, p92.y, p92.w, p92.h);

            Rect p93 = new Rect(330, 170, 20, hh, Color.decode("#FF5733"));
            g2.setColor(p93.c);
            g2.fillRect(p93.x, p93.y, p93.w, p93.h);












            if(a==0){
            paredes.add(p);
            paredes.add(p2);
            paredes.add(p3);

            a=1;
            }

            System.out.println(player_x);
            System.out.println(player_y);



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
            if(r.colision(meta)){
                if(segundos<10 && minutos<10){
                    JOptionPane.showMessageDialog(null,"Ganaste, tu tiempo fue 0"+minutos+":0"+segundos,"GG",JOptionPane.INFORMATION_MESSAGE);
                }
                if(segundos>10 && minutos>10) {
                    JOptionPane.showMessageDialog(null, "Ganaste, tu tiempo fue " + minutos + ":" + segundos, "GG", JOptionPane.INFORMATION_MESSAGE);
                }
                if(segundos>10 && minutos<10) {
                    JOptionPane.showMessageDialog(null, "Ganaste, tu tiempo fue 0" + minutos + ":" + segundos, "GG", JOptionPane.INFORMATION_MESSAGE);
                }
                if(segundos<10 && minutos>10) {
                    JOptionPane.showMessageDialog(null, "Ganaste, tu tiempo fue " + minutos + ":0" + segundos, "GG", JOptionPane.INFORMATION_MESSAGE);
                }
                segundos=0;
                minutos=0;
                player_x=20;
                player_y=10;

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
