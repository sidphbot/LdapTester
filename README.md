# LdapTester
ldap connection checker using java

Ldap test util :
----------------------
Utility : ad_ldaptest.class

User : [any user]

Features : 
•	Tests LDAP connectivity
•	Tests LDAP credentials
•	Tests LDAP SSL handshake(when ldaps is choosen)

Usage :
$ java ad_ldaptest [ldap/ldaps] [ldap_host] [ldap_port] [bind_user] [password] [base_search_dn]

e.g.
$ java ad_ldaptest ldaps myldap.mydomain.com 636 ldapuser myldap password ""
