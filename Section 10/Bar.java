/* *****************************************************************************
 *  Name:   Ricky Singh
 *  Course: Princeton: Computer Science: Programming with a Purpose
 *
 *  Purpose:  The Bar class defines a Bar data type with three private variables:
 *  String nameOfItem, int valueOfItem, and String categoryOfItem.  It has a constructor
 *  public Bar(String name, int value, String category). It also contains
 *  the following methods .getName(), .getValue, .getCategory(), .compareTo() which
 *  are self explanatory.
 *
 **************************************************************************** */

public class Bar implements Comparable<Bar> {

    // Instance Variables
    private final String nameOfItem;
    private final int valueOfItem;
    private final String categoryOfItem;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if ((name == null) || (value < 0) || (category == null)) {
            throw new IllegalArgumentException("Illegal values for constructor.");
        }
        nameOfItem = name;
        valueOfItem = value;
        categoryOfItem = category;

    }

    // Returns the name of this bar.
    public String getName() {
        return this.nameOfItem;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.valueOfItem;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.categoryOfItem;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {

        if (that == null) {
            throw new NullPointerException("compareTo() object is null");
        }

        return Integer.compare(this.valueOfItem, that.valueOfItem);
    }

    public static void main(String[] args) {

    }

}
