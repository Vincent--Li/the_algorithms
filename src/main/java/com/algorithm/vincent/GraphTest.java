package com.algorithm.vincent;

import java.util.HashMap;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class GraphTest {


    public static void main(String[] args) {

        Graph graph = new Graph("AAB511, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
        if (null == graph) {
            return;
        }
        //1. The distance of the route A-B-C.
        //2. The distance of the route A-D.
        //3. The distance of the route A-D-C.
        //4. The distance of the route A-E-B-C-D.
        //5. The distance of the route A-E-D.
        GraphQuestionSolver solver = new GraphQuestionSolver(graph);
        solver.solveQuestion("A-B-C");
        solver.solveQuestion("A-D");
        solver.solveQuestion("A-D-C");
        solver.solveQuestion("A-E-B-C-D");
        solver.solveQuestion("A-E-D");


    }

    public static class Graph {
        HashMap<String, Long> weights;

        public Graph(String graphString) {
            try {
                // 1. 去重获取所有的顶点
//            String graphString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
                String[] edges = graphString.split(",");

                weights = new HashMap<>(edges.length);


                for (int i = 0; i < edges.length; i++) {
                    String edge = edges[i].trim();
                    weights.put(edge.substring(0, 2), Long.valueOf(edge.substring(2)));
                }
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }

        public Long calculateDistanceBetweenSteps(String step) {
            return weights.get(step);
        }
    }


    public interface SolveInterface {
        void solveQuestion(String question);
    }

    public static class GraphQuestionSolver implements SolveInterface {
        private Graph graph;

        public GraphQuestionSolver(Graph graph) {
            this.graph = graph;
        }

        @Override
        public void solveQuestion(String question) {
            String[] steps = question.split("-");
            Long distance = 0L;
            Boolean hasAnswer = true;
            for (int j = 1; j < steps.length; j++) {
                Long weight = graph.weights.get(steps[j - 1] + steps[j]);
                if (null == weight) {
                    hasAnswer = false;
                    break;
                }
                distance += weight;
            }

            if (hasAnswer) {
                System.out.println("Distance of question : " + question + " is : " + distance);
            } else {
                System.out.println("NO SUCH ROUTE");
            }
        }
    }


}
