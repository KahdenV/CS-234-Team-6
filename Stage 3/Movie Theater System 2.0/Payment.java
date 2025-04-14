import java.util.Date;
import java.util.Map;
import java.util.HashMap;

/**
 * Represents a payment transaction and provides utilities for payment processing and tracking.
 */
public class Payment {
    private final String paymentId;
    private final String customerId;
    private final double amount;
    private final Date paymentDate;
    private String status;

    private final static Map<String, Payment> paymentRecords = new HashMap<>();

    /**
     * Constructs a Payment object with the given details.
     *
     * @param paymentId   Unique payment identifier.
     * @param customerId  ID of the customer who made the payment.
     * @param amount      Payment amount.
     * @param paymentDate Date of the transaction.
     * @param status      Status of the payment.
     */
    public Payment(String paymentId, String customerId, double amount, Date paymentDate, String status) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public String getPaymentId() { return paymentId; }
    public String getCustomerId() { return customerId; }
    public double getAmount() { return amount; }
    public Date getPaymentDate() { return paymentDate; }
    public String getStatus() { return status; }

    /**
     * Processes a payment and saves it in the records.
     *
     * @param customerId The ID of the customer making the payment.
     * @param amount     The amount to be paid.
     * @return A newly created Payment object.
     */
    public static Payment processPayment(String customerId, double amount) {
        String paymentId = generatePaymentId();
        Date paymentDate = new Date();
        String status = "Completed";

        Payment payment = new Payment(paymentId, customerId, amount, paymentDate, status);
        paymentRecords.put(paymentId, payment);
        System.out.println("Payment processed successfully: " + paymentId);
        return payment;
    }

    /**
     * Marks a payment as refunded.
     *
     * @param paymentId The ID of the payment to refund.
     */
    public static void refundPayment(String paymentId) {
        Payment payment = paymentRecords.get(paymentId);
        if (payment != null && payment.status.equals("Completed")) {
            payment.status = "Refunded";
            System.out.println("Payment refunded: " + paymentId);
        } else {
            System.out.println("Refund failed. Payment not found or already refunded.");
        }
    }

    /**
     * Retrieves a specific payment by ID.
     *
     * @param paymentId The ID of the payment.
     * @return The Payment object or null if not found.
     */
    public static Payment getPaymentDetails(String paymentId) {
        Payment payment = paymentRecords.get(paymentId);
        if (payment != null) {
            return payment;
        } else {
            System.out.println("Payment not found: " + paymentId);
            return null;
        }
    }

    /**
     * Returns all recorded payments.
     *
     * @return A map of payment ID to Payment object.
     */
    public static Map<String, Payment> getPaymentRecords() {
        return paymentRecords;
    }

    /**
     * Updates the status of a given payment.
     *
     * @param paymentId The payment ID.
     * @param status    The new status to set.
     */
    public static void updatePaymentStatus(String paymentId, String status) {
        Payment payment = paymentRecords.get(paymentId);
        if (payment != null) {
            payment.status = status;
            System.out.println("Payment status updated to: " + status);
        } else {
            System.out.println("Payment not found: " + paymentId);
        }
    }

    /**
     * Generates a unique payment ID.
     *
     * @return A unique identifier string.
     */
    private static String generatePaymentId() {
        return "PAY" + System.currentTimeMillis();
    }

    /**
     * Returns a string representation of the payment.
     *
     * @return A summary string of the payment details.
     */
    @Override
    public String toString() {
        return "Payment ID: " + paymentId +
                ", Customer ID: " + customerId +
                ", Amount: " + amount +
                ", Payment Date: " + paymentDate +
                ", Status: " + status;
    }
}