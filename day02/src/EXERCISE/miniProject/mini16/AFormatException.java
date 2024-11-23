package EXERCISE.miniProject.mini16;

public class AFormatException extends RuntimeException{
    //命名一定要见名知义

    //编译时异常：extends Exception
    //运行时异常：extends RuntimeException

    //构造方法选前两个
    public AFormatException() {
    }

    public AFormatException(String message) {
        super(message);
    }
}
