package persistence;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Robot Value Object.
  * This class is value object representing database table robot
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Robot implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int serie;
    private String base;
    private String hombro;
    private String codo;
    private String muneca;
    private String pinza;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Robot () {

    }

    public Robot (int serieIn) {

          this.serie = serieIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getSerie() {
          return this.serie;
    }
    public void setSerie(int serieIn) {
          this.serie = serieIn;
    }

    public String getBase() {
          return this.base;
    }
    public void setBase(String baseIn) {
          this.base = baseIn;
    }

    public String getHombro() {
          return this.hombro;
    }
    public void setHombro(String hombroIn) {
          this.hombro = hombroIn;
    }

    public String getCodo() {
          return this.codo;
    }
    public void setCodo(String codoIn) {
          this.codo = codoIn;
    }

    public String getMuneca() {
          return this.muneca;
    }
    public void setMuneca(String munecaIn) {
          this.muneca = munecaIn;
    }

    public String getPinza() {
          return this.pinza;
    }
    public void setPinza(String pinzaIn) {
          this.pinza = pinzaIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int serieIn,
          String baseIn,
          String hombroIn,
          String codoIn,
          String munecaIn,
          String pinzaIn) {
          this.serie = serieIn;
          this.base = baseIn;
          this.hombro = hombroIn;
          this.codo = codoIn;
          this.muneca = munecaIn;
          this.pinza = pinzaIn;
    }


    /** 
     * hasEqualMapping-method will compare two Robot instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Robot valueObject) {

          if (valueObject.getSerie() != this.serie) {
                    return(false);
          }
          if (this.base == null) {
                    if (valueObject.getBase() != null)
                           return(false);
          } else if (!this.base.equals(valueObject.getBase())) {
                    return(false);
          }
          if (this.hombro == null) {
                    if (valueObject.getHombro() != null)
                           return(false);
          } else if (!this.hombro.equals(valueObject.getHombro())) {
                    return(false);
          }
          if (this.codo == null) {
                    if (valueObject.getCodo() != null)
                           return(false);
          } else if (!this.codo.equals(valueObject.getCodo())) {
                    return(false);
          }
          if (this.muneca == null) {
                    if (valueObject.getMuneca() != null)
                           return(false);
          } else if (!this.muneca.equals(valueObject.getMuneca())) {
                    return(false);
          }
          if (this.pinza == null) {
                    if (valueObject.getPinza() != null)
                           return(false);
          } else if (!this.pinza.equals(valueObject.getPinza())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Robot, mapping to table robot\n");
        out.append("Persistent attributes: \n"); 
        out.append("serie = " + this.serie + "\n"); 
        out.append("base = " + this.base + "\n"); 
        out.append("hombro = " + this.hombro + "\n"); 
        out.append("codo = " + this.codo + "\n"); 
        out.append("muneca = " + this.muneca + "\n"); 
        out.append("pinza = " + this.pinza + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Robot cloned = new Robot();

        cloned.setSerie(this.serie); 
        if (this.base != null)
             cloned.setBase(new String(this.base)); 
        if (this.hombro != null)
             cloned.setHombro(new String(this.hombro)); 
        if (this.codo != null)
             cloned.setCodo(new String(this.codo)); 
        if (this.muneca != null)
             cloned.setMuneca(new String(this.muneca)); 
        if (this.pinza != null)
             cloned.setPinza(new String(this.pinza)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}

