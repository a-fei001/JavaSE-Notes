package com.shuyuan.ui;

import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.swing.*;

public class LoginJFrame extends JFrame {

    //在构造方法，创建Login页面
    public LoginJFrame() {
        //初始化小白框页面
        init();

        //丰富页面中内容
        initView();

        //让界面显示出来
        this.setVisible(true);
    }

    private void init(){
        //设置界面宽高
        this.setSize(488, 430);

        //设置界面的标题
        this.setTitle("登录×  混哪个道上的√");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式(点窗口×号，程序停止)
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//直接写3也行
        //这个成员方法输入参数0-3控制的关闭模式不同，3表示关一个页面，整个程序停止运行
    }

    private void initView(){
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("Project_01_PuzzleGame\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        JTextField username = new JTextField();
        username.setBounds(195, 135, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("Project_01_PuzzleGame\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        JTextField password = new JTextField();
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

  /*      String codeStr = Red.getCode();
        JLabel rightCode = new JLabel();
        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);*/

        JLabel background = new JLabel(new ImageIcon("Project_01_PuzzleGame\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);



    }

}
