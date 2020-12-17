package Auxiliary;

import java.util.Random;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class Functions {

    public double uniform(){
        return new Random().nextDouble();
    }

    //Whether or not an enemy shows up
    public double binomial (int n, int k, double p){ //n = number of tries; k = number of sucessses; p = probabibility to get it right 1st
        int answer = 1;
        for (int i = 1; i <= k; i++) {
            answer = answer * (n - k + i);
            answer = answer / i;
        }
        return answer * (double)Math.pow(p, k) * (double)Math.pow(1 - p, n - k);
    }

    //For critical damage (double damage)
    public double negativeBinomial (int s, double p){
        assert(s >= 1);
        int sum = 0;
        for (int i = 0; i < s; i++) sum += geometric(p);
        return sum;
    }

    public int geometric( double p ) {
        assert( 0. < p && p < 1. );
        return (int) (log(uniform())/log( 1 - p ));
    }

    //The higher the player level, the higher the enemy level is; c=1
    public double triangular(double xMin, double xMax, double c){
        assert( xMin < xMax && xMin <= c && c <= xMax );
        double p = uniform();
        double q = 1. - p;
        if ( p <= ( c - xMin ) / ( xMax - xMin ) )
            return xMin + sqrt( ( xMax - xMin ) * ( c - xMin ) * p );
        else
            return xMax - sqrt( ( xMax - xMin ) * ( xMax - c ) * q );
    }

    //The higher the player level, the harder it is to run
    public double exponential( double a, double b ){
        assert(b > 0);
        return a - b * log(uniform());
    }

}
