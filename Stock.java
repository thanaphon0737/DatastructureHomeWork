/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
 */
package hw4_group17;

/**
 *
 * @author Patiwet
 */
public class Stock {

    private List list;
    private int totalShares;

    public Stock(String costBasis) {
        switch (costBasis) {
            case "FIFO":
                list = new Queue();
                break;
            case "LIFO":
                list = new Stack();
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }

    public void buy(int boughtShares, double boughtPrice) {
        // Complete this code
        // Something is missing here
        list.push(new Node(boughtShares, boughtPrice));//to push buydata to list
        totalShares += boughtShares;
    }

    public void sell(int soldShares, double soldPrice) {
        if (soldShares <= totalShares) {
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;
            boolean flagUnrealizeGain = false; //for control when to calculate realizedGain and unrealizedGain

            totalShares -= soldShares;
            while (soldShares != 0) { //do until soldShares = 0

                if (soldShares < list.top().shares) { //do when soldShares < list.top().shares
                    if (!flagUnrealizeGain) { //do when flag down
                        realizedGain += (soldPrice - list.top().price) * soldShares; //calculate realizeGain
                        list.top().shares -= soldShares; //to change list.top().shares after sell 
                        soldShares -= soldShares; // soldShares = 0 
                    }

                }
                if (soldShares >= list.top().shares) { // do when soldShares >= list.top().shares

                    if (!flagUnrealizeGain) { //when flag down calculate realizedGain
                        realizedGain += (soldPrice - list.top().price) * list.top().shares; //calculate realizeGain
                        soldShares -= list.top().shares;//to decrease soldShares until soldShares = 0
                        list.pop(); //to change list.top()
                    } else { //when flag up calculate unrealizedGain
                        Node n = list.top();//create Node n point to list.top
                        while (n != null) { //do until n = null
                            unrealizedGain += (soldPrice - n.price) * n.shares; //calculate unrealizedGain
                            soldShares -= n.shares; //to decrease soldShares until soldShares = 0
                            n = n.next; //to access next Node
                        }
                    }

                }
                if (soldShares == 0) { 
                    if (!flagUnrealizeGain) {//do this when flag down
                        soldShares = totalShares; //change totalShares to soldShares for calculate unrealizedGain
                    }
                    
					flagUnrealizeGain = true; //change to flag up
                }

            }

            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
        } else {
            System.out.println("Sell command rejected");
        }
    }

    public void showList() {
        Node currentNode = list.top();
        System.out.print("head -> ");
        while (currentNode != null) {
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}
