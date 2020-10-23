/******************************************************************************
 *  Name:
 *  Calvin Nowlen
 *  Hours to complete assignment (optional):
 *  10
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

  The search first looks at the middle of the array and checks to see if the
  value is equal to our search term, if so we set a variable equal to the value
  and change our high term to one less than the middle, if it is greater than
  our search term we set our high term to one less than the middle term
  otherwise we raise the low term to one plus the high term

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O(nlogn)

allMatches():O(mlogm)

numberOfMatches():O(logn)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
 The AutocompleteGUI program does not work. I'm confused why

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
I used https://beginnersbook.com/2013/12/java-string-substring-method-example/
to learn about the substring() method of strings in order to better implement my
autocorrect program
/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/
without the substring method and the boolean assignment statement words smaller
than the prefix would create an error.




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/


