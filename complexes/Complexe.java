package angry_balls.complexes;
import java.io.*;
/**
 * 
 * repr�sente un nombre complexe z sous forme cart�sienne z = x + y*i
 * 
 * utilis�e pour tester les junits
 * 
 * dans l'ordre : �crire d'abord les tests PUIS impl�menter les m�thodes
 * 
 * */
public class Complexe implements Serializable
{
public static final Complexe zero = new Complexe(0,0);
public static final Complexe un = new Complexe(1,0);
public static final Complexe i = new Complexe(0,1);

private double x,y;// z = x + y*i

/**
 * cr�e 0+0*i
 * */
public Complexe(){this.x = this.y = 0;}

/**
 * cr�e x+0*i
 * @param x : partie r�elle
 * */
public Complexe(double x){this.x = x; this.y = 0;}
/**
 * 
 * cr�e x+y*i
 * 
 * @param x : partie r�elle
 * @param y : partie imaginaire
 * 
 * */
public Complexe(double x, double y){this.x=x; this.y=y;}


/**
 * 
 * cr�e x+y*i
 * 
 * @param string respectant le format de toString
 *  * 
 * */
public Complexe(String string)
{
int p;
String debut, reste;

reste = string;

p = reste.indexOf('+');
debut = reste.substring(0, p);

this.x = Double.parseDouble(debut.trim());

reste = reste.substring(p+1);
p = reste.indexOf('*');
debut = reste.substring(0, p);
this.y = Double.parseDouble(debut.trim());
}

public double getX() {return x;}
public double getY() {return y;}

/**
 * 
 * calcule this+x
 * 
 * */
public Complexe somme(Complexe z) {return new Complexe( this.x+z.x,this.y+z.y);}





/**
 * 
 * calcule this-x
 * 
 * */
public Complexe difference(Complexe z) {return this.somme(z.oppose());}

/**
 * 
 * calcule this*x
 * 
 * */
public Complexe produit(Complexe z) {return new Complexe( this.x*z.x - this.y*z.y, this.x*z.y + this.y*z.x );}

/**
 * 
 * calcule this*a
 * 
 * */
public Complexe produit(double a) {return new Complexe( a*this.x, a*this.y);}

/**
 * 
 * calcule -this
 * 
 * */
public Complexe oppose() {return new Complexe(-this.x,-this.y);}

/**
 * 
 * calcule 1/this
 * 
 * */
public Complexe inverse() {return this.conjugue().produit(1/this.module2());}


/**
 * 
 * calcule le complexe conjugu� de this
 * rappel : si this = x + yi alors this* = x - yi
 * 
 * */
public Complexe conjugue() {return new Complexe( this.x,-this.y);}


/**
 * 
 * calcule |this| (norme euclidienne)
 * 
 * */
public double module() {return Math.sqrt(this.module2());}
public double moduleInfini() {return Math.max( Math.abs(this.x), Math.abs(this.y));}
public double arg() {return Math.atan2(this.y, this.x);}

public double module2() {return this.x*this.x + this.y*this.y;}

/**
 * 
 * calcule les n racines n-i�mes de this
 * 
 * rappel : si z = R * e^(i * theta) alors z a n racines n-�mes Z0, ..., Zn-1 
 * 
 * telles que Zk = r * e^(i (alfa + k*2* PI/n)) pour 0 <= k <= n-1
 * 
 * o� r = R^(1/n) et alfa = theta/n
 * 
 * on a aussi Zk+1 = Zk * e^(2*i*PI/n)
 * 
 * */
public Complexe[] racines(int n)
{
Complexe [] rac = new Complexe[n];
double R, r, theta, alfa;
Complexe u;
int k;

theta = this.arg();
R = this.module();

r = Math.pow(R, 1./n);
alfa = theta/n;

u = Complexe.creePolaire(1,2*Math.PI/n);

for ( k = 1, rac[0] = Complexe.creePolaire(r,alfa); k < n; ++k)
    rac[k] = rac[k-1].produit(u);

return rac;
}

/**
 * 
 * cr�e le nombre complexe Z = r * e^(i * theta)
 * 
 * */
public static Complexe creePolaire(double r, double theta)
{

return new Complexe(r*Math.cos(theta),r*Math.sin(theta));
}

public boolean equals(Object o)
{
if (!(o instanceof Complexe))
    return false;
else
    {
    Complexe z = (Complexe)o;
    double d, eps = 1.E-6;
    d = this.difference(z).moduleInfini();
    return d < eps;
    }
}

public String toString() 
{
return Double.toString(this.x)+"+"+Double.toString(this.y)+"*i";
}
} //Complexe
