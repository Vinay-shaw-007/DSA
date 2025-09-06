package Graph;

import java.util.*;

/**
 * Problem: Minimum Cost to Reach City With Discounts (LeetCode 2093)
 
 * Description
 * You are given an undirected weighted graph representing n cities (numbered 0 to n-1) and a list of highways. Each highway connects two cities and has a toll.
 
 * You also have a limited number of discount coupons. Each coupon can be usedDiscount to halve the toll cost of exactly one highway (using integer division). Each coupon can be usedDiscount only once, and you can use at most one coupon per highway.
 
 * Goal: Find the minimum total toll cost to travel from city 0 to city n-1, using at most the allowed number of coupons. Return -1 if the node is unreachable.
 
 * Constraints
 
 * 2 <= n <= 1000
 
 * 1 <= highways.length <= 1000
 
 * Each highways[i] = [city1, city2, toll] where:
 
 * 0 <= city1, city2 <= n-1
 
 * city1 != city2
 
 * 0 <= toll <= 10^5
 
 * 0 <= discounts <= 500
 
 * No duplicate highways.
 
 * &mdash;
 
 * Example 1
 * Input:
 * n = 5
 * highways = [
 *   [0, 1, 4],
 *   [2, 1, 3],
 *   [1, 4, 11],
 *   [3, 2, 3],
 *   [3, 4, 2]
 * ]
 * discounts = 1
 
 * Output: 9
 
 * Explanation:
 * - Travel 0 &rarr; 1 (cost = 4)
 * - Travel 1 &rarr; 4 using discount (cost = 11 / 2 = 5)
 * Total cost = 4 + 5 = 9

 * Leetcode
 
 * Example 2
 * Input:
 * n = 4
 * highways = [
 *   [1, 3, 17],
 *   [1, 2, 7],
 *   [3, 2, 5],
 *   [0, 1, 6],
 *   [3, 0, 20]
 * ]
 * discounts = 20
 
 * Output: 8
 
 * Explanation:
 * - Travel 0 &rarr; 1 (use discount; cost = 6 / 2 = 3)
 * - Travel 1 &rarr; 2 (use discount; cost = 7 / 2 = 3)
 * - Travel 2 &rarr; 3 (use discount; cost = 5 / 2 = 2)
 * Total cost = 3 + 3 + 2 = 8
 
 *
 * Leetcode
 
 * Example 3
 * Input:
 * n = 4
 * highways = [
 *   [0, 1, 3],
 *   [2, 3, 2]
 * ]
 * discounts = 0
 
 * Output: -1
 
 * Explanation: City 3 is unreachable from city 0.
 
 *
 * Leetcode
 
 * Summary Overview
 * Feature	Details
 * Graph Type	Undirected, Weighted
 * Special Constraint	Up to discounts coupons, each halves one edge
 * Task	Min-cost path from 0 to n-1
 * Return Value	Min cost or -1 if unreachable
 */

import java.util.*;

public class MinimumCostWithDiscounts {

    // State for priority queue: represents being at `node`
    // with total `cost` spent so far, having usedDiscount
    static class State {
        int node, cost, usedDiscount;
        State(int n, int c, int u) {
            node = n;
            cost = c;
            usedDiscount = u;
        }
    }

    // Main function to compute minimum cost from city 0 to city n-1
    public int minimumCost(int n, int[][] highways, int discounts) {
        // Build adjacency list (graph)
        // Each entry: adj[u] contains [v, weight]
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] h : highways) {
            adj.get(h[0]).add(new int[]{h[1], h[2]}); // edge u->v with weight
            adj.get(h[1]).add(new int[]{h[0], h[2]}); // undirected, so add reverse
        }

        // Infinity value for initialization
        int INF = (int)1e9;

        // dist[node][k] = minimum cost to reach `node` using exactly `k` discounts
        int[][] dist = new int[n][discounts + 1];
        for (int[] d : dist) Arrays.fill(d, INF);
        dist[0][0] = 0; // start at node 0 with 0 cost and 0 discounts usedDiscount

        // Min-heap priority queue ordered by total cost
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new State(0, 0, 0)); // start state: node 0, cost 0, usedDiscount=0

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            int cost = cur.cost;
            int usedDiscount = cur.usedDiscount;

            // If we reach destination (n-1), return the cost (Dijkstra guarantees it's min)
            if (u == n - 1) return cost;

            // Skip if we already found a better cost for this state
            if (cost > dist[u][usedDiscount]) continue;

            // Explore neighbors
            for (int[] edge : adj.get(u)) {
                int v = edge[0], w = edge[1];

                // Case 1: travel normally (no discount)
                if (dist[v][usedDiscount] > cost + w) {
                    dist[v][usedDiscount] = cost + w;
                    pq.offer(new State(v, dist[v][usedDiscount], usedDiscount));
                }

                // Case 2: travel with discount (if available)
                if (usedDiscount < discounts && dist[v][usedDiscount + 1] > cost + w / 2) {
                    dist[v][usedDiscount + 1] = cost + w / 2;
                    pq.offer(new State(v, dist[v][usedDiscount + 1], usedDiscount + 1));
                }
            }
        }

        // If destination is unreachable, return -1
        return -1;
    }

    // ---------------- DRIVER CODE ----------------
    public static void main(String[] args) {
        MinimumCostWithDiscounts solver = new MinimumCostWithDiscounts();

        // Example 1
        int n1 = 5;
        int[][] highways1 = {
                {0, 1, 4},
                {2, 1, 3},
                {1, 4, 11},
                {3, 2, 3},
                {3, 4, 2}
        };
        int discounts1 = 1;
        System.out.println("Output: " + solver.minimumCost(n1, highways1, discounts1));
        // Expected: 9

        // Example 2
        int n2 = 4;
        int[][] highways2 = {
                {1, 3, 17},
                {1, 2, 7},
                {3, 2, 5},
                {0, 1, 6},
                {3, 0, 20}
        };
        int discounts2 = 20;
        System.out.println("Output: " + solver.minimumCost(n2, highways2, discounts2));
        // Expected: 8

        // Example 3
        int n3 = 4;
        int[][] highways3 = {
                {0, 1, 3},
                {2, 3, 2}
        };
        int discounts3 = 0;
        System.out.println("Output: " + solver.minimumCost(n3, highways3, discounts3));
        // Expected: -1
    }
}

