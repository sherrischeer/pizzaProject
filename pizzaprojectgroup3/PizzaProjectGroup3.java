 
package pizzaprojectgroup3;

//Authors:  Sherri Scheer, Mike Ventimiglia, Vasanthi Bodasingi
//Date: 10/04/2017

import java.util.Scanner;


public class PizzaProjectGroup3 {

 
    public static void main(String[] args) {

       // Ingredients
        String[][] ingTable = {
            {"1a  OR","Crust - regular","each","one"},
            {"1b","Crust - gluten-free","each","one"},
            {"2","Red Sauce","1/4 cup","two"},
            {"3","Pizza Cheese","1/4 cup","two"},
            {"4","Diced onion","1/8 cup","two"},
            {"5","Diced green pepper","1/8 cup","two"},
            {"6","Pepperoni","2 pieces","four"},
            {"7","sliced mushroom","1/8 cup","two"},
            {"8","Diced jalapenos","1/8 cup","two"},
            {"9","Sardines","each","four"},
            {"10","Pineapple chuncks","2 pieces","four"},
            {"11","Tofu","1/4 cup","two"},
            {"12","Ham chunks","4 pieces","four"},
            {"13","Dry red pepper","Generous spinkle","four"},
            {"14","Dried basil","Generous sprinkle","two"},
        };
        
        // Counters
        int[][] ingCnt = new int[][]{ // max, # selected
            {1,0}, {1,0}, {2,0}, {2,0}, {2,0}, {2,0}, {4,0}, {2,0}, {2,0},
            {4,0}, {4,0}, {2,0}, {4,0}, {4,0}, {2,0} };
         int nbrSelected = 0;

        // print welcome message
        System.out.println("Welcome to Group 3 Pizza Kitchen.\n" +
                "Please select up to 8 ingredients from the list below.\n");
        
        //print menu
        printList(ingTable, ingCnt);
        
        //declare scanner
        Scanner input=new Scanner(System.in);
        boolean finished=false;
        
         //prompt user for choice of ingredients
         while(!finished) {
            
             int qty;
             boolean validSelection=true;
             System.out.print("Enter Item #: ");
             String answer=input.nextLine();
             switch(answer) {
                case "1a": 
                    if(ingCnt[0][1]==0 && ingCnt[1][1]==0){
                        nbrSelected++;
                    }
                    ingCnt [0][1]=1; 
                    ingCnt [1][1]=0;
                    System.out.println("You have added Regular Crust"); 
                    break;
                case "1b": 
                    if(ingCnt[0][1]==0 && ingCnt[1][1]==0){
                        nbrSelected++;
                    }
                    ingCnt [1][1]=1; 
                    ingCnt [0][1]=0; 
                    System.out.println("You have added Gluten Free Crust"); 
                    break;
                case "2": 
                    if(ingCnt[2][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt, 2, nbrSelected); 
                    if (qty>0) nbrSelected++; 
                    ingCnt[2][1]=qty; 
                    break;
                case "3": 
                     if(ingCnt[3][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,3, nbrSelected);
                     if (qty>0) nbrSelected++; 
                    ingCnt[3][1]=qty; 
                    break;
                case "4": 
                      if(ingCnt[4][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,4, nbrSelected);
                    if (qty>0) nbrSelected++; 
                    ingCnt[4][1]=qty; 
                    break;
                case "5": 
                      if(ingCnt[5][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,5, nbrSelected); 
                    if (qty>0) nbrSelected++; 
                    ingCnt[5][1]=qty; 
                    break;
                case "6":
                      if(ingCnt[6][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,6, nbrSelected); 
                    if (qty>0) nbrSelected++; 
                    ingCnt[6][1]=qty; 
                    break;
                case "7": 
                      if(ingCnt[7][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,7, nbrSelected);
                    if (qty>0) nbrSelected++; 
                    ingCnt[7][1]=qty; 
                    break;
                case "8": 
                      if(ingCnt[8][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,8, nbrSelected); 
                    if (qty>0) nbrSelected++; 
                    ingCnt[8][1]=qty; 
                    break;
                case "9": 
                    System.out.println("This item is not allowed."); 
                    break;
                case "10": 
                    System.out.println("This item is not allowed."); 
                    break;
                case "11": 
                    System.out.println("This item is not allowed."); 
                    break;
                case "12": 
                      if(ingCnt[12][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,12, nbrSelected); 
                    if (qty>0) nbrSelected++; 
                    ingCnt[12][1]=qty; 
                    break;
                case "13": 
                      if(ingCnt[13][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,13, nbrSelected); 
                    if (qty>0) nbrSelected++; 
                    ingCnt[13][1]=qty; 
                    break;
                case "14": 
                      if(ingCnt[14][1]>0){
                        nbrSelected--;
                    }
                    qty=getQuantity(ingTable, ingCnt,14, nbrSelected); 
                    if (qty>0) nbrSelected++; 
                    ingCnt[14][1]=qty; 
                    break;
                default:  
                    validSelection=false; System.out.println("Invalid Selection.  Enter item #: ");
                     break; 
             }
               System.out.println("Are you finished and ready to bake your pizza?  y/n ");
               String choice=input.nextLine();
               if (choice.equalsIgnoreCase("y")) {
                  
                   if(ingCnt[0][1]==0 && ingCnt[1][1]==0) {
                       System.out.println("Really, no crust. No mess here; choose a crust!");
                   } else { 
                        finished=true;
                   }
               } else {
                     printList(ingTable, ingCnt);
               }

             }
          //print recipe
          System.out.println("Recipe:");
          String crustType;
          if (ingCnt[0][1]>0) {
              crustType="Regular";
          } else {
              crustType="Gluten-free";
              
          }
           System.out.println("Crust - "+crustType);
          for(int row=2;row<ingTable.length;row++){
              if (ingCnt[row][1]>0) {
                  System.out.println(ingTable[row][1]+" - "+ingCnt[row][1]);
              }   
          }
          System.out.println("Instructions: \tSpread above ingredients proportionately on top of crust. \n"
                  + "\t\tCook until crust is golden brown and toppings are fully warm.");
         }
                 
    //get the ingredient quantity
    private static int getQuantity(String[][] ingTbl, int[][] ingCnt, int row, int nbrSelected) {
        Scanner input=new Scanner(System.in);
        boolean gotIngredient=false;
        int quantity=0; int nbrIn=0;
        if (nbrSelected>7) {
            System.out.println("Max ingredients reached.");
        } else {
            while(!gotIngredient) {
                System.out.print("How many portions (" +ingTbl[row][2]+ ") "+" would you like? ");
                nbrIn=input.nextInt();
                if (nbrIn<0 || nbrIn >ingCnt[row][0]) {
                    System.out.println("Amount "+nbrIn+" is too small or too big");
                } else {
                    quantity=nbrIn;
                    gotIngredient=true;
                }
            }
        }
        return quantity;
         
    }
    
    //print recipe with Baking instructions
    private static void printList(String[][] ingTbl, int[][] cnt) {
        System.out.println("Pizza Ingredients:"+"\n");
        System.out.format("%-10s%-20s%-20s%-20s%-10s", "Item #", "Category",
                "Measure", "Maximum Quantity", "Quantity"+"\n");
        System.out.println(""+"\n");
        for (int row=0;row<ingTbl.length;row++) {
            System.out.format("%-10s%-20s%-20s%-20s%-10d", ingTbl[row][0], ingTbl[row][1],
                    ingTbl[row][2], ingTbl[row][3], cnt[row][1]);
            System.out.println(""+"\n");
        }
    }
}

