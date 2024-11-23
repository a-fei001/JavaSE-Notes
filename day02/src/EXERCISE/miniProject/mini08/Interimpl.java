package EXERCISE.miniProject.mini08;

public class Interimpl implements Inter01, Inter02 {

    @Override
    public void method() {
        System.out.println("实现类重写的抽象方法");
    }

    //(只实现Inter01的话)默认方法不强制重写，重写格式如下：
    //如果是实现了Inter01和Inter02，两个都有默认重名的show方法，则这里必须重新
    @Override
    public void show() {
        System.out.println("重写接口中的默认方法");
    }
}
