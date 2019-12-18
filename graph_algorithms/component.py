

class Component :

    def __init__(self, graph):
        self.graph = graph
        self.visited = []
        self.id = []
        # 记录有多少个连通分量
        self.ccount = 0
        for i in range(graph.V()):
            self.visited.append(False)
            # 连通的节点
            self.id.append(-1)

        for i in range(graph.V()):
            if not self.visited[i]:
                self.__dfs__(i)
                self.ccount+=1
                # print(self.ccount)

    def count(self):
        return self.ccount

    def __dfs__(self, v):
        self.visited[v] = True
        self.id[v] = self.ccount
        adj = self.graph.adjIterator(self.graph, v)
        i = adj.begin()
        while not adj.end():
            if not self.visited[i]:
                self.__dfs__(i)
            i = adj.next()

    def is_connected(self, v, w):
        return self.id[v] == self.id[w]

    