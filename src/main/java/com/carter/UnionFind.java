package com.carter;

/**
 * 并查集
 */
public class UnionFind {
    /**
     * 根节点的父节点是自身
     */
    private final int[] parents;
    /**
     * 每棵树的节点数
     */
    private final int[] sizes;
    /**
     * 连通分量
     */
    private int cnt;

    public int getCnt() {
        return cnt;
    }

    public UnionFind(int n) {
        this.parents = new int[n];
        this.sizes = new int[n];
        this.cnt = n;
        for (int i = 0; i < n; i++) {
            this.parents[i] = i;
            this.sizes[i] = 1;
        }
    }

    /**
     * 连接两个节点
     *
     * @param node1
     * @param node2
     * @return
     */
    public boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent1 == parent2) {
            return false;
        }
        if (sizes[parent1] < sizes[parent2]) {
            //树2比树1的节点多,树2的根节点作为根.增加树2的节点数
            parents[parent1] = parent2;
            sizes[parent2] += sizes[parent1];
        } else {
            //树1比树2的节点多,树1的根节点作为根.增加树1的节点数
            parents[parent2] = parent1;
            sizes[parent1] += sizes[parent2];
        }
        this.cnt--;
        return true;
    }

    /**
     * 两个节点是否相连
     *
     * @param node1
     * @param node2
     * @return
     */
    public boolean connected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    /**
     * 查找根节点
     *
     * @param node
     * @return
     */
    public int find(int node) {
        while (parents[node] != parents[parents[node]]) {
            //如果当前节点的父节点不是根节点,将当前节点移到其祖父节点,直到当前节点的父节点是根节点
            sizes[parents[node]] -= sizes[node];
            //TODO 这里需要加吗?
            sizes[parents[parents[node]]] += sizes[node];
            parents[node] = parents[parents[node]];
        }
        return parents[node];
    }
}

//class UnionFind1 {
//    private Map<Integer,Integer> father;
//
//    public UnionFind1() {
//        father = new HashMap<>();
//    }
//
//    public void add(int x) {
//        if (!father.containsKey(x)) {
//            father.put(x, null);
//        }
//    }
//
//    public void merge(int x, int y) {
//        int rootX = find(x);
//        int rootY = find(y);
//
//        if (rootX != rootY){
//            father.put(rootX,rootY);
//        }
//    }
//
//    public int find(int x) {
//        int root = x;
//
//        while(father.get(root) != null){
//            root = father.get(root);
//        }
//
//        while(x != root){
//            int original_father = father.get(x);
//            father.put(x,root);
//            x = original_father;
//        }
//
//        return root;
//    }
//
//    public boolean isConnected(int x, int y) {
//        return find(x) == find(y);
//    }
//}