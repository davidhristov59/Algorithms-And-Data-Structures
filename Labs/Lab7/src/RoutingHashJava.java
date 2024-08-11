import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//nejasna
public class RoutingHashJava {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine()); //num of routers

        CBHT<String, String[]> addresses = new CBHT<String, String[]>(2 * n); //moram kaj value String[]

        for (int i = 0; i < n; i++) {

            String interfaceIP = bufferedReader.readLine(); //IP address of the interface
            String[] routes = bufferedReader.readLine().split(","); //IP addresses of the networks to which it has static routes

            addresses.insert(interfaceIP, routes);
        }

        int m = Integer.parseInt(bufferedReader.readLine()); //num of routing attempts
        for (int i = 0; i < m; i++) {
            String IP_address_interface = bufferedReader.readLine(); //input interface
            String network = bufferedReader.readLine(); //device IP address

            SLLNode<MapEntry<String, String[]>> node = addresses.search(IP_address_interface);

            if(node != null){

                String[] parts = node.element.value;
                String[] mreza = network.split("\\.");

                boolean valid = false;
                for (int j= 0; j < parts.length; j ++){
                    String[] tbl = parts[j].split("\\.");

                    if(tbl[0].compareTo(mreza[0]) == 0 && tbl[1].compareTo(mreza[1]) == 0 && tbl[2].compareTo(mreza[2]) == 0){
                        System.out.println("postoi");
                        valid = true;
                        break;
                    }
                }

                if(!valid){
                    System.out.println("ne postoi");
                    break;
                }
            }
            else {
                System.out.println("ne postoi");
            }

        }

    }
}

