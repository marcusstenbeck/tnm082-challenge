package tnm082.challenge.tests;

import junit.framework.TestCase;
import tnm082.challenge.Group;
import tnm082.challenge.User;

public class GroupTest extends TestCase {
	
		public void testGroup()
		{
			Group g = new Group();
			
			assertNotNull(g.getId());
			assertNotNull(g.getName());
			assertNotNull(g.getUserList());
		}
		

		public void testGetName() {
			Group g = new Group();
			
			// Make sure the name taken from the object is not null
			assertNotNull(g.getName());
		}
		
		public void testGetId()
		{
			Group g = new Group();
			
			// make sure we get an id
			assertNotNull(g.getId());
		}

		public void testSetName()
		{
			Group g = new Group();
			
			// Create name string to pass to object
			String name = "Boba Fett";
			
			// Use object setName() method to set name
			g.setName(name);
			
			// Make sure the name taken from the object is the one we set
			assertEquals(name, g.getName());
		}
		
		public void testGetUserList()
		{
			Group g = new Group();
			
			// Make sure that the user list vector is initialized
			assertNotNull(g.getUserList());
		}
		
		public void testRemoveUser()
		{
			Group g = new Group();
			
			// Create a user to add
			User u = new User();
			
			// Set the user id and name to something else than what the object initializes it to
			int userId = 666;
			String userName = "Satan Beelsebub";
			u.setId(userId);
			u.setName(userName);
			
			// Add the user to the Group object
			g.addUser(u);
			
			// Remove the user
			g.removeUser(u);
			
			// Make sure the user returned is not null...
			User retrievedUser = g.getUser(userId);
			assertNull(retrievedUser);
		}
		
		public void testGetUser()
		{
			/*  
			 *	This also tests the function Group.addUser(User u) 
			 */
			Group g = new Group();
			
			// Create a user to add
			User u = new User();
			
			// Set the user id and name to something else than what the object initializes it to
			int userId = 666;
			String userName = "Satan Beelsebub";
			u.setId(userId);
			u.setName(userName);
			
			// Add the user to the Group object
			g.addUser(u);
			
			
			// Make sure the user returned is not null...
			User retrievedUser = g.getUser(userId);
			assertNotNull(retrievedUser);
			
			// ... and that its the user we added.
			assertEquals(userId, retrievedUser.getId());
			assertEquals(userName, retrievedUser.getName());
		}
}
