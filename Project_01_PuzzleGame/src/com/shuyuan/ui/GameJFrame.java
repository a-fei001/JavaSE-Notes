package com.shuyuan.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    //记录图片序号，从而标记图片位置
    int[][] data;

    //记录序号1的下标位置(图片1-16，二维数组中存的也是1-16)
    //规定1处为空白
    int x = 0, y = 0;

    //展示当前图片路径
    String path = "Project_01_PuzzleGame\\image\\girl\\girl1\\";

    //展示图片共通的路径
    String normalPath = "Project_01_PuzzleGame\\image\\";
    //区别三大图片类
    String choosePath = "girl";
    //区别大类中的不同图片
    int numPath = 1;

    //胜利时候的二维数组数据
    int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

    //统计步数
    //注意胜利后没有归零
    int step = 0;

    //创建两个选项下面的条目对象
    //(因为重写的ActionListener的方法也要使用这些变量，所以开成成员变量)
    JMenuItem replayItem = new JMenuItem("重开一把");
    JMenuItem reLoginItem = new JMenuItem("转生换身份");
    JMenuItem closeItem = new JMenuItem("溜了 溜了");

    JMenuItem accountItem = new JMenuItem("帅气迷人的作者的联系方式");

    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem girlItem = new JMenuItem("妹子");
    JMenuItem sportItem = new JMenuItem("运动");

    //在构造方法，创建Game页面，使得只要初始化一个GameJFrame对象
    //就能创建一个Game页面
    public GameJFrame() {
        //初始化页面
        init();

        //初始化菜单
        initJMenuBar();

        //初始化data数组(随机)
        initData();

        //初始化图片
        initImage();

        //让界面显示出来(基本都放最后)
        this.setVisible(true);
    }


    private void initData() {
        Random r = new Random();

        //先初始化一个一维数组，
        //辅助获取随机组合的二维数组数据
        int[] temp = new int[16];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i + 1;
        }

        //得到一个随机的一维数组
        for (int i = 0; i < temp.length; i++) {
            int t = r.nextInt(temp.length);
            int p = temp[i];
            temp[i] = temp[t];
            temp[t] = p;
        }

        //得到一个随机的二维数组
        this.data = new int[4][4];
        for (int i = 0; i < temp.length; i++) {
            //记录序号为1(空白方块在二维数组中的位置)
            if (temp[i] == 1) {
                x = i / 4;
                y = i % 4;
            }
            //骚操作，直接把时间复杂度从O(n^2)变成了O(n)
            data[i / 4][i % 4] = temp[i];
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }


    private void initImage() {
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        if (victory()) {
            //显示胜利的图标
            JLabel winJ = new JLabel(new ImageIcon("Project_01_PuzzleGame\\image\\win.png"));
            winJ.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJ);
        }

        //添加显示步数
        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        //下面循环的代码解析
        /*
        //创建一个图片ImageIcon的对象//绝对路径
        ImageIcon icon = new ImageIcon("D:\\sure_\\编译工具和项目\\项目文件" +
                "\\java_intellij idea\\java2\\Project_01_PuzzleGame\\image\\girl\\girl6\\all.jpg");

        //创建一个JLabel的对象（管理容器）
        JLabel jLabel1 = new JLabel(icon);

        //指定图片位置(提供的图片数据：小图片长宽105，all图片长宽420)
        //左上角是原点，向右x轴正方向，向下y轴正方向
        //每个小图片的位置坐标由该图片左上角位置决定
        jLabel1.setBounds(0, 0, 105, 105);

        //把管理容器添加到页面当中
        //this.add(jLabel);//没有调取窗口中隐藏的容器
        //调取窗口中隐藏的容器，再调用add方法
        this.getContentPane().add(jLabel1);*/

        //加载图片
        int number;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number = data[i][j];
                if (number == 1) continue;
                //上面前两步合成一步
                JLabel jLabel = new JLabel(new ImageIcon(normalPath+choosePath+"\\"+choosePath+numPath+"\\"+number+".jpg"));
                //83 134控制图片出现在页面中央
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);//细节i j顺序
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));//值为1，表示图片凹下去
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        //细节：先添加的图片默认在上面，后加载的图片在下面
        //如果先加载背景图片，会把拼图给盖住
        //相对路径
        JLabel jLabel1 = new JLabel(new ImageIcon("Project_01_PuzzleGame\\image\\background.png"));
        jLabel1.setBounds(40, 40, 508, 560);//数据都是试出来的
        this.getContentPane().add(jLabel1);

        //刷新界面
        this.getContentPane().repaint();
    }


    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上两个选项的对象(功能 关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        JMenu changeJMenu = new JMenu("更多图片");

        //将每个选项下面的条目添加到选项中
        functionJMenu.add(changeJMenu);

        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        changeJMenu.add(animalItem);
        changeJMenu.add(girlItem);
        changeJMenu.add(sportItem);

        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);

        accountItem.addActionListener(this);

        animalItem.addActionListener(this);
        girlItem.addActionListener(this);
        sportItem.addActionListener(this);

        //将菜单中的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }


    private void init() {
        //设置界面宽高
        this.setSize(603, 680);

        //设置界面的标题
        this.setTitle("最无聊的1集————拼图");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置页面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式(点窗口×号，程序停止)
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//直接写3也行
        //这个成员方法输入参数0-3控制的关闭模式不同，3表示关一个页面，整个程序停止运行

        //取消默认居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);

        //给整个页面添加键盘监听事件
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    //按下不松
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //按住H不松
        if (code == 72) {
            //清空原本已经出现的所有图片
            this.getContentPane().removeAll();
            //添加完整all图片
            JLabel jLabel = new JLabel(new ImageIcon(normalPath+choosePath+"\\"+choosePath+numPath+"\\all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);
            //添加背景图片
            JLabel jLabel1 = new JLabel(new ImageIcon("Project_01_PuzzleGame\\image\\background.png"));
            jLabel1.setBounds(40, 40, 508, 560);//数据都是试出来的
            this.getContentPane().add(jLabel1);
            //刷新界面
            this.getContentPane().repaint();
        }
    }


    //松开
    @Override
    public void keyReleased(KeyEvent e) {
        //如果游戏胜利，不能再根据键盘移动图片了
        if (victory()) {
            return;
        }
        int code = e.getKeyCode();
        //w87 a65 s83 d68
        //左37 上38 右39 下40
        if (code == 65 || code == 37) {
            if (y == 3) return;//防止数组越界
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 1;
            y++;
            step++;//计数器增加一步
            initImage();
        } else if (code == 87 || code == 38) {
            if (x == 3) return;
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 1;
            x++;
            step++;//计数器增加一步
            initImage();
        } else if (code == 68 || code == 39) {
            if (y == 0) return;
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 1;
            y--;
            step++;//计数器增加一步
            initImage();
        } else if (code == 83 || code == 40) {
            if (x == 0) return;
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 1;
            x--;
            step++;//计数器增加一步
            initImage();
        } else if (code == 72) {
            //松开H，要回为原位
            initImage();
        } else if (code == 54) {
            //松开 上6，就可通关
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };
            x = 0;//理论上不加也行，但为了严谨
            y = 0;//还是更新一下x,y的值
            initImage();
        }
    }


    //判断data数组的元素是否和win数组中的相同
    //如果全部相同，游戏胜利，返回true，反之返回false
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j])
                    return false;
            }
        }
        return true;
    }

    //鼠标点击或者点击空格
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem) {
            //重新
            step = 0;//计步器清零
            initData();
            initImage();
        } else if (obj == reLoginItem) {
            //重新登录
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == closeItem) {
            //关闭游戏
            System.exit(0);
        } else if (obj == accountItem) {
            //弹出公众号
            //创建一个弹窗对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象
            JLabel jLabel = new JLabel(new ImageIcon("Project_01_PuzzleGame\\image\\A_fei01.jpg"));
            //设置图片位置和宽高
            jLabel.setBounds(0, 0, 500, 644);
            //将图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //设置弹框大小
            jDialog.setSize(505, 666);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框剧居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭，就无法操作下面页面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        } else if (obj == animalItem) {
            Random r = new Random();
            choosePath = "animal";
            int t = numPath;
            while(t==numPath){//防止重复,导致图片不变
                numPath = r.nextInt(8)+1;
            }
            step = 0;//步数初始化为0
            initData();
            initImage();
        } else if (obj == sportItem) {
            Random r = new Random();
            choosePath = "sport";
            int t = numPath;
            while(t==numPath){//防止重复,导致图片不变
                numPath = r.nextInt(10)+1;
            }
            step = 0;
            initData();
            initImage();
        } else if (obj == girlItem) {
            Random r = new Random();
            choosePath = "girl";
            int t = numPath;
            while(t==numPath){//防止重复,导致图片不变
                numPath = r.nextInt(13)+1;
            }
            step = 0;
            initData();
            initImage();
        }
    }
}
