
# 二分查找法
def binarySearch(arr, n, target):
    # 在arr[l...r]查找target
    l = 0
    r = n - 1
    while(l <= r):
        mid = ( r - l ) //2 + l
        if arr[mid] == target:
            return mid
        if target < arr[mid]:
            r = mid - 1
        else:
            l = mid + 1
    return -1

print(binarySearch([1,2,3,4,5,6], 6, 9))