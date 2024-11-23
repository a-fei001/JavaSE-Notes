package com.shuyuan.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //在构造方法，创建Register页面
    public RegisterJFrame() {
        //初始化页面(小白框)
        init();

        //让界面显示出来
        this.setVisible(true);
    }

    private void init(){
        //设置界面宽高
        this.setSize(488, 500);

        //设置界面的标题
        this.setTitle("注册×  拜码头√");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式(点窗口×号，程序停止)
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//直接写3也行
        //这个成员方法输入参数0-3控制的关闭模式不同，3表示关一个页面，整个程序停止运行
    }


}
