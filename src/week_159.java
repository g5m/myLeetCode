import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class week_159 {
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/aaaaa", "/a/aaaab", "/a/aaaac", "/a/aaaad", "/a/aaaae", "/a/aaaaf", "/a/aaaag", "/a/aaaah", "/a/aaaai", "/a/aaaaj", "/a/aaaak", "/a/aaaal", "/a/aaaam", "/a/aaaan", "/a/aaaao", "/a/aaaap", "/a/aaaaq", "/a/aaaar", "/a/aaaas", "/a/aaaat", "/a/aabqg", "/a/aabqh", "/a/aabqi", "/a/aabqj", "/a/aabqk", "/a/aabql", "/a/aabqm", "/a/aabqn", "/a/aabqo", "/a/aabqp", "/a/aabqq", "/a/aabqr", "/a/aabqs", "/a/aabqt", "/a/aabqu", "/a/aabqv", "/a/aabqw", "/a/aabqx", "/a/aabqy", "/a/aabqz", "/a/aabra", "/a/aabrb", "/a/aabrc", "/a/aabrd", "/a/aabre", "/a/aabrf", "/a/aabrg", "/a/aabrh", "/a/aabri", "/a/aabrj", "/a/aabrk", "/a/aabrl", "/a/aabrm", "/a/aabrn", "/a/aabro", "/a/aabrp", "/a/aabrq", "/a/aabrr", "/a/aabrs", "/a/aabrt", "/a/aabru", "/a/aabrv", "/a/aabrw", "/a/aabrx", "/a/aaoaq", "/a/aaoar", "/a/aaoas", "/a/aaoat", "/a/aaoau", "/a/aaoav", "/a/aaoaw", "/a/aaoax", "/a/aaoay", "/a/aaoaz", "/a/aaoba", "/a/aaobb", "/a/aaobc", "/a/aaobd", "/a/aaobe", "/a/aaobf", "/a/aaobg", "/a/aaobh", "/a/aaobi", "/a/aaobj", "/a/aaobk", "/a/aaobl", "/a/abdor", "/a/abdos", "/a/abdot"};

        System.out.println(removeSubfolders(folder));
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        if (coordinates.length == 2) {
            return true;
        }
        double k0 = 0;
        double k1 = 0;
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        k0 = coordinates[1][0] - x;
        k1 = coordinates[1][1] - y;
        double k = k0 / k1;
        if (k1 == 0) {
            for (int i = 1; i < coordinates.length; i++) {
                if (coordinates[i][1] != y) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < coordinates.length; i++) {
                if (((double) (coordinates[i][0] - x)) / ((double) (coordinates[i][1] - y)) != k) {
                    return false;
                }

            }
        }
        return true;
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        if (folder[0].equals("/")) {
            result.add("/");
            return result;
        }
        String first = "@";
        for (int i = 0; i < folder.length; i++) {
            if (!(folder[i].startsWith(first) && folder[i].replaceFirst(first, "").startsWith("/"))) {
                result.add(folder[i]);
                first = folder[i];
            }
        }
        return result;
    }





}
