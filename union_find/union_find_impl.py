

class UnionFind:

    def __init__(self, n):
        self.id = []
        self.count = n
        for i in range(n):
            self.id.append(i)

    def find(self, p):
        """
        quick find
        :return:
        """
        assert(0 <= p < self.count)
        return self.id[p]

    def union_elements(self, p, q):
        pId = self.find(p)
        qId = self.find(q)

        if pId == qId:
            return

        for i in range(self.count):
            if self.id[i] == pId:
                self.id[i] = qId