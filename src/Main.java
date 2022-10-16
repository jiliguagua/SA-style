import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Main extends JFrame{
    JTextField jtfUrl;

    JButton jb1;
    JButton jb2;
    JButton jb3;
    JButton jb4;

    Image image;
    JTextArea text;
    Toolkit toolKit;
    public Main(){
        super("经典软件体系结构教学软件");
        Container container=getContentPane();
        jtfUrl=new JTextField("请输入txt文件地址",18);
        JPanel jp = new JPanel();
        JTextArea jta = new JTextArea(20, 20);

        jb1 = new JButton("主程序-子程序");
        jb1.setBounds(20, 200, 100, 100);
        jb2 = new JButton("事件系统");
        jb2.setBounds(20, 350, 100, 100);
        jb3 = new JButton("管道-过滤");
        jb3.setBounds(20, 500, 100, 100);
        jb4 = new JButton("面向对象");
        jb4.setBounds(20, 650, 100, 100);

        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);

        container.setLayout(new FlowLayout());


        container.add(jtfUrl);
        container.add(jp);
        container.add(jta);
        toolKit=getToolkit();

        jtfUrl.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jtfUrl.getText().equals("请输入txt文件地址")) {
                    jtfUrl.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jtfUrl.getText().equals("")) {
                    jtfUrl.setText("请输入txt文件地址");
                }
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fileIsExist())
                    return;
                try {
                    image = toolKit.getImage(new URL("https://img-blog.csdnimg.cn/2020" +
                            "1209233858758.png?x-oss-process=image/watermark," +
                            "type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9" +
                            "nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center"));
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
                File outFile = type1.demo1.run(jtfUrl.getText());

                try {
                    jta.read(new BufferedReader(new InputStreamReader(new FileInputStream(outFile))), "READING FILE :-)");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fileIsExist())
                    return;
                try {
                    image = toolKit.getImage(new URL("https://img-blog.csdnimg" +
                            ".cn/20201209233936983.png?x-oss-process=image/watermark,t" +
                            "ype_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLm" +
                            "NzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center"));
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }

                File outFile = type2.Main.run(jtfUrl.getText());

                try {
                    jta.read(new BufferedReader(new InputStreamReader(new FileInputStream(outFile))), "READING FILE :-)");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fileIsExist())
                    return;
                try {
                    image = toolKit.getImage(new URL("https://img-blog.csdnimg.cn/20201209233949962." +
                            "png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR" +
                            "0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,si" +
                            "ze_16,color_FFFFFF,t_70#pic_center"));
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }

                File outFile = null;
                try {
                    outFile = type3.Main.run(jtfUrl.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    jta.read(new BufferedReader(new InputStreamReader(new FileInputStream(outFile))), "READING FILE :-)");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!fileIsExist())
                    return;
                try {
                    image = toolKit.getImage(new URL("https://img-blog.csdnimg.cn/202012" +
                            "09233922504.png#pic_center"));
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }

                File outFile = type4.Main.run(jtfUrl.getText());

                try {
                    jta.read(new BufferedReader(new InputStreamReader(new FileInputStream(outFile))), "READING FILE :-)");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
            }
        });
        setSize(1280,640);
        setLocation(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paint(Graphics g){
        super.paint(g);
        if (image!=null){
            g.drawImage(image,100,350,this);
        }
    }

    boolean fileIsExist() {
        String fileName = jtfUrl.getText();
        File file = new File(fileName);
        if (!fileName.endsWith(".txt") || !file.exists()) {
            JOptionPane.showMessageDialog(null, "文件不正确，请输入正确的txt文件地址");
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        new Main();
    }

}