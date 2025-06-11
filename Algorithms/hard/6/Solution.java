import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    static List<List<int[]>> graph;
    static List<int[]> dfa;
    static List<List<Integer>> matrix;
    static List<Integer> finalStates;
    static List<Integer> epsilon;
    static boolean[] visited;

    static void buildNFA(String s, int[] index, int in, int out) {
        if (s.charAt(index[0]) == 'a') {
            graph.get(in).add(new int[]{out, 1});
            index[0]++;
            return;
        }
        if (s.charAt(index[0]) == 'b') {
            graph.get(in).add(new int[]{out, 2});
            index[0]++;
            return;
        }
        int m1 = graph.size();
        graph.add(new ArrayList<>());
        int m2 = graph.size();
        graph.add(new ArrayList<>());
        index[0]++;
        buildNFA(s, index, m1, m2);
        if (s.charAt(index[0]) == '*') {
            graph.get(m2).add(new int[]{m1, 0});
            graph.get(in).add(new int[]{m2, 0});
            graph.get(m2).add(new int[]{out, 0});
            index[0] += 2;
            return;
        }
        if (s.charAt(index[0]) == '|') {
            graph.get(in).add(new int[]{m1, 0});
            graph.get(m2).add(new int[]{out, 0});
            index[0]++;
            buildNFA(s, index, m1, m2);
            index[0]++;
            return;
        }
        graph.get(in).add(new int[]{m1, 0});
        buildNFA(s, index, m2, out);
        index[0]++;
    }

    static void dfsEpsilon(int node) {
        if (visited[node]) return;
        visited[node] = true;
        epsilon.add(node);
        for (int[] e : graph.get(node)) {
            if (e[1] == 0) dfsEpsilon(e[0]);
        }
    }

    static void dfs(List<Integer> state, int type) {
        visited = new boolean[graph.size()];
        epsilon = new ArrayList<>();
        for (int node : state) {
            for (int[] e : graph.get(node)) {
                if (e[1] == type) dfsEpsilon(e[0]);
            }
        }
    }

    static void NFAtoDFA() {
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<List<Integer>> states = new ArrayList<>();
        dfa = new ArrayList<>();
        epsilon = new ArrayList<>();
        visited = new boolean[graph.size()];
        dfsEpsilon(0);
        Collections.sort(epsilon);
        states.add(new ArrayList<>(epsilon));
        map.put(new ArrayList<>(epsilon), 0);
        dfa.add(new int[]{-1, -1});
        int n = 1;
        for (int i = 0; i < n; i++) {
            dfs(states.get(i), 1);
            Collections.sort(epsilon);
            if (!epsilon.isEmpty()) {
                List<Integer> eCopy = new ArrayList<>(epsilon);
                if (!map.containsKey(eCopy)) {
                    map.put(eCopy, n++);
                    states.add(eCopy);
                    dfa.add(new int[]{-1, -1});
                }
                dfa.get(i)[0] = map.get(eCopy);
            }
            dfs(states.get(i), 2);
            Collections.sort(epsilon);
            if (!epsilon.isEmpty()) {
                List<Integer> eCopy = new ArrayList<>(epsilon);
                if (!map.containsKey(eCopy)) {
                    map.put(eCopy, n++);
                    states.add(eCopy);
                    dfa.add(new int[]{-1, -1});
                }
                dfa.get(i)[1] = map.get(eCopy);
            }
        }
        matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>(Collections.nCopies(n, 0)));
        }
        for (int i = 0; i < n; i++) {
            if (dfa.get(i)[0] != -1) matrix.get(i).set(dfa.get(i)[0], matrix.get(i).get(dfa.get(i)[0]) + 1);
            if (dfa.get(i)[1] != -1) matrix.get(i).set(dfa.get(i)[1], matrix.get(i).get(dfa.get(i)[1]) + 1);
        }
        finalStates = new ArrayList<>();
        for (int i = 0; i < states.size(); i++) {
            visited = new boolean[graph.size()];
            epsilon = new ArrayList<>();
            for (int node : states.get(i)) dfsEpsilon(node);
            if (epsilon.contains(1)) finalStates.add(i);
        }
    }

    static void mmult(List<List<Integer>> A, List<List<Integer>> B) {
        int n = A.size();
        List<List<Integer>> R = new ArrayList<>();
        for (int i = 0; i < n; i++) R.add(new ArrayList<>(Collections.nCopies(n, 0)));
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = (sum + A.get(i).get(k) * 1L * B.get(k).get(j)) % 1000000007;
                }
                R.get(i).set(j, (int) sum);
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A.get(i).set(j, R.get(i).get(j));
    }

    static void mexp(List<List<Integer>> M, int power) {
        int n = M.size();
        List<List<Integer>> R = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            R.add(new ArrayList<>(Collections.nCopies(n, 0)));
            R.get(i).set(i, 1);
        }
        while (power > 0) {
            if ((power & 1) != 0) mmult(R, M);
            power >>= 1;
            if (power > 0) mmult(M, M);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                M.get(i).set(j, R.get(i).get(j));
    }

    public static int countStrings(String r, int l) {
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        int[] index = {0};
        buildNFA(r, index, 0, 1);
        NFAtoDFA();
        mexp(matrix, l);
        long res = 0;
        for (int j : finalStates) {
            res = (res + matrix.get(0).get(j)) % 1000000007;
        }
        return (int) res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        for (int tItr = 0; tItr < t; tItr++) {
            String[] parts = bufferedReader.readLine().split(" ");
            String r = parts[0];
            int l = Integer.parseInt(parts[1]);
            int result = Result.countStrings(r, l);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
