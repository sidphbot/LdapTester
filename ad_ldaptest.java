import java.util.*;
import javax.naming.*;
import javax.naming.directory.*;

public class ad_ldaptest {
  public static void main(String a[]) {

    // set the LDAP authentication method
    String auth_method  = "simple";
    // set the LDAP client Version
    String ldap_version = "3";
    String protocol     = a[0];

    // This is our LDAP Server's IP
    String ldap_host    = a[1];
    // This is our LDAP Server's Port
    String ldap_port    = a[2];
    // This is our access ID
    String ldap_dn      = a[3];
   // This is our access PW
    String ldap_pw      = a[4];
    // This is our base DN
    String base_dn      = a[5];

    DirContext ctx      = null;
    Hashtable env       = new Hashtable();

    // Here we store the returned LDAP object data
    String dn           = "";
    // This will hold the returned attribute list
    Attributes attrs;

    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL,protocol + "://" + ldap_host + ":" + ldap_port);
    env.put(Context.SECURITY_AUTHENTICATION, auth_method);
    env.put(Context.SECURITY_PRINCIPAL, ldap_dn);
    env.put(Context.SECURITY_CREDENTIALS, ldap_pw);
    env.put("java.naming.ldap.version", ldap_version);

    try{
      System.out.println("Connecting to host " + ldap_host + " at port " + ldap_port + "...");
      System.out.println();

      ctx = new InitialDirContext(env);
      System.out.println("LDAP authentication successful!");
/*
      // Specify the attribute list to be returned
      String[] attrIDs = { "memberOf" };

      SearchControls ctls = new SearchControls();
      ctls.setReturningAttributes(attrIDs);
      ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

      // Specify the search filter to match
      String filter = "(&(objectClass=user)(sAMAccountName=frank4dd))";

      // Search the subtree for objects using the given filter
      NamingEnumeration answer = ctx.search(base_dn, filter, ctls);

      // Print the answer
      //Search.printSearchEnumeration(answer);

      while (answer.hasMoreElements()) {
        SearchResult sr = (SearchResult)answer.next();
        dn = sr.getName();
        attrs = sr.getAttributes();

        System.out.println("Found Object: " + dn + "," + base_dn);
        if (attrs != null) {
          // we have some attributes for this object
          NamingEnumeration ae = attrs.getAll();
          while (ae.hasMoreElements()) {
            Attribute attr = (Attribute)ae.next();
            String attrId = attr.getID();
            System.out.println("Found Attribute: " + attrId);
            Enumeration vals = attr.getAll();
            while (vals.hasMoreElements()) {
              String attr_val = (String)vals.nextElement();
              System.out.println(attrId + ": " + attr_val);
            }
          }
        }
     }
*/

      // Close the context when we're done
      ctx.close();
    } catch (AuthenticationException authEx) {
      authEx.printStackTrace();
      System.out.println("LDAP authentication failed!");
    } catch (NamingException namEx) {
      System.out.println("LDAP connection failed!");
      namEx.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
   }
  }
}
