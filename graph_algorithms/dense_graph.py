
class DenseGraph:

    def __init__(self,n , directed):
        self.n = n
        self.m = 0
        self.directed = directed
        self.g = []
        for i in range(n):
            self.g.append([])
            for j in range(n):
                self.g[i].append(False)

    def V(self):
        return self.n

    def E(self):
        return self.m

    def has_edge(self, v, w):
        assert (0 <= v < self.n)
        assert (0 <= w < self.n)
        return self.g[v][w]

    def add_edge(self, v, w):
        assert(0 <= v < self.n)
        assert(0 <= w < self.n)

        # 这句话将平行边也去掉了
        if self.has_edge(v, w):
            return

        self.g[v][w] = True
        if not self.directed:
            self.g[w][v] = True
        self.m += 1

    def show(self):
        for i in range(self.n):
            for j in range(self.n):
                print(self.g[i][j], end=" ")
            print("")

    class adjIterator:

        def __init__(self, graph, v):
            self.v = v
            self.index = -1
            self.graph = graph

        def begin(self):
            self.index = -1
            return self.next()

        def next(self):
            self.index +=1
            # print(self.index, self.graph.V())
            while self.index < self.graph.V():
                if self.graph.g[self.v][self.index]:
                    return self.index
                self.index +=1
            return -1

        def end(self):
            return self.index >= len(self.graph.g[self.v])

