# count string

---Асуулт---"english" :
A regular expression is used to describe a set of strings. For this problem the alphabet is limited to 'a' and 'b'.

We define  to be a valid regular expression if:
1)  is "" or "".
2)  is of the form "", where  and  are regular expressions.
3)  is of the form "" where  and  are regular expressions.
4)  is of the form "" where  is a regular expression.

Regular expressions can be nested and will always have have two elements in the parentheses. ('' is an element, '' is not; basically, there will always be pairwise evaluation) Additionally, '' will always be the second element; '' is invalid.

The set of strings recognized by  are as follows:
1) If  is "", then the set of strings recognized .
2) If  is "", then the set of strings recognized .
3) If  is of the form "" then the set of strings recognized = all strings which can be obtained by a concatenation of strings  and , where  is recognized by  and  by .
4) If  is of the form "" then the set of strings recognized = union of the set of strings recognized by  and .
5) If  is of the form "" then the the strings recognized are the empty string and the concatenation of an arbitrary number of copies of any string recognized by .

Task
Given a regular expression and an integer, , count how many strings of length  are recognized by it.

Input Format

The first line contains the number of test cases .  test cases follow.
Each test case contains a regular expression, , and an integer, .

Constraints

It is guaranteed that  will conform to the definition provided above.
Output Format

Print  lines, one corresponding to each test case containing the required answer for the corresponding test case. As the answers can be very big, output them modulo .

Sample Input
3  
((ab)|(ba)) 2  
((a|b)*) 5  
((a*)(b(a*))) 100
Sample Output
2  
32  
100
Explanation

For the first case, the only strings recognized are "" and "". Of the  possible strings of length ,  of them fit that expression.
For the second case, the RegEx recognizes any string of any length containing only 's and 's. The number of strings of length  recognized by this expression is .
For the third case, the RegEx recognizes any string having one , preceeded and followed by any number of 's. There are  strings of length  which have a single  in them.

---Асуулт---"Монголоор" :
Энэ бодлогод бид зөвхөн 'a' ба 'b' гэсэн хоёр үсгийг агуулсан үгийн олонлогийг дүрсэлдэг тогтмол илэрхийлэл (regular expression) ашиглана.

Тогтмол илэрхийлэл дараах нөхцлүүдийг хангах бол зөвшөөрөгдөнө:

"a" эсвэл "b" бол шууд зөв.

"(R1R2)" хэлбэртэй бол зөв. Энд R1 ба R2 нь өөрсдөө тогтмол илэрхийлэл.

"(R1|R2)" хэлбэртэй бол зөв. Энд | нь эсвэл (OR)-ийн утгатай.

"(R1*)” хэлбэртэй бол зөв. Энэ нь R1-ийн дурын тооны давталтыг илэрхийлнэ (0 ба түүнээс дээш удаа).

Тайлбар:

Илэрхийлэл үргэлж хоёр элементийг хамарсан хаалттай бүтэцтэй байна. Жишээ нь: ((a|b)*) зөв, харин (a|) бол буруу.

* тэмдэг үргэлж хоёр дахь элемент байж болохгүй ((*a) буруу), зөвхөн "(R1*)" хэлбэртэй байна.

Илэрхийлэл ямар үгсийг хүлээн зөвшөөрөх вэ:

"a" гэвэл зөвхөн "a" үгийг.

"b" гэвэл зөвхөн "b" үгийг.

"(R1R2)" бол R1 ба R2-оор тодорхойлогдох үгсийг нийлүүлэн гарсан бүх үгсийг.

"(R1|R2)" бол R1 эсвэл R2-оор тодорхойлогдох үгс.

"(R1*)" бол R1-оор тодорхойлогдох үгийг дурын тоогоор давтсан үгс (0 удаа давтах ч боломжтой, өөрөөр хэлбэл хоосон үг ч багтана).

Даалгавар:
Тогтмол илэрхийлэл r болон бүхэл тоо l өгөгдөх ба, уг илэрхийлэлд таарах яг урт нь l үг хэд байгааг ол.

Оролт:

Эхний мөрөнд туршилтын тоо t (жишээ нь: 3).
Дараагийн t мөр бүрд:

Тогтмол илэрхийлэл r

Бүхэл тоо l

Гаралт:

Туршилт бүрийн хувьд 1 мөрөнд, тухайн тогтмол илэрхийлэлд таарах яг урт l үг хэд байгааг хэвлэ.

Тоо их байж болзошгүй учраас 10^9 + 7 модулоор гаргана.

Жишээ оролт:
3  
((ab)|(ba)) 2  
((a|b)*) 5  
((a*)(b(a*))) 100
Гаралт:

2  
32  
100
Тайлбар:

Эхний илэрхийлэл (ab) ба (ba) хоёрын аль нэгийг зөвшөөрнө. 2 тэмдэгттэй үг 2 ширхэг л байна.

Хоёр дахь нь a болон b үсгийг дурын удаа давтахыг зөвшөөрнө. Тиймээс урт нь 5 байх бүх боломжит үгс: 2^5 = 32

Гурав дахь нь ганц b үсэг дунд нь орсон, хоёр талаараа дурын тооны a үсэгтэй үгсийг зөвшөөрнө. Жишээ нь: aaabaa, baaa, aaaaab, гэх мэт. Яг нэг b ба бусад нь a гэсэн үгс, урт нь 100 байх боломжит ийм үгсийн тоо: 100.
---Код---" "
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


---Тайлбар--- 
![count string](https://github.com/user-attachments/assets/061d7327-42aa-4134-b601-9f8d6980493b)
