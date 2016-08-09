/**
 * @author Anthony Pham
 * @version 2/17/14
 *
 * This class represents the tests to see if the sequence class is functioning
 * properly with linked list
 */
public class LinkedListTester {
    public static final boolean VERBOSE = true;
    
    public static void main(String[] args)
    {
    	System.out.println("Starting Tests");
	
    	testConstructor();
    	testremoveHead();
    	testremoveTail();
    	testinsertAtTail();
    	testSearch();
    	testAdd();
    	testRemove();
    	testGetData();
	
    	System.out.println("Tests Complete");
    }
    
    private static void testConstructor()
    {
    	testsSection("Linked List Constructor test");
	
    	LinkedList myList;
    	myList = new LinkedList();
    	
    	assertEquals("Non-default constructor", "()", myList.toString());
    }
    
    private static void testremoveHead()
    {
    	testsSection("removeHead Test");
    	
    	LinkedList stringList;
    	stringList = new LinkedList();
    	String s1, s2;
    	s1 = "A";
    	s2 = "B";
    	
    	assertEquals("No strings in list", null, stringList.removeHead());
    	assertEquals("No strings in list length", 0, stringList.getLength());
    	
    	stringList.insertAtHead(s1);
    	assertEquals("1 string in list", "A" , stringList.removeHead().toString());
    	assertEquals("1 string in list length", 0, stringList.getLength());
    	
    	stringList.insertAtHead(s1);
    	stringList.insertAtHead(s2);
    	assertEquals("2 strings in list", "B", stringList.removeHead().toString());
    	assertEquals("2 strings in list length", 1, stringList.getLength());
    }
    
    private static void testremoveTail()
    {
    	testsSection("removeTail test");
    
    	LinkedList stringList;
    	stringList = new LinkedList();
    	String s1, s2;
    	s1 = "A";
    	s2 = "B";
    	
    	assertEquals("No strings in list", null, stringList.removeHead());
    	assertEquals("No strings in list length", 0, stringList.getLength());
    	
    	stringList.insertAtHead(s1);
    	assertEquals("1 string in list", "A" , stringList.removeTail().toString());
    	assertEquals("1 string in list length", 0, stringList.getLength());
    	
    	stringList.insertAtHead(s1);
    	stringList.insertAtHead(s2);
    	assertEquals("2 strings in list", "A", stringList.removeTail().toString());
    	assertEquals("2 strings in list length", 1, stringList.getLength());
    }
    
    private static void testinsertAtTail()
    {
    	testsSection("insertAtTail test");
        
    	LinkedList stringList;
    	stringList = new LinkedList();
    	String s1, s2;
    	s1 = "A";
    	s2 = "B";
    	
    	stringList.insertAtTail(s1);
    	assertEquals("String added to empty List", "(A)", stringList.toString());
    	assertEquals("String added to empty List length", 1, stringList.getLength());
    	
    	stringList.insertAtTail(s2);
    	assertEquals("String added to non-empty List", "(A," + "\n" +
    				"B)", stringList.toString());
    	assertEquals("String added to non-empty List length", 2, stringList.getLength());
    }
    
    private static void testSearch()
    {
    	testsSection("search Test");
    	
    	LinkedList stringList;
    	stringList = new LinkedList();
    	String s1, s2, s3;
    	s1 = "A";
    	s2 = "B";
    	s3 = "B";
    	
    	stringList.insertAtHead(s1);
    	stringList.insertAtTail(s2);
    	
    	assertEquals("String is in List", 0, stringList.search("A"));
    	assertEquals("String not in List", -1, stringList.search("C"));
    	assertEquals("Last String", 1, stringList.search("B"));
    	
    	stringList.insertAtTail(s3);
    	assertEquals("Two strings with same name", 1, stringList.search("B"));
    	
    }
    
    private static void testAdd()
    {
    	testsSection ("add Test");
    	
    	LinkedList stringList;
    	stringList = new LinkedList();
    	String s1, s2, s3;
    	s1 = "A";
    	s2 = "B";
    	s3 = "C";
    	
    	stringList.add(s1,0);
    	assertEquals("String added to empty list", "(A)", stringList.toString());
    	assertEquals("String added to empty list length", 1, stringList.getLength());
    	
    	stringList.add(s1,10);
    	assertEquals("String added out of index", "(A)", stringList.toString());
    	assertEquals("String added out of index length", 1, stringList.getLength());
    	
    	stringList.add(s2,0);
    	assertEquals("String added to beginning of non-empty linked list", "(B," + "\n"
    				+ "A)", stringList.toString());
    	assertEquals("String added to beginning of non-empty linked list length", 2, stringList.getLength());
    	
    	stringList.add(s3,1);
    	assertEquals("String added to end of non-empty linked list", "(B," + "\n"
    				+ "A," + "\n" + "C)", stringList.toString());
    	assertEquals("String added to end of non-empty linked list length", 3, stringList.getLength());
    	
    	stringList.add(s2,1);
    	assertEquals("String added to non-empty List", "(B," + "\n" + "A," + "\n"
    				+ "B," + "\n" + "C)", stringList.toString());
    	assertEquals("String added to non-empty List", 4, stringList.getLength());
    }
    
