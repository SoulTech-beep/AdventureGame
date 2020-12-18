package Auxiliary;

import java.util.Random;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class Functions {


    //Whether or not an enemy shows up
    public double uniform() {
        return new Random().nextDouble();
    }

    public int bernoulli( double p ) {
        assert( 0<=p && p<=1 );
        int bool =0;
        if(uniform() < p)
            bool = 1;
        return bool;
    }

    //Whether or not an enemy shows up
    public int binomial(int n, double p) { //n = number of tries; k = number of sucessses; p = probabibility to get it right 1st
        assert ( 0<=p && p<=1 && n>=1);
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += bernoulli(p);
        return sum;
    }

    public int geometric( double p ) {
        assert( 0 < p && p < 1 );
        return (int) ( log(uniform()) / log(1-p) );
    }

    //For critical damage (double damage)
    public int negativeBinomial( int s, double p ) {
        assert(s>=1);
        int sum = 0;
        for ( int i = 0; i < s; i++ )
            sum += geometric(p);
        return sum;
    }

    //The higher the player level, the higher the enemy level is; c=1
    public double triangular( double xMin, double xMax, double c )
    {
        assert( xMin<xMax && xMin<=c && c<=xMax );
        double p = uniform();
        double q = 1-p;
        if ( p <= (c-xMin)/(xMax-xMin) )
            return xMin + sqrt( (xMax-xMin) * (c-xMin) * p );
        else
            return xMax - sqrt( (xMax-xMin) * (xMax-c) * q );
    }

    //The higher the player level, the harder it is to run
    public double exponential( double a, double b ) {
        assert(b>0);
        return a - b * log(uniform());
    }

}
