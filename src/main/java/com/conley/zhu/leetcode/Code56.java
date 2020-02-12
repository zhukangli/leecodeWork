package com.conley.zhu.leetcode;

import java.util.*;


public class Code56 {
    static class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //临接表的一个图
    private Map<Interval,List<Interval>> graph;

    //构建邻接表的图
    private void buildGraph(List<Interval> intervals){
        graph = new HashMap<>();
        for(Interval interval : intervals){
            graph.put(interval,new LinkedList<>());
        }
        for(Interval interval : intervals){
            for(Interval interval2 : intervals){
                if(overlap(interval,interval2)){
                    graph.get(interval).add(interval2);
                    graph.get(interval2).add(interval);
                }
            }
        }
    }

    //判断是否区间重叠
    private boolean overlap(Interval a,Interval b){
        return a.start <= b.end && b.start <= a.end;
    }

    //遍历邻接表后形成的连通图列表
    private Map<Integer,List<Interval>> nodesInComp;
    //存已访问过的结点
    private Set<Interval> visited;

    //遍历连通图
    private void buildComponents(List<Interval> intervals) {
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compMember = 0;
        for(Interval interval : intervals){
            if(!visited.contains(interval)){
                markComponentDFS(interval,compMember);
                compMember++;
            }
        }
    }

    private void markComponentDFS(Interval interval, int compMember){
        Stack<Interval> stack = new Stack<>();
        stack.add(interval);
        while (!stack.isEmpty()){
            Interval node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                if(nodesInComp.get(compMember) == null){
                    nodesInComp.put(compMember,new LinkedList<>());
                }
                nodesInComp.get(compMember).add(node);
                for(Interval val : graph.get(node)){
                    stack.add(val);
                }
            }
        }
    }



    private List<Interval> arrayToList(int[][] intervals){
        List<Interval> list = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            list.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        return list;
    }

    private int[][] listToArray(List<Interval> list){
        int[][] ins = new int[list.size()][2];
        for(int i = 0;i<list.size();i++){
            ins[i][0] = list.get(i).start;
            ins[i][1] = list.get(i).end;
        }
        return ins;
    }

    public int[][] merge2(int[][] vals) {
        List<Interval> intervals = arrayToList(vals);
        buildGraph(intervals);
        buildComponents(intervals);
        List<Interval> merged = new LinkedList<>();
        for(int i = 0;i<nodesInComp.size();i++) {
            //把所有连通图连城一个
            Interval val = mergeNodes(nodesInComp.get(i));
            merged.add(val);
        }
        return listToArray(merged);
    }

    private Interval mergeNodes(List<Interval> nodes) {
        int minStart = nodes.get(0).start;
        for (Interval node : nodes) {
            minStart = Math.min(minStart, node.start);
        }

        int maxEnd = nodes.get(0).end;
        for (Interval node : nodes) {
            maxEnd= Math.max(maxEnd, node.end);
        }
        return new Interval(minStart, maxEnd);
    }


    /**
     * 上面的邻接表方法超时了，下面用排序的方法来做
     */
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public int[][] merge(int[][] vals) {
        List<Interval> intervals = arrayToList(vals);
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return listToArray(merged);
    }




    public static void main(String[] args) {
        int[] t1 = new int[]{1,3};
        int[] t2 = new int[]{2,6};
        int[] t3 = new int[]{8,10};
        int[] t4 = new int[]{15,18};
        int[][] ans = new int[4][];
        ans[0] = t1;
        ans[1] = t2;
        ans[2] = t3;
        ans[3] = t4;
        System.out.println(new Code56().merge(ans));
    }

}
