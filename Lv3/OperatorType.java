package Lv3;

public enum OperatorType {
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');

    private char type;

    OperatorType(char c) {
        this.type = c;
    }

    public static OperatorType fromChar(char ch) {
        for (OperatorType op : OperatorType.values()) {
            if (op.type == ch) {
                return op;
            }
        }
        throw new OperatorNotFoundError("Operator Not Found");
    }
}