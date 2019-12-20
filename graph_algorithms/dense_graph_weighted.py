from graph_algorithms.edge import Edge


class DenseGraph:

    def __init__(self,n , directed):
        self.n = n
        self.m = 0
        self.directed = directed
        self.g = []
        for i in range(n):
            self.g.append([])
            for j in range(n):
                self.g[i].append(None)

    def V(self):
        return self.n

    def E(self):
        return self.m

    def has_edge(self, v, w):
        assert (0 <= v < self.n)
        assert (0 <= w < self.n)
        return self.g[v][w] is not None

    def add_edge(self, v, w,  weight):
        assert(0 <= v < self.n)
        assert(0 <= w < self.n)

        # 这句话将平行边也去掉了
        if self.has_edge(v, w):
            del self.g[v][w]
            if not self.directed:
                del self.g[w][v]
            self.m -=1


        self.g[v][w] = Edge(v,w, weight)
        if not self.directed:
            self.g[w][v] = Edge(w,v , weight)
        self.m += 1

    def show(self):
        for i in range(self.n):
            for j in range(self.n):
                if self.g[i][j] is not None:
                    print(self.g[i][j].wt(),  end=" ")
                else:
                    print('None', end=" ")
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
                if self.graph.g[self.v][self.index] is not None:
                    return self.graph.g[self.v][self.index]
                self.index += 1
            return None

        def end(self):
            return self.index >= len(self.graph.g[self.v])

