# HairForYouAppointmentSystem
# Default login: admin|password
Kimano Lambert
COMP2171 Presentation 3
Code Documentation

Hair For You Appointment System

The Hair For You Appointment System is a simple software solution for a small company that would like to keep track of its administrators, customers, and more importantly, their set and requested appointments. The system has three main components: a Login System, the main Appointment GUI, and a Client Menu.

The Login System allows administrators and clients to create accounts, both of which are users. and are categorized accordingly. Therefore, I used inheritance to convey this relationship, where the Clients and Admin classes are generalized from the User class, therefore they share similar characteristics. The Login System scans each line of the "users.txt" file, checks the tag of each user, then validates the username and password. If both match the contents of the line found for that user, the system closes the Login GUI and either closes the AppointmentGUI, or the Client Menu, depending on the user.

A UserManager instance is created when a user clicks the New User button, and this opens separate a form (NewClientGUI or NewAdminGUI) that corresponds to the type of account being created. After the fields are populated correctly, the user's data is stored in the "users.txt" file for future use.

In the AppointmentGUI, the appointments are listed in a table format, as defined in the AppointmentTableModel class. The fields are as follows: ID, Name, Number, Address, Date, and Time. The constructor, accessors, and mutators from the Appointment class are used in the creation of appointments. Appointments are stored in the “appointments.db" file, and the system uses SQL queries to add, update, query and remove appointment data.
When the Add Appointment button is clicked, a panel opens which allows the admin to select a user they may want to create an appointment for. If a user is selected, their name, number, and address is automatically populated in the relevant fields. The admin can then add a date and time, and if no time conflicts are found (no appointment is found within 2 hours of the appointment time), the appointment is added.

When the Update Appointment button is clicked, a panel is also displayed with all the details of the interview that was selected, which allows the admin to easily edit the desired field (except the ID number, which is read-only) and keep the rest of the data. The update can then be seen with a confirmation message. Finally, for the Remove Appointments button, a selected appointment is removed from the table and database upon admin confirmation. These methods were created in the AppointmentDao interface and are implemented by the AppointmentDaoImpl class. These classes, along with the AppointmentTableModel, represent the model-view-controller (MVC) pattern I decided to implement.

The Generate Report button allows the user to save the current list of appointments as a .pdf file.
Appointment requests can be approved or denied with the Manage Requests button, which opens a menu and displays a list of appointment requests from clients.
Finally, the sign out button returns the user to the LoginSystem.
When a client signs in, the ClientMenuGUI is opened and from there, a client has the ability to view their upcoming appointments and schedule an appointment.
