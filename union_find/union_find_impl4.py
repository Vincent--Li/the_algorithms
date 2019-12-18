# 将每个元素, 看做一个节点

# quick union 实现方式

class UnionFind4:

    def __init__(self, n):
        self.parent = []
        self.rank = []
        self.count = n
        for i in range(n):
            self.parent.append(i)
            self.rank.append(1)

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
        优化点2: 单纯基于元素的个数判断, 仍然会有问题, 应该基于从根节点
            开始构成的树的深度, 这就是基于rank的优化, rank[i]表示根节点为i的树的高度
        优化点3: 路径压缩 Path Compression, find的时候, 将路径向上提详见 impl5
        :param p:
        :param q:
        :return:
        """
        p_root = self.find(p)
        q_root = self.find(q)
        if p_root == q_root:
            return
        if self.rank[p_root] < self.rank[q_root]:
            self.parent[p_root] = q_root
        elif self.rank[p_root] > self.rank[q_root]:
            self.parent[q_root] = p_root
        else:
            self.parent[p_root] = q_root
            self.rank[q_root] += 1