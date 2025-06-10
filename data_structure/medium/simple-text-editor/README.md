# simple-text-editor

---asuult---"english" :

Implement a simple text editor. The editor initially contains an empty string, . Perform  operations of the following  types:
append - Append string  to the end of .
delete - Delete the last  characters of .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
Example
operation
index   S       ops[index]  explanation
-----   ------  ----------  -----------
0       abcde   1 fg        append fg
1       abcdefg 3 6         print the 6th letter - f
2       abcdefg 2 5         delete the last 5 letters
3       ab      4           undo the last operation, index 2
4       abcdefg 3 7         print the 7th characgter - g
5       abcdefg 4           undo the last operation, index 0
6       abcde   3 4         print the 4th character - d
The results should be printed as:
f
g
d
Input Format
The first line contains an integer, , denoting the number of operations.
Each line  of the  subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer,  (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,  is followed by its space-separated argument. For example, if  and , line  will be 1 abcd.

Constraints
The sum of the lengths of all  in the input .
The sum of  over all delete operations .
All input characters are lowercase English letters.
It is guaranteed that the sequence of operations given as input is possible to perform.
Output Format

Each operation of type  must print the  character on a new line.

Sample Input

STDIN   Function
-----   --------
8       Q = 8
1 abc   ops[0] = '1 abc'
3 3     ops[1] = '3 3'
2 3     ...
1 xy
3 2
4 
4 
3 1
Sample Output
c
y
a
Explanation
Initially,  is empty. The following sequence of  operations are described below:
. We append  to , so .
Print the  character on a new line. Currently, the  character is c.
Delete the last  characters in  (), so .
Append  to , so .
Print the  character on a new line. Currently, the  character is y.
Undo the last update to , making  empty again (i.e., ).
Undo the next to last update to  (the deletion of the last  characters), making .
Print the  character on a new line. Currently, the  character is a.

---asuult---"mongoloor" :
Энгийн текст засварлагч хэрэгжүүл
Засварлагч нь анх хоосон тэмдэгт мөр ("") агуулсан байна. Дараах төрлийн Q тооны үйлдлийг гүйцэтгэнэ:

Үйлдлийн төрлүүд:
append s — Тэмдэгт мөр s-ийг одоо байгаа мөрийн төгсгөлд нэмнэ.
delete k — Одоо байгаа мөрийн төгсгөлийн k ширхэг тэмдэгтийг устгана.
print k — Одоо байгаа мөрийн k-дахь (1-ээс эхэлдэг) тэмдэгтийг хэвлэнэ.
undo — Өмнө нь хийсэн хамгийн сүүлийн (буюу өмнө нь "болих" хийгдээгүй) append эсвэл delete үйлдлийг буцааж, тухайн үеийн байдалд сэргээнэ.

Жишээ
index	Mөрийн утга	 Үйлдэл	Тайлбар
0	    abcde	     1 fg	fg-г нэмнэ
1	    abcdefg      3 6	6 дахь үсэг — f
2	    abcdefg	     2 5	Сүүлийн 5 үсгийг устгана
3	    ab	         4	    Сүүлчийн үйлдлийг болино
4	    abcdefg	     3 7	7 дахь үсэг — g
5	    abcdefg	     4	    Үйлдэл 0-ийг болино
6	    abcde	     3 4	4 дэх үсэг — d

Хэвлэгдэх үр дүн:
f  
g  
d
Оролтын формат:
Эхний мөрөнд Q — нийт үйлдлийн тоо.
Дараагийн Q мөрөнд тус бүрийн үйлдлийг оруулна.
Хэрэв 1 буюу append бол "1 s" — тэмдэгт мөр.
Хэрэв 2 буюу delete бол "2 k" — устгах тэмдэгтийн тоо.
Хэрэв 3 буюу print бол "3 k" — хэвлэх индекс.
Хэрэв 4 буюу undo бол "4" л байна.
Хязгаарлалт:
Бүх оролт зөв байна.
Оролтод орсон бүх тэмдэгтүүд жижиг латин үсэг байна.
s-ийн нийт урт нь 10⁶-аас хэтрэхгүй.
delete-д заагдсан нийт тэмдэгтийн тоо 10⁶-аас ихгүй.
Жишээ оролт:
8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1
Жишээ гаралт:
c  
y  
a