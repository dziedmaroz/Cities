/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cities;

/**
 *
 * @author lucian
 */
public class Vertex implements Comparable<Vertex>
{
    private int distance_; // оптимальное расстояние
    private int id_; // номер вершины   
    

    public Vertex(int distance_, int id_)
    {
        this.distance_ = distance_;
        this.id_ = id_;
    }

    /**
     * Get the value of previous
     *
     * @return the value of previous
     */
     

    public int getDistance_()
    {
        return distance_;
    }

    public int getId_()
    {
        return id_;
    }

    public void setDistance_(int distance_)
    {
        this.distance_ = distance_;
    }

    public void setId_(int id_)
    {
        this.id_ = id_;
    }

    public int compareTo(Vertex o)
    {
        return this.distance_-o.distance_;
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
        final Vertex other = (Vertex) obj;
        if (this.distance_ != other.distance_)
        {
            return false;
        }
        if (this.id_ != other.id_)
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
