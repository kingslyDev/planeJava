package view.Admin;

import controller.FlightController; // Import the FlightController class
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 * AdminMain - Main view for Admin to manage flight data
 */
public class AdminMain extends javax.swing.JFrame {

    private final FlightController controllerFlight;

    // Constructor
    public AdminMain() {
        initComponents();

        // Align center
        setLocationRelativeTo(null);

        // Set background color
        getContentPane().setBackground(Color.WHITE);

        // Initialize FlightController
        controllerFlight = new FlightController();

        // Load flight data into the table
        loadFlightData();
    }

    /**
     * Load flight data into the JTable
     */
    private void loadFlightData() {
        // Fetch flight data from the controller
        var flightList = controllerFlight.getAllTickets();

        // Clear the table first
        DefaultTableModel model = (DefaultTableModel) DataTicket.getModel();
        model.setRowCount(0);  // Clear existing rows

        // Populate table with flight data
        for (var flight : flightList) {
            Object[] rowData = {
                flight.getFlightCode(),
                flight.getDepartureCity(),
                flight.getArrivalCity(),
                flight.getDepartureDate(),
                flight.getDepartureTime(),
                flight.getAvailableSeats(),
                flight.getStatus(),
                flight.getPrice()
            };
            model.addRow(rowData);
        }
    }

    /**
     * Event handler for adding new flight data
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        // Open AddData form
        AddData tambahData = new AddData();
        tambahData.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        DataTiketTxt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTicket = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DataTiketTxt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DataTiketTxt.setForeground(new java.awt.Color(0, 0, 0));
        DataTiketTxt.setText("DATA TIKET");
        getContentPane().add(DataTiketTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 143, -1));

        DataTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight Code", "Departure City", "Arrival City", "Date", "Time", "Available Seats", "Status", "Ticket Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DataTicket);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 191, 913, 88));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("+ Add");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(883, 143, 74, 30));

        BG.setText("jLabel1");
        BG.setMaximumSize(new java.awt.Dimension(1000, 665));
        BG.setMinimumSize(new java.awt.Dimension(1000, 665));
        BG.setPreferredSize(new java.awt.Dimension(1000, 665));
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
    }// </editor-fold>                        

    /**
     * Main method
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel BG;
    private javax.swing.JTable DataTicket;
    private javax.swing.JLabel DataTiketTxt;
    private javax.swing.JButton btnAdd;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
