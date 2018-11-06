import java.util.*;
import java.util.stream.Collectors;

public class Index
{
    public Map<String, Set<Integer>> index;

    public Index()
    {
        index = new HashMap<>();
    }

    public void begriffHinzufuegen(String begriff, int seitenZahl)
    {
        index.putIfAbsent(begriff, new TreeSet<>());
        index.get(begriff).add(seitenZahl);
    }

    public String toString()
    {
        return this.index.keySet().stream().map(s -> "<" + s + ">:" + this.index.get(s).stream().map(Object::toString)
                                                .collect(Collectors.joining(", ", "<", ">")))
                                            .collect(Collectors.joining("\n"));
    }


}