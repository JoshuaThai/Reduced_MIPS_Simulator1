
/*
    Author's name: Joshua Thaisananikone
    This is the first milestone for the second program in my Computer Architecture class during my junior year
    at the University of Wisconsin - Milwaukee. For this milestone, we will take the MIPS machine code instructions
    and simulate the internal workings of a MIPS processor using a single-cycle datapath. We will enter the

 */
public class Main {
    public static void main(String[] args) {
        //OPCODE WILL TELL US WHICH INSTRUCTION IT IS.
        Instructions add1 = new Instructions();
        Object test = new Object();
        add1.convertMachineCode(args[0]); // will convert machine code to binary.
        test = add1.determineType();

        if(test instanceof rType){//check if we are looking at a r-Type instruction.
            ((rType) test).setMachineCode(add1.machineCode); //transfer binary code to here.
            System.out.println(test.toString());
        } else if(test instanceof iType){ //check if we are looking at a i-Type instruction.
            ((iType) test).setMachineCode(add1.machineCode); //transfer binary code to here.
            System.out.println(test.toString());
        } else if (test instanceof jType){
            ((jType) test).setMachineCode(add1.machineCode); //transfer binary code to here.
            System.out.println(test.toString());
        } else{
            System.out.println(test.toString());//print out syscall output.
        }
    }
}