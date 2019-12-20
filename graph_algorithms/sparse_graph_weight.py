from graph_algorithms.edge import Edge


class SparseGraph:

    def __init__(self, n, directed):
        self.n = n
        self.directed = directed
        self.m = 0
        self.g = []
        for i in range(n):
            self.g.append([])

    def V(self):
        return self.n

    def E(self):
        return self.m

    def has_edge(self, v, w):
        assert (0 <= v < self.n)
        assert (0 <= w < self.n)
        for i in range(len(self.g[v])):
            if self.g[v][i].other(v) == w:
                return True
        return False

    def add_edge(self, v, w, weight):
        assert (0 <= v < self.n)
        assert (0 <= w < self.n)

        # 邻接表判断是否有平行边的问题, 成本较高, 所以此处先忽略
        # 通常等到所有边都加入图之后, 再全局的处理一次平行边的问题
        self.g[v].append(Edge(v, w, weight))
        if  v!=w and not self.directed:
            self.g[w].append(Edge(w, v, weight))

        self.m += 1

    def show(self):
        for i in range(self.n):
            print("vertex ", i, end=": |")
            for j in range(len(self.g[i])):
                print("to: ", self.g[i][j].w(), ", wt:", self.g[i][j].wt(), end="| ")
            print("")



    class adjIterator:

        def __init__(self, graph, v):
            self.v = v
            self.index = 0
            self.graph = graph

        def begin(self):
            self.index = 0
            if len(self.graph.g[self.v]) > 0:
                return self.graph.g[self.v][0]
            return None

        def next(self):
            self.index +=1
            if self.index < len(self.graph.g[self.v]):
                return self.graph.g[self.v][self.index]
            return None

        def end(self):
            return self.index >= len(self.graph.g[self.v])

