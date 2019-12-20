import random

from graph_algorithms.component import Component
from graph_algorithms.dense_graph_weighted import DenseGraph
from graph_algorithms.path import Path
from graph_algorithms.read_graph import ReadGraph
from graph_algorithms.shortest_path import ShortestPath
from graph_algorithms.sparse_graph_weight import SparseGraph

# N = 20
# M = 100
#
# print("========== sparse graph ===========")
# g1 = SparseGraph(N, False)
# for i in range(M):
#     a = random.randint(0, 100000)%N
#     b = random.randint(0, 100000)%N
#     g1.add_edge(a, b)
#
# # O(E): 数据量大的话, 有优势
# for v in range(N):
#     print(v, end=": ")
#     adj = SparseGraph.adjIterator(g1, v)
#
#     w = adj.begin()
#     while not adj.end():
#         print(w, end=" ")
#         w = adj.next()
#     print("")
#
# print("========== dense graph ===========")
# g2 = DenseGraph(N, False)
# for i in range(M):
#     a = random.randint(0, 100000)%N
#     b = random.randint(0, 100000)%N
#     g2.add_edge(a, b)
#
# # O(V^2)
# for v in range(N):
#     print(v, end=": ")
#     adj = DenseGraph.adjIterator(g2, v)
#
#     w = adj.begin()
#     while not adj.end():
#         print(w, end=" ")
#         w = adj.next()
#     print("")

filename1 = 'testG1.txt'
filename2 = 'testG2.txt'

# g1 = ReadGraph(SparseGraph, filename1).g
# c1 = Component(g1)
# g1.show()

# 最短路径
# g2 = ReadGraph(DenseGraph, filename2).g
# c2 = Component(g2)
# # g2.show()
#
# p2 = Path(g2,0)
# p2.show_path(6)
#
# p3 = ShortestPath(g2, 0)
# p3.show_path(6)

# 带权图
dgw1 = ReadGraph(DenseGraph, filename1).g
dgw1.show()

sgw = ReadGraph(SparseGraph, filename1).g
sgw.show()