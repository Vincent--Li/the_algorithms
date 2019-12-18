# 将每个元素, 看做一个节点

# quick union 实现方式

class UnionFind2:

    def __init__(self, n):
        self.parent = []
        self.count = n
        for i in range(n):
            self.parent.append(i)

    def find(self, p):
        """
        quick find
        :return:
        """
        assert(0 <= p < self.count)
        while p!= self.parent[p]:
            p = self.parent[p]
        return p

    def is_connected(self, p, q):
        return self.find(p) == self.find(q)


    def union_elements(self, p, q):
        """
        优化点1: 合并的过程中, 不应该固定的将前面的节点指向后面的节点.
            应该开辟一个值存储当前节点下的元素个数,
            然后合并的时候判断, 将元素少的集合, 指向元素多的集合的根节点
            详细见impl3
        :param p:
        :param q:
        :return:
        """
        p_root = self.find(p)
        q_root = self.find(q)
        if p_root == q_root:
            return
        self.parent[p_root] = q_root

