package lint.ad_ladder2;

/**
 * Created by xuanlin on 3/5/17.
 * 391
 * http://www.lintcode.com/en/problem/connecting-graph-ii/
 */

import common.datastructure.Interval;
import java.util.List;
import java.util.Comparator;

class Point{
    int time;
    int flag;

    Point(int t, int s){
        this.time = t;
        this.flag = s;
    }
    public static Comparator<Point> PointComparator  = new Comparator<Point>(){
        public int compare(Point p1, Point p2){
            if(p1.time == p2.time) return p1.flag - p2.flag;
            else return p1.time - p2.time;
        }
    };
}

public class NumberOfAirplanes {

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        return 0;
    }
}


/*
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Have you met this question in a real interview? Yes
Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3
 */