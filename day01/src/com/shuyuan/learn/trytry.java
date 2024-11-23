package com.shuyuan.learn;

/*public class trytry {
    public static void main(String[] args) {
        String a ="abcd";
    }
}*/

/*import java.util.Random;
import java.util.Scanner;

public class trytry {
    public static void main(String[] args) {
        int i=1;
        int j=10;
        do{
            if(i++>--j){
                continue;
            }
        }while(i<5);
    }
}*/
//package practice;

import java.util.Scanner;
public class trytry {
    public static void main(String[] args) {
        int money=10;//原有的钱
        int bets=0;//投进去的钱
        int rand=0;//系统所含有的水果
        int unit=0;//奖励的倍数
        int rewards=0;//收到的钱
        String choiseid=null;//选择的水果
        String luckyid=null;//系统给的水果

        Scanner sc=new Scanner(System.in);

        while(true) {

            System.out.println("您当前的金币总计：￥"+money);
            if(money<=0) {
                System.out.println("您的金币已用完，游戏结束!");
                System.exit(0);//这条代码执行后，程序结束
            }
            System.out.println("欢迎进入游戏，新的一轮游戏马上开始！");
            System.out.println("猜中的物品和对应的奖励如下：");
            System.out.println("苹果-------2倍奖励");
            System.out.println("木瓜-------5倍奖励");
            System.out.println("西瓜-------10倍奖励");
            System.out.println("香蕉-------20倍奖励");
            System.out.println("橙子-------50倍奖励");
            System.out.println("葡萄-------100倍奖励");
            System.out.println("游戏结束，请按Q！");
            System.out.println("请输入您选中的水果：");
            choiseid=sc.next();//键盘录入你要选择的水果
            if(choiseid.equals("Q")) {
                System.out.println("您选择了退出游戏，欢迎下次再来!");
                System.exit(0);
            }


            while(true) {
                System.out.println("请输入您要押的金币数(最多)"+money+"金币：");
                bets=sc.nextInt();//键盘录入你要压的金币
                if(bets<=0) {
                    System.out.println("您的下注不能为空或未负! ");
                }
                else if(bets>money){
                    System.out.println("你的金币不足!");

                }else {
                    break;
                }
            }
            rand=(int) (Math.random()*6)+1;//给所有的水果表示一个范围
            System.out.println(rand);
            switch(rand) {


                case 1:System.out.println("----苹果----");luckyid="苹果";unit=2;break;
                case 2:System.out.println("----木瓜----");luckyid="木瓜";unit=5;break;
                case 3:System.out.println("----西瓜----");luckyid="西瓜";unit=10;break;
                case 4:System.out.println("----香蕉----");luckyid="香蕉";unit=20;break;
                case 5:System.out.println("----橙子----");luckyid="橙子";unit=50;break;
                case 6:System.out.println("----葡萄----");luckyid="葡萄";unit=100;break;
                default:System.out.println("----水果盘----");luckyid="水果盘";}
            if(choiseid.equals(luckyid)){
                rewards=bets*unit;
                money+=rewards;
                System.out.println("恭喜您获得"+rewards+"金币！");
            }
            else {
                money-=bets;
                System.out.println("很遗憾，您没有猜对，您损失了"+bets+"金币");
            }
            System.out.println("\n本轮游戏结束--------\n");
        }
    }
}


