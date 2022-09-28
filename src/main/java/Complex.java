import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
/**
 * class Complex 
 */
public class Complex{
    
    private BigDecimal real;
    private BigDecimal imag;

    public Complex() {
        this.real = new BigDecimal("0");
        this.imag = new BigDecimal("0");
    }

    public Complex(double real, double imag) {
        this.real = new BigDecimal(real);
        this.imag = new BigDecimal(imag);
    }

    public static Complex valueOf(double real, double imag) {
        return new Complex(real, imag);
    }

    public boolean equals(Complex other){
        return this.real.compareTo(other.real) == 0 && this.imag.compareTo(other.imag) == 0;
    }

    public BigDecimal getReal(){
        return this.real;
    }

    public BigDecimal getImag(){
        return this.imag;
    }

    public Complex add(Complex other){
        Complex newObj = new Complex();
        newObj.real = this.real.add(other.real);
        newObj.imag = this.imag.add(other.imag);
        return newObj;
    }

    public Complex sub(Complex other){
        Complex newObj = new Complex();
        newObj.real = this.real.subtract(other.real);
        newObj.imag = this.imag.subtract(other.imag);
        return newObj;
    }
    
    public Complex mul(Complex other){
        Complex newObj = new Complex();
        newObj.real = this.real.multiply(other.real).subtract(this.imag.multiply(other.imag));
        newObj.imag = this.imag.multiply(other.real).add(this.real.multiply(other.imag));
        return newObj;
    }

    public BigDecimal getModule(){
        return (this.real.pow(2).add(this.imag.pow(2))).sqrt(new MathContext(2));
    }
    
    public double getArg(){
        BigDecimal tmpImag = new BigDecimal("0").add(this.imag);
        BigDecimal tmpReal = new BigDecimal("0").add(this.real);
        while(tmpImag.abs().compareTo(new BigDecimal(Double.MAX_VALUE)) > 0
            || tmpReal.abs().compareTo(new BigDecimal(Double.MAX_VALUE)) > 0 ){
            tmpReal = tmpReal.divide(new BigDecimal(1000000));
            tmpImag = tmpImag.divide(new BigDecimal(1000000));
        }
        while(tmpImag.abs().compareTo(new BigDecimal(Double.MIN_VALUE)) < 0
            || tmpReal.abs().compareTo(new BigDecimal(Double.MIN_VALUE))  < 0 ){
            tmpReal = tmpReal.multiply(new BigDecimal(1000000));
            tmpImag = tmpImag.multiply(new BigDecimal(1000000));
        }
        return Math.atan(tmpImag.doubleValue() / tmpReal.doubleValue());
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(5);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
        return String.format("%s + (%s)i", df.format(this.real), df.format(this.imag));
    }
    //TODO: Equals and HashCode
}