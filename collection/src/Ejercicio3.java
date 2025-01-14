import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class GroupsManager{
    ConcurrentHashMap<String, List<String>> grupos = new ConcurrentHashMap<>();
    boolean addUserToGroup(String group, String user){
        grupos.putIfAbsent(group, new ArrayList<>());
        grupos.compute(group, new BiFunction<String, List<String>, List<String>>() {
            @Override
           public List<String> apply(String group, List<String> usuarios) {
               usuarios.removeIf(u -> user.equals(u));
               usuarios.add(user);
               return usuarios;
           }
        });
        return false;
    }

    boolean removeUserFromGroup(String user, String group){
        for (var u: grupos.get(group)){
            if (u.equals(user)){
                grupos.get(group).remove(u);
                if (grupos.get(group).isEmpty()) {
                    grupos.remove(group);
                }
                return true;
            }
        }
        return false;
    }

    boolean deleteGroup(String group){
        if (grupos.containsKey(group)){
            grupos.remove(group);
            return true;
        }
        return false;
    }

    void mostrarGroups() {
        for (Map.Entry<String, List<String>> entry : grupos.entrySet()){
            System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
        }
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        var users = List.of("user1", "user2", "user3", "user4", "user5", "user6");
        var groups = List.of("group1", "group2", "group3", "group4");
        GroupsManager gm = new GroupsManager();
        try (var executors = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i=0; i <100;i++) {
                executors.submit(() -> {
                    //System.out.println("hola");
                    gm.addUserToGroup("group1", "user1");
                });
            }
            for (int i=0; i <100;i++) {
                executors.submit(() -> {
                    //System.out.println("hola");
                    gm.addUserToGroup("group1", "user2");
                });
            }
        }
        System.out.println(gm.grupos.get("group1").size());
    }
}

