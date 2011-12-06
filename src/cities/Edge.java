/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cities;

/**
 *
 * @author lucian
 */
public class Edge implements Comparable<Edge>
{

    protected  int u;
    protected  int v;

    /**
     * Get the value of u
     *
     * @return the value of u
     */
    public int getU()
    {
        return u;
    }

    /**
     * Set the value of u
     *
     * @param u new value of u
     */
    public void setU(int u)
    {
        this.u = u;
    }

    /**
     * Get the value of v
     *
     * @return the value of v
     */
    public int getV()
    {
        return v;
    }

    /**
     * Set the value of v
     *
     * @param v new value of v
     */
    public void setV(int v)
    {
        this.v = v;
    }

    public Edge(int u, int v)
    {
        this.u = u;
        this.v = v;
    }

    public int compareTo(Edge o)
    {
       return this.u-o.u;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Edge other = (Edge) obj;
        if (this.u != other.u)
        {
            return false;
        }
        if (this.v != other.v)
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        return hash;
    }

    
    

}
