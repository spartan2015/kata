package shoppingcart;

import java.util.Vector;

public class ProductCatalog
{
    protected Item[] items;

    public ProductCatalog()
    {

// Set up an array of items that represents the catalog.

        items = new Item[] {
            new Item("PBJG-1", "Pale Blue Japanese Guitar",
                700.00, 1),
            new Item("PBJZ-1", "Pale Blue Japanese Zither",
                1400.00, 1),
            new Item("PBJS-1", "Peanut Butter & Jelly Sandwich",
                1.00, 1),
            new Item("GCX", "Garlic Clove", 0.40, 1),
            new Item("XC", "Xenophobic Cat", 72.00, 1),
            new Item("BH", "Buttonhole", 0.05, 6),
            new Item("K9", "Dog", 100.00, 1),
            new Item("ATL", "Atlanta Airport", 9000000.00, 1),
            new Item("TEG", "Sheep", 75.00, 1),
            new Item("UPC", "Universal Price Code", 1.00, 1),
            new Item("ALL", "The Universe", 0.01, 1),
            new Item("ZYZZYVAS", "The last word in Scrabble",
                74.00, 1),
            new Item("SAM", "Urchin (aged for 7 years)", 0.0, 1),
            new Item("KATY", "Urchin (aged for 4 years)", 0.0, 1),
            new Item("FR44", "Flamingo Relish (tastes like chicken)",
                2.00, 1),
            new Item("PF44", "Pickled Flamingo (tastes like chicken)",
                2.00, 1),
            new Item("LF44", "Pink Lawn Flamingo (tasteless)",
                12.00, 1)
        };
    }

/** returns an array containing all the items in the catalog */
    public Item[] getItems()
    {
        return getItems(0, items.length);
    }

/** returns an array containing a subset of items from the catalog */
    public Item[] getItems(int startingLocation, int numItems)
    {
// If the number of items to be returned is larger than the number
// in the catalog, adjust the number to be returned.
        if (numItems > items.length)
        {
            numItems = items.length;
        }

// If by returning numItems items you would run out of items (if there
// are 5 items, you ask for 3, but give a starting location of 4),
// adjust the starting location backward to ensure that the proper
// number of items is returned.
        if (startingLocation+numItems >= items.length)
        {
            startingLocation = items.length - numItems;
        }

// Create an array for the returned items.
        Item[] returnItems = new Item[numItems];

// Copy the items from the catalog into the return array.
        System.arraycopy(items, startingLocation,
            returnItems, 0, numItems);

        return returnItems;
    }

/** Returns true if there are items at a particular starting location.
    This is helpful in determining whether a page should show a "Next"
    button to see the next page of catalog items.
*/
    public boolean itemsAvailable(int startingLocation)
    {
        if (startingLocation >= items.length) return false;
        return true;
    }

/** Searches for an item by product code and returns it. If there is
    no such item, this method returns null.  */
    public Item findItemByProductCode(String productCode)
    {
// Linear searches aren't a good idea for big arrays, but this
// one is small.
        for (int i=0; i < items.length; i++)
        {
            if (items[i].getProductCode().equals(
                productCode))
            {
                return items[i];
            }
        }

        return null;
    }
}
