## ${\color{lightblue} Important \space Data \space Structure \space Algorithms}$

This folder contains all the important algorithms sorted out by the type of Data Structure and the logic in which it can be used. These are the major algorhtms and approach used in solving multiple DSA problems.

## ${\color{lightblue} Table}$

#### ${\color{lightblue} Graph}$

| ${\color{red}No.}$ | ${\color{red}Algorithm}$ | ${\color{red}Code}$ | ${\color{red}Mainly \space used}$ | ${\color{red} Time}$ | ${\color{red} Space}$
|-|-|-|-|-|-|
| ***1.*** | ${\color{lightgreen} Dijkstra}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Dijkstra.java) | Shortest path from one node to all other nodes (without negative edges) | ${O(n \space log \space n)}$ | ${O(n)}$ |
| ***2.*** | ${\color{lightgreen} Cycle \space Detection}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/CycleDetect.java) | Detects if there is any cycle in graph and can even count | ${O(n)}$ | ${O(stack)}$ |
| ***3.*** | ${\color{lightgreen} Bellman \space Ford}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/BellmanFord.java) | Shortest path from one to all other nodes (with negative edges) | ${O(n^2)}$ | ${O(n)}$ |
| ***4.*** | ${\color{lightgreen} Dinic \space Flow}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Dinic.java) | Maximum flow through the graph in unit time | ${O(n)}$ | ${O(n)}$ |
| ***5.*** | ${\color{lightgreen} Kahn}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Kahn.java) | Performs topological sorting on the basis of pre-requisites | ${O(n \space log \space n)}$ | ${O(n)}$ |
| ***6.*** | ${\color{lightgreen} Prim}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Prim.java) | Generate a Minimum Spanning Tree (MST) with minimum weights possible | ${O(n \space log \space n)}$ | ${O(n)}$ |
| ***7.*** | ${\color{lightgreen} Krushkal}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Krushkal.java) | Find the number of Components in a Graph using Disjoint Set Union (DSU) | ${O(n)}$ | ${O(n)}$ |
| ***8.*** | ${\color{lightgreen} Tarjan}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Tarjan.java) | Evaluate and store the Strongly Connected Components or the Articulation points | ${O(n)}$ | ${O(stack)}$ |

---

#### ${\color{lightblue} Number \space Theory}$

| ${\color{red}No.}$ | ${\color{red}Algorithm}$ | ${\color{red}Code}$ | ${\color{red}Mainly \space used}$ | ${\color{red} Time}$ | ${\color{red} Space}$ |
|-|-|-|-|-|-|
| ***1.*** | ${\color{lightgreen} Sieve \space Of \space Erasthosthenes}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/SieveOfErasthosthenes.java) | Evaluate the numbers as prime uptil a certain value | ${O(n \space log \space log \space n)}$ | ${O(n)}$ |
| ***2.*** | ${\color{lightgreen} GCD \space and \space LCM}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/GCD.java) | Evaluate the GCD and LCM of two numbers using fast division | ${O(log \space n)}$ | ${O(1)}$ |
| ***3.*** | ${\color{lightgreen} Prime \space Factorization}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/PrimeFactorization.java) | Finding the prime factors of a given number by checking only valid numbers | ${O(\sqrt n)}$ | ${O(\sqrt n)}$ |
| ***4.*** | ${\color{lightgreen} Binary \space Exponentiation}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/BinaryExponent.java) | Quick Exponentiation of a number by fast division | ${O(log \space n)}$ | ${O(1)}$ |
| ***5.*** | ${\color{lightgreen} Modular \space Exponentiation}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/ModularExponent.java) | Quick Exponentiation of a number with prime modulo arithmetic and fast division | ${O(log \space n)}$ | ${O(n)}$ |
| ***6.*** | ${\color{lightgreen} Matrix \space Exponentiation}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/MatrixExponent.java) | Matrix Chain Multiplication (MCM) used in Linear and Combinatorial DP | ${O(log \space n)}$ | ${O(n)}$ |
| ***7.*** | ${\color{lightgreen} Combinatorics}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Combinatorics.java) | Evaluating Permutation and Combination of value using Fernet's Theorem | ${O(n)}$ | ${O(n)}$ |

---

#### ${\color{lightblue} Binary \space Tree}$

| ${\color{red}No.}$ | ${\color{red}Algorithm}$ | ${\color{red}Code}$ | ${\color{red}Mainly \space used}$ | ${\color{red} Time}$ | ${\color{red} Space}$ |
|-|-|-|-|-|-|
| ***1.*** | ${\color{lightgreen} Breadth \space First \space Search}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/BFS.java) | Traverses the tree in level wise fashion using queus | ${O(n)}$ | ${O(n)}$ |
| ***2.*** | ${\color{lightgreen} Depth \space First \space Search}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/DFS.java) | Traverses the tree in depth wise manner usng recursion and stack | ${O(n)}$ | ${O(n)}$ |
| ***3.*** | ${\color{lightgreen} Global \space Data \space Pass}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/GlobalTreePass.java) | Passing any data globally across the entire tree in a single pass | ${O(n)}$ | ${O(1)}$ |
| ***4.*** | ${\color{lightgreen} LCA \space of \space K \space nodes}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/LCA.java) | Lowest Common Ancestor (LCA) of any k nodes by passing postorder bits in a map | ${O(nk)}$ | ${O(n)}$ |
| ***5.*** | ${\color{lightgreen} Tree \space Mapping \space Algorithm}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/TreeMapping.java) | Converting tree into an undirected Minimum Spanning Tree (MST) | ${O(n)}$ | ${O(n)}$ |
| ***6.*** | ${\color{lightgreen} Vertical \space Paths}$ | [Code](https://github.com/VishuKalier2003/Data-Structures-and-Algorithms/blob/main/Important/algos/Vertical.java) | Passing and grouping tree nodes on the basis of their y coordinates | ${O(n)}$ | ${O(log \space n)}$ |

