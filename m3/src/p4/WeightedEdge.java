package p4;

import java.util.Map;
import java.util.Set;

public class WeightedEdge implements Comparable<WeightedEdge> {
  public final int first;
  public final int second;
  public final int cost;
  
  public WeightedEdge(int first, int second, int cost) {
    this.first = first;
    this.second = second;
    this.cost = cost;
  }

  @Override
  public String toString() { return "("+first+", "+second+", " + cost+")"; }
  
  @Override
  public int hashCode() {
    int h1 = first, h2 = second;
    int h = (h1 + (h1 << 10)) ^ (h1 >> 6) + h2;
    h +=  (h << 12);
    return h ^ (h >> 6);
  }

  @Override
  public int compareTo(WeightedEdge that) {
    int firstOrder = this.first - that.first;

    if (firstOrder==0) {
      int secondOrder = this.second - that.second;
      if (secondOrder == 0) return this.cost - that.cost;
      else return secondOrder;
    }
    else return firstOrder;
  }

  public boolean equals(WeightedEdge that) {
    return (this.first == that.first) &&
      (this.second == that.second) &&
      (this.cost == that.cost);
  }

  public static WeightedEdge Edge(int u, int v, int c) {
    return new WeightedEdge(u, v, c);
  }

}
