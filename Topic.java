package test;
import test.Agent;


import java.util.ArrayList;
import java.util.List;

public class Topic {
    public final String name;
    public final List<Agent> subs;
    public final List<Agent> pubs;

 public   Topic(String name,List<Agent> subs,List<Agent> pubs)
    {
        this.name=name;
        this.pubs=pubs;
        this.subs=subs;
    }
public Topic(String name)
{
    this.name=name;
    this.subs=new ArrayList<>();
    this.pubs=new ArrayList<>();
}
  public void subscribe(Agent a)
  {
      if(this.subs!=null && this.subs.isEmpty()&& !this.subs.contains(a))

          this.subs.add(a);


  }
    public void unsubscribe(Agent a)
    {
       if( this.subs.contains(a)==true)
           this.subs.remove(a);

    }

    public void publish(Message m) {
        if (this.subs != null && !this.subs.isEmpty()) { // תיקון
            for (Agent a : this.subs) {
                a.callback(this.name, m);
            }
        }
    }


    public void addPublisher(Agent a)
    {
        this.pubs.add(a);

        System.out.println("Before subscribe, subs size: " + this.subs.size());
        this.subs.add(a);
        System.out.println("After subscribe, subs size: " + this.subs.size());

    }

    public void removePublisher(Agent a)
    {
        if(this.pubs.contains(a)==true)
            this.pubs.remove(a);
    }


}
