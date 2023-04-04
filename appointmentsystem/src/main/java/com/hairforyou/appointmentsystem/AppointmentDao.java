
package com.hairforyou.appointmentsystem;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

/**
 *
 * @author manoklm
 */
public interface AppointmentDao {
    public boolean addAppointment(Appointment appointment);
    public boolean updateAppointment(Appointment appointment);
    public boolean removeAppointment(int id);
    public boolean generateReport() throws IOException, DocumentException;
}