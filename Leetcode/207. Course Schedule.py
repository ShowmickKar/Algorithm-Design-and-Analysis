# Problem Link: https://leetcode.com/problems/course-schedule/

class Graph:
    def __init__(self, v):
        self.vertices = v
        self.adj = [[] for i in range(v)]
        
    def addEdge(self, u, v):
        self.adj[u].append(v)
        
    def dfs(self, stack, v, visited):
        visited[v] = True
        for x in self.adj[v]:
            if not visited[x]:
                self.dfs(stack, x, visited)
        stack.append(v)
        
    def topologicalSort(self):
        visited = [False for i in range(self.vertices)]
        stack = []
        for v in range(self.vertices):
            if not visited[v]:
                self.dfs(stack, v, visited)
        return stack[::-1]
    
        
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        hashTable = {}
        graph = Graph(numCourses)
        for i in range(len(prerequisites)):
            graph.addEdge(prerequisites[i][0], prerequisites[i][1])
        stack = graph.topologicalSort()
        for i in range(len(stack)):
            hashTable[stack[i]] = i
        for i in range(len(prerequisites)):
            if hashTable[prerequisites[i][0]] > hashTable[prerequisites[i][1]]:
                return False
        return True                 
