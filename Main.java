/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
*/ 
package hw4_group17;

/**
 *
 * @author Patiwet
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
      /* Stock ptt = new Stock("FIFO");
        
        ptt.showList();
        ptt.buy(10, 100);
        ptt.buy(10, 150);
        ptt.showList();
        ptt.buy(20, 110);
        ptt.buy(20, 160);
        ptt.showList();*/

       
        Stock ptt = new Stock("FIFO");
        ptt.buy(10, 100);
        ptt.buy(10, 150);
        ptt.buy(20, 110);
        ptt.buy(20, 160);
        ptt.showList();
        ptt.sell(58, 130);
        ptt.showList();
        
        
   /*    Stock ptt = new Stock("LIFO");
        ptt.buy(10, 100);
        ptt.buy(10, 150);
        ptt.buy(20, 110);
        ptt.buy(20, 160);
        ptt.showList();
        ptt.sell(25, 130);
        ptt.showList();*/
        
        
        
       /* Stock cpall = new Stock("FIFO");
        cpall.buy(35, 100);
        cpall.sell(25, 130);
        cpall.buy(5, 130);
        cpall.sell(10, 120);
        cpall.sell(5, 120);
        
        cpall = new Stock("LIFO");
        cpall.buy(35, 100);
        cpall.sell(25, 130);
        cpall.buy(5, 130);
        cpall.sell(10, 120);
        cpall.sell(5, 120);
*/
        
  /*      Stock scb = new Stock("FIFO");
        scb.buy(5, 100);
        scb.sell(10, 150);
        scb.buy(5, 150);
        scb.sell(10, 150);
*/
      /*
        Stock scb = new Stock("LIFO");
        scb.buy(5, 100);
        scb.sell(10, 150);
        scb.buy(5, 150);
        scb.sell(0, 125);
*/

    }
    
}
