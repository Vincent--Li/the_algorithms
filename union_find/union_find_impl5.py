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
        优化点3: 路径压缩 Path Compression,
        find的时候, 如果当前节点不是根节点, 将当前节点连接到父亲的父亲(两步一跳)
         用以压缩数据
        :return:
        """
        assert(0 <= p < self.count)
        # 一种路径压缩
        # while p!= self.parent[p]:
            # 路径压缩最关键的一句
            # self.parent[p] = self.parent[self.parent[p]]
            # p = self.parent[p]

        # 另一种路径压缩, 使用递归过程
        if p != self.parent[p]:
            self.parent[p] = self.find(self.parent[p])

        return self.parent[p]

    def is_connected(self, p, q):
        return self.find(p) == self.find(q)


    def union_elements(self, p, q):
        """
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