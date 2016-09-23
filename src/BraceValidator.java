/*
 * Copyright (c) 2016 Kyle Laker
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import java.util.Stack;

/**
 * A utility class used for verifiy whether a string is a valid series
 * of braces. Matches the following types of brace: '{', '[', '('.
 * Ensures that the braces appear in a last-in/first-out order.
 *
 * @author Kyle Laker (github.com/kylelaker)
 * @version 1
 */
 public class BraceValidator {
    
    /**
     * Checks if the provided character is the opening form of some sort
     * of brace. Characters considered opening braces are: '{', '[',
     * '('.
     * @param c The character to check
     * @return  true if the provided character is one of the specified
     *          opening-brace characters
     */
    private static boolean isOpening(char c) {
        switch (c) {
            case '{': // Fall through
            case '[': // Fall through
            case '(':
                return true;
            default:
                return false;
        }
    }
   
    /**
     * Checks whether the two chars are matching forms of the same
     * brace.
     * @param open  The brace to check as the opening brace
     * @param close The brace to check as the closing brace
     * @return      true if both braces are of the same type and open is
     *              the opening form of the brace and close is the
     *              closing form
     */
    private static boolean matches(char open, char close) {
        return open == '{' && close == '}'
            || open == '[' && close == ']'
            || open == '(' && close == ')';
    }

    /**
     * Validates an input string to ensure that all braces are properly
     * opened and closed. Each brace must be closed in a
     * last-in/first-out order.
     *
     * For example:
     *      "[[]]"          Valid
     *      "[[]"           Invalid
     *      "{[{]"          Invalid
     *      "{[()[]{}]()}"  Valid
     * 
     * @param s The string against which to perform the validation
     * @return true if the string is valid, false otherwise
     */
    public static boolean validate(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
            if (isOpening(c))                   stack.push(c);
            else if (!matches(stack.pop(), c))  return false;
        return stack.empty();
    }

}

