package corps.AtomTickets;

/**
 * Created by xuanlin on 3/17/17.
 */

/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Seat {
    String name;
    int row;
    int col;
    boolean occupied;
    Seat(String name, int row, int col, boolean occupied) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.occupied = occupied;
    }

}

class CRow {
    int row;
    List<CSeat> seats;
}

class CSeat {
    int start;
    int num;
    int recIndex; //
}



public class SeatRecommend {
    int getRecommendationIndex(int row, int col) {
        return 10;
    }

    HashMap<Integer, List<CSeat>> hash = new HashMap<>();

    ArrayList<Seat> recommendSeats(Seat[][] map, int num) {
        ArrayList<CRow> newMap = preprocess(map);
        if (num <=0 || newMap.size() <0) {
            return null;
        }

        for (CRow crow: newMap) {
            for (CSeat cseat: crow.seats) {
                if (cseat.num >= num) {
                    //return recommend results
                    ArrayList<Seat> rst = new ArrayList<>();
                    for (int i=0; i<num; i++) {
                        rst.add(map[crow.row-1][i + cseat.start]);

                        //update map
                        //map[crow.row-1][i + cseat.start].occupied = true;
                    }
                    return rst;
                }
            }
        }

        //
        for (int i = 10; i>0; i--) {
            List<CSeat> listSeat = hash.get(i);
            if (listSeat != null && listSeat.size()>0) {
                //find seat
                for (CSeat candidate : listSeat) {
                    if (candidate.num >= num) {
                        ArrayList<Seat> rst = new ArrayList<>();
                        for (int j=0; j<num; j++) {
                            rst.add(map[candidate - 1][j+candidate.start]);
                        }
                        return rst;
                    }
                }
            }
        }

        return null;
    }

    ArrayList<CRow> preprocess(Seat[][] map) {
        ArrayList<CRow> list = new ArrayList<>();

        if (map == null || map.length == 0 ||
                map[0] == null || map[0].length == 0) {
            return list;
        }

        int row = map.length;
        int count = 0;
        for (int i=0; i<row; i++) {
            count = 0;
            CRow rows = new CRow();
            rows.row = i+1; //todo
            rows.seats = new ArrayList<CSeat>();

            int start = 0;
            for (int j=0; j<map[i].length; j++) {
                if (!map[i][j].occupied) {
                    if (count == 0) {
                        start = j;
                    }
                    count++;
                }
                else {
                    //end of contious seat
                    if (count >0) {
                        CSeat cseat = new CSeat();
                        cseat.start = start;
                        cseat.num = count;
                        count = 0;
                        rows.seats.add(cseat);
                        //cal recindex
                        int recIndex = getRecommendationIndex(rows.row, start);
                        List<CSeat> listSeats = hash.get(recIndex);
                        if (listSeats != null) {
                            listSeats.add(cseat);
                        }
                        else {
                            List<CSeat> listSeats2 = new ArrayList<>();
                            listSeats2.add(cseat);
                            hash.put(recIndex, listSeats2);
                        }

                    }
                }
            }
            if (count > 0) {
                CSeat cseat = new CSeat();
                cseat.start = start;
                cseat.num = count;
                rows.seats.add(cseat);
            }
            list.add(rows);
        }
        return list;
    }

    public static void main (String[] args) {
        SeatRecommend seatRecommend = new SeatRecommend();


A2,1,2,true
A3,1,3,true
A4,1,4,false
A5,1,5,false
A6,1,6,true

B1,2,1,false
B2,2,2,false
B3,2,3,true
B4,2,4,false
B5,2,5,true
B6,2,6,false

C1,3,1,false
C2,3,2,true
C3,3,3,true
C4,3,4,false
C5,3,5,false
C6,3,6,false

        Seat[][] map = new Seat[3][6];
        Seat seat;
        map[0][0] = new Seat("A1",1,1,false);
        map[0][1] = new Seat("A2",1,2,true);
        map[0][2] = new Seat("A3",1,3,true);
        map[0][3] = new Seat("A4",1,4,false);
        map[0][4] = new Seat("A5",1,5,false);
        map[0][5] = new Seat("A6",1,6,true);

        map[1][0] = new Seat("B1",2,1,false);
        map[1][1] = new Seat("B2",2,2,false);
        map[1][2] = new Seat("B3",2,3,true);
        map[1][3] = new Seat("B4",2,4,false);
        map[1][4] = new Seat("B5",2,5,true);
        map[1][5] = new Seat("B6",2,6,false);

        map[2][0] = new Seat("C1",3,1,false);
        map[2][1] = new Seat("C2",3,2,true);
        map[2][2] = new Seat("C3",3,3,true);
        map[2][3] = new Seat("C4",3,4,false);
        map[2][4] = new Seat("C5",3,5,false);
        map[2][5] = new Seat("C6",3,6,false);

        ArrayList<Seat> seats = seatRecommend.recommendSeats(map, 4);
        if (seats !=null) {
            for (Seat s : seats) {
                System.out.print(s.name + ",");
            }
            System.out.println();
        }
    }



}
*/