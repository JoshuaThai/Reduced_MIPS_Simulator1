public class Instructions {
    String machineCode;
    String opcode;

    public Instructions(){

    }

    //return machine code as binary.
    public void convertMachineCode(String code){
        if(code.equals("0000000c")) {
            this.machineCode = code;
            return; // no modification if syscall.
        }
        // Convert the hex string to a binary string, ensuring leading zeros are preserved
        long decimal = Long.parseLong(code, 16); // Parse hex as base 16 (long for large values)
        String binary = Long.toBinaryString(decimal); // Convert to binary string

        // Ensure the binary string is 32 bits (for 8 hex characters)
        binary = String.format("%32s", binary).replace(' ', '0');

        this.machineCode = binary;
        getOpCode(); // We are going to use the opcode to determine what we will have to do.
    }

    //opcode will help us figure out which type of instruction.
    // 000000 is R-TYPE
    private void getOpCode(){
        assert machineCode != null;
        opcode = machineCode.substring(0,6);
    }

    //we will determine instruction type using opcode with the exception of syscall.
    public Object determineType() {
        if(machineCode.equals("0000000c")) return new syscall();

        if (opcode.equals("000000")) {// r type detected
            return new rType();
        } else if (opcode.equals("000010")) { // jump type detected
            return new jType();
        }
        return new iType();// immeadiate type detected
    }
}
