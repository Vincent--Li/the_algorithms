
class Path:
    """
    深度优先遍历算法, 有向图也适用
    TODO: 查看图从是否有环
    """

    def __init__(self, graph, s):
        assert( 0 <= s < graph.V())
        self.visited = []
        self.from_list = []
        self.graph = graph

        for i in range(graph.V()):
            self.visited.append(False)
            self.from_list.append(-1)

        self.s = s
        self.__dfs__(s)


    def __dfs__(self, v):
        self.visited[v] = True

        adj = self.graph.adjIterator(self.graph, v)
        i = adj.begin()
        while not adj.end():
            if not self.visited[i]:
                self.from_list[i] = v
                self.__dfs__(i)
            i = adj.next()


    def has_path(self, w):
        assert(0 <= w < self.graph.V())
        return self.visited[w]


    def path(self, w, path_list):

        p = w
        while p!= -1 :
            path_list.append(p)
            p = self.from_list[p]

        path_list.reverse()



    def show_path(self, w):
        path_list = []
        self.path(w, path_list)
        print(path_list)