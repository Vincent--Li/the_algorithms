
import heapq

class LazyPrimMST:

    def __init__(self, graph):
        self.marked = []
        self.graph = graph
        self.mst = []
        self.mstWeight = 0
        self.pq = []

        for i in range(graph.V()):
            self.marked.append(False)

        # lazy prim
        self.visit(0)
        while len(self.pq) != 0:
            e = heapq.heappop(self.pq)
            if self.marked[e.v()] == self.marked[e.w()]:
                continue
            self.mst.append(e)
            if not self.marked[e.v()]:
                self.visit(e.v())
            else:
                self.visit(e.w())

        for edge in self.mst:
            self.mstWeight += edge.wt()

    def mstEdges(self):
        return self.mst

    def result(self):
        return self.mstWeight

    def visit(self, v):
        assert(not self.marked[v])
        self.marked[v] = True

        adj = self.graph.adjIterator(self.graph, v)
        e = adj.begin()
        while not adj.end():
            if not self.marked[e.other(v)]:
                heapq.heappush(self.pq, e)
            i = adj.next()

