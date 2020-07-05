# hibernate-envers
### The Envers module aims to provide an easy auditing / versioning solution for entity classes.
  - Add the hibernate-envers dependency to your classpath.
  - Annotate your entity or entity properties with the [@Audited][df1] annotation.


### table_AUD suffix

audit table with append _AUD as the suffix of each annotated table which will contains all modification, creation and deletion for tables. [Official Document](https://docs.jboss.org/envers/docs/) 
- rev: revision number. basically, one transaction is one revision. that means rev is global and you can query for various tables at a particular version.
- revtype: revision type. `0: create, 1: modify, 2: delete`

### [PPT](https://prezi.com/p/edit/azbxkdyx9dvf/) 