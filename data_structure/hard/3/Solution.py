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

