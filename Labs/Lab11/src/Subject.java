import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Subject {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numSubjects = Integer.parseInt(bufferedReader.readLine());

        Set<String> subjects = readSubjects(bufferedReader, numSubjects);

        int numDependencies = Integer.parseInt(bufferedReader.readLine());

        Map<String, List<String>> dependencies = readDependencies(bufferedReader, numDependencies);

        String lastSubject = bufferedReader.readLine();

        String nextSubject = findNextSubject(dependencies, lastSubject, subjects);

        if (nextSubject != null) {
            System.out.println(nextSubject);
        } else {
            System.out.println("Предметот не е пронајден");
        }

        bufferedReader.close();
    }

    private static Set<String> readSubjects(BufferedReader reader, int numSubjects) throws IOException {
        Set<String> subjects = new HashSet<>();
        for (int i = 0; i < numSubjects; i++) {
            subjects.add(reader.readLine());
        }
        return subjects;
    }

    private static Map<String, List<String>> readDependencies(BufferedReader reader, int numDependencies) throws IOException {
        Map<String, List<String>> dependencies = new HashMap<>();
        for (int i = 0; i < numDependencies; i++) {
            String[] dependencyLine = reader.readLine().split("\\s+");
            String subject = dependencyLine[0];
            List<String> deps = Arrays.asList(Arrays.copyOfRange(dependencyLine, 1, dependencyLine.length));
            dependencies.put(subject, deps);
        }
        return dependencies;
    }

    private static String findNextSubject(Map<String, List<String>> dependencies, String lastSubject, Set<String> subjects) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(lastSubject);
        visited.add(lastSubject);

        while (!queue.isEmpty()) {
            String currentSubject = queue.poll();

            if (dependencies.containsKey(currentSubject)) {
                for (String nextSubject : dependencies.get(currentSubject)) {
                    if (!visited.contains(nextSubject)) {
                        visited.add(nextSubject);
                        queue.add(nextSubject);
                    }
                }
            }
        }

        List<String> sortedSubjects = new ArrayList<>(subjects);
        Collections.sort(sortedSubjects);

        return findNextAvailableSubject(dependencies, visited, sortedSubjects);
    }

    private static String findNextAvailableSubject(Map<String, List<String>> dependencies, Set<String> visited, List<String> sortedSubjects) {
        for (String subject : sortedSubjects) {
            if (!visited.contains(subject)) {
                if (!dependencies.containsKey(subject)) {
                    return subject;
                }
                List<String> deps = dependencies.get(subject);
                if (visited.containsAll(deps)) {
                    return subject;
                }
            }
        }
        return null;
    }
}
