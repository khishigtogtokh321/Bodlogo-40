# truck-tour

---Асуулт---"english" :
Suppose there is a circle. There are  petrol pumps on that circle. Petrol pumps are numbered  to  (both inclusive). You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give, and (2) the distance from that petrol pump to the next petrol pump.

Initially, you have a tank of infinite capacity carrying no petrol. You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle. Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each litre of the petrol.

Input Format

The first line will contain the value of .
The next  lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol pump and the next petrol pump.

Constraints:


Output Format

An integer which will be the smallest index of the petrol pump from which we can start the tour.

Sample Input

3
1 5
10 3
3 4
Sample Output

1
Explanation

We can start the tour from the second petrol pump.

---Асуулт---"Монголоор" :
Гэрлэн тойрог байна гэж төсөөлье. Тэр тойрог дээр шатахуун түгээх станцууд байрлана. Шатахуун түгээх станцуудыг 0-аас n-1 хүртэл дугаарласан байдаг (хоёуланг нь оролцуулна). Шатахуун түгээх станц бүрийн хувьд танд хоёр төрлийн мэдээлэл байна: (1) тухайн шатахуун түгээх станц хэр хэмжээний шатахуун өгч чадах вэ, (2) тэр станцаас дараагийн станц хүртэлх зай. Эхэндээ таньд хязгааргүй багтаамжтай, гэхдээ шатахуунгүй сав байгаа. Та аяллаа аль ч шатахуун түгээх станцаас эхлүүлж болно. Ачааны машин тойргийг бүрэн тойрон явах боломжтой хамгийн эхний цэгийг ол. Ачааны машин шатахуун түгээх станц бүр дээр зогсож явна гэж үзнэ. Ачааны машин шатахууны нэг литрт нэг километр явна. Эхний мөрөнд n-ийн утга өгөгдөнө. Дараагийн n мөр тус бүрт хоёр бүхэл тоо өгөгдөх ба, эхнийх нь тухайн станц хэр их шатахуун өгөхийг, хоёр дахь нь дараагийн станц хүртэлх зайг илэрхийлнэ. Аяллаа эхэлж болох хамгийн бага дугаартай шатахуун түгээх станцын индексийг хэвлэнэ. Бид аяллаа хоёр дахь шатахуун түгээх станцаас эхлүүлж чадна.


---Код---" "
#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'truckTour' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
#

def truckTour(petrol_pumps):
    start_index = 0
    total_liters = 0
    total_distance = 0

    for i in range(len(petrol_pumps)):
        liters, distance = petrol_pumps[i]
        total_liters += liters
        total_distance += distance
        # Arriving to next petrol pump

        if total_liters - total_distance < 0:
            # Initialize start index before restarting in start index
            start_index = i + 1
            total_liters = 0
            total_distance = 0
    
    return start_index
 

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    petrolpumps = []

    for _ in range(n):
        petrolpumps.append(list(map(int, input().rstrip().split())))

    result = truckTour(petrolpumps)

    fptr.write(str(result) + '\n')

    fptr.close()

---Тайлбар
![truck tour](https://github.com/user-attachments/assets/a925d4dd-976d-4796-95ce-349d3d87dd25)
ар--- 
