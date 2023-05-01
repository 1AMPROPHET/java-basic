package Exception;

public class NameFormatException extends RuntimeException {
    // NameFormat：当前异常的名字，表示姓名格式化问题
    // Exception：表示是一个异常类

    // 运行时：RuntimeException 核心 就表示由于参数错误导致的问题

    public NameFormatException() {
    }

    public NameFormatException(String message) {
        super(message);
    }
}
