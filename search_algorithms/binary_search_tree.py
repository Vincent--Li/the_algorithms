
class Node:
    def __init__(self, key, value):
        self.value = value
        self.key = key
        self.left = None
        self.right = None

    def copy_node(self):
        node = Node()
        node.key = self.key
        node.value = self.value
        node.left = self.left
        node.right = self.right
        return node

class BST:
    def __init__(self):
        self.root = None
        self.count = 0

    def size(self):
        return self.count

    def isEmpty(self):
        return self.count == 0

    def insert(self, key, value):
        self.root = self.__insert__(self.root, key, value)

    def __insert__(self, node, key, value):
        '''
        以node为根的二叉搜索树中, 插入节点(key, value) 返回插入新节点后的二叉树的根
        :param node:
        :param key:
        :param value:
        :return:
        '''
        if node is None:
            self.count += 1
            return Node(key, value)

        if key == node.key:
            node.value = value
        elif key < node.key:
            node.left = self.__insert__(node.left, key, value)
        else:
            node.right = self.__insert__(node.right, key, value)
        return node

    def contain(self, key):
        return self.__contain__(self.root, key)

    def __contain__(self, node, key):
        if node is None:
            return False
        if node.key == key:
            return True
        elif key < node.key:
            return self.__contain__(node.left, key)
        else:
            return self.__contain__(node.right, key)

    def search(self, key):
        return self.__search__(self.root, key)

    def __search__(self, node, key):
        if node is None:
            return None
        if key == node.key:
            return node.value
        elif key < node.key:
            return self.__search__(node.left, key)
        else:
            return self.__search__(node.right, key)

    def print(self):
        self.__print__(self.root)

    def __print__(self, node):
        if node is not None:
            print(node.key)
            if node.left is not None:
                self.__print__(node.left)
            if node.right is not None:
                self.__print__(node.right)

    def pre_order(self):
        self.__pre_order_(self.root)

    def __pre_order_(self, node):
        if node is not None:
            print(node.key)
            self.__pre_order_(node.left)
            self.__pre_order_(node.right)

    def in_order(self):
        self.__in_order__(self.root)

    def __in_order__(self, node):
        if node is not None:
            self.__in_order__(node.left)
            print(node.key)
            self.__in_order__(node.right)

    def post_order(self):
        self.__post_order__(self.root)

    def __post_order__(self, node):
        if node is not None:
            self.__post_order__(node.left)
            self.__post_order__(node.right)
            print(node.key)

    def level_order(self):
        queue = []
        if self.root is not None:
            queue.append(self.root)
            while len(queue) != 0:
                node = queue.pop(0)
                print(node.key)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)

    def minium(self):
        assert(self.count !=0)
        min_node = self.__minium__(self.root)
        return min_node

    def __minium__(self, node):
        if node.left is None :
            return node
        else:
            return self.__minium__(node.left)

    def maximum(self):
        assert(self.count != 0)
        max_node = self.__maximum__(self.root)
        return max_node

    def __maximum__(self, node):
        if node.right is None:
            return node
        else:
            return self.__maximum__(node.right)

    def remove_min(self):
        if self.root is not None:
            root = self.__remove_min__(self.root)

    def __remove_min__(self,  node):
        if node.left is None:
            right_node = node.right
            self.count -=1
            return right_node
        node.left = self.__remove_min__(node.left)
        return node

    def remove_max(self):
        if self.root is not None:
            root = self.__remove_max__(self.root)

    def __remove_max__(self,  node):
        if node.right is None:
            left_node = node.left
            self.count -=1
            return left_node
        node.right = self.__remove_max__(node.right)
        return node

    def remove(self, key):
        '''
        TODO: 删除任一节点: hibbard deletion:  删除的节点用右子树的最小值(或左子树的最大值)替代删除的节点 s = min(d->right)
        O(logn)
        :param key:
        :return:
        '''
        root = self.__remove__(self.root , key)

    def __remove__(self, node, key):
        if node is None:
             return None
        if key < node.key:
            node.left = self.__remove__(node.left, key)
            return node
        elif key > node.key:
            node.right = self.__remove__(node.right, key)
            return node
        else:
            if node.left is None:
                right_node = node.right
                self.count -= 1
                return right_node
            if node .right is None:
                left_node = node.left
                self.count -=1
                return left_node

            successor = self.minium(node.right).copy_node()
            self.count += 1
            successor.right = self.remove_min(node.right)
            successor.left = node.left
            del node
            self.count -= 1
            return successor

# TODO: predecessor/successor floor/ceil rank select 支持重复元素的二分搜索树
# TODO: 平衡二叉树的实现之 红黑树 / 2-3 tree / AVL tree / Splay tree / Treap(平衡二叉树+堆)
# TODO: trie

tree = BST()
tree.insert(2, 2)
tree.insert(1, 1)
tree.insert(3, 3)
tree.insert(100,100)
tree.insert(90, 90)
tree.insert(12, 12)
print('=====')
tree.pre_order()
print('=====')
tree.in_order()
print('=====')
tree.post_order()
print('=====')
tree.level_order()
print('====')
print(tree.minium().value)
print('=====')
print(tree.maximum().value)



