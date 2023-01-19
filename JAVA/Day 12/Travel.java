/*
Sri Vihaan Travels announced a family trip to Sri Nagar, for which they began 
taking reservations. They are only offering 2 and 3-seater tickets for this trip.

Each member of certain groups is identifiable by the group ID to which he or 
she belongs. Each group is uniquely identified by its group ID.

The travel administration decided that the ticket will only be issued to members of the same group. It is decided that No wasted tickets will be issued 
(i.e., If a person is alone, then he is not allowed to get a ticket).

You are given a list of integers person_id[], where person_id[i] is the group ID 
of the ith person in the list. Your objective is to determine whether fewer tickets 
should be issued to cover everyone in each group. Print -1, if it is not possible.


Input Format:
-------------
Line-1: Comma separated integers, Person's group-ID

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
1,1,3,2,2,2,1,2,2,3

Sample Output-1:
----------------
4

Explanation: 
------------
They can book the tickets for all the people, as follows:
- Issue the 3-seater ticket, to group with ID-1 of size 3.
- Issue the 2-seater ticket, to group with ID-3 of size 2.
- Issue the 3-seater ticket, to group with ID-2 of size 5.
- Issue the 2-seater ticket, to group with ID-2 of size 5.
So, you have issued 4 tickets in total.


Sample Input-2:
---------------
1,1,1,2,2,3

Sample Output-2:
----------------
-1

Explanation: 
------------
There is a group with ID-3 of size 1. 
The administration's ruling states that a single person cannot receive a ticket.
So, print -1.

*/

 
import java.util.*;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        String[] inputArr = input.split(",");
        int[] personId = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            personId[i] = Integer.parseInt(inputArr[i]);
        }

        int result = getTicketCount(personId);
        System.out.println(result);
    }


    public static int getTicketCount(int[] personId) {
        HashMap<Integer, Integer> groupSizes = new HashMap<Integer, Integer>();
        for (int id : personId) {
            if (groupSizes.containsKey(id)) {
                groupSizes.put(id, groupSizes.get(id) + 1);
            } else {
                groupSizes.put(id, 1);
            }
        }

        for (int size : groupSizes.values()) {
            if (size == 1) {
                return -1;
            }
        }

        int ticketCount = 0;
        for (int size : groupSizes.values()) {
            ticketCount += (size / 3);
            if (size % 3 != 0) {
                ticketCount++;
            }
        }

        return ticketCount;
    }
}       

 
