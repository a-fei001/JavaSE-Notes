package EXERCISE.miniProject.mini12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyJFrame extends JFrame implements ActionListener {

    int flag = 0;//标记菜单栏是否展示

    //JMenuItem helpItem = new JMenuItem("爸爸最帅了，爸爸，饶命~");
    JMenuItem aboutItem = new JMenuItem("帅气小sure的联系方式");
    JMenuItem fuckItem = new JMenuItem("作者脑子有病(注:提前保存电脑重要文件)");

    JButton jb1 = new JButton("比sure还帅!!");
    JButton jb2 = new JButton("普普通通");
    JButton jb3 = new JButton("丑陋无比");
    JButton h = new JButton("sure爸爸，儿子错了，别让我关机！");

    MyJFrame() {
        //初始化页面
        init();

        //菜单
        initMenu();

        //加上按钮
        initButton();

        //显示页面
        this.setVisible(true);
    }

    private void init() {
        this.setSize(603, 680);

        //设置界面的标题
        this.setTitle("不好意思，俺闲的了");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式(点窗口×号，程序停止)
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//直接写3也行
        //这个成员方法输入参数0-3控制的关闭模式不同，3表示关一个页面，整个程序停止运行

        //取消默认居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);
    }

    private void initMenu() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上选项
        //JMenu helpJMenu = new JMenu("这个是救命用的");
        JMenu playJMenu = new JMenu("|  更多~");

        //条目加到选项上
        //helpJMenu.add(helpItem);
        playJMenu.add(aboutItem);
        playJMenu.add(fuckItem);
        //条目加上鼠标事件
        //helpItem.addActionListener(this);
        aboutItem.addActionListener(this);
        fuckItem.addActionListener(this);
        //选项加到菜单上
        //jMenuBar.add(helpJMenu);
        jMenuBar.add(playJMenu);
        //菜单加到页面上
        this.setJMenuBar(jMenuBar);
    }

    private void initButton() {
        this.getContentPane().removeAll();

        jb1.setBounds(200, 100, 200, 100);
        jb2.setBounds(200, 250, 200, 100);
        jb3.setBounds(200, 400, 200, 100);

        if (flag == 0) {//不这样写，事件监听器重复加载2次，
            //需要点击两次，弹窗才会关闭(再次点击jb1弹窗再次增加~)
            jb1.addActionListener(this);
            jb2.addActionListener(this);
            jb3.addActionListener(this);
        }

        this.getContentPane().add(jb1);
        this.getContentPane().add(jb2);
        this.getContentPane().add(jb3);

        if (flag == 1) {
            h.setBounds(100, 10, 400, 90);
            h.addActionListener(this);
            this.getContentPane().add(h);
        }

        //询问问题
        initQuestion();

        //刷新界面
        this.getContentPane().repaint();
    }

    private void initQuestion() {
        JLabel stepCount = new JLabel("你觉得自己的长相怎么样？");
        stepCount.setBounds(200, 20, 200, 60);
        this.getContentPane().add(stepCount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == h) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("day02\\src\\EXERCISE\\miniProject\\mini12\\" +
                    "zagou.jpg"));
            //设置图片位置和宽高
            jLabel.setBounds(0, 0, 800, 800);
            //将图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //设置弹框大小
            jDialog.setSize(800, 800);
            jDialogSet(jDialog);
        } else if (source == jb1) {
            flag = 1;
            try {
                Runtime.getRuntime().exec("notepad");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            initButton();
        } else if (source == jb2) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("day02\\src\\EXERCISE\\miniProject\\mini12\\" +
                    "G.png"));
            //设置图片位置和宽高
            jLabel.setBounds(0, 0, 700, 700);
            //将图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //设置弹框大小
            jDialog.setSize(700, 700);
            jDialogSet(jDialog);
        } else if (source == jb3) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("day02\\src\\EXERCISE\\miniProject\\mini12\\" +
                    "great.png"));
            //设置图片位置和宽高
            jLabel.setBounds(0, 0, 600, 500);
            //将图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //设置弹框大小
            jDialog.setSize(600, 500);
            jDialogSet(jDialog);
        } else if (source == aboutItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("day02\\src\\EXERCISE\\miniProject\\mini12\\" +
                    "A_fei01.jpg"));
            //设置图片位置和宽高
            jLabel.setBounds(0, 0, 500, 650);
            //将图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //设置弹框大小
            jDialog.setSize(500, 650);
            jDialogSet(jDialog);
        } else if (source == fuckItem) {
            try {
                Runtime.getRuntime().exec("notepad");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void jDialogSet(JDialog jDialog) {
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框剧居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭，就无法操作下面页面
        jDialog.setModal(true);
        //让弹框显示出来
        jDialog.setVisible(true);
    }
}
