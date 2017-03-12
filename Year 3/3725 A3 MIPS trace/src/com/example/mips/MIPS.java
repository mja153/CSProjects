package com.example.mips;
import java.util.Scanner;

/*
Page: 3
Author: Michael Anderson
MUN ID: 201449410
Class: CS3725
Project: Assignment 3
Instructor: Ashoke Deb
Due Date: March 7, 2017

Program to take input from user and trace the  given input through the MIPS IPC. Limited to commands add, sub, lw, sw, and beq only.
*/
public class MIPS {

    public static void add(int op1, int op2, int op3, Scanner in, int PC){
        //$op1 <- $op2 + $op3
        System.out.println("The semantics for the add instruction are as follows: \nACC <- ACC + M[X]\n");
        System.out.println("Given your input, the format is: "+"$"+op1+" <- $"+op2+" + $"+op3+"\n");
        System.out.println("The control signal vector is:");
        System.out.println(" _IF_   _ID_   _____EX_____");
        System.out.println("[1][1] [1][1] [1][0][0][0][0]\n");
        System.out.println("Please enter the Register value of $"+ op1+". [format: R"+op1+" <value>]");

        try{
            String regVals = in.nextLine();
            String[] splitRegVals1 = regVals.split(" ");
            int opReg1 = Integer.parseInt(splitRegVals1[1]);

            System.out.println("Please enter the Register value of $"+ op2+". [format: R"+op2+" <value>]");

            regVals = in.nextLine();
            String[] splitRegVals2 = regVals.split(" ");
            int opReg2 = Integer.parseInt(splitRegVals2[1]);

            System.out.println("Please enter the Register value of $"+ op3+". [format: R"+op3+" <value>]");

            regVals = in.nextLine();
            String[] splitRegVals3 = regVals.split(" ");
            int opReg3 = Integer.parseInt(splitRegVals3[1]);

            System.out.println("Based on your input, the following is the result of your trace through MIPS:\n");
            System.out.println(" IF Stage:");
            System.out.println("PC: "+PC);
            System.out.println("Readaddress: "+PC);
            System.out.println("Output of program counter PC+4: "+(PC+4));


            System.out.println("\n\n IF/ID Buffer:\n");
            System.out.println("op   rs   rt   rd   shamt  funct");
            System.out.println("[32]  ["+op2+"]  ["+op3+"]  ["+op1+"]   [0]   [32]");


            System.out.println("\n\n ID Stage:\n");
            System.out.println("Read register 1: "+op2);
            System.out.println("Read register 2: "+op3);
            System.out.println("Instruction [15-11]: "+op1);
            System.out.println("Read data 1: "+opReg2);
            System.out.println("Read data 2: "+opReg3);


            System.out.println("\n\n ID/EX Buffer:\n");
            System.out.println("inst[15-11]  inst[20-16]  inst[15-0]  readdata2  readdata1  pc+4");
            System.out.println("    ["+op2+"]        [x]          [y]         ["+opReg3+"]       ["+opReg2+"]       ["+(PC+4)+"]");


            System.out.println("\n\n EX Stage:\n");
            System.out.println("Lower MUX at Port 0: X");
            System.out.println("Lower MUX at Port 1: "+op1);
            System.out.println("RegDst: 1");
            System.out.println("Output of Lower MUX: "+op1);

            System.out.println("\nALU Control 6-bit main input: 32");
            System.out.println("ALU Control ALUOp input: 10");
            System.out.println("ALU Control output: Addition");

            System.out.println("\nUpper MUX, upper input: "+opReg2);
            System.out.println("Upper MUX, lower input: Y");
            System.out.println("Upper MUX, ALU src: 0");
            System.out.println("Upper MUX output: "+opReg2);

            System.out.println("\nALU top input: "+opReg2);
            System.out.println("ALU lower input (from upper MUX): "+opReg3);
            System.out.println("ALU result: "+(opReg2+opReg3));
            System.out.println("Zero: 0");

            System.out.println("\nInput to Shift Left 2: Y");
            System.out.println("Output of Shift Left 2: 4*Y");

            System.out.println("\nInput 0 to Add: "+(PC+4));
            System.out.println("Input 1 to Add: 4*Y");
            System.out.println("Output of Add: 4*Y+"+(PC+4)+" [Z]");

            System.out.println("\n\n EX/MEM Buffer:\n");
            System.out.println("output of MUX  readdata2  ALUresult  zero  Addresult");
            System.out.println("     ["+op1+"]        ["+opReg3+"]         ["+(opReg2+opReg3)+"]      [0]      [Z]");

            System.out.println("\n\n MEM Stage:\n");
            System.out.println("Bottom (**) Data Path: "+op1);

            System.out.println("\nRead address: "+(opReg2+opReg3));
            System.out.println("Write address: "+(opReg2+opReg3));
            System.out.println("Write data: "+opReg3);
            System.out.println("MemWrite: 0");
            System.out.println("MemRead: 0");
            System.out.println("ReadData: T");

            System.out.println("\nInput 1 of AND-Gate: 0");
            System.out.println("Input 2 of AND-Gate: 0");
            System.out.println("Output of AND-Gate: 0");

            System.out.println("\nValue Datapath Labelled * on Handout: Z");

            System.out.println("\n\n MEM/WB Buffer:\n");
            System.out.println("** data path  ALUresult  Readdata");
            System.out.println("    ["+op1+"]           ["+(opReg2+opReg3)+"]       [T]");

            System.out.println("\n\n WB Stage:\n");
            System.out.println("Input 1 of MUX: T");
            System.out.println("Input 2 of MUX: "+(opReg2+opReg3));
            System.out.println("MemToReg: 0");
            System.out.println("Output of MUX: "+(opReg2+opReg3));

            System.out.println("\nLocated in ID Stage, but received from WB stage:");
            System.out.println("WriteRegister: "+op1);
            System.out.println("WriteData: "+(opReg2+opReg3));
            System.out.println("RegWrite: 1");

            System.out.println("\nLocated in IF Stage, but received from WB stage:");
            System.out.println("Input 0 to MUX: "+(PC+4));
            System.out.println("Input 1 to MUX: Z");
            System.out.println("MUX Selector: 0");
            System.out.println("Output of MUX: "+(PC+4));


        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You entered the incorrect format.");
        }
    }

