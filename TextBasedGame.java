package textbasedgame;
import java.util.Random;
import java.util.Scanner;

public class TextBasedGame {
    
    public static void main(String[] args) {
        // System Objects
        Scanner in= new Scanner(System.in);
        Random rand=new Random();
        
        //Game variables
        String[] enemies={"skeleton","warrior","zombie","Assasian"};
        int maxEnemyHealth=85;
        int enemyAttackDamage=25;
        
        //players variable
        int health=100;
        int attackDamage=50;
        int numHealthPotions=4;
        int healthPotionHealAmount=30;
        int healthPotionDropChance=50;
        
        boolean running=true;
        
        System.out.println("Welcome to the Dungeon!!");
        
        GAME:
        while(running){
             System.out.println("--------------------------------------------");
             
            int enemyHealth=rand.nextInt(maxEnemyHealth);
            String enemy= enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# "+ enemy +" has appeared!! #\n");
            
            while(enemyHealth > 0){
                System.out.println("\tYour HP: "+ health);
                System.out.println("\t"+ enemy +"'s HP: "+ enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink Health Potion");
                System.out.println("\t3.Run!!");
                
                String input=in.nextLine();
                
                if(input.equals("1"))
                {
                    int damageDealt=rand.nextInt(attackDamage);
                    int damageTaken=rand.nextInt(enemyAttackDamage);
                    
                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    
                    System.out.println("\t>You strike the "+enemy+" for "+damageDealt+" damage.");
                    System.out.println("\t>You recieve "+damageTaken+" in retailation!");
                    
                    if(health<1){
                        System.out.println("\t>You have taken too much damage,you are too weak to go on!!");
                        break;
                    }
                }
                else if(input.equals("2"))
                {
                    if(numHealthPotions>0){
                        health+=healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("t>You drink a health potion, healing yourself for "+healthPotionHealAmount+
                                "\n\t>You now have "+health+" HP."+
                                "\n\t>You have "+numHealthPotions+" health potions left.");
                          
                    }
                    else{
                        System.out.println("\t>You have no Health Potion left! Defeat enemies for chance to win!!");
                    }
                }
                else if(input.equals("3"))
                {
                    System.out.println("\t>You ran away from "+enemy+"!");
                    continue GAME;
                }
                else{
                    System.out.println("\t>Invalid Number!!!");
                }
            }
            if(health<1){
                System.out.println("\t>You limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("--------------------------------------------");
            System.out.println(" # "+enemy+" is defeated! # ");
             System.out.println(" # You have "+health+" HP left. # ");
             
             if(rand.nextInt(100) < healthPotionDropChance){
                 numHealthPotions++;
                 System.out.println(" # The "+enemy+" has dropped a Health Potion # ");
                 System.out.println(" # You now have "+numHealthPotions+" Health Potion. # ");
             }
             System.out.println("--------------------------------------------");
             System.out.println("What would you like to do now?");
             System.out.println("1.Continue Fighting");
             System.out.println("2.Exit Dungeon!");
             
             String input=in.nextLine();
             
             while(!input.equals("1") && !input.equals("2")){
                 System.out.println("Invalid Command.");
                 input=in.nextLine();
             }
             
             if(input.equals("1")){
                 System.out.println("You continue on your adventure.");
             }
             else if(input.equals("2")){
                 System.out.println("You exit the Dungeon, successful from your adventure. ");
                 break;
             }
             
        }
        System.out.println("--------------------------------------------");
           System.out.println("############################");
           System.out.println("    THANKS FOR PLAYING!!    ");
           System.out.println("############################");
           System.out.println("--------------------------------------------");
    }
    
}
