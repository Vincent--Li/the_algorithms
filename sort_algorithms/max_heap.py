import random
import math

class MaxHeap:
    '''
    假设data的索引从1开始, parent_index = i/2, 左子节点 left_index = i * 2, right_index = i * 2 + 1
    '''
    def __init__(self,  arr=[]):
        self.data = []
        self.data.append(0)
        self.count = 0

        if arr != None and len(arr) != 0:
            for i in range(len(arr)):
                self.data.append(arr[i])
            self.count = len(arr)
            for i in range(self.count//2, 0, -1):
                self.__shift_down__(i)



    def size(self):
        return self.count;

    def isEmpty(self):
        return self.count == 0

    def   insert(self, item):
        self.data.append(item)
        self.count += 1
        self.__shift_up__(self.count)

    def __shift_up__(self, k):
        while k > 1 and self.data[k] > self.data[k//2]:
            self.data[k], self.data[k//2] = self.data[k//2], self.data[k]
            k //= 2

    def extract_max(self):
        assert( self.count > 0)

        # 交换最后一个元素和最后一个元素
        result = self.data[1]
        self.data[self.count], self.data[1] = self.data[1], self.data[self.count]
        self.count -= 1

        self.__shift_down__(1)

        return result

    def __shift_down__(self, k):
        # 两个孩子节点, 谁大和谁换.
        # 完全二叉树中, 只要有左孩子, 就可以; 不可能只有右孩子没有左孩子
        while 2*k <= self.count :
            j = 2 * k # j 先默认设置为左孩子, 其含义是待交换的节点index
            if j + 1 <= self.count and self.data[j + 1] > self.data[j]:
                j += 1 # 如果有右孩子,  且两个孩子中右孩子较大
            if self.data[k] > self.data[j]: # 当前需要交换的节点, 比两个孩子都大, 就停止
                break
            self.data[k], self.data[j] = self.data[j] , self.data[k]
            k = j

def print_heap(heap):
    for i in range(1, math.ceil(math.log(heap.count, 2)) + 1):
        temp_arr = []
        for j in heap.data[int(math.pow(2, i - 1)):int(math.pow(2, i))]:
            temp_arr.append(j)
        print((math.ceil(math.log(heap.count, 2)) + 1 - i) * 2  * ' ', end='')
        for item in temp_arr:
            print(item, end='  ')
        print('\n')

# 基于堆的排序算法
def heap_sort_1(arr, n):
    max_heap = MaxHeap()
    for i in range(n):
        max_heap.insert(arr[i])

    tmp_arr = []
    for i in range(n, 0,-1):
        tmp_arr.append( max_heap.extract_max())

def heap_sort_2(arr, n):
    max_heap = MaxHeap(arr)
    tmp_arr = []
    for i in range(n, 0, -1):
        tmp_arr.append(max_heap.extract_max())


def _shift_down(data, n, k):
    # 两个孩子节点, 谁大和谁换.
    # 完全二叉树中, 只要有左孩子, 就可以; 不可能只有右孩子没有左孩子
    while 2 * k  + 1 < n:
        j = 2 * k  + 1 # j 先默认设置为左孩子, 其含义是待交换的节点index
        # print(n,j,k)
        if j + 1 < n and data[j + 1] > data[j]:
            j += 1  # 如果有右孩子,  且两个孩子中右孩子较大

        if data[k] > data[j]:  # 当前需要交换的节点, 比两个孩子都大, 就停止
            break
        data[k], data[j] = data[j], data[k]
        k = j


def heap_sort(arr, n):
    # heapify这一步, 不需要调用, 直接在arr上使用shift_down完成, 此处暂时这样写, 需要替换掉
    for i in range((n-1)//2, -1, -1):
        # print(i)
        _shift_down(arr, n, i)

    # 原地堆排序
    for i in range(n-1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        _shift_down(arr, i, 0)


# 测试
## 测试插入
# temp_heap  = MaxHeap()
# for item in random_int_list(5, 90, 20):
#     temp_heap.insert(item)

## 测试取最大值
# while not temp_heap.isEmpty():
#     print_heap(temp_heap)
#     print('count is: ', temp_heap.count , ' max is: ',temp_heap.extract_max())

## 测试排序算法
# heap_sort_1(random_int_list(5, 1000, 20), 20)

