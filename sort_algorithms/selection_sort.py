import time
import random

def random_int_list(start, stop, length):
  start, stop = (int(start), int(stop)) if start <= stop else (int(stop), int(start))
  length = int(abs(length)) if length else 0
  random_list = []
  for i in range(length):
    random_list.append(random.randint(start, stop))
  return random_list


def selectionSort(arr, n):
    for i in range(0, n):
        # [i, n] 闭区间中最小的元素做交换
        min_index = i;
        for j in range(i + 1, n):
            if arr[j] <  arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]

def insertionSort(arr, n):
    # 特点 会提前终止
    # [1, n-1] 区间内, 向前依次比较, 直到停止
    for i in range(1, n):
        temp_value = arr[i]
        for j in range(i, 0, -1):
            if arr[j] < arr[j - 1]:
                arr[j] =   arr[j - 1]
            else:
                arr[j] = temp_value
                break

def mergeSort(arr, n):
    if len(arr) <=1:
        return arr

    mid = int(n / 2)

    left = mergeSort(arr[:mid], len(arr[:mid]))
    right = mergeSort(arr[mid:], len(arr[mid:]))

    # 优化点1: 不是所有情况都需要merge的
    if  left[-1] > right[0]:
        return merge(left, right)
    else:
        left += right
        return left
    # 优化点2: n值很小的时候, 插入排序的算法效率高
    # return merge(left, right)

def merge(left, right):
    result = []
    i ,j = 0, 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result += left[i:]
    result += right[j:]
    return result


def quickSort(arr, n):
    l, j, i  =  0, 0, 0

    for k in range(1, n):
        if arr[l] ==  arr[k]:
            l += 1
            arr[i] = arr[j]
            arr[j] = arr[l]
            arr[l] = arr[k]
        elif arr[k] > arr[l]:
            i += 1
        else:
            arr[i] , arr[j] = arr[j], arr[i]
            j +=1
            i+=1
    quickSort(arr[l+1:j])

def testSort(sort_method, arr):
    start_time =time.time() * 1000
    result = sort_method(arr, len(arr))
    end_time = time.time() * 1000
    c = end_time - start_time
    # print(result)
    print(str(c) + ' ms' )

# testSort(selectionSort, random_int_list(1, 10000000, 100000))
# testSort(insertionSort, random_int_list(1, 10000000, 100000))
testSort(mergeSort, random_int_list(1, 10000000, 100000))
