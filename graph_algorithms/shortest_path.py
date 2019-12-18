

class ShortestPath:

    def __init__(self, graph, s):

        assert(0 <= s < graph.V())

        self.visited = []
        self.from_list = []
        self.old = []
        self.graph = graph
        for i in range(graph.V()):
            self.visited.append(False)
            self.from_list.append(-1)
            self.old.append(-1)
        self.s = s

        q = []

        