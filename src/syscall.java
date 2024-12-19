public class syscall extends Instructions{
    String mnemonic = "syscall";
    String opcode = "00";
    String code = "000000";
    String funct = "0c";

    public syscall(){
        super();
    }

    public String toString(){
        return this.mnemonic + " {opcode: " + this.opcode + ", code: " + this.code + ", funct: "+ this.funct + "}";
    }
}
