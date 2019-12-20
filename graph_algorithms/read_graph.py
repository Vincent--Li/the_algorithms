

class ReadGraph :

    def __init__(self, graph, filename):

        file = open(filename, 'r')
        try:
            text_lines = file.readlines()
            V, E = text_lines[0].split(" ")
            V, E = int(V), int(E)
            self.g = graph(V, False)

            for i in range(int(E)):
                a, b, weight = text_lines[i+1].split(" ")
                a, b, weight = int(a), int(b), float(weight)
                assert( 0 <= a < V)
                assert( 0 <= b < V)
                self.g.add_edge(a, b, weight)
        finally:
            file.close()