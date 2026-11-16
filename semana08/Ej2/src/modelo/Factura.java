package modelo;

import java.util.Locale;

public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha, double importe,
                   String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    public double calcularTotal() {
        return importe * (1.0 - descuento) * (1.0 + iva);
    }

    public static Factura crearDesdeLineaTSV(String linea, String separador) {
        String[] partes = linea.split(separador);
        if (partes.length != 8) {
            return null;
        }
        try {
            String concepto = partes[0].trim();
            double descuento = Double.parseDouble(partes[1].trim());
            String fecha = partes[2].trim();
            double importe = Double.parseDouble(partes[3].trim());
            String nif = partes[4].trim();
            String nombreCliente = partes[5].trim();
            String direccion = partes[6].trim();
            double iva = Double.parseDouble(partes[7].trim());

            return new Factura(concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String toCSV() {
        return String.format(Locale.US, "%s,%.2f,%s,%.2f,%s,%s,%s,%.2f,%.2f",
                concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva, calcularTotal());
    }

    public String toFilaHTML() {
        return String.format(Locale.US,
                "<tr><td>%s</td><td>%.2f</td><td>%s</td><td>%.2f €</td><td>%s</td><td>%s</td><td>%s</td><td>%.2f</td><td><b>%.2f €</b></td></tr>\n",
                concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva, calcularTotal());
    }

    public String getConcepto() {
        return concepto;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public String getNif() {
        return nif;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getIva() {
        return iva;
    }
}
