package lint.Microsoft;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

/**
 * Created by xuanlin on 2/23/17.
 */

class People {
    String name;
    HashSet<String> friends;

    People (String name) {
        this.name = name;
        friends = new HashSet<>();
    }

    public void AddFriend(People people) {
        if (!friends.contains(people.name)) {
            friends.add(people.name);
        }
    }

    public void AddFriend(String name) {
        if (!friends.contains(name)) {
            friends.add(name);
        }
    }
}


class SocialApp {
    HashMap<String, People> peopleMap;
    SocialApp() {
        peopleMap = new HashMap<>();
    }

    public void SignUp(String name) {
        if (! peopleMap.containsKey(name)) {
            People people = new People(name);
            peopleMap.put(name, people);
        }
    }

    People findPeople(String name) {
        if (peopleMap.containsKey(name)) {
            return peopleMap.get(name);
        }
        else {
            return null;
        }
    }

    int FindShortestDistanceBetween(String name1, String name2) {
        if (null == name1 || name1.length() ==0) {
            return -1;
        }
        People first = findPeople(name1);
        if (null == first) {
            return -1;
        }
        HashSet<String> hash = new HashSet<>();
        hash.add(first.name);
        int distance = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(first.name);


        while (! queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                String people = queue.poll();
                if (people == name2) {
                    return distance;
                }
                for (String friend: findPeople(people).friends) {
                    if (!hash.contains(friend)) {
                        hash.add(friend);
                        queue.offer(friend);
                    }
                }
            }

            distance++;
        }

    }
}

