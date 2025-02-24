
# Advanced Programming and Data Structures - Project S2

## Overview
This project focuses on the implementation and analysis of several advanced data structures and algorithms, primarily in Java. It incorporates the use of trees, graphs, and hash tables, with the goal of efficiently managing and processing large datasets. The project covers the following structures and algorithms:
- **Graphs**: BFS, DFS, Topological Sorting, and Dijkstra's Algorithm
- **Trees**: AVL Trees, Binary Trees, R-Trees
- **Maps (Hash Tables)**: Open Addressing with Quadratic Probing

## Table of Contents
1. [Language Choice](#1-language-choice)
2. [Data Structure Costs](#2-data-structure-costs)
3. [Graph Implementations](#3-graph-implementations)
4. [Tree Implementations](#4-tree-implementations)
5. [R-Tree Implementations](#5-r-tree-implementations)
6. [Map Implementations](#6-map-implementations)
7. [Performance Analysis](#7-performance-analysis)
8. [Testing Methodology](#8-testing-methodology)
9. [Problems Encountered](#9-problems-encountered)
10. [Conclusions](#10-conclusions)
11. [Screenshots](#11-screenshots)

---

## 1. Language Choice
The programming language selected for this project is **Java**, chosen for its familiarity, object-oriented features, and built-in data structures, such as **ArrayList**, **LinkedList**, and **HashMap**. Java’s strong type system, collections framework, and features like inheritance and interfaces facilitate efficient implementation of the project’s components.

---

## 2. Data Structure Costs
### ArrayList:
- **Insertion (at end)**: O(1), but may require reallocation when the internal array exceeds capacity.
- **Access by index**: O(1).
- **Insertion at specific position**: O(n), as elements need to be shifted.
- **Removal of element**: O(n), as elements must be shifted.

### LinkedList:
- **Insertion (at end)**: O(1), no need to reallocate or shift elements.
- **Access by index**: O(n), as it requires traversal from the head.
- **Insertion at specific position**: O(n), traversal needed to find the position.
- **Removal of element**: O(n), as traversal is required to find the node to remove.

---

## 3. Graph Implementations
### Structure Design:
- **Users as Nodes**: Each user is represented by a node containing attributes, and relationships (followers/following) are modeled as edges.
- **Sorting**: Users are sorted by ID using Quicksort for efficient binary search during future lookups.

### Implemented Algorithms:
- **Breadth-First Search (BFS)**: Explores a graph level by level. Used for network exploration and finding connected users.
- **Depth-First Search (DFS)**: Used for user recommendation based on following relationships, though a direct loop-based approach was used instead of the typical DFS.
- **Topological Sort**: Used for contextualizing drama, ensuring that user relationships (following) are processed in the correct order.
- **Dijkstra’s Algorithm**: Finds the shortest path between nodes, applied for networking purposes in this project.

---

## 4. Tree Implementations
### AVL Tree:
- **Self-Balancing Tree**: An AVL Tree was used to manage ordered data, balancing itself after each insertion and deletion.
- **Insertion and Deletion**: Balancing via rotations ensures O(log n) time complexity for both operations.
- **Timestamp-based Ordering**: Nodes are inserted based on timestamps, ensuring sorted order, and simplifying range searches.

---

## 5. R-Tree Implementations
### Design:
- **R-Trees**: Used to manage spatial data, particularly for 2D shapes like circles and rectangles.
- **Insertions and Deletions**: Handled with recursion. Overflow is addressed by splitting nodes and creating new parent nodes.
- **Search Algorithms**: Includes spatial area search and special color-based search.

---

## 6. Map Implementations
### Hash Tables with Open Addressing:
- **Quadratic Probing**: Used to resolve hash collisions, offering better performance than linear probing in most cases.
- **Insertions**: The insertion algorithm uses hashing to generate a unique index for each entry, with collisions handled by quadratic probing.
- **Deletions and Queries**: The table can dynamically resize based on occupancy, improving performance as datasets grow.

---

## 7. Performance Analysis
Performance was analyzed for each data structure and operation, using several datasets of increasing size (XS, S, M, L, XL, XXL). The key results are as follows:
- **Graphs**: BFS and DFS performance showed quadratic growth with increasing dataset size. The Dijkstra algorithm exhibited linear performance in most cases.
- **Trees**: AVL trees performed well with balanced data, though insertion times increased during rebalancing.
- **R-Trees**: Insertion and search times were logarithmic but showed significant variance depending on the dataset and tree structure.
- **Maps**: Insertion times showed linear growth, but rehashing operations slowed performance on larger datasets.

---

## 8. Testing Methodology
Testing was conducted using small datasets initially, then progressively larger ones. The tests verified:
- **Correctness**: Ensured that insertion, deletion, and searching performed correctly across all data structures.
- **Performance**: Time taken for each operation was recorded and graphed to analyze the scalability of each algorithm.

---

## 9. Problems Encountered
- **User Recommendation Algorithm**: The recommendation algorithm initially used DFS but was implemented using loops for simplicity. This caused performance issues with larger files.
- **Overflow in R-Trees**: Managing overflow during circle and rectangle insertions proved complex, requiring manual handling to avoid recursion issues.
- **Map Collisions**: Multiple rehashing cycles were required during hash collisions, leading to inefficiencies. Switching to quadratic probing helped mitigate this problem.

---

## 10. Conclusions
This project reinforced the importance of balancing time complexity and memory usage when choosing data structures. The AVL tree and hash tables performed well, but R-Trees provided challenges due to their complexity. Each data structure has its trade-offs, and the selection should be based on the problem's specific needs.

---

## 11. Screenshots
### Graph Structures:
- **Graph Structure Example**: ![Graph Example](https://github.com/user-attachments/assets/fc7cb23c-9ca3-414a-a7ef-614e7f2c5c93)

### Tree Structures:
- **AVL Tree Example**: ![AVL Tree Example](https://github.com/user-attachments/assets/3a4e774b-dbb0-46ec-aa0d-7b36da0fee69)

### R-Tree Structures:
- **R-Tree Examples**: ![R-Tree Example1](https://github.com/user-attachments/assets/4e3ebb11-752f-4fee-b8d9-ff18d7e5e095)
- ![R-Tree Example1](https://github.com/user-attachments/assets/acd3ebb8-0e9e-4ed3-90d8-fc334d411d2a)

### Map Structures:
- **Map Example**: ![Map Example](https://github.com/user-attachments/assets/81dcb627-dd85-4654-b944-292e1ab535f4)


---

