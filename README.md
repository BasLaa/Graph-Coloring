# Graph-Coloring #

These are some of the algorithms I implemented for a graph coloring competition at Maastricht University. 

As a brief recap, the graph coloring problem is the problem of assigning colors to vertices in a graph, such that not two adjacent vertices (linked by an edge) have the same colour. The goal is to use as little problems as possible. The optimal (minimal) number of colors is called the chromatic number of the graph.
We approximate the chromatic number by looking for upper and lower bounds.

However, of course, the competition is only interesting because the graph coloring problem is NP-hard, meaning there is no optimal algorithm running in reasonable time.
I will provide a brief summary of each algorithm here, with links to papers to read more deeply about them.

## DSatur backtracking ##

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
