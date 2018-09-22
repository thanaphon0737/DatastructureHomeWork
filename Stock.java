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
        list.push(new Node(boughtShares, boughtPrice));
        totalShares += boughtShares;
    }

    public void sell(int soldShares, double soldPrice) {
        if (soldShares <= totalShares) {
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;
            boolean flagUnrealizeGain = false;

            totalShares -= soldShares;
            while (soldShares != 0) {

                if (soldShares < list.top().shares) {
                    if (!flagUnrealizeGain) {
                        realizedGain += (soldPrice - list.top().price) * soldShares;
                        list.top().shares -= soldShares;
                        soldShares -= soldShares;
                    }

                }
                if (soldShares >= list.top().shares) {

                    if (!flagUnrealizeGain) {
                        realizedGain += (soldPrice - list.top().price) * list.top().shares;
                        soldShares -= list.top().shares;
                        list.pop();
                    } else {
                        Node n = list.top();
                        while (n != null) {
                            unrealizedGain += (soldPrice - n.price) * n.shares;
                            soldShares -= n.shares;
                            n = n.next;
                        }
                    }

                }
                if (soldShares == 0) {
                    if (!flagUnrealizeGain) {
                        soldShares = totalShares;
                    }
                    flagUnrealizeGain = true;
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
