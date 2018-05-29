import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MFrame extends JFrame {
    Container cp;
    private Timer t1;
    private Timer t2;
    private int newjlb2X, newjlb2Y;
    private int tarX, tarY;
    private float m = 0.0f;
    private int dirFlag = 1, objX = 50, objY = 50, objW = 50, objH = 50;
    private JButton jbnR = new JButton("RUN");
    private JButton jbnU = new JButton("↑");
    private JButton jbnD = new JButton("↓");
    private JButton jbnRI = new JButton("←");
    private JButton jbnL = new JButton("→");
    private JButton jbnE = new JButton("EXIT");
    private JLabel jlb = new JLabel();
    private JLabel jlb2 = new JLabel();
    private ImageIcon icon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled\\src\\moomin.jpg");
    private boolean jlb2flag = false;

    public MFrame() {
        Ex1();
    }

    private void Ex1() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(100, 50);
        this.setSize(800, 600);
        cp = this.getContentPane();

        jbnR.setBounds(100, 500, 100, 50);
        jbnU.setBounds(200, 500, 100, 50);
        jbnD.setBounds(300, 500, 100, 50);
        jbnRI.setBounds(400, 500, 100, 50);
        jbnL.setBounds(500, 500, 100, 50);
        jbnE.setBounds(600, 500, 100, 50);
        jlb.setBounds(50, 50, 100, 100);
        jlb2.setBounds(150, 150, 100, 100);
        jlb.setIcon(icon);
        jlb2.setIcon(icon);

        this.add(jbnR);
        this.add(jbnU);
        this.add(jbnD);
        this.add(jbnRI);
        this.add(jbnL);
        this.add(jbnE);
        this.add(jlb);
        this.add(jlb2);


        jbnR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });
        jbnU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 1;
            }
        });
        jbnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 2;
            }
        });
        jbnRI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 3;
            }
        });
        jbnL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 4;
            }
        });

        t2 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Math.abs(jlb2.getX() - tarX) < 30 && Math.abs(jlb2.getY() - tarY) < 30) {
                    t2.stop();
                } else {
                    if (jlb2.getX() < tarX) {
                        newjlb2X = jlb2.getX() + 3;
                    } else {
                        newjlb2X = jlb2.getX() - 3;
                    }
                    newjlb2Y = Math.round(m * (float) (newjlb2X - jlb2.getX()) + jlb2.getX());
                    jlb2flag=true;
                    jlb2.setLocation(newjlb2X, newjlb2Y);
                    System.out.println(newjlb2X + "," + newjlb2Y);
                }
            }
        });
        jlb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jlb2flag = true;
            }
        });
        cp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tarX = e.getX();
                tarY = e.getY();

                if (jlb2flag) {
//                    jlb2.setLocation(e.getX(), e.getY());
                    jlb2flag = false;
                    m = (float)(tarY - getY())/(float) (tarX - getX());
                    t2.start();

            }
            }

        });
        t1 = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag) {
                    case 1:
                        if (objY - 2 > 0) {
                            objY -= 2;
                        }
                        break;
                    case 2:
                        if (objY < 300) {
                            objY += 2;
                        }
                        break;
                    case 3:
                        if (objX - 2 > 0) {
                            objX -= 2;
                        }
                        break;
                    case 4:
                        if (objX < 600) {
                            objX += 2;
                        }
                        break;
                    case 5:
                        if (objW - 2 > 0) {
                            objW -= 2;
                        }
                        break;
                    case 6:
                        if (objW < 500) {
                            objW += 2;
                        }
                        break;
                    case 7:
                        if (objH - 2 > 0) {
                            objH -= 2;
                        }
                        break;
                    case 8:
                        if (objH < 500) {
                            objH += 2;
                        }
                        break;
                }
                jlb.setLocation(objX, objY);
            }
        });
        jbnE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
