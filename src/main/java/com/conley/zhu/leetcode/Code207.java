package com.conley.zhu.leetcode;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序
 */
public class Code207 {
    /**
     *
     * @param numCourses    课程数量
     * @param prerequisites 课程先后顺序数组
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adjacency.add(new ArrayList<>());
        }
        int[] indegrees  = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int[] cp : prerequisites){
            //cp[1] -> cp[0],所以cp[0]的入度要+1
            indegrees[cp[0]]++;
            //构建邻接表
            adjacency.get(cp[1]).add(cp[0]);
        }
        for(int i = 0 ;i<numCourses;i++){
            //把入度为0的，即初始课程先入队
            if(indegrees[i] == 0)queue.add(i);
        }
        while (!queue.isEmpty()){
            numCourses--;
            //获得初始课程
            int i = queue.poll();
            //得到初始课程对应的下一节课,把他们入度减少，使他们成为初始课程
            for(int j : adjacency.get(i)){
                if(--indegrees[j] == 0){
                    queue.add(j);
                }
            }
        }
        return numCourses == 0;
    }

}
