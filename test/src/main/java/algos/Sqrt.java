package algos;

import org.junit.Test;

import javax.xml.transform.sax.SAXSource;

/**
 * Created by Battlestar on 2/6/2015.
 */
public class Sqrt {
    @Test
    public void t(){
        for(int i = 4; i <=9; i++){
            System.out.println(sqrt(i));
}
    }

    double sqrt(double c){
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while(Math.abs( t - c/t) > err * t){
            //System.out.printf("t - c/t > err * t => %f - %f/%f > %f * %f => %f > %f", t, c, t, err, t, Math.abs(t - c / t), err * t);
            //System.out.printf(", t = (c/t + t) / 2 => (%f/%f + %f ) /2 => %f",c,t,t, (c/t + t)/2.0);
            t = (c/t + t)/2.0;
        }
        return t;
    }
}
