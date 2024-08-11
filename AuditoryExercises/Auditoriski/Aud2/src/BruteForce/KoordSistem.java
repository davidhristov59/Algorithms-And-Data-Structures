package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Point{

private int x;
private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(){

    }

    //bruteforce koj ke ni se dvizi niz site tocki i ke presmetuva

    //EVKLIDOVO RASTOJANIE - sqrt((Xa - Xb)^2 + (Ya - Yb)^2)
    public  double rastojanie(Point d){
        return Math.sqrt((this.x - d.x) * (this.x - d.x) + (this.y - d.y) * (this.y - d.y));
    }

}

public class KoordSistem {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Point p = new Point();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

        }
        System.out.println(p.rastojanie(p));

    }


}