    public static void sub(int op1, int op2, int op3, Scanner in, int PC){
        //$op1 <- $op2 - $op3
        System.out.println("The semantics for the sub instruction are as follows: \nACC <- ACC - M[X]\n");
        System.out.println("Given your input, the format is: "+"$"+op1+" <- $"+op2+" - $"+op3+"\n");
        System.out.println("The control signal vector is:");
        System.out.println(" _IF_   _ID_   _____EX_____");
        System.out.println("[1][1] [1][1] [0][1][0][0][0]\n");
        System.out.println("Please enter the Register value of $"+ op1+". [format: R"+op1+" <value>]");

        try{
            String regVals = in.nextLine();
            String[] splitRegVals1 = regVals.split(" ");
            int opReg1 = Integer.parseInt(splitRegVals1[1]);

            System.out.println("Please enter the Register value of $"+ op2+". [format: R"+op2+" <value>]");

            regVals = in.nextLine();
            String[] splitRegVals2 = regVals.split(" ");
            int opReg2 = Integer.parseInt(splitRegVals2[1]);

            System.out.println("Please enter the Register value of $"+ op3+". [format: R"+op3+" <value>]");

            regVals = in.nextLine();
            String[] splitRegVals3 = regVals.split(" ");
            int opReg3 = Integer.parseInt(splitRegVals3[1]);

            System.out.println("Based on your input, the following is the result of your trace through MIPS:\n");
            System.out.println(" IF Stage:");
            System.out.println("PC: "+PC);
            System.out.println("Readaddress: "+PC);
            System.out.println("Output of program counter PC+4: "+(PC+4));


            System.out.println("\n\n IF/ID Buffer:\n");
            System.out.println("op   rs   rt   rd   shamt  funct");
            System.out.println("[34]  ["+op2+"]  ["+op3+"]  ["+op1+"]   [0]   [34]");


            System.out.println("\n\n ID Stage:\n");
            System.out.println("Read register 1: "+op2);
            System.out.println("Read register 2: "+op3);
            System.out.println("Instruction [15-11]: "+op1);
            System.out.println("Read data 1: "+opReg2);
            System.out.println("Read data 2: "+opReg3);


            System.out.println("\n\n ID/EX Buffer:\n");
            System.out.println("inst[15-11]  inst[20-16]  inst[15-0]  readdata2  readdata1  pc+4");
            System.out.println("    ["+op2+"]        [x]          [y]         ["+opReg3+"]       ["+opReg2+"]       ["+(PC+4)+"]");


            System.out.println("\n\n EX Stage:\n");
            System.out.println("Lower MUX at Port 0: X");
            System.out.println("Lower MUX at Port 1: "+op1);
            System.out.println("RegDst: 1");
            System.out.println("Output of Lower MUX: "+op1);

            System.out.println("\nALU Control 6-bit main input: 34");
            System.out.println("ALU Control ALUOp input: 10");
            System.out.println("ALU Control output: Subtraction");

            System.out.println("\nUpper MUX, upper input: "+opReg2);
            System.out.println("Upper MUX, lower input: Y");
            System.out.println("Upper MUX, ALU src: 0");
            System.out.println("Upper MUX output: "+opReg2);

            System.out.println("\nALU top input: "+opReg2);
            System.out.println("ALU lower input (from upper MUX): "+opReg3);
            System.out.println("ALU result: "+(opReg2-opReg3));
            System.out.println("Zero: 0");

            System.out.println("\nInput to Shift Left 2: Y");
            System.out.println("Output of Shift Left 2: 4*Y");

            System.out.println("\nInput 0 to Add: "+(PC+4));
            System.out.println("Input 1 to Add: 4*Y");
            System.out.println("Output of Add: 4*Y+"+(PC+4)+" [Z]");

            System.out.println("\n\n EX/MEM Buffer:\n");
            System.out.println("output of MUX  readdata2  ALUresult  zero  Addresult");
            System.out.println("     ["+op1+"]          ["+opReg3+"]         ["+(opReg2-opReg3)+"]    [0]      [Z]");

            System.out.println("\n\n MEM Stage:\n");
            System.out.println("Bottom (**) Data Path: "+op1);

            System.out.println("\nRead address: "+(opReg2-opReg3));
            System.out.println("Write address: "+(opReg2-opReg3));
            System.out.println("Write data: "+opReg3);
            System.out.println("MemWrite: 0");
            System.out.println("MemRead: 0");
            System.out.println("ReadData: T");

            System.out.println("\nInput 1 of AND-Gate: 0");
            System.out.println("Input 2 of AND-Gate: 0");
            System.out.println("Output of AND-Gate: 0");

            System.out.println("\nValue Datapath Labelled * on Handout: Z");

            System.out.println("\n\n MEM/WB Buffer:\n");
            System.out.println("** data path  ALUresult  Readdata");
            System.out.println("   ["+op1+"]           ["+(opReg2-opReg3)+"]       [T]");

            System.out.println("\n\n WB Stage:\n");
            System.out.println("Input 1 of MUX: T");
            System.out.println("Input 2 of MUX: "+(opReg2-opReg3));
            System.out.println("MemToReg: 0");
            System.out.println("Output of MUX: "+(opReg2-opReg3));

            System.out.println("\nLocated in ID Stage, but received from WB stage:");
            System.out.println("WriteRegister: "+op1);
            System.out.println("WriteData: "+(opReg2-opReg3));
            System.out.println("RegWrite: 1");

            System.out.println("\nLocated in IF Stage, but received from WB stage:");
            System.out.println("Input 0 to MUX: "+(PC+4));
            System.out.println("Input 1 to MUX: Z");
            System.out.println("MUX Selector: 0");
            System.out.println("Output of MUX: "+(PC+4));


        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You entered the incorrect format.");
        }
    }
    public static void lw(int op1, int op2, int op3, Scanner in, int PC)
    {
        //$op1 <- M[op2+$op3]
        //op2 = OFFSET
        System.out.println("The semantics for the lw instruction are as follows: \nACC <- M[X]\n");
        System.out.println("Given your input, the format is: "+"$"+op1+" <- M["+op2+"+$"+op3+"]\n");
        System.out.println("The control signal vector is:");
        System.out.println(" _IF_   _ID_   _____EX_____");
        System.out.println("[1][1] [1][1] [0][0][1][0][0]\n");
        System.out.println("Please enter the Register value of $"+ op1+". [format: R"+op1+" <value>]");

        try{
            String regVals = in.nextLine();
            String[] splitRegVals1 = regVals.split(" ");
            int opReg1 = Integer.parseInt(splitRegVals1[1]);

            System.out.println("Please enter the Memory value of M["+ op3+"]. [format: <"+op3+"> <value>]");

            regVals = in.nextLine();
            String[] splitRegVals2 = regVals.split(" ");
            int opReg2 = op2;
            int opReg3 = Integer.parseInt(splitRegVals2[1]);

            System.out.println("Based on your input, the following is the result of your trace through MIPS:\n");
            System.out.println(" IF Stage:");
            System.out.println("PC: "+PC);
            System.out.println("Readaddress: "+PC);
            System.out.println("Output of program counter PC+4: "+(PC+4));


            System.out.println("\n\n IF/ID Buffer:\n");
            System.out.println("op   rs   rt   16-bit immediate");
            System.out.println("[35] ["+op3+"] ["+op1+"]       ["+op2+"]");


            System.out.println("\n\n ID Stage:\n");
            System.out.println("Read register 1: "+op3);
            System.out.println("Instruction [15-0]: "+op2);
            System.out.println("Write Register: "+op1);
            System.out.println("Read data 1: "+opReg3);



            System.out.println("\n\n ID/EX Buffer:\n");
            System.out.println("inst[20-16]  inst[15-0]    readdata1  pc+4");
            System.out.println("      ["+op1+"]        ["+op2+"]        ["+opReg3+"]      ["+(PC+4)+"]");


            System.out.println("\n\n EX Stage:\n");


            System.out.println("\nALU Control 6-bit main input: 35");
            System.out.println("ALU Control ALUOp input: 10");
            System.out.println("ALU Control output: LW");

            System.out.println("\nUpper MUX, upper input: Y");
            System.out.println("Upper MUX, lower input: "+op2);
            System.out.println("Upper MUX, ALU src: 1");
            System.out.println("Upper MUX output: "+opReg2);

            System.out.println("\nALU top input: "+opReg3);
            System.out.println("ALU lower input (from upper MUX): "+opReg2);
            System.out.println("ALU result: "+(opReg2+opReg3));
            System.out.println("Zero: 0");

            System.out.println("\nInput to Shift Left 2: "+op2);
            System.out.println("Output of Shift Left 2: "+(4*op2));

            System.out.println("\nInput 0 to Add: "+(PC+4));
            System.out.println("Input 1 to Add: "+(4*op2));
            System.out.println("Output of Add: "+((4*op2)+(PC+4)));

            System.out.println("\n\n EX/MEM Buffer:\n");
            System.out.println(" ALUresult  zero  Addresult");
            System.out.println("  ["+(opReg2+opReg3)+"]       [0]      ["+((4*op2)+(PC+4))+"]");

            System.out.println("\n\n MEM Stage:\n");

            System.out.println("Read address: "+(opReg2+opReg3));
            System.out.println("Write address: "+(opReg2+opReg3));
            System.out.println("MemWrite: 0");
            System.out.println("MemRead: 1");
            System.out.println("ReadData: M["+(opReg2+opReg3)+"]");

            System.out.println("\nInput 1 of AND-Gate: 0");
            System.out.println("Input 2 of AND-Gate: 0");
            System.out.println("Output of AND-Gate: 0");

            System.out.println("\nValue Datapath Labelled * on Handout: "+(opReg2+opReg3));

            System.out.println("\n\n MEM/WB Buffer:\n");
            System.out.println("ALUresult  Readdata");
            System.out.println("    ["+(opReg2+opReg3)+"]      [M["+(opReg2+opReg3)+"]]");

            System.out.println("\n\n WB Stage:\n");
            System.out.println("Input 1 of MUX: M["+(opReg2+opReg3)+"]");
            System.out.println("Input 2 of MUX: "+(opReg2+opReg3));
            System.out.println("MemToReg: 1");
            System.out.println("Output of MUX: M["+(opReg2+opReg3)+"]");

            System.out.println("\nLocated in ID Stage, but received from WB stage:");
            System.out.println("WriteRegister: "+op1);
            System.out.println("Write data: M["+(opReg2+opReg3)+"]");
            System.out.println("RegWrite: 1");

            System.out.println("\nLocated in IF Stage, but received from WB stage:");
            System.out.println("Input 0 to MUX: "+(PC+4));
            System.out.println("Input 1 to MUX: "+((4*op2)+(PC+4)));
            System.out.println("MUX Selector: 0");
            System.out.println("Output of MUX: "+(PC+4));

            System.out.println("\n\nNew Value of register $"+op1+": M["+(opReg2+opReg3)+"]");


        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You entered the incorrect format.");
        }
    }
    public static void sw(int op1, int op2, int op3, Scanner in, int PC)
    {
        //M[op2+$op3] <- $op1
        //op2 = OFFSET
        System.out.println("The semantics for the sw instruction are as follows: \nM[X] <- ACC\n");
        System.out.println("Given your input, the format is: M["+op2+"+$"+op3+"] <- "+"$"+op1);
        System.out.println("The control signal vector is:");
        System.out.println(" _IF_   _ID_   _____EX_____");
        System.out.println("[1][1] [1][1] [0][0][0][1][0]\n");
        System.out.println("Please enter the Register value of $"+ op1+". [format: R"+op1+" <value>]");

        try{
            String regVals = in.nextLine();
            String[] splitRegVals1 = regVals.split(" ");
            int opReg1 = Integer.parseInt(splitRegVals1[1]);

            System.out.println("Please enter the Memory value of M["+ op3+"]. [format: <"+op3+"> <value>]");

            regVals = in.nextLine();
            String[] splitRegVals2 = regVals.split(" ");
            int opReg2 = op2;
            int opReg3 = Integer.parseInt(splitRegVals2[1]);

            System.out.println("Based on your input, the following is the result of your trace through MIPS:\n");
            System.out.println(" IF Stage:");
            System.out.println("PC: "+PC);
            System.out.println("Readaddress: "+PC);
            System.out.println("Output of program counter PC+4: "+(PC+4));


            System.out.println("\n\n IF/ID Buffer:\n");
            System.out.println("op   rs   rt   16-bit immediate");
            System.out.println("[43] ["+op3+"] ["+op1+"]       ["+op2+"]");


            System.out.println("\n\n ID Stage:\n");
            System.out.println("Read register 1: "+op3);
            System.out.println("Read register 2: "+opReg1);
            System.out.println("Instruction [15-0]: "+op2);
            System.out.println("Write Register: "+op1);
            System.out.println("Read data 1: "+opReg3);



            System.out.println("\n\n ID/EX Buffer:\n");
            System.out.println("inst[20-16]  inst[15-0]    readdata1  pc+4");
            System.out.println("     ["+op1+"]          ["+op2+"]        ["+opReg3+"]     ["+(PC+4)+"]");


            System.out.println("\n\n EX Stage:\n");

            System.out.println("\nALU Control 6-bit main input: 43");
            System.out.println("ALU Control ALUOp input: 10");
            System.out.println("ALU Control output: SW");

            System.out.println("\nUpper MUX, upper input: "+opReg1);
            System.out.println("Upper MUX, lower input: "+op2);
            System.out.println("Upper MUX, ALU src: 1");
            System.out.println("Upper MUX output: "+opReg2);

            System.out.println("\nALU top input: "+opReg3);
            System.out.println("ALU lower input (from upper MUX): "+opReg2);
            System.out.println("ALU result: "+(opReg2+opReg3));
            System.out.println("Zero: 0");

            System.out.println("\nInput to Shift Left 2: "+op2);
            System.out.println("Output of Shift Left 2: "+(4*op2));

            System.out.println("\nInput 0 to Add: "+(PC+4));
            System.out.println("Input 1 to Add: "+(4*op2));
            System.out.println("Output of Add: "+((4*op2)+(PC+4)));

            System.out.println("\n\n EX/MEM Buffer:\n");
            System.out.println(" ALUresult  zero  Addresult");
            System.out.println("   ["+(opReg2+opReg3)+"]      [0]      ["+((4*op2)+(PC+4))+"]");

            System.out.println("\n\n MEM Stage:\n");

            System.out.println("Read address: "+(opReg2+opReg3));
            System.out.println("Write address: "+(opReg2+opReg3));
            System.out.println("MemWrite: 1");
            System.out.println("MemRead: 0");
            System.out.println("WriteData: "+opReg1);
            System.out.println("ReadData: T");

            System.out.println("\nInput 1 of AND-Gate: 0");
            System.out.println("Input 2 of AND-Gate: 0");
            System.out.println("Output of AND-Gate: 0");

            System.out.println("\nValue Datapath Labelled * on Handout: "+(opReg2+opReg3));

            System.out.println("\n\n MEM/WB Buffer:\n");
            System.out.println("ALUresult  Readdata");
            System.out.println("   ["+(opReg2+opReg3)+"]        [T]");

            System.out.println("\n\n WB Stage:\n");
            System.out.println("Input 1 of MUX: T");
            System.out.println("Input 2 of MUX: "+(opReg2+opReg3));
            System.out.println("MemToReg: 1");
            System.out.println("Output of MUX: T");

            System.out.println("\nLocated in ID Stage, but received from WB stage:");
            System.out.println("WriteRegister: "+op1);
            System.out.println("Write data: T");
            System.out.println("RegWrite: 0");

            System.out.println("\nLocated in IF Stage, but received from WB stage:");
            System.out.println("Input 0 to MUX: "+(PC+4));
            System.out.println("Input 1 to MUX: "+((4*op2)+(PC+4)));
            System.out.println("MUX Selector: 0");
            System.out.println("Output of MUX: "+(PC+4));

            System.out.println("\n\nNew Value of memory at M["+(opReg2+opReg3)+"]: "+opReg1);


        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You entered the incorrect format.");
        }
    }
    public static void beq(int op1, int op2, int op3, Scanner in, int PC){
        //if $op1 = $op2, PC <- PC+4 + (4*op3)
        //offset = op3
        System.out.println("The semantics for the beq instruction are as follows: \nif ($x=$y) then PC <- PC+4 + (4*offset)\n");
        System.out.println("Given your input, the format is: "+"if($"+op1+"= $"+op2+") then PC <- PC+4 + (4*"+op3+")\n");
        System.out.println("The control signal vector is:");
        System.out.println(" _IF_   _ID_   _____EX_____");
        System.out.println("[1][1] [1][1] [0][0][0][0][1]\n");
        System.out.println("Please enter the Register value of $"+ op1+". [format: R"+op1+" <value>]");

        try{
            String regVals = in.nextLine();
            String[] splitRegVals1 = regVals.split(" ");
            int opReg1 = Integer.parseInt(splitRegVals1[1]);

            System.out.println("Please enter the Register value of $"+ op2+". [format: R"+op2+" <value>]");

            regVals = in.nextLine();
            String[] splitRegVals2 = regVals.split(" ");
            int opReg2 = Integer.parseInt(splitRegVals2[1]);
            int opReg3 = op3;
            int zero = 0;
            if(opReg1 == opReg2){
                zero = 1;
            }

            System.out.println("Based on your input, the following is the result of your trace through MIPS:\n");
            System.out.println(" IF Stage:");
            System.out.println("PC: "+PC);
            System.out.println("Readaddress: "+PC);
            System.out.println("Output of program counter PC+4: "+(PC+4));


            System.out.println("\n\n IF/ID Buffer:\n");
            System.out.println("op   rs   rt   inst[15-0]");
            System.out.println("[4]  ["+op1+"]  ["+op2+"]    ["+op3+"]");


            System.out.println("\n\n ID Stage:\n");
            System.out.println("Read register 1: "+op1);
            System.out.println("Read register 2: "+op2);
            System.out.println("Instruction [15-0]: "+op3);
            System.out.println("Read data 1: "+opReg1);
            System.out.println("Read data 2: "+opReg2);


            System.out.println("\n\n ID/EX Buffer:\n");
            System.out.println("inst[15-0]  readdata2  readdata1  pc+4");
            System.out.println("    ["+op3+"]         ["+opReg2+"]       ["+opReg1+"]      ["+(PC+4)+"]");


            System.out.println("\n\n EX Stage:\n");

            System.out.println("\nALU Control 6-bit main input: 4");
            System.out.println("ALU Control ALUOp input: 10");
            System.out.println("ALU Control output: Branch if Equal");

            System.out.println("\nUpper MUX, upper input: "+opReg2);
            System.out.println("Upper MUX, lower input: "+op3);
            System.out.println("Upper MUX, ALU src: 0");
            System.out.println("Upper MUX output: "+opReg2);

            System.out.println("\nALU top input: "+opReg1);
            System.out.println("ALU lower input (from upper MUX): "+opReg2);
            System.out.println("ALU result: "+(opReg1-opReg2));
            System.out.println("Zero: "+zero);

            System.out.println("\nInput to Shift Left 2: "+op3);
            System.out.println("Output of Shift Left 2: "+(4*op3));

            System.out.println("\nInput 0 to Add: "+(PC+4));
            System.out.println("Input 1 to Add: "+(4*op3));
            System.out.println("Output of Add: "+((4*op3)+(PC+4)));

            System.out.println("\n\n EX/MEM Buffer:\n");
            System.out.println("readdata2  ALUresult  zero  Addresult");
            System.out.println("    ["+opReg2+"]         ["+(opReg2+opReg3)+"]    ["+zero+"]      ["+((4*op3)+(PC+4))+"]");

            System.out.println("\n\n MEM Stage:\n");

            System.out.println("\nRead address: "+(opReg1-opReg2));
            System.out.println("Write address: "+(opReg1-opReg2));
            System.out.println("Write data: "+opReg2);
            System.out.println("MemWrite: 0");
            System.out.println("MemRead: 0");
            System.out.println("ReadData: T");

            System.out.println("\nInput 1 of AND-Gate: 1");
            System.out.println("Input 2 of AND-Gate: "+zero);
            System.out.println("Output of AND-Gate: "+zero);

            System.out.println("\nValue Datapath Labelled * on Handout: "+((4*op3)+(PC+4)));

            System.out.println("\n\n MEM/WB Buffer:\n");
            System.out.println("  ALUresult  Readdata");
            System.out.println("     ["+(opReg1-opReg2)+"]          [T]");

            System.out.println("\n\n WB Stage:\n");
            System.out.println("Input 1 of MUX: T");
            System.out.println("Input 2 of MUX: "+(opReg1-opReg2));
            System.out.println("MemToReg: 0");
            System.out.println("Output of MUX: "+(opReg1-opReg2));

            System.out.println("\nLocated in ID Stage, but received from WB stage:");
            System.out.println("WriteData: "+(opReg1-opReg2));
            System.out.println("RegWrite: 1");

            System.out.println("\nLocated in IF Stage, but received from WB stage:");
            System.out.println("Input 0 to MUX: "+(PC+4));
            System.out.println("Input 1 to MUX: "+((4*op3)+(PC+4)));
            System.out.println("MUX Selector: "+zero);
            if(zero ==0){
                System.out.println("Output of MUX: "+(PC+4));
            }
            else{
                System.out.println("Output of MUX: "+((4*op3)+(PC+4)));
            }


        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You entered the incorrect format.");
        }
    }

