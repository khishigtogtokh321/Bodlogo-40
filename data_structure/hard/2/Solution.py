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
