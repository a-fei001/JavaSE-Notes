package com.shuyuan.ui.eventTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame01 extends JFrame implements ActionListener {
    JButton jtb1 = new JButton("111");
    JButton jtb2 = new JButton("111");

    public MyJFrame01() {
        init();
    }

    private void init() {
        //设置界面宽高
        this.setSize(603, 680);

        //设置界面的标题
        this.setTitle("最无聊1集————拼图");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式(点窗口×号，程序停止)
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//直接写3也行
        //这个成员方法输入参数0-3控制的关闭模式不同，3表示关一个页面，整个程序停止运行

        //取消默认居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);


        jtb1.setBounds(0, 0, 100, 50);
        jtb2.setBounds(100, 0, 200, 100);
        jtb1.addActionListener(this);
        jtb2.addActionListener(this);
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取JButton类型对象
        Object source = e.getSource();
        if (source == jtb1) {
            //变大
            jtb1.setSize(200, 200);
        } else if (source == jtb2) {
            //改位置
            jtb2.setLocation(500, 300);
        }
    }
}
