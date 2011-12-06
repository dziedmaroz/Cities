/*
 * 3. С помощью SET реализовать сл. Задачу. Дано множество городов, соединенных
 * дорогами. Для каждого из городов известно множество городов, достижимых без
 * остановки. Для двух заданных городов найти путь (кратчайший путь).
 */

package cities;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 *
 * @author lucian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        final int INF = Integer.MAX_VALUE;
        final String file_in = "input.in";
        final String file_out = "output.out";

        int distance [] = null; // оптимальные расстояния от стартовой вершины
        int path [] = null; // предыдущая оптимальная вершина
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(); // очередь непосещенных вершин
        Set<Edge> E = new HashSet<Edge>(); // множесто ребер графа


        int n = 0;  // количество вершин
        int s = 0;  // стартовая вершина
        int g = 0; // конечная вершина

        try
        {
            BufferedReader br = new BufferedReader (new FileReader(file_in));

            String tmp = br.readLine();
            StringTokenizer tok = new StringTokenizer(tmp);
            n = Integer.parseInt(tok.nextToken());
            int m = Integer.parseInt(tok.nextToken());
            s = Integer.parseInt(tok.nextToken());
            g = Integer.parseInt(tok.nextToken());

            
            for (int i=0;i<m;i++)
            {
                tmp = br.readLine();
                tok = new StringTokenizer(tmp);
                int a = Integer.parseInt(tok.nextToken());
                int b = Integer.parseInt(tok.nextToken());
                E.add(new Edge(a, b));
                E.add(new Edge(b, a));
            }
            br.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        distance = new int[n];
        for (int i=0;i<n;i++)
        {
            distance[i]=INF;
            queue.add(new Vertex( INF,i));
        }

        path = new int [n];
        path[s]=s;
        distance[s]=0;
        queue.remove(new Vertex(INF,s));
        queue.add(new Vertex( 0,s));

        while(!queue.isEmpty())
        {

            Vertex v= queue.element();
            if (v.getDistance_()==INF)
            {
                break;
            }
            else
            {
                queue.remove(v);
                for (int i=0;i<n;i++)
                {
                    Edge e = new Edge(v.getId_(), i);
                    if(E.contains(e))
                    {
                     
                        int alt = distance[v.getId_()]+1;
                        if (alt<distance[i])
                        {
                            Vertex u = new Vertex (distance[i],i);
                            distance[i]=alt;
                            path[i]=v.getId_();
                            queue.remove(u);
                            queue.add(new Vertex(alt, i));
                        }
                    }
                }
            }
        }

        try
        {
            BufferedWriter bw = new BufferedWriter (new FileWriter(file_out));
            bw.write("Shortest path from "+s+" to "+g+": "+Integer.toString(distance[g]));
            bw.newLine();
            bw.write("Backtrack : "+Integer.toString(g));
            while(g!=s)
            {
                bw.write(" <- "+Integer.toString(path[g]));
                g=path[g];
            }
            bw.newLine();
            bw.close();
        }
        catch (Exception e)
        {
        }
 
    }

}
