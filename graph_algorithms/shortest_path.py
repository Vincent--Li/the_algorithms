
# 广度优先遍历, 需要使用辅助队列(先进先出, 后进后出)
# 可以求出无权图的最短路径
# TODO: 如果有多条最短路径, 如何处理
class ShortestPath:

    def __init__(self, graph, s):

        assert(0 <= s < graph.V())

        self.visited = []
        self.from_list = []
        self.ord = []
        self.graph = graph
        for i in range(graph.V()):
            self.visited.append(False)
            self.from_list.append(-1)
            self.ord.append(-1)
        self.s = s

        q = []
        # 无向图最短路径算法
        q.append(s)
        self.visited[s] = True
        self.ord[s] = 0
        while len(q) > 0:
            v = q.pop(0)

            adj = graph.adjIterator(self.graph, v)
            i = adj.begin()
            while not adj.end():
                if not self.visited[i]:
                    q.append(i)
                    self.visited[i] = True
                    self.ord[i] = self.ord[v] + 1
                    self.from_list[i] = v
                i = adj.next()

    def has_path(self, w):
        assert(0 <= w < self.graph.V())
        return self.visited[w]

    def path(self, w, path_list):
        assert( 0 <= w < self.graph.V())

        p = w
        while p != -1:
            path_list.append(p)
            p = self.from_list[p]
        path_list.reverse()

    def show_path(self, w):
        path_list = []
        self.path(w, path_list)
        print(path_list)

    def length(self, w):
        assert( 0 <= w < self.graph.V())
        return self.ord[w]
