package com.shuyuan.ui.eventTest;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame03 extends JFrame implements KeyListener {

    public MyJFrame03(){
        //设置界面宽高
        this.setSize(900, 900);

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

        this.addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按一个不松，会反复调用这个
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        int code = e.getKeyCode();
        //每一个按键都有一个编号与之对应
        System.out.println(code);
    }
}
