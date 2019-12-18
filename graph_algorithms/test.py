import random

from graph_algorithms.component import Component
from graph_algorithms.dense_graph import DenseGraph
from graph_algorithms.read_graph import ReadGraph
from graph_algorithms.sparse_graph import SparseGraph

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

g1 = ReadGraph(SparseGraph, filename1).g
c1 = Component(g1)
print(c1.count())

g2 = ReadGraph(DenseGraph, filename2).g
c2 = Component(g2)
print(c2.count())
