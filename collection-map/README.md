NavigableMap Implementations
Being an interface, you need an implementation of the Java NavigableMap before you can use it. The java.util package only has one implementation of the NavigableMap interface: The java.util.TreeMap class. There is a Java NavigableMap implementation in the java.util.concurrent package too, but that is outside the scope of this tutorial.

Create a NavigableMap
To create a Java NavigableMap you must create an instance of one of the classes that implements the NavigableMap interface. Here is an example of creating an instance of the Java TreeMap class which implements the NavigableMap interface:

NavigableMap navigableMap = new TreeMap();
Create a NavigableMap With Comparator
It is possible to pass a Comparator implementation to the TreeMap constructor. This Comparator will then be used to sort the keys of the key, value pairs stored in the NavigableMap. Here is an example of creating a Java TreeMap with a Comparator:

Comparator comparator = new MyComparatorImpl();

SortedMap sortedMap = new TreeMap(comparator);
descendingKeySet()
The first interesting navigation method of NavigableMap is the descendingKeySet() method. The descendingKeySet() method returns a NavigableSet in which the order of the elements is reversed compared to the original key set. The returned "view" is backed by the original NavigableSet key Set, so changes to the descending key Set are also reflected in the original set.

Here is a simple NavigableMap descendingKeySet() example:

NavigableSet reverse = map.descendingKeySet();
descendingMap()
The second interesting navigation method is the descendingMap() method. The descendingMap() method returns a NavigableMap which is a view of the original Map. The order of the elements in this view map is reverse of the order of the original map. Being a view of the original map, any changes to this view is also reflected in the original map.

Here is a simple NavigableMap descendingMap() example:

NavigableMap descending = map.descendingMap();
headMap()
The headMap() method returns a view of the original NavigableMap which only contains elements that are "less than" the given element. Here is an example:

NavigableMap original = new TreeMap();
original.put("1", "1");
original.put("2", "2");
original.put("3", "3");

//this headmap1 will contain "1" and "2"
SortedMap headmap1 = original.headMap("3");

//this headmap2 will contain "1", "2", and "3" because "inclusive"=true
NavigableMap headmap2 = original.headMap("3", true);
tailMap()
The tailMap() method is similar to the headMap() method, except that tailMap() returns all elements that are equal to or higher than the given parameter element. Here is a NavigableMap tailMap() example:

NavigableMap navigableMap = new TreeMap();

navigableMap.put("a", "1");
navigableMap.put("c", "3");
navigableMap.put("e", "5");
navigableMap.put("d", "4");
navigableMap.put("b", "2");

SortedMap tailMap = navigableMap.tailMap("c");
The tailMap variable will reference a SortedMap containing all key + value pairs from the NavigableMap for the keys "c", "d" and "e", as these keys are considered equal to or larger than the parameter value "c" passed to the tailMap() method.

subMap()
The subMap() allows you to pass two parameters demarcating the boundaries of the view map to return. Here is a NavigableMap subMap() example:

NavigableMap original = new TreeMap();
original.put("1", "1");
original.put("2", "2");
original.put("3", "3");
original.put("4", "4");
original.put("5", "5");

//this submap1 will contain "3", "3"
SortedMap    submap1  = original.subMap("2", "4");

//this submap2 will contain ("2", "2") ("3", "3") and ("4", "4") because
//    fromInclusive=true, and toInclusive=true
NavigableMap submap2 = original.subMap("2", true, "4", true);
ceilingKey()
The ceilingKey() method returns the least (smallest) key in this map that is greater than or equal to the element passed as parameter to the ceilingKey() method. Here is a NavigableMap ceilingKey() example:

NavigableMap original = new TreeMap();
original.put("1", "1");
original.put("2", "2");
original.put("3", "3");


//ceilingKey will be "2".
Object ceilingKey = original.ceilingKey("2");
floorKey()
The floorKey() method does the opposite of ceilingKey(). Thus, floorKey() returns the greatest key which is less than or equal to the parameter value passed to ceilingKey(). Here is a NavigableMap ceilingKey() example:

NavigableMap original = new TreeMap();
original.put("1", "1");
original.put("2", "2");
original.put("3", "3");

//floorKey will be "2".
Object floorKey = original.floorKey("2");
The returned floorKey will be "2" since the greatest key equal to or smaller than "2" is "2" in the example above.

higherKey()
The higherKey() method returns the least (smallest) element in this map that is greater than (not equal too) the element passed as parameter to the higherKey() method. Here is a NavigableMap higherKey() example:

NavigableMap original = new TreeMap();
original.put("1", "1");
original.put("2", "2");
original.put("3", "3");


//higherKey will be "3".
Object higherKey = original.higherKey("2");
lowerKey()
The lowerKey() method does the opposite of the higherKey() method. Thus, lowerKey() returns the greatest key which is lower than the parameter value passed to the lowerKey() method. Here is a NavigableMap lowerKey() example:

