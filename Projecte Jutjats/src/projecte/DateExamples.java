/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joan
 */
public class DateExamples {

    public void exempleSimpleDateformat() {
        try {
            String format = "dd/MM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            //Transforma un String a Date
            Date data = sdf.parse("07/04/2013");
            System.out.println(data);
            //Transforma Date a String
            Date ara = new Date();
            String araText = sdf.format(ara);
            System.out.println(araText);
        } catch (ParseException ex) {
            Logger.getLogger(DateExamples.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void exempleCalendar() {
            //Obtenim un calendar
            Calendar cal=Calendar.getInstance();
            int any=2013;
            int mes=Calendar.APRIL;
            int dia=7;
            int hora= 15;
            int minut=40;
            int segon=35;
            //Establim la data i l'hora del calendari
            cal.set(any, mes, dia, hora, minut, segon);
            //Obtenim un Date a partir del calendari.
            Date diaHora=cal.getTime();
            System.out.println(diaHora);

    }

    public static void main(String[] args) {
        DateExamples exemple = new DateExamples();
        exemple.exempleSimpleDateformat();
        exemple.exempleCalendar();
    }

}
