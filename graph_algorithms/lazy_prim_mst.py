
class LazyPrimMST:

    def __init__(self, graph, priority_queue):
        self.marked = []
        self.graph = graph
        self.mst = []
        self.mstWeight = 0

        for i in range(graph.V()):
            self.marked.append(False)

        # lazy prim
        

    def mstEdges(self):
        return self.mst

    def result(self):
        return self.mstWeight