NavigableMap original = new TreeMap();
original.put("1", "1");
original.put("2", "2");
original.put("3", "3");

//lowerKey will be "1"
Object lowerKey = original.lowerKey("2");
In the example above, the returned lowerKey will be "1", as this is the highest key which is lower than the parameter value "2" passed to the lowerKey() method.

celingEntry(), floorEntry(), higherEntry(), lowerEntry()
The NavigableMap also has methods to get the entry for a given key, rather than the key itself. These methods behave like the ceilingKey() etc. methods, except they return a Map.Entry instead of the key object itself.

A Map.Entry maps a single key to a single value.

Each of the methods ceilingEntry(), floorEntry(), higherEntry() and lowerEntry() will be covered in the following sections.

ceilingEntry()
The ceilingEntry() method returns the key + value stored for the least (smallest) key in the NavigableMap which is higher than or equal to the parameter value passed to the ceilingEntry() method. The ceilingEntry() is thus similar to the ceilingKey() method, except the ceilingKey() method only returns the key, and ceilingKey() returns a Map.Entry object containing both the key and value.

Here is a simple NavigableMap ceilingEntry() example:

NavigableMap original = new TreeMap();
navigableMap.put("a", "1");
navigableMap.put("c", "3");
navigableMap.put("e", "5");
navigableMap.put("d", "4");
navigableMap.put("b", "2");

//ceilingEntry will be ("c", "3").
Map.Entry ceilingEntry = navigableMap.ceilingEntry("c");
In the example above the returned ceilingEntry will contain the key "c" and the value "3", since the key "c" is the smallest key that is greater than or equal to the parameter value "c" passed to ceilingEntry() .

floorEntry()
The floorEntry() method works opposite of the ceilingEntry() method. The floorEntry() method returns the key + value for the greatest key which is equal to or lower than the parameter value passed to the floorEntry() method. Here is a NavigableMap floorEntry() example:

NavigableMap original = new TreeMap();
navigableMap.put("a", "1");
navigableMap.put("c", "3");
navigableMap.put("e", "5");
navigableMap.put("d", "4");
navigableMap.put("b", "2");

//floorEntry will be ("c, "3").
Map.Entry floorEntry = navigableMap.floorEntry("c");
The floorEntry returned in the example above will contain the key + value pair "c" + "3" , because key "c" is the greatest key which is lower than or equal to the parameter value "c" passed to the floorEntry() method.

higherEntry()
The higherEntry() method returns the key + value stored for the smallest key that is higher than the parameter value passed to the higherEntry() method. Here is a NavigableMap higherEntry() example:

NavigableMap original = new TreeMap();
navigableMap.put("a", "1");
navigableMap.put("c", "3");
navigableMap.put("e", "5");
navigableMap.put("d", "4");
navigableMap.put("b", "2");

//higherEntry will be ("d", "4").
Map.Entry higherEntry = original.higherEntry("c");
The higherEntry returned in the example above will contain the key + value pair "d" + "4" because the key "d" is the lowest key which is higher than the parameter value "c" passed to the higherEntry() method.

lowerEntry()
The lowerEntry() method in the NavigableMap interface returns the key + value pair for the highest key which is lower than the parameter value passed to the lowerEntry() method. Here is a NavigableMap lowerEntry() example:

NavigableMap original = new TreeMap();
navigableMap.put("a", "1");
navigableMap.put("c", "3");
navigableMap.put("e", "5");
navigableMap.put("d", "4");
navigableMap.put("b", "2");

//lowerEntry will be ("a", "1")
Map.Entry lowerEntry = original.lowerEntry("b");
The lowerEntry returned in this example will be the key + value pair "a" + "1" since "a" is the highest key which is lower than the parameter value "b" passed to the lowerEntry() method.

pollFirstEntry()
The pollFirstEntry() method returns and removes the "first" entry (key + value) in the NavigableMap or null if the map is empty. "First" means smallest element according to the sort order of the keys. Here is a pollFirstEntry() example:

NavigableMap original = new TreeMap();
navigableMap.put("a", "1");
navigableMap.put("c", "3");
navigableMap.put("e", "5");
navigableMap.put("d", "4");
navigableMap.put("b", "2");


//first is ("a", "1")
Map.Entry first = original.pollFirstEntry();
The first entry returned in the above example will be the key + value pair "a" + "1" since the key "a" will be considered the first key of the key + value pairs added in this example.

pollLastEntry()
The pollLastEntry() returns and removes the "last" element in the map or null if the map is empty. "Last" means largest key according to the element sorting order of the map. Here is a pollLastEntry() example:

NavigableMap original = new TreeMap();
navigableMap.put("a", "1");
navigableMap.put("c", "3");
navigableMap.put("e", "5");
navigableMap.put("d", "4");
navigableMap.put("b", "2");


//first is ("e", "5")
Map.Entry last = original.pollLastEntry();
The last entry returned in the above example will be the key + value pair "e" + "5" since the key "e" will be considered the last key of the key + value pairs added in this example.