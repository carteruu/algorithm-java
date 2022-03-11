package com.carter.leet;

import java.util.*;

public class Item1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //修课程前,需要修那些课
        Set<Integer>[] inDeg = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            inDeg[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            inDeg[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int i = 0; i < queries.length; i++) {
            Boolean isQ = false;
            Set<Integer> qs = new HashSet<>(inDeg[queries[i][1]]);
            while (qs.size() > 0) {
                if (qs.contains(queries[i][0])) {
                    isQ = true;
                    break;
                }
                Iterator<Integer> iterator = qs.iterator();
                while (iterator.hasNext()){
                    iterator.next();
                }
            }
            ans.add(isQ);
        }
        return ans;
    }
}
