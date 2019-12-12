import random
import math

class MaxHeap:
    '''
    假设data的索引从1开始, parent_index = i/2, 左子节点 left_index = i * 2, right_index = i * 2 + 1
    '''
    def __init__(self):
        self.data = []
        self.data.append(0)
        self.count = 0

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



def random_int_list(start, stop, length):
  start, stop = (int(start), int(stop)) if start <= stop else (int(stop), int(start))
  length = int(abs(length)) if length else 0
  random_list = []
  for i in range(length):
    random_list.append(random.randint(start, stop))
  return random_list


def print_heap(heap):
    '''
    工具方法
    :param arr:
    :return:
    '''
    for i in range(1, math.ceil(math.log(heap.count, 2)) + 1):
        temp_arr = []
        for j in heap.data[int(math.pow(2, i - 1)):int(math.pow(2, i))]:
            temp_arr.append(j)
        print((math.ceil(math.log(heap.count, 2)) + 1 - i) * 2  * ' ', end='')
        for item in temp_arr:
            print(item, end='  ')
        print('\n')


# 测试
temp_heap  = MaxHeap()
for item in random_int_list(5, 90, 20):
    temp_heap.insert(item)

while not temp_heap.isEmpty():
    print_heap(temp_heap)
    print('count is: ', temp_heap.count , ' max is: ',temp_heap.extract_max())