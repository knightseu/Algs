package lc.solutions;
/*
 *  There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *  You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 *  You begin the journey with an empty tank at one of the gas stations.
 *  
 *  Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *  
 *  Note:
 *  The solution is guaranteed to be unique. 

 */

public class LC134_GasStation {
/*
 * 1 如果总的gas - cost小于零的话，那么没有解返回-1

2 如果前面所有的gas - cost加起来小于零，那么前面所有的点都不能作为出发点。
 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int index = -1;

        for(int i = 0; i<gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0) {
                index = i;
                sum = 0;
            }
        }
        return total < 0 ? -1 : index + 1;
        // index should be updated here for cases ([5], [4]);
        // total < 0 is for case [2], [2]
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