    private static void testRemove()
    {
    	testsSection("remove test");
    	
    	LinkedList stringList;
    	stringList = new LinkedList();
    	String s1, s2, s3;
    	s1 = "A";
    	s2 = "B";
    	s3 = "C";
    	
    	assertEquals("Removing from non-empty stringList", null, stringList.remove(0));
    	assertEquals("Removing from non-empty stringList length", 0, stringList.getLength());
    	
    	stringList.add(s1,0);
    	assertEquals("Removing beginning from non-empty stringList", "A", stringList.remove(0));
    	assertEquals("Removing beginning from non-empty stringList length", 0, stringList.getLength());
    	
    	stringList.add(s1,0);
    	stringList.add(s2,1);
    	stringList.add(s3,2);
    	
    	assertEquals("Removing from non-empty stringList", "B", stringList.remove(1));
    	assertEquals("Removing from non-empty stringList length", 2, stringList.getLength());
    	
    	
    	assertEquals("Removing end from non-empty stringList", "C", stringList.remove(1));
    	assertEquals("Removing end from non-empty stringList length", 1, stringList.getLength());
    	
    }
    
    public static void testGetData()
    {
    	testsSection("getData test");
    	
    	LinkedList stringList;
    	stringList = new LinkedList();
    	String s1, s2, s3;
    	s1 = "A";
    	s2 = "B";
    	s3 = "C";
    	
    	stringList.add(s1,0);
    	stringList.add(s2,1);
    	stringList.add(s3,2);
    	
    	assertEquals("Retrieve first node", "A", stringList.getData(0));
    	assertEquals("Retrieve middle node", "B", stringList.getData(1));
    	assertEquals("Retrieve last node", "C", stringList.getData(2));
    }
    
    
    /***********  TESTING TOOLS ****************/
    
    /**
     * Each of the assertEquals methods tests whether the actual
     * result equals the expected result.  If it does, then the test
     * passes, otherwise it fails.  If VERBOSE is true, then complete
     * information is printed, whether the tests passes or fails.  If
     * VERBOSE is false, only failures are printed.
     *
     * The only difference between these methods is the types of the
     * parameters.  All take a String message and two values of the
     * same type (either boolean, int, or String) to compare:
     *
     * @param message a message or description of the test
     * @param expected the correct, or expected, value
     * @param actual the actual value
     */
    private static void assertEquals(String message, 
				    boolean expected, boolean actual)
    {
    	printTestCaseInfo(message, "" + expected, "" + actual);
    	if (expected == actual) {
    		pass();
    	} else {
    		fail(message);
    	}
    }

    private static void assertEquals(String message, 
				    int expected, int actual)
    {
    	printTestCaseInfo(message, "" + expected, "" + actual);
    	if (expected == actual) {
    		pass();
    	} else {
    		fail(message);
    	}
    }
    
    private static void assertEquals(String message, 
				    String expected, String actual)
    {
    	printTestCaseInfo(message, expected, actual);
	
    	if (expected == null) {
    		if (actual == null) {
    			pass();
	    	} else {
	    		fail(message);
	    	}
    	} 
    	else if (expected.equals(actual)) {
    		pass();
    	} 
		else {
			fail(message);
		}
    }
    
    private static void assertEquals(String message, 
    		Object expected, Object actual)
    {
    	try {
    		printTestCaseInfo(message, expected.toString(), actual.toString());
    	}
    	catch (NullPointerException e)
    	{
    		printTestCaseInfo(message, "", "");
    	}

    	if (expected == null) {
    		if (actual == null) {
    			pass();
    		} else {
    			fail(message);
    		}
    	} 
    	else if (expected.equals(actual)) {
    		pass();
    	} 
    	else {
    		fail(message);
    	}
    }
    
    private static void printTestCaseInfo(String message, 
					  String expected, String actual)
    {
    	if (VERBOSE) {
    		System.out.println(message + ":");
    		System.out.println("expected: " + expected);
    		System.out.println("actual:   " + actual);
		}
    }
    
    private static void pass()
    {
    	if (VERBOSE) {
    		System.out.println("PASS");
    		System.out.println();
    	}
    }
    
    private static void fail(String description)
    {
    	if (!VERBOSE) {
    		System.out.print(description + "  ");
    	}
    	System.out.println("FAIL");
    }
    
    private static void testsSection(String sectionTitle)
    {
	if (VERBOSE) {
	    int dashCount = sectionTitle.length();
	    System.out.println(sectionTitle);
	    for (int i = 0; i < dashCount; i++) {
		System.out.print("-");
	    }
	    System.out.println();
	    System.out.println();
		}
    }
}
