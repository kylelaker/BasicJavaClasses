/*
 * Copyright (c) 2016 Kyle Laker
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

/**
 * Represents a 10-digit North American phone number.
 *
 * @author Kyle Laker
 * @version 20160120
 */
public class PhoneNumber {
    private int areaCode;
    private int exchange;
    private int extension;

    public PhoneNumber(int areaCode, int exchange, int extension) {
        if (areaCode > 999 || areaCode <= 200) throw new IllegalArgumentException();
        if (exchange > 999 || exchange <= 200) throw new IllegalArgumentException();
        if (extension > 9999 || exchange < 0) throw new IllegalArgumentException();

        this.areaCode = areaCode;
        this.exchange = exchange;
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof PhoneNumber) {
            PhoneNumber other = (PhoneNumber) o;
            return (this.areaCode == other.areaCode)
                && (this.exchange == other.exchange)
                && (this.extension == other.extension);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = areaCode;
        result = 31 * result + exchange;
        result = 31 * result + extension;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode, exchange, extension);
    }

    /**
     * Provides a PhoneNumber from a String.
     * Must use the North American format "XXXYYYZZZZ" without an international
     * code or extra characters. Attempts to handle any extraneous characters,
     * but this is unsupported behaviour.
     * <p>XXXYYYZZZZ should represent:
     * <ul>
     *     <li>XXX - Area Code
     *     <li>YYY - Exchange Code
     *     <li>ZZZZ - Extension Code
     * </ul>
     * @param phoneNumber The phone number string to match
     * @return A PhoneNumber if a valid number is provided, null otherwise
     */
    public static PhoneNumber fromString(String phoneNumber) {
        int area, exchange, extension;
        String adjustedPhone = phoneNumber;

        // If the phone number is null, return null
        if (phoneNumber == null) {
            throw new NullPointerException("Provided phone number was null.");
        }

        // Attempt to remove an international code
        if (adjustedPhone.startsWith("+1")) {
            adjustedPhone = adjustedPhone.substring(2, adjustedPhone.length());
        }

        // Remove any potentially extraneous characters
        adjustedPhone = adjustedPhone.replaceAll("[^0-9]", "");

        // Phone numbers must be 10 digits
        if (adjustedPhone.length() == 10 || adjustedPhone.matches("[0-9]*")) {
            area = Integer.parseInt(adjustedPhone.substring(0, 3));
            exchange = Integer.parseInt(adjustedPhone.substring(3, 6));
            extension = Integer.parseInt(adjustedPhone.substring(6, 10));

            return new PhoneNumber(area, exchange, extension);
        } else {
            return null;
        }
    }

}
