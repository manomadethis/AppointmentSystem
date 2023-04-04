package com.hairforyou.appointmentsystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author manoklm
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AppointmentDaoImpl implements AppointmentDao {

    private Connection conn;

    public AppointmentDaoImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:appointments.db");
            createTableIfNotExists();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS appointments (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT," +
                    "number TEXT," +
                    "address TEXT," +
                    "date TEXT," +
                    "time TEXT)";
        stmt.executeUpdate(sql);
        stmt.close();
    }

    @Override
    public boolean addAppointment(Appointment appointment) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO appointments (id, name, number, address, date, time) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, appointment.getCustomerID());
            stmt.setString(2, appointment.getCustomerName());
            stmt.setString(3, appointment.getCustomerNumber());
            stmt.setString(4, appointment.getCustomerAddress());
            stmt.setString(5, appointment.getDate());
            stmt.setString(6, appointment.getTime());

            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
public boolean updateAppointment(Appointment appointment) {
    try {
        PreparedStatement stmt = conn.prepareStatement("UPDATE appointments SET name=?, number=?, address=?, date=?, time=? WHERE id=?");
        stmt.setString(1, appointment.getCustomerName());
        stmt.setString(2, appointment.getCustomerNumber());
        stmt.setString(3, appointment.getCustomerAddress());
        stmt.setString(4, appointment.getDate());
        stmt.setString(5, appointment.getTime());
        stmt.setInt(6, appointment.getCustomerID()); // <-- Set the correct ID value here
        stmt.executeUpdate();
        stmt.close();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    @Override
    public boolean removeAppointment(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM appointments WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM appointments");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String number = rs.getString("number");
                String address = rs.getString("address");
                String date = rs.getString("date");
                String time = rs.getString("time");
                appointments.add(new Appointment(id, name, number, address, date, time));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    @Override
    public boolean generateReport() throws IOException, DocumentException {
        List<Appointment> appointments = getAppointments();

        // Set the default file name to "Appointment Report-[today's date]-[current time].pdf"
        String defaultFileName = String.format("Appointment Report-%s-%s.pdf", LocalDate.now().toString());

        // Create a file chooser dialog with the default file name
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(defaultFileName));

        // Set a file filter to show only PDF files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
        fileChooser.setFileFilter(filter);

        // Show the file chooser dialog and wait for the user to select a file
        int option = fileChooser.showSaveDialog(null);

        // If the user selects a file, generate the report and save it to the selected file
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // If the selected file name does not end with .pdf, add it to the file name
            if (!selectedFile.getName().endsWith(".pdf")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".pdf");
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
            document.open();
            Paragraph title = new Paragraph("Appointment Report");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add spacing between the title and the table contents
            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(6);
            table.addCell("Date");
            table.addCell("Time");
            table.addCell("Client ID");
            table.addCell("Client Name");
            table.addCell("Client Number");
            table.addCell("Client Address");

            for (Appointment appointment : appointments) {
                table.addCell(appointment.getDate());
                table.addCell(appointment.getTime());
                table.addCell(Integer.toString(appointment.getCustomerID()));
                table.addCell(appointment.getCustomerName());
                table.addCell(appointment.getCustomerNumber());
                table.addCell(appointment.getCustomerAddress());
            }

            document.add(table);
            document.close();

            return true;
        }

        return false;
    }
}
