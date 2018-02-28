package d5;

import java.util.ArrayList;
import java.util.Scanner;

public class P1245 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int count = scn.nextInt();
            int[] positions = new int[count];
            int[] weights = new int[count];

            for(int i=0; i<count; i++) positions[i] = scn.nextInt();
            for(int i=0; i<count; i++) weights[i] = scn.nextInt();

            ArrayList<Double> ans = new ArrayList<>();
            for(int step=0; step<count-1; step++){
                double left = positions[step];
                double right = positions[step+1];
                double center = 0.0;

                while(true){

                    if(Math.abs(right-left) < 0.000000000001) break;

                    center = (left+right)/2.0;
                    double F = 0.0;

                    for(int i=0; i<count; i++){
                        double d = (double)weights[i] / Math.pow(center - positions[i], 2);
                        if(positions[i] < center)
                            F -= d;
                        else
                            F += d;

                    }

                    if(F < 0.0)
                        left = center;
                    else if(F > 0.0)
                        right = center;
                    else
                        break;
                }
                ans.add(center);
            }

            System.out.print("#" + testCase + " ");
            for(double d : ans){
                System.out.print(String.format("%.10f ", d));
            }
            System.out.println();

        }
    }
}
