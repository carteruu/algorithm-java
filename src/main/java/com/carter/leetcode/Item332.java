package com.carter.leetcode;

import java.util.*;

public class Item332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> dis = new HashMap<>();
        for (List<String> ticket : tickets) {
            dis.putIfAbsent(ticket.get(0), new ArrayList<>());
            dis.get(ticket.get(0)).add(ticket.get(1));
        }
        for (List<String> t : dis.values()) {
            Collections.sort(t);
        }
        ArrayList<String> ans = new ArrayList<>(dis.size());
        this.dfs(dis, "JFK", ans);
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(Map<String, List<String>> dis, String start, List<String> ans) {
        Iterator<String> iterator = dis.getOrDefault(start, new ArrayList<>()).iterator();
        while (iterator.hasNext()) {
            String target = iterator.next();
            iterator.remove();
            dfs(dis, target, ans);
        }
        ans.add(start);
    }
}
