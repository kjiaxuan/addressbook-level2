package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Age {

    public static final String Example = "20";
    public static final String MESSAGE_AGE_CONSTRAINTS =
            "Person age should be alphanumeric";
    public static final String AGE_VALIDATION_REGEX = "";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given age.
     *
     * @throws IllegalValueException if given age is invalid.
     */
    public Age(String age, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedAge = age.trim();
        if (!isValidAge(trimmedAge)) {
            throw new IllegalValueException(MESSAGE_AGE_CONSTRAINTS);
        }
        this.value = trimmedAge;
    }

    /**
     * Returns true if the given string is a valid person age.
     */
    public static boolean isValidAge(String test) {
        return test.matches(AGE_VALIDATION_REGEX);
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Age // instanceof handles nulls)
            && this.value.equals(((Age) other).value)); // state check
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }

    public boolean isPrivate(){
        return isPrivate;
    }

}
