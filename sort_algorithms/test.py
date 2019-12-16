import time
import random

from sort_algorithms.max_heap import heap_sort_1, heap_sort_2, heap_sort, print_heap
from sort_algorithms.selection_sort import mergeSort, quickSort


def random_int_list(start, stop, length):
  start, stop = (int(start), int(stop)) if start <= stop else (int(stop), int(start))
  length = int(abs(length)) if length else 0
  random_list = []
  for i in range(length):
    random_list.append(random.randint(start, stop))
  return random_list


def testSort(sort_method, arr):
    start_time =time.time() * 1000
    result = sort_method(arr, len(arr))
    end_time = time.time() * 1000
    c = end_time - start_time
    # print(result)
    print(str(c) + ' ms' )


# testSort(selectionSort, random_int_list(1, 10000000, 100000))
# testSort(insertionSort, random_int_list(1, 10000000, 100000))
# testSort(mergeSort, random_int_list(1, 10000000, 100000))
# testSort(quickSort, random_int_list(1, 10000000, 100000))
testSort(heap_sort_1, random_int_list(1, 10000000, 100000))
testSort(heap_sort_2, random_int_list(1, 10000000, 100000))
testSort(heap_sort, random_int_list(1, 10000000, 100000))
# test_list = random_int_list(1, 1000, 10)
# print(test_list)
# heap_sort(test_list, 10)
# print(test_list)