//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class WaterConnectionProblem {
//
//    //greedy algorithm
//    public static void waterConnection(int [][] houses){
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        //gi izminuvame site kukji
//        for (int i = 0; i < houses.length; i++) {
//            //barame pocetna vakva kukja
//            if(houses[i][0] == 0 && houses[i][1] != -1) { //nema vlezna cevka
//                //prebaruvanje
//                int curr = i;
//                int min_d = houses[curr][2];
//                while(houses[curr][1] != -1){
////                    curr = houses[curr][1]; //krajnata kukja ni e vo curr zacuvana
//                    if(houses[curr][2] < min_d){
//                        min_d = houses[curr][2];
//                    }
//                    curr = houses[curr][1]; //krajnata kukja ni e vo curr zacuvana
//                }
//                ArrayList<Integer> tmp = new ArrayList<>();
//                tmp.add(i);
//                tmp.add(curr);
//                tmp.add(min_d);
//                res.add(tmp); //dodavame vo rezultantnata
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int houses[][] = new int[n][3];
//
//        for (int i = 0; i < n; i++) {
//            houses[i][0] = 0;  //dali ima vlezna cevka - 0
//            houses[i][1] = -1; //indeksot na kukja kon koja sto imame izlezna cevka
//            houses[i][2] = 0; //dijametar na izlezna cevka
//
//        }
//
//        int p = scanner.nextInt(); //broj na cevki
//        for (int i = 0; i < p; i++) {
//            int pK = scanner.nextInt(); //pocetna kukja
//            int vK = scanner.nextInt(); //vlezna kukja
//            int d = scanner.nextInt(); //dijametarot
//
//            houses[pK][1] =  vK;
//            houses[pK][2] = d;
//            houses[vK][0] = pK; //ili p
//        }
//        ArrayList<ArrayList<Integer>> res = waterConnection();
//        System.out.println(res.size());
//
//        for (int i = 0; i < res.size(); i++) {
//            for (int j = 0; j < res.get(i).size(); j++) {
//                System.out.println(res.get(i).get(j));
//            }
//            System.out.println();
//        }
//    }
//}