    public static void main(String[] args) {
        String opcode;
        String operand1;
        String operand2;
        String operand3;
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your desired instruction to be traced through the MIPS cycle [format: opcode operand1 operand2 operand3]");

        String input = in.nextLine();
        String[] splitInput = input.split(" ");
        opcode = splitInput[0];
        operand1 = splitInput[1];
        operand2 = splitInput[2];
        operand3 = splitInput[3];

        System.out.println("The input received was as follows: "+opcode+" "+operand1+" "+operand2+" "+operand3+"\n \n");
        System.out.println("What is the current value of PC?");
        String PC = in.nextLine();
        while(Integer.parseInt(PC)%4 != 0){
            System.out.println("PC must be a multiple of 4. Please enter a new value.");
            PC = in.nextLine();
        }
        int intPC = Integer.parseInt(PC);
        int op1 = Integer.parseInt(operand1);
        int op2 = Integer.parseInt(operand2);
        int op3 = Integer.parseInt(operand3);

        if(opcode.compareTo("add")==0){
            add(op1, op2, op3, in, intPC);
        }
        else if(opcode.compareTo("sub")==0){
            sub(op1, op2, op3, in, intPC);
        }
        else if(opcode.compareTo("lw")==0){
            lw(op1, op2, op3, in, intPC);
        }
        else if(opcode.compareTo("sw")==0){
            sw(op1, op2, op3, in, intPC);
        }
        else if(opcode.compareTo("beq")==0){
            beq(op1, op2, op3, in, intPC);
        }
        else {
            System.out.println("The opcode your entered is not supported.");
        }
    }
}















