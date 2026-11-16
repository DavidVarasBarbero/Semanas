package modelo;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import es.usal.progiii.tools.Rutas;

public class Modelo {
    private ArrayList<Factura> facturas;
    private Path rutaEntradaTSV = Rutas.pathToFileOnDesktop("facturas.tsv");
    private Path rutaSalidaHTML = Rutas.pathToFileOnDesktop("facturas.html");
    private Path rutaSalidaCSV = Rutas.pathToFileOnDesktop("facturas.csv");

    public Modelo() {
        this.facturas = new ArrayList<>();
    }

    public Path getRutaEntradaTSV() {
        return rutaEntradaTSV;
    }

    public ArrayList<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }

    public int cargarFacturasTSV(Path ruta) {
        File file = ruta.toFile();
        if (!file.exists() || !file.isFile()) {
            return -1;
        }
        try {
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            facturas.clear();
            for (String linea : lineas) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                Factura f = Factura.crearDesdeLineaTSV(linea, "\t");
                if (f != null) {
                    facturas.add(f);
                }
            }
            return facturas.size();
        } catch (Exception e) {
            return -1;
        }
    }

    public ArrayList<Factura> obtenerFacturasSuperioresA(double minimo) {
        ArrayList<Factura> resultado = new ArrayList<>();
        for (Factura f : facturas) {
            if (f.calcularTotal() > minimo) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    public boolean exportarHTML() {
        String plantillaHTML = """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>Listado de Facturas</title>
                </head>
                <body>
                    <h1>Listado Total de Facturas</h1>
                    <table border="1">
                        <caption>Facturas registradas en el sistema</caption>
                        <thead>
                            <tr>
                                <th>Concepto</th>
                                <th>Descuento</th>
                                <th>Fecha</th>
                                <th>Importe Base</th>
                                <th>NIF</th>
                                <th>Cliente</th>
                                <th>Dirección</th>
                                <th>IVA</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            %%TABLA%%
                        </tbody>
                    </table>
                </body>
                </html>
                """;

        StringBuilder filas = new StringBuilder();
        for (Factura f : facturas) {
            filas.append(f.toFilaHTML());
        }

        String htmlFinal = plantillaHTML.replace("%%TABLA%%", filas.toString());

        try {
            Files.writeString(rutaSalidaHTML, htmlFinal, StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean exportarCSV() {
        List<String> lineas = new ArrayList<>();
        lineas.add("Concepto,Descuento,Fecha,Importe,NIF,Cliente,Direccion,IVA,Total");
        for (Factura f : facturas) {
            lineas.add(f.toCSV());
        }

        try {
            Files.write(rutaSalidaCSV, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}