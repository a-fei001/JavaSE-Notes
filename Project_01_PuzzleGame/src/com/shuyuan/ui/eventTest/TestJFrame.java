package com.shuyuan.ui.eventTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestJFrame extends JFrame {
    TestJFrame() {
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

        //创建一个JButton对象
        JButton jtb = new JButton("别点我");
        //设置按钮宽高
        jtb.setBounds(0, 0, 100, 50);
        //给按钮添加事件
        //ActionListener是一个接口，这里括号里应为一个接口类，所以用匿名内部类
        //MyJFrame01类是自己实现ActionListener接口的写法，MyJFrame01是单独一个窗口
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//ActionEvent是接口中抽象方法的参数
                System.out.println("草泥马的，闲的碧阳了吧，在这贩见");//这里就是重写抽象方法，
            }                                      //所以不用管ActionEvent，它和本功能关系不大
        });
        //将按钮添加到整个界面当中
        this.getContentPane().add(jtb);
        this.setVisible(true);
    }

}
