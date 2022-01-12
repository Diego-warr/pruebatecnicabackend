package com.proyecto.pruebatecnicaback.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UtilsMethods {

    private static final double ESPERANZA_VIDA_LIMA_INEI = 77.87;
    private static final int MILLIS_IN_SECOND = 1000;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;
    private static final int DAYS_IN_YEAR = 365; //I know this value is more like 365.24...
    private static final long MILLISECONDS_IN_YEAR = (long) MILLIS_IN_SECOND * SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAY * DAYS_IN_YEAR;

    public static int getEdad(Date fechaNacimiento) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaNacimiento);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());

        Integer aaaa = calendar.get(Calendar.YEAR);
        Integer aActual = calendar1.get(Calendar.YEAR);

        System.out.println("Anios: "+aaaa+", "+aActual);
        return aActual-aaaa;

    }

    public static Double desviacionstandar(List<Integer> edades){

        Double promedio = edades.stream().mapToDouble(a->a).summaryStatistics().getAverage();

        double valor = edades.stream().mapToDouble(e-> Math.pow(e-promedio,2)).summaryStatistics().getAverage();

        return Math.sqrt(valor);
    }

    public static Date setFechaProbableDeMuerte(Date fechaNacimiento){

        int edad = getEdad(fechaNacimiento);

        if(edad<ESPERANZA_VIDA_LIMA_INEI){
            double anios =(Double) ESPERANZA_VIDA_LIMA_INEI-edad;
            System.out.println(anios);

            long anios2 = (long) (MILLISECONDS_IN_YEAR*anios);

            System.out.println("anios in mill. "+anios2);
            long nuevaFecha = System.currentTimeMillis()+anios2;

            System.out.println("actual: "+System.currentTimeMillis());
            System.out.println(nuevaFecha);

            return new Date(nuevaFecha);

        }else {
            return new Date(0L);
        }

    }

    public static boolean validarFecha(String fecha){

        System.out.println("entre a validar fecha");
        try
        {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
            sdfrmt.setLenient(false);
            Date date = sdfrmt.parse(fecha);

            return true;
        }
        catch (ParseException e)
        {
            return false;
        }
    }

    public static Date dateFromString(String fecha) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(fecha);

        return date;
    }
}
