# min average time

---Асуулт---"english" :
Tieu owns a pizza restaurant and he manages it in his own way. While in a normal restaurant, a customer is served by following the first-come, first-served rule, Tieu simply minimizes the average waiting time of his customers. So he gets to decide who is served first, regardless of how sooner or later a person comes.

Different kinds of pizzas take different amounts of time to cook. Also, once he starts cooking a pizza, he cannot cook another pizza until the first pizza is completely cooked. Let's say we have three customers who come at time t=0, t=1, & t=2 respectively, and the time needed to cook their pizzas is 3, 9, & 6 respectively. If Tieu applies first-come, first-served rule, then the waiting time of three customers is 3, 11, & 16 respectively. The average waiting time in this case is (3 + 11 + 16) / 3 = 10. This is not an optimized solution. After serving the first customer at time t=3, Tieu can choose to serve the third customer. In that case, the waiting time will be 3, 7, & 17 respectively. Hence the average waiting time is (3 + 7 + 17) / 3 = 9.

Help Tieu achieve the minimum average waiting time. For the sake of simplicity, just find the integer part of the minimum average waiting time.

Input Format

The first line contains an integer N, which is the number of customers.
In the next N lines, the ith line contains two space separated numbers Ti and Li. Ti is the time when ith customer order a pizza, and Li is the time required to cook that pizza.

The  customer is not the customer arriving at the  arrival time.

Output Format

Display the integer part of the minimum average waiting time.
Constraints

1 ≤ N ≤ 105
0 ≤ Ti ≤ 109
1 ≤ Li ≤ 109
Note

The waiting time is calculated as the difference between the time a customer orders pizza (the time at which they enter the shop) and the time she is served.

Cook does not know about the future orders.

Sample Input #00

3
0 3
1 9
2 6
Sample Output #00

9
Sample Input #01

3
0 3
1 9
2 5
Sample Output #01

8
Explanation #01

Let's call the person ordering at time = 0 as A, time = 1 as B and time = 2 as C. By delivering pizza for A, C and B we get the minimum average wait time to be

(3 + 6 + 16)/3 = 25/3 = 8.33 

---Асуулт---"Монголоор" :
Tieu пиццаны ресторан ажиллуулдаг бөгөөд тэрээр үүнийг өөрийнхөөрөө удирддаг.
Хэвийн рестораны хувьд үйлчлүүлэгчдийг ирсэн дарааллаар нь үйлчилдэг бол, Tieu үйлчлүүлэгчдийн дундаж хүлээлгийн хугацааг багасгахыг зорьдог. Тиймээс хэн түрүүлж ирсэн нь хамаагүй, хэн түрүүлж үйлчлүүлэхээ Tieu өөрөө шийддэг.

Янз бүрийн төрлийн пицца хийхэд янз бүрийн хугацаа шаардагддаг. Мөн нэг пиццаг хийж эхэлсний дараа, тэр пицца бүрэн бэлэн болтол өөр пицца хийх боломжгүй. Жишээлбэл, гурван үйлчлүүлэгч t = 0, t = 1, t = 2 үед ирдэг гэж үзье. Тэдний пицца хийх хугацаа нь тус бүртээ 3, 9, 6 минут байна. Хэрвээ Tieu ирсэн дарааллаар үйлчилбэл, үйлчлүүлэгчдийн хүлээлгийн хугацаа нь 3, 11, 16 минут болно. Энэ тохиолдолд дундаж хүлээлгийн хугацаа нь (3 + 11 + 16) / 3 = 10 минут болно. Гэхдээ энэ нь хамгийн оновчтой шийдэл биш. Эхний үйлчлүүлэгчийг t = 3 үед дуусгасны дараа Tieu гурав дахь үйлчлүүлэгчид үйлчилбэл, тэдний хүлээлгийн хугацаа нь 3, 7, 17 минут болно. Ингэснээр дундаж хүлээлгийн хугацаа нь (3 + 7 + 17) / 3 = 9 минут болно.

Tieu-д үйлчлүүлэгчдийн дундаж хүлээлгийн хугацааг хамгийн бага байлгахад нь туслаарай. Хялбар болгохын тулд дундаж хугацааны зөвхөн бүхэл хэсгийг ол.

Оролтын формат:
Эхний мөрөнд N бүхэл тоо өгөгдөнө — үйлчлүүлэгчдийн тоо.
Дараагийн N мөр бүрт хоёр бүхэл тоо өгөгдөнө:

Ti — i дахь үйлчлүүлэгчийн захиалга өгсөн цаг

Li — тухайн пиццаны хийгдэх хугацаа

Жич: i дахь мөр дээр байгаа үйлчлүүлэгч нь Ti хугацаанд ирсэн үйлчлүүлэгчтэй заавал таарах албагүй.

Гаралтын формат:
Хүлээлгийн дундаж хугацааны бүхэл хэсгийг хэвлэ.


Жишээ оролт #00:
3
0 3
1 9
2 6
Жишээ гаралт #00:
9
Жишээ оролт #01:
3
0 3
1 9
2 5
Жишээ гаралт #01:
8
Тайлбар #01:
0 үед захиалсан үйлчлүүлэгчийг A,
1 үед захиалсан үйлчлүүлэгчийг B,
2 үед захиалсан үйлчлэгчийг C гэж нэрлэе.
Хэрвээ A → C → B дарааллаар үйлчилбэл хүлээлгийн хугацаа нь:

A: 3 минут

C: 6 минут (тэр 2-р минут ирсэн ч 3-аас эхэлж 5 минут хүлээнэ → 3+5 = 8 → 8 − 2 = 6)

B: 16 минут
Ингээд дундаж нь (3 + 6 + 16) / 3 = 8.33 бөгөөд бүхэл хэсэг нь 8 болно.
---Код---"PYTHON3"
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumAverage' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY customers as parameter.
#
import heapq

def minimumAverage(customers):
    customers.sort()
    n = len(customers)
    i = 0
    current_time = 0
    waiting_time = 0
    h = []

    while i < n or h:
        # Add all custoemrs with arrival time less or equal to current time so that no customer that arrives later is processed, as that is not valid.
        while i < n and customers[i][0] <= current_time:
            heapq.heappush(h, (customers[i][1], customers[i][0]))
            i += 1

        # From the clients whose arrival time is less than the current time, extract the one whose pizza has the least preparation time.
        if h:
            prep_time, arrival_time = heapq.heappop(h)
            current_time += prep_time
            waiting_time += current_time - arrival_time

        # In case there are no customers to process, move to next customer. :)
        else:
            current_time = customers[i][0]

    return waiting_time // n
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    customers = []

    for _ in range(n):
        customers.append(list(map(int, input().rstrip().split())))

    result = minimumAverage(customers)

    fptr.write(str(result) + '\n')

    fptr.close()


---Тайлбар--- ![image](https://github.com/user-attachments/assets/0f7ada5b-3efa-454b-adaf-5a97dd33d53b)

