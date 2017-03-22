package corps.salesforce;

/**
 * Created by xuan on 2/13/17.
 */
public class FlightInfo {
}


/*
hello from xuan


Write a program that prints the numbers from 1 to 100.
But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
For numbers which are multiples of both three and five print “FizzBuzz”.

void num_print(){
    for (int i = 1; i <= 100; i++) {
        if (i % 5 ==0 && i % 3 == 0) {
            System.out.print("FizzBuzz");
        }
        else if (i % 3 == 0) {
            System.out.print("Fizz");
        }
        else if (i % 5 == 0) {
            System.out.print("Buzz");
        }
        else {
            System.out.print(i);
        }
    }
}




Given flight data, find all paths from City A to City B.
Example: Flight data - SEA->LAS, CHI->LAS, CHI->SEA, LAS->CHI, LAX->LAS, ATL->LAG, CHI->LAX.
Find all paths from CHI to LAS.
Output should be - CHI->LAS, CHI->SEA->LAS, CHI->LAX->LAS.

List<List<Strign>> findAllPathsFromSrcToDest(List<List<String>> flightData, String src, String dest) {
    Stack<String> stack = new LinkedList<String>();
    HashMap<String, List<String>> flights = new HashMap<>();
    HashSet<String> visited = new HashSet<>();

    queue.offer(src);
    visited.add(src);

    while (! queue.isEmpty()) {
        size = queue.size();
        for (int i = 0; i < size; i++) {
            String cur = queue.poll();
            nextDest = getNextFlight(flightData, src);
            if (!visited.containKeys(nextDest) && (nextDest != dest)) {
                queue.offer(nextDest);
            }
        }
    }
}



List<String> getNextFlight(List<List<String>> flightData, String src, HashSet<String> visited) {
    List<String> rst = new LinkedList<String>();
    List<String> dests = filightData.get(src);
    for (int i; int i< dests.size(); i++) {
        if (!visited(dests.get(i)) {
            rst.add(dests.get(i);
        }
    }
    return dests;
}

void dfsHelper(List<String> results, String src, String dest, List<List<String>> fligtResults) {
    Stack<String> stack = new LinkedList<String>();
    HashSet<String> visited = new HashSet<>();
    stack.offer(src);
    visited.add(src);
    results.add(src);
    while (! stack.isEmpty()) {
        String cur = stack.pop();
        List<Srting> dests = getNextFlight(flightData, src);
        if (dests.size() == 0) {
            results.remove(results.size()-1);
        }
        for (int i = 0; i< dests.size(); i++) {
            if (dests.get(i) == dest) {
                results.add(dest);
                flightResults.add(results);
            }
            else if (! visited(dests.get(i)) {
                visited.add(dests.get(i));
                stack.add(dests.get(i));
            }
        }
    }
}
 */