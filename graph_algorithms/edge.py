

class Edge:


    def __init__(self, a, b, weight):
        self.a = a
        self.b = b
        self.weight = weight

    def v(self):
        return self.a

    def w(self):
        return self.b

    def wt(self):
        return self.weight

    def other(self, x):
        return self.a if x != self.a else self.b

