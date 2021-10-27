# Graph-Coloring #

These are some of the algorithms I implemented for a graph coloring competition at Maastricht University. I came in first place, which won me a chocolate bar, but mostly a learning experience ;)

As a brief recap, the graph coloring problem is the problem of assigning colors to vertices in a graph, such that not two adjacent vertices (linked by an edge) have the same colour. The goal is to use as little problems as possible. The optimal (minimal) number of colors is called the chromatic number of the graph.
We approximate the chromatic number by looking for upper and lower bounds.

However, of course, the competition is only interesting because the graph coloring problem is NP-hard, meaning there is no optimal algorithm running in reasonable time.
I will provide a brief summary of each algorithm here, with links to papers to read more deeply about them.

## DSatur backtracking ##
The algorithm implemented here was originally proposed in 1979 by Korman and is a
backtracking version of the DSatur algorithm. The DSatur algorithm (meaning “degree of
saturation”) was originally proposed by the mathematician Daniel Brélaz in 1979.
This is an exact algorithm, meaning that it always find the best result.
On the other hand, this makes it very slow (non-polynomial). 

It involves ordering the vertices by increasing saturation degree based on the current partial coloring
of the graph. The saturation degree of a vertex is the number of different colors assigned to its
neighbouring vertices. More formally, sat(v) = |{c(u) : u ∈ Γ (v) ∧ c(u) =/ 0}| , where c(u)
is the color of vertex u and Γ (v) is the set of neighbours of vertex v. 

When the next vertex is colored, the ordering of vertices by saturation degree is recalculated based
on the new partial coloring. When two vertices have the same saturation degree, the degree of the
vertices is used to break the tie, so the vertex with the largest degree comes first.
For the backtracking version of DSatur, the initial ordering of the vertices is determined
by the DSatur algorithm. The vertices are then colored by the backtracking algorithm, with one
meaningful change. Whenever the algorithm performs a backtrack, the vertices are reordered
again based on their saturation degree. This ensures a more valid ordering based on the current
state of the graph.

Further details: https://dl.acm.org/doi/10.1145/359094.359101

## Welsh-Powell ##
The first of the upper-bound algorithms is often called the Welsh-Powell (WP) algorithm, after the
authors of the original paper. It involves ordering vertices by their
degree and keeping track of two sets, V , which includes all uncolored vertices at the start, and
V* , which is initially empty. The vertices are ordered by degree, where the vertex with the
largest degree has the highest rank. The vertex v with the highest degree is selected to be colored,
and is assigned to the lowest color class possible, which is the first color class at the start. The
color to which vertices are being assigned in this iteration is the active color, c. The vertices
non-adjacent to v are added to V* , which becomes the set of candidates for the next selection.
The vertex in V* with the highest degree is colored next with color c, and all vertices adjacent to
it are removed from V* . This process is repeated until V* is empty, as there are no candidate
vertices left. If there are uncolored vertices left, these are added to V again and the next iteration
starts with the next color c+1 as the active color, until there are no uncolored vertices left.

Further details: https://doi.org/10.1093/comjnl/10.1.85

## RLF-p ##

## MCQ ##



Besides implementing the algorithms, I also wrote a small game for graph colouring in JavaFX, where you can specify the size of a graph and you get a certain time to colour it.


![Capture](https://user-images.githubusercontent.com/25391343/138945689-c47b33c9-8b79-4871-8e71-9e23ce015e48.JPG)
