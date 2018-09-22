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
            int remainSoldShares = soldShares;
            int remainTotalShares;
            boolean flag = false;
            // Complete this code
            // Something is missing here
            totalShares -= soldShares;
            remainTotalShares = totalShares;
            do {

                if (remainSoldShares < list.top().shares) {
                    remainSoldShares = soldShares;
                    if(realizedGain == 0.0){
                        list.pop();
                        flag = true;
                        break;
                    }
                    if(flag) break;

                }
                if (remainSoldShares > list.top().shares) {
                    remainSoldShares = list.top().shares;
                    

                }
                realizedGain += (soldPrice - (list.top().price)) * remainSoldShares;
                soldShares -= remainSoldShares;
                if (remainSoldShares == list.top().shares) {
                    list.pop();
                }
            } while (soldShares != 0);
            List tempList = new Stack();
            tempList.push(list.top());
            while (totalShares != 0) { //This loop for unrealizerGain.
                if (remainTotalShares > list.top().shares) {
                    remainTotalShares = list.top().shares - remainSoldShares; //stock remain form total
                    totalShares -= remainTotalShares;
                }
                unrealizedGain += (soldPrice - (list.top().price)) * remainTotalShares;
                remainTotalShares = totalShares;
                totalShares -= remainTotalShares;
                tempList.pop();
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